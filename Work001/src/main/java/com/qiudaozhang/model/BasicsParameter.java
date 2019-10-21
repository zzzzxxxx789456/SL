package com.qiudaozhang.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * basics_parameter
 * @author 
 */
@Getter
@Setter
public class BasicsParameter implements Serializable {
    private String id;

    private String name;

    private String code;

    private String value;

    private String description;

    private String dr;

    private static final long serialVersionUID = 1L;

}