package com.qiudaozhang.controller;

import com.qiudaozhang.dto.IdDto;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.model.Role;
import com.qiudaozhang.model.User;
import com.qiudaozhang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

/**
 * @author 深圳邱道长
 * @since 2019/10/10
 */
@Controller
@RequestMapping("role")
public class RoleController {


    @Autowired
    private RoleService roleService;


    @RequestMapping("to/list")
    public String toList() {
        return "role/list";
    }

    @RequestMapping("to/add")
    public String toAdd() {
        return "role/add";
    }


    @RequestMapping("add")
    public String add(Role role, HttpSession session) {
        User sessionUser = (User) session.getAttribute("sessionUser");
        role.setCreatedBy(sessionUser.getLoginCode());
        role.setCreateDate(LocalDate.now());
        roleService.save(role);
        return "redirect:/role/to/list";
    }



    @RequestMapping("list")
    @ResponseBody
    public ResponseCode list(){
        ResponseCode code = new ResponseCode();
        code.setData(roleService.findAll());
        code.setCode(0);
        return code;
    }

    @RequestMapping("delGroup")
    @ResponseBody
    public ResponseCode delGroup(@RequestBody IdDto idDto){
        ResponseCode code =  roleService.delByIds(idDto.getIds());
        return code;
    }
}
