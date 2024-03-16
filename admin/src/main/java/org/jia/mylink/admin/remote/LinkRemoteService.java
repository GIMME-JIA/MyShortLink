package org.jia.mylink.admin.remote;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.jia.mylink.admin.common.convention.result.Result;
import org.jia.mylink.admin.remote.dto.request.LinkCreateReqDTO;
import org.jia.mylink.admin.remote.dto.request.LinkPageReqDTO;
import org.jia.mylink.admin.remote.dto.request.LinkUpdateReqDTO;
import org.jia.mylink.admin.remote.dto.response.LinkCreateRespDTO;
import org.jia.mylink.admin.remote.dto.response.LinkGroupCountQueryRespDTO;
import org.jia.mylink.admin.remote.dto.response.LinkPageRespDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 短链接中台远程调用服务
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/13
 */

public interface LinkRemoteService {
    // TODO (JIA,2024/3/16,12:01)透传服务模块后期需要补充优化

    /**
     * 分页查询短链接
     *
     * @param requestParam 短链接分页查询请求对象
     * @return 短链接分页查询响应对象的集合
     */
    default Result<IPage<LinkPageRespDTO>> pageLink(LinkPageReqDTO requestParam) {
        Map<String, Object> requestMap = new HashMap<>();
        requestMap.put("gid", requestParam.getGid());
        requestMap.put("current", requestParam.getCurrent());
        requestMap.put("size", requestParam.getSize());

        String resultPageStr = HttpUtil.get("http://127.0.0.1:8001/api/short-link/admin/v1/page", requestMap);

        return JSON.parseObject(resultPageStr, new TypeReference<>() {
        });
    }

    /**
     * 创建短链接
     *
     * @param requestParam 短链接创建请求对象
     * @return 短链接创建响应对象
     */
    default Result<LinkCreateRespDTO> createLink(LinkCreateReqDTO requestParam) {
        String resultBydyStr = HttpUtil.post("http://127.0.0.1:8001/api/short-link/admin/v1/create", JSON.toJSONString(requestParam));
        return JSON.parseObject(resultBydyStr, new TypeReference<>() {
        });
    }

    /**
     * 查询短链接分组内的数量
     *
     * @param requestParam 短链接分组id集合
     * @return 短链接分组查询响应对象
     */
    default Result<List<LinkGroupCountQueryRespDTO>> listGroupLinkCount(List<String> requestParam) {
        HashMap<String, Object> requestMap = new HashMap<>();
        requestMap.put("requestParam", requestParam);

        String resultStr = HttpUtil.get("http://127.0.0.1:8001/api/short-link/admin/v1/count", requestMap);
        return JSON.parseObject(resultStr, new TypeReference<>() {
        });

    }

    /**
     * 修改短链接
     *
     * @param requestParam 短链接修改请求对象
     */
    default void updateLink(LinkUpdateReqDTO requestParam) {
        HttpUtil.post("http://127.0.0.1:8001/api/short-link/admin/v1/update", JSON.toJSONString(requestParam));
    }
}
