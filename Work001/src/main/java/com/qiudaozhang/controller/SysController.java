package com.qiudaozhang.controller;

import com.qiudaozhang.components.FileConfig;
import com.qiudaozhang.dto.IdDto;
import com.qiudaozhang.dto.ResponseCode;
import com.qiudaozhang.model.Role;
import com.qiudaozhang.model.User;
import com.qiudaozhang.model.Country;
import com.qiudaozhang.model.DataDictionary;
import com.qiudaozhang.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;


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
    private BasicDataService basicDataService;

    @Autowired
    private DataDictionaryService dictionaryService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private FileConfig fileConfig;

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

    @RequestMapping("u/to/add")
    public String userToAdd(Model model){
        // 获取所有的角色
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles",roles);
        // 获取所有会员类型
        List<DataDictionary> userTypes = dictionaryService.findByTypeCode("USER_TYPE");
        model.addAttribute("userTypes",userTypes);
        // 获取所有证件类型
        List<DataDictionary> cardTypes = dictionaryService.findByTypeCode("CARD_TYPE");
        model.addAttribute("cardTypes",cardTypes);
        // 获取所有国家
        List<Country> countries = countryService.findAll();
        model.addAttribute("countries",countries);
        return "sys/add/UserAdd";
    }

    @RequestMapping("u/add")
    public String add(User user,
                      @RequestParam("idCardPicPosPathFile") MultipartFile idCardPicPosPathFile ,
                      @RequestParam("idCardPicNegPathFile") MultipartFile idCardPicNegPathFile ,
                      @RequestParam("bankPicPathFile") MultipartFile bankPicPathFile,
                      HttpSession session
    ){
        User sessionUser = (User) session.getAttribute("sessionUser");
        // 处理文件上传
        File dest1  = new File(fileConfig.getUploadRootPath(),idCardPicPosPathFile.getOriginalFilename());
        File dest2  = new File(fileConfig.getUploadRootPath(),idCardPicNegPathFile.getOriginalFilename());
        File dest3  = new File(fileConfig.getUploadRootPath(),bankPicPathFile.getOriginalFilename());
        try {
            idCardPicPosPathFile.transferTo(dest1);
            idCardPicNegPathFile.transferTo(dest2);
            bankPicPathFile.transferTo(dest3);
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setIdCardPicPosPath(idCardPicPosPathFile.getOriginalFilename());
        user.setIdCardPicNegPath(idCardPicNegPathFile.getOriginalFilename());
        user.setBankPicPath(bankPicPathFile.getOriginalFilename());
        user.setRecommender(sessionUser);
        userService.add(user);
        return "sys/UserList";
    }

    @RequestMapping("u/del")
    @ResponseBody
    public ResponseCode userDel(@RequestParam(value = "id") Long id){
        ResponseCode code = userService.delById(id);
        return code;
    }

    @RequestMapping("u/delGroup")
    @ResponseBody
    public ResponseCode userDelGroup(@RequestBody IdDto idDto){
        ResponseCode code = userService.delGroup(idDto.getIds());
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

    @RequestMapping("r/del")
    @ResponseBody
    public ResponseCode roleDel(@RequestParam(value = "id") Long id){
        ResponseCode code = roleService.delById(id);
        return code;
    }

    @RequestMapping("r/delGroup")
    @ResponseBody
    public ResponseCode roleDelGroup(@RequestBody IdDto idDto){
        ResponseCode code = roleService.delGroup(idDto.getIds());
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

    @RequestMapping("g/del")
    @ResponseBody
    public ResponseCode goodsDel(@RequestParam(value = "id") Long id){
        ResponseCode code = goodsService.delById(id);
        return code;
    }

    @RequestMapping("g/delGroup")
    @ResponseBody
    public ResponseCode goodsDelGroup(@RequestBody IdDto idDto){
        ResponseCode code = goodsService.delGroup(idDto.getIds());
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

    @RequestMapping("gp/del")
    @ResponseBody
    public ResponseCode goodsPickDel(@RequestParam(value = "id") Long id){
        ResponseCode code = goodsPackService.delById(id);
        return code;
    }

    @RequestMapping("gp/delGroup")
    @ResponseBody
    public ResponseCode goodsPickDelGroup(@RequestBody IdDto idDto){
        ResponseCode code = goodsPackService.delGroup(idDto.getIds());
        return code;
    }


    @RequestMapping("bp/to/list")
    public String basicsToList() {
        return "sys/BasicDataList";
    }

    @RequestMapping("bp/list")
    @ResponseBody
    public ResponseCode basicsList(@RequestParam(value = "limit") Integer pageSize, @RequestParam(value = "page") Integer pageNum){
        ResponseCode code  = basicDataService.find(pageSize,pageNum);
        return code;
    }

    @RequestMapping("bp/del")
    @ResponseBody
    public ResponseCode basicsDel(@RequestParam(value = "id") Long id){
        ResponseCode code = basicDataService.delById(id);
        return code;
    }

    @RequestMapping("bp/delGroup")
    @ResponseBody
    public ResponseCode basicsDelGroup(@RequestBody IdDto idDto){
        ResponseCode code = basicDataService.delGroup(idDto.getIds());
        return code;
    }


    @RequestMapping("dd/to/list")
    public String dictionaryToList() {
        return "sys/DictionaryList";
    }

    @RequestMapping("dd/list")
    @ResponseBody
    public ResponseCode dictionaryList(@RequestParam(value = "limit") Integer pageSize, @RequestParam(value = "page") Integer pageNum){
        ResponseCode code  = dictionaryService.find(pageSize,pageNum);
        return code;
    }

    @RequestMapping("dd/del")
    @ResponseBody
    public ResponseCode dictionaryDel(@RequestParam(value = "id") Long id){
        ResponseCode code = dictionaryService.delById(id);
        return code;
    }

    @RequestMapping("dd/delGroup")
    @ResponseBody
    public ResponseCode dictionaryDelGroup(@RequestBody IdDto idDto){
        ResponseCode code = dictionaryService.delGroup(idDto.getIds());
        return code;
    }
}
