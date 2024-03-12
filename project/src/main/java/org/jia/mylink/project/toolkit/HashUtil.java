package org.jia.mylink.project.toolkit;

import cn.hutool.core.lang.hash.MurmurHash;

/**
 * Hash工具类
 * @author JIA
 * @version 1.0
 * @since 2024/3/12
 */

public class HashUtil {

    /**
     * Base62 字符集
     */
    private static final char[] CHARS = new char[]{
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };


    private static final int SIZE = CHARS.length;

    /**
     * 将十进制数转换为 Base62 表示的字符串
     *
     * @param num 十进制数
     * @return Base62 表示的字符串
     */
    private static String convertDecToBase62(long num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int i = (int) (num % SIZE);
            sb.append(CHARS[i]);
            num /= SIZE;
        }
        return sb.reverse().toString();
    }

    /**
     * 将字符串哈希为 Base62 表示的字符串
     *
     * @param str 待哈希的字符串
     * @return Base62 表示的哈希字符串
     */
    public static String hashToBase62(String str) {
        // 使用 MurmurHash 哈希算法将字符串转换为 32 位整数
        int i = MurmurHash.hash32(str);
        // 将哈希值转换为长整型
        long num = i < 0 ? Integer.MAX_VALUE - (long) i : i;
        // 将长整型数转换为 Base62 表示的字符串
        return convertDecToBase62(num);
    }
}
