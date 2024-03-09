package org.jia.mylink.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.jia.mylink.admin.common.convention.result.Result;
import org.jia.mylink.admin.common.convention.result.Results;
import org.jia.mylink.admin.dto.response.UserActualRespDTO;
import org.jia.mylink.admin.dto.response.UserRespDTO;
import org.jia.mylink.admin.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 *
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/7
 */
@RestController
@RequiredArgsConstructor    // 通过lombok的构造器注入代替@Autowired和@Resource
public class UserController {

    private final UserService userService;

    /**
     * 根据用户名查询用户
     * @param username 用户名
     */
    @GetMapping("/api/short-link/admin/v1/user/{username}")
    public Result<UserRespDTO> getUserByUserName(@PathVariable("username") String username){

        return Results.success(userService.getUserbyUserName(username)) ;
    }

    /**
     * 根据用户名查询无脱敏用户信息
     * @param username 用户名
     */
    @GetMapping("/api/short-link/admin/v1/actual/user/{username}")
    public Result<UserActualRespDTO> getActualUserByUserName(@PathVariable("username") String username){

        return Results.success(BeanUtil.toBean(userService.getUserbyUserName(username), UserActualRespDTO.class)) ;
    }


}