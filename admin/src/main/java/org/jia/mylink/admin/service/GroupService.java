package org.jia.mylink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jia.mylink.admin.dao.entity.GroupDO;
import org.jia.mylink.admin.dto.request.ShortLinkGroupSortReqDTO;
import org.jia.mylink.admin.dto.request.ShortLinkGroupUpdateReqDTO;
import org.jia.mylink.admin.dto.response.ShortLinkGroupListRespDTO;

import java.util.List;

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

    /**
     * 查询短链接分组集合
     * @return 短链接分组集合
     */
    List<ShortLinkGroupListRespDTO> listGroup();

    /**
     * 修改短链接分组名称
     * @param requestParam 短链接分组修改请求实体
     */
    void updateGroup(ShortLinkGroupUpdateReqDTO requestParam);

    /**
     * 删除短链接分组
     * @param gid 分组标识
     */
    void deleteGroup(String gid);

    /**
     * 排序短链接分组
     * @param requestParam 短链接分组排序请求实体
     */
    void sortGroup(List<ShortLinkGroupSortReqDTO> requestParam);
}
