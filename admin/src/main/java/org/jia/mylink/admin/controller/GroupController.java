package org.jia.mylink.admin.controller;

import lombok.RequiredArgsConstructor;
import org.jia.mylink.admin.service.GroupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 分组管理控制层
 * @author JIA
 * @version 1.0
 * @since 2024/3/11
 */
@RestController
@RequestMapping(path = "/api/short-link/admin/v1/group")
@RequiredArgsConstructor
public class GroupController {

    private final GroupService groupService;


}
