package com.qiudaozhang.dto;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserDto {


    private String loginCode;

    private String oldPwd;

    private String oldPwd2;

    private String newPwd;

    private String newPwd2;
}
