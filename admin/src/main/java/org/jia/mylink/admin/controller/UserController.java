package org.jia.mylink.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import lombok.RequiredArgsConstructor;
import org.jia.mylink.admin.common.convention.result.Result;
import org.jia.mylink.admin.common.convention.result.Results;
import org.jia.mylink.admin.dto.request.UserLoginReqDTO;
import org.jia.mylink.admin.dto.request.UserRegisterReqDTO;
import org.jia.mylink.admin.dto.request.UserUpdateReqDTO;
import org.jia.mylink.admin.dto.response.UserActualRespDTO;
import org.jia.mylink.admin.dto.response.UserLoginRespDTO;
import org.jia.mylink.admin.dto.response.UserRespDTO;
import org.jia.mylink.admin.service.UserService;
import org.springframework.web.bind.annotation.*;

/**
 * 用户管理控制层
 *
 * @author JIA
 * @version 1.0
 * @since 2024/3/7
 */
@RestController
@RequestMapping(path = "/api/short-link/admin/v1/user")
@RequiredArgsConstructor    // 通过lombok的构造器注入代替@Autowired和@Resource
public class UserController {

    private final UserService userService;

    /**
     * 根据用户名查询用户
     * @param username 用户名
     */
    @GetMapping("/{username}")
    public Result<UserRespDTO> getUserByUserName(@PathVariable("username") String username){

        return Results.success(userService.getUserbyUserName(username)) ;
    }

    /**
     * 根据用户名查询无脱敏用户信息
     * @param username 用户名
     */
    @GetMapping("/actual/{username}")
    public Result<UserActualRespDTO> getActualUserByUserName(@PathVariable("username") String username){

        return Results.success(BeanUtil.toBean(userService.getUserbyUserName(username), UserActualRespDTO.class)) ;
    }

    /**
     * 注册用户
     * @param requestParam 用户注册请求实体
     */
    @PostMapping
    public Result<Void> registerUser(@RequestBody UserRegisterReqDTO requestParam){
        userService.registerUser(requestParam);
        return Results.success();
    }

    /**
     * 查询用户名是否可使用
     * @param username 用户名
     */
    @GetMapping("/has-username")
    public Result<Boolean> hasUsername(@RequestParam("username") String username){
        return Results.success(userService.hasUsername(username));
    }

    /**
     * 更新用户信息
     * @param requestParam 用户信息修改请求实体
     */
    @PutMapping
    public Result<Void> updateUser(@RequestBody UserUpdateReqDTO requestParam){
        userService.updateUser(requestParam);
        return Results.success();
    }

    /**
     * 用户登录
     * @param requestParam 用户登录请求实体
     */
    @PostMapping("/login")
    public Result<UserLoginRespDTO> login(@RequestBody UserLoginReqDTO requestParam){
        return Results.success(userService.login(requestParam));
    }

    /**
     * 校验用户是否处于登录状态
     * @param token 登录标识
     */
    @GetMapping("/check-login")
    public Result<Boolean> checkLogin(@RequestParam("username") String username,@RequestParam("token") String token){
        // TODO (JIA,2024/3/11,11:48) 改为双token 模式登录
        return Results.success(userService.checkLogin(username,token));
    }



}