package org.jia.mylink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.jia.mylink.project.dao.entity.LinkAccessLogsDO;
import org.jia.mylink.project.dao.entity.LinkAccessStatsDO;
import org.jia.mylink.project.dto.request.LinkGroupStatsReqDTO;
import org.jia.mylink.project.dto.request.LinkStatsReqDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 访问日志监控持久层
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/18
 */

public interface LinkAccessLogsMapper extends BaseMapper<LinkAccessLogsDO> {
    /**
     * 根据短链接获取指定日期内高频访问IP数据
     *
     * @param requestParam 访问短链接监控请求对象
     * @return List:Map:key:ip,val:count
     */
    @Select("SELECT " +
            "    ip, " +
            "    COUNT(ip) AS count " +
            "FROM " +
            "    t_link_access_logs " +
            "WHERE " +
            "    full_short_url = #{param.fullShortUrl} " +
            "    AND gid = #{param.gid} " +
            "    AND create_time BETWEEN #{param.startDate} and #{param.endDate} " +
            "GROUP BY " +
            "    full_short_url, gid, ip " +
            "ORDER BY " +
            "    count DESC " +
            "LIMIT 5;")
    List<HashMap<String, Object>> listTopIpByShortLink(@Param("param") LinkStatsReqDTO requestParam);

    /**
     * 根据分组获取指定日期内高频访问IP数据
     *
     * @param requestParam 访问短链接分组监控请求对象
     * @return List:Map:key:ip,val:count
     */
    @Select("SELECT " +
            "    ip, " +
            "    COUNT(ip) AS count " +
            "FROM " +
            "    t_link_access_logs " +
            "WHERE " +
            "    gid = #{param.gid} " +
            "    AND create_time BETWEEN #{param.startDate} and #{param.endDate} " +
            "GROUP BY " +
            "    gid, ip " +
            "ORDER BY " +
            "    count DESC " +
            "LIMIT 5;")
    List<HashMap<String, Object>> listTopIpByGroup(@Param("param") LinkGroupStatsReqDTO requestParam);

    /**
     * 根据短链接获取指定日期内新旧访客数据
     *
     * @param requestParam 访问短链接监控请求对象
     * @return Map:key:oldUserCnt,newUserCnt,val:count
     */
    @Select("SELECT " +
            "    SUM(old_user) AS oldUserCnt, " +
            "    SUM(new_user) AS newUserCnt " +
            "FROM ( " +
            "    SELECT " +
            "        CASE WHEN COUNT(DISTINCT DATE(create_time)) > 1 THEN 1 ELSE 0 END AS old_user, " +
            "        CASE WHEN COUNT(DISTINCT DATE(create_time)) = 1 AND MAX(create_time) >= #{param.startDate} AND MAX(create_time) <= #{param.endDate} THEN 1 ELSE 0 END AS new_user " +
            "    FROM " +
            "        t_link_access_logs " +
            "    WHERE " +
            "        full_short_url = #{param.fullShortUrl} " +
            "        AND gid = #{param.gid} " +
            "    GROUP BY " +
            "        user " +
            ") AS user_counts;")
    HashMap<String, Object> findUvTypeCntByShortLink(@Param("param") LinkStatsReqDTO requestParam);

    /**
     * 获取用户信息是否新老访客
     *
     * @param gid                短链接分组id
     * @param fullShortUrl       完整短链接
     * @param startDate          开始日期
     * @param endDate            结束日期
     * @param userAccessLogsList 用户访问日志集合
     * @return List:Map:key:user,uvtype
     */
    @Select(
            "SELECT " +
                    "    user, " +
                    "    CASE " +
                    "        WHEN MIN(create_time) BETWEEN #{startDate} AND #{endDate} THEN '新访客' " +
                    "        ELSE '老访客' " +
                    "    END AS uvType " +
                    "FROM " +
                    "    t_link_access_logs " +
                    "WHERE " +
                    "    full_short_url = #{fullShortUrl} " +
                    "    AND gid = #{gid} " +
                    "    AND user IN " +
                    "    <foreach item='item' index='index' collection='userAccessLogsList' open='(' separator=',' close=')'> " +
                    "        #{item} " +
                    "    </foreach> " +
                    "GROUP BY " +
                    "    user;"
    )
    List<Map<String, Object>> selectUvTypeByUsers(
            @Param("gid") String gid,
            @Param("fullShortUrl") String fullShortUrl,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("userAccessLogsList") List<String> userAccessLogsList
    );

    /**
     * 获取分组用户信息是否新老访客
     *
     * @param gid                短链接分组id
     * @param startDate          开始日期
     * @param endDate            结束日期
     * @param userAccessLogsList 用户访问日志集合
     * @return List:Map:key:user,uvtype
     */
    @Select(
            "SELECT " +
                    "    user, " +
                    "    CASE " +
                    "        WHEN MIN(create_time) BETWEEN #{startDate} AND #{endDate} THEN '新访客' " +
                    "        ELSE '老访客' " +
                    "    END AS uvType " +
                    "FROM " +
                    "    t_link_access_logs " +
                    "WHERE " +
                    "    gid = #{gid} " +
                    "    AND user IN " +
                    "    <foreach item='item' index='index' collection='userAccessLogsList' open='(' separator=',' close=')'> " +
                    "        #{item} " +
                    "    </foreach> " +
                    "GROUP BY " +
                    "    user;"
    )
    List<Map<String, Object>> selectGroupUvTypeByUsers(
            @Param("gid") String gid,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("userAccessLogsList") List<String> userAccessLogsList
    );

    /**
     * 根据短链接获取指定日期内PV、UV、UIP数据
     *
     * @param requestParam 访问短链接监控请求对象
     * @return 访问基础监控持久层实体
     */
    @Select("SELECT " +
            "    COUNT(user) AS pv, " +
            "    COUNT(DISTINCT user) AS uv, " +
            "    COUNT(DISTINCT ip) AS uip " +
            "FROM " +
            "    t_link_access_logs " +
            "WHERE " +
            "    full_short_url = #{param.fullShortUrl} " +
            "    AND gid = #{param.gid} " +
            "    AND create_time BETWEEN #{param.startDate} and #{param.endDate} " +
            "GROUP BY " +
            "    full_short_url, gid;")
    LinkAccessStatsDO findPvUvUidStatsByShortLink(@Param("param") LinkStatsReqDTO requestParam);

    /**
     * 根据分组获取指定日期内PV、UV、UIP数据
     *
     * @param requestParam 访问短链接分组监控请求对象
     * @return 访问基础监控持久层实体
     */
    @Select("SELECT " +
            "    COUNT(user) AS pv, " +
            "    COUNT(DISTINCT user) AS uv, " +
            "    COUNT(DISTINCT ip) AS uip " +
            "FROM " +
            "    t_link_access_logs " +
            "WHERE " +
            "    gid = #{param.gid} " +
            "    AND create_time BETWEEN #{param.startDate} and #{param.endDate} " +
            "GROUP BY " +
            "    gid;")
    LinkAccessStatsDO findPvUvUidStatsByGroup(@Param("param") LinkGroupStatsReqDTO requestParam);
}
