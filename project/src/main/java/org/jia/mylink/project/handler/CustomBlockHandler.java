package org.jia.mylink.project.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.jia.mylink.project.common.convention.result.Result;
import org.jia.mylink.project.dto.request.LinkCreateReqDTO;
import org.jia.mylink.project.dto.response.LinkCreateRespDTO;

/**
 * 自定义流控策略
 * @author JIA
 * @version 1.0
 * @since 2024/3/22
 */

public class CustomBlockHandler {
    /**
     * 流控返回结果
     * @param requestParam 短链接创建请求对象
     * @param exception 超出流控范围抛出的异常
     * @return 向用户返回错误
     */
    public static Result<LinkCreateRespDTO> createShortLinkBlockHandlerMethod(LinkCreateReqDTO requestParam, BlockException exception) {
        return new Result<LinkCreateRespDTO>().setCode("B100000").setMessage("当前访问网站人数过多，请稍后再试...");
    }
}
