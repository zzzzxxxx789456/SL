package com.qiudaozhang.controller;

import com.qiudaozhang.components.FileConfig;
import com.qiudaozhang.model.Country;
import com.qiudaozhang.model.DataDictionary;
import com.qiudaozhang.model.User;
import com.qiudaozhang.service.CountryService;
import com.qiudaozhang.service.DataDictionaryService;
import com.qiudaozhang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private DataDictionaryService dataDictionaryService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private UserService userService;
    @Autowired
    private FileConfig fileConfig;

    @RequestMapping("to/login")
    public String toLogin() {
        return "user/login";
    }

    @RequestMapping("login")
    public String login(User user, HttpSession session) {
        User queryUser = userService.findByLoginCode(user.getLoginCode());
        if (queryUser == null) {
            return "redirect:user/login";
        } else if (queryUser.getPassword().equals(user.getPassword())) {
            queryUser.setPassword(null);
            userService.updateLoginTime(queryUser.getId(), LocalDateTime.now());
            session.setAttribute("sessionUser", queryUser);
            return "user/main";
        } else {
            return "redirect:u/login";
        }
    }

    @RequestMapping("to/register")
    public String toRegister(Model model) {
        List<DataDictionary> dataDictionaries = dataDictionaryService.findByTypeCode("CARD_TYPE");
        model.addAttribute("cardTypes", dataDictionaries);
        List<Country> countries = countryService.findAll();
        model.addAttribute("countries", countries);
        return "user/register";
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

}
