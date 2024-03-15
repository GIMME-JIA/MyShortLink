package org.jia.mylink.project.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 短链接有效期类型枚举类
 * @author JIA
 * @version 1.0
 * @since 2024/3/14
 */
@RequiredArgsConstructor
public enum VailDateTypeEnum {
    /**
     * 永久有效
     */
    PERMANENT(0),

    /**
     * 自定义有效期
     */
    CUSTOM(1);

    @Getter
    private final int type;
}
