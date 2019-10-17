package com.qiudaozhang.controller;

import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.service.RoleService;
import com.qiudaozhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sys")

public class SysController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping("u/to/list")
    public String userToList(){
        return "sys/UserList";
    }

    @RequestMapping("u/list")
    @ResponseBody
    public ResponseCode userList(@RequestParam(value = "limit") Integer pageSize, @RequestParam(value = "page") Integer pageNum,
                             @RequestParam(value = "loginCode",defaultValue = "") String loginCode){
        ResponseCode code  = userService.find(pageSize,pageNum,loginCode);
        return code;
    }

    @RequestMapping("r/to/list")
    public String roleToList() {
        return "sys/RoleList";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseCode roleList(@RequestParam(value = "limit") Integer pageSize, @RequestParam(value = "page") Integer pageNum,
                                 @RequestParam(value = "loginCode",defaultValue = "") String loginCode){
        ResponseCode code  = roleService.find(pageSize,pageNum,loginCode);
        return code;
    }
}
