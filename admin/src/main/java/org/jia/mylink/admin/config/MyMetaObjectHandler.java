package org.jia.mylink.admin.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 自定义元对象处理器（字段填充）
 * @author JIA
 * @version 1.0
 * @since 2024/3/10
 */
@Primary
@Component(value = "myMetaObjectHandlerByAdmin")
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入时字段填充
     * @param metaObject 元数据对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        strictInsertFill(metaObject, "createTime",Date::new, Date.class);
        strictInsertFill(metaObject, "updateTime",Date::new, Date.class);
        strictInsertFill(metaObject, "delFlag", () -> 0, Integer.class);
    }

    /**
     * 更新时字段填充
     * @param metaObject 元数据对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        strictInsertFill(metaObject, "updateTime", Date::new, Date.class);
    }
}
