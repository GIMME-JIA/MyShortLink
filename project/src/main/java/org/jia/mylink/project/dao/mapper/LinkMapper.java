package org.jia.mylink.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.jia.mylink.project.dao.entity.LinkDO;
import org.jia.mylink.project.dto.request.LinkPageReqDTO;

/**
 * 短链接管理持久层
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/12
 */

public interface LinkMapper extends BaseMapper<LinkDO> {

    /**
     * 短链接访问统计自增
     */
    @Update("update t_link set total_pv = total_pv + #{totalPv}, total_uv = total_uv + #{totalUv}, total_uip = total_uip + #{totalUip} where gid = #{gid} and full_short_url = #{fullShortUrl}")
    void incrementStats(
            @Param("gid") String gid,
            @Param("fullShortUrl") String fullShortUrl,
            @Param("totalPv") Integer totalPv,
            @Param("totalUv") Integer totalUv,
            @Param("totalUip") Integer totalUip
    );
    /**
     * 分页统计短链接
     *
     * @param requestParam 短链接分页查询请求对象
     * @return 实体Page
     */
    IPage<LinkDO> pageLink(LinkPageReqDTO requestParam);
}
