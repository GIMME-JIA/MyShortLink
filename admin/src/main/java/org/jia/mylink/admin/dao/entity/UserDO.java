package org.jia.mylink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jia.mylink.admin.dao.base.BaseDO;

/**
 * 用户持久层实体
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/7
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user")
public class UserDO extends BaseDO {

    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;

    /**
     * 注销时间戳
     */
    private Long deletionTime;

}
