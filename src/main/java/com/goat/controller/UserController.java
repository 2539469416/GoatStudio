package com.goat.controller;/**
 * @author lwj
 * @date 2021/7/8 8:12
 * @version 1.0
 */

import com.goat.entity.User;
import com.goat.jwt.TokenUtil;
import com.goat.service.impl.UserServiceImpl;
import com.goat.util.ResultUtil;
import com.goat.vo.LoginUserVo;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassNameUserController
 * @Descriprion
 * @AuthorLenovo
 * @Date 2021/7/88:12
 * @Version 1.0
 */
@Api(description = "登录")
@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    //登录
    @RequestMapping("/login")
    public ResultUtil<LoginUserVo> Login(@RequestParam("email") String username, @RequestParam("password") String password){
        logger.info("登录--username："+username+"-password："+password);

        User user = userServiceImpl.queryUserByUserName(username);

        if(user==null){
            return ResultUtil.buildResult(ResultUtil.Status.USER_NOT);
        } else if(password.equals(user.getPassword())){
            String token = TokenUtil.getToken(user);
            LoginUserVo loginUserVo = new LoginUserVo(user,token);
            return ResultUtil.buildResult(ResultUtil.Status.OK,loginUserVo);
        }else if (!password.equals(user.getUsername())){
            return ResultUtil.buildResult(ResultUtil.Status.PWD_ERROR);
        }

        return ResultUtil.buildResult(ResultUtil.Status.NOT_FOUND);
    }


    //退出登录
    @RequestMapping("/loginOut")
    public ResultUtil<String> LoginOut(String token){
        logger.info("用户退出");
        return ResultUtil.buildResult(ResultUtil.Status.OK,"ok");
    }

    //注册
    @RequestMapping("/register")
    public ResultUtil<String> register(String username,String password){
        logger.info("注册--username："+username+"-password："+password);
        if (userServiceImpl.queryUserByUserName(username)!=null){
            return ResultUtil.buildResult(ResultUtil.Status.EXIT,"用户存在");
        }
        User user = new User(username,password);
        boolean state = userServiceImpl.register(user);
        if (state){
            return ResultUtil.buildResult(ResultUtil.Status.OK,"注册成功");
        }

        return ResultUtil.buildResult(ResultUtil.Status.INTERNAL_SERVER_ERROR,"未知错误");
    }
}
