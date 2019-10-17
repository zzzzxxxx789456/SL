package com.qiudaozhang.controller;

import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.service.GoodsPackService;
import com.qiudaozhang.service.GoodsService;
import com.qiudaozhang.service.RoleService;
import com.qiudaozhang.service.UserService;
import com.qiudaozhang.service.DictionaryService;
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

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsPackService goodsPackService;

    @Autowired
    private DictionaryService dictionaryService;

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

    @RequestMapping("r/list")
    @ResponseBody
    public ResponseCode roleList(@RequestParam(value = "limit") Integer pageSize, @RequestParam(value = "page") Integer pageNum){
        ResponseCode code  = roleService.find(pageSize,pageNum);
        return code;
    }

    @RequestMapping("g/to/list")
    public String goodsToList() {
        return "sys/GoodsList";
    }

    @RequestMapping("g/list")
    @ResponseBody
    public ResponseCode goodsList(@RequestParam(value = "limit") Integer pageSize, @RequestParam(value = "page") Integer pageNum,
                                  @RequestParam(value = "goodsName",defaultValue = "") String goodsName){
        ResponseCode code  = goodsService.find(pageSize,pageNum,goodsName);
        return code;
    }

    @RequestMapping("gp/to/list")
    public String goodsPickToList() {
        return "sys/GoodsPickList";
    }

    @RequestMapping("gp/list")
    @ResponseBody
    public ResponseCode goodsPickList(@RequestParam(value = "limit") Integer pageSize, @RequestParam(value = "page") Integer pageNum,
                                  @RequestParam(value = "goodsPickName",defaultValue = "") String goodsPickName){
        ResponseCode code  = goodsPackService.find(pageSize,pageNum,goodsPickName);
        return code;
    }

    @RequestMapping("dd/to/list")
    public String dictionaryToList() {
        return "sys/Dictionary";
    }

    @RequestMapping("dd/list")
    @ResponseBody
    public ResponseCode dictionaryList(@RequestParam(value = "limit") Integer pageSize, @RequestParam(value = "page") Integer pageNum){
        ResponseCode code  = dictionaryService.find(pageSize,pageNum);
        return code;
    }
}
