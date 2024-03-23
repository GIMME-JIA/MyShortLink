package org.jia.mylink.admin.remote.dto.request;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

/**
 * 回收站短链接分页请求对象
 * @author JIA
 * @version 1.0
 * @since 2024/3/23
 */
@Data
public class RecycleBinPageReqDTO extends Page {

    /**
     * 分组标识
     */
    private List<String> gidList;
}
