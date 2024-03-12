package org.jia.mylink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jia.mylink.admin.dao.entity.GroupDO;

/**
 * 短链接分组服务接口层
 * @author JIA
 * @version 1.0
 * @since 2024/3/11
 */

public interface GroupService extends IService<GroupDO> {
    /**
     * 创建短链接分组
     * @param name 分组名称
     */
    void saveGroup(String name);

    /**
     * 新增短链接分组
     * @param username  用户名
     * @param groupName 短链接分组名
     */
    void saveGroup(String username, String groupName);
}
