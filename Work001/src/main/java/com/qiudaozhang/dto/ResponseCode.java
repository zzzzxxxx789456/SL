package com.qiudaozhang.dto;

import lombok.Data;

/**
 * @author 邱道长
 * @since 2019/8/7
 */
@Data
public class ResponseCode {


    public static final int SUCCESS = 2000;

    public static final int FAIL = 4000;

    private Integer code;

    private String msg;

    private String detail;
}
