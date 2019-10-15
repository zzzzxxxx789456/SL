package com.qiudaozhang.controller;

import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sys/u")

public class SysUserController {
    @Autowired
    private UserService userService;

    @RequestMapping("to/list")
    public String toList(){
        return "sys/UserList";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseCode list(@RequestParam(value = "limit") Integer pageSize, @RequestParam(value = "page") Integer pageNum,
                             @RequestParam(value = "loginCode",defaultValue = "") String loginCode){
        ResponseCode code  = userService.find(pageSize,pageNum,loginCode);
        return code;
    }
}
