package com.qiudaozhang.controller;

import com.qiudaozhang.components.FileConfig;
import com.qiudaozhang.dto.IdDto;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.dto.UserDto;
import com.qiudaozhang.model.Country;
import com.qiudaozhang.model.DataDictionary;
import com.qiudaozhang.model.User;
import com.qiudaozhang.service.CountryService;
import com.qiudaozhang.service.DataDictionaryService;
import com.qiudaozhang.service.UserService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("u")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("to/login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("login")
    public String login(User user, HttpSession session){
        User queryUser = userService.findByLoginCode(user.getLoginCode());
        if(queryUser == null){
            // 用户不存在
            return "redirect:login";
        } else if(queryUser.getPassword().equals(user.getPassword())) {
            // 成功
            queryUser.setPassword(null);
            // 更新用户最后登录时间
            userService.updateLoginTime(queryUser.getId(), LocalDateTime.now());
            session.setAttribute("sessionUser",queryUser);
            return "main";
        } else {
            // 密码错误
            return "redirect:login";
        }

    }


}
