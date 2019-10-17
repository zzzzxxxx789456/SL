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

/**
 * @author 深圳邱道长
 * @since 2019/10/7
 */
@Controller
@RequestMapping("u")
public class UserController {

    @Autowired
    private FileConfig fileConfig;

    @Autowired
    private UserService userService;

    @Autowired
    private DataDictionaryService dataDictionaryService;

    @Autowired
    private CountryService countryService;

    @RequestMapping("to/register")
    public String toRegister(Model model){
        // 查询数据字典里面的卡的类型
        List<DataDictionary> dataDictionaries = dataDictionaryService.findByTypeCode("CARD_TYPE");
        model.addAttribute("cardTypes",dataDictionaries);
        // 查询国家信息
        List<Country> countries = countryService.findAll();
        model.addAttribute("countries",countries);
        return "u/register";
    }

    @RequestMapping("register")
    public String register(User user,
                           @RequestParam("idCardPicPosPathFile") MultipartFile idCardPicPosPathFile ,
                           @RequestParam("idCardPicNegPathFile") MultipartFile idCardPicNegPathFile ,
                           @RequestParam("bankPicPathFile") MultipartFile bankPicPathFile
    ){
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
        userService.save(user);
        return "u/register";
    }

    @RequestMapping("to/modify/pwd")
    public String toModifyPwd(){
        return "u/modifypwd";
    }

    @RequestMapping("modify/pwd")
    @ResponseBody
    public ResponseCode modifyPwd(UserDto userDto , HttpSession session){
        Object sessionUser = session.getAttribute("sessionUser");

        if(sessionUser == null){
            ResponseCode code = new ResponseCode();
            code.setCode(ResponseCode.FAIL);
            code.setMsg("您还未登录，无法修改密码！");
            return code;
        }

        User u = (User) sessionUser;
        // 查询真实的旧密码
        userDto.setLoginCode(u.getLoginCode());
        ResponseCode code = userService.modifyPwd(userDto);
        return  code;
    }

    @RequestMapping("modify/pwd2")
    @ResponseBody
    public ResponseCode modifyPwd2(UserDto userDto , HttpSession session){
        Object sessionUser = session.getAttribute("sessionUser");

        if(sessionUser == null){
            ResponseCode code = new ResponseCode();
            code.setCode(ResponseCode.FAIL);
            code.setMsg("您还未登录，无法修改密码！");
            return code;
        }

        User u = (User) sessionUser;
        // 查询真实的旧密码
        userDto.setLoginCode(u.getLoginCode());
        ResponseCode code = userService.modifyPwd2(userDto);
        return  code;
    }





    @RequestMapping("to/login")
    public String toLogin(){
        return "u/login";
    }

    @RequestMapping("login")
    public String login(User user, HttpSession session){
        User queryUser = userService.findByLoginCode(user.getLoginCode());
        if(queryUser == null){
            // 用户不存在
            return "redirect:u/login";
        } else if(queryUser.getPassword().equals(user.getPassword())) {
            // 成功
            queryUser.setPassword(null);
            // 更新用户最后登录时间
            userService.updateLoginTime(queryUser.getId(), LocalDateTime.now());
            session.setAttribute("sessionUser",queryUser);
            return "u/main";
        } else {
            // 密码错误
            return "redirect:u/login";
        }

    }


    @RequestMapping("to/modify")
    public String toModify(HttpSession session,Model model){
        User sessionUser = (User) session.getAttribute("sessionUser");
        String loginCode = sessionUser.getLoginCode();
        User u = userService.findDetailByLoginCode(loginCode);
        model.addAttribute("user",u);
        // 查阅证件类型
        List<DataDictionary> dataDictionaries = dataDictionaryService.findByTypeCode("CARD_TYPE");
        model.addAttribute("cardTypes",dataDictionaries);
        // 查询国家信息
        List<Country> countries = countryService.findAll();
        model.addAttribute("countries",countries);
        return "u/modify";
    }

    @RequestMapping("modify")
    public String modify(User user ,
                         @RequestParam("idCardPicPosPathFile") MultipartFile idCardPicPosPathFile ,
                         @RequestParam("idCardPicNegPathFile") MultipartFile idCardPicNegPathFile ,
                         @RequestParam("bankPicPathFile") MultipartFile bankPicPathFile){
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
        userService.modify(user);
        return "u/main";
    }

    @RequestMapping("to/list")
    public String toList(){
        return "u/list";
    }

    @RequestMapping("list")
    @ResponseBody
    public ResponseCode list(@RequestParam(value = "limit") Integer pageSize, @RequestParam(value = "page") Integer pageNum){
        ResponseCode code  = userService.find(pageSize,pageNum);
        return code;
    }

    @RequestMapping("del/{id}")
    @ResponseBody
    public ResponseCode del(@PathVariable("id") Long id){
        ResponseCode code = userService.delById(id);
        return code;
    }

    @RequestMapping("delGroup")
    @ResponseBody
    public ResponseCode delGroup(@RequestBody IdDto idDto){
        ResponseCode code = userService.delGroup(idDto.getIds());
        return code;
    }
}
