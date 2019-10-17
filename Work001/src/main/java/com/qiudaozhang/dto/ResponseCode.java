package com.qiudaozhang.dto;

import lombok.Data;


@Data
public class ResponseCode {


    /**
     * 通用的成功
     */
    public static final int SUCCESS = 2000;

    /**
     * 通用的失败
     */
    public static final int FAIL = 4000;

    private Integer code;

    private String msg;

    private String detail;

    private Object data;

    private Long count;

//    private Integer page;
//
//    private Integer limit;


}
