package org.jia.mylink.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 短链接访问跳转控制层
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/15
 */
@Controller
public class LinkNotFoundController {
    /**
     * 短链接不存在跳转页面
     * @return 文件名称：会定位到/resources/templates/notfound.html
     */
    @RequestMapping("/page/notfound")
    public String notfound() {
        return "notfound";
    }
}
