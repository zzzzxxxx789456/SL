package com.qiudaozhang.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 深圳邱道长
 * @since 2019/10/8
 */
@Setter
@Getter
public class UserDto {


    private String loginCode;

    private String oldPwd;

    private String oldPwd2;

    private String newPwd;

    private String newPwd2;
}
