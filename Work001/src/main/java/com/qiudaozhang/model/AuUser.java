package com.qiudaozhang.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * au_user
 * @author 
 */
@Getter
@Setter
public class AuUser implements Serializable {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 登录账号
     */
    private String logincode;

    /**
     * 登录密码（初始密码为证件号码后六位）
     */
    private String password;

    /**
     * 二级密码（初始密码为证件号码后六位）
     */
    private String password2;

    /**
     * 用户真实姓名
     */
    private String username;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 证件类型id
     */
    private String cardtype;

    /**
     * 证件类型名称
     */
    private String cardtypename;

    /**
     * 证件号码
     */
    private String idcard;

    /**
     * 收货国家
     */
    private String country;

    /**
     * 手机
     */
    private String mobile;

    /**
     * email
     */
    private String email;

    /**
     * 收获地址
     */
    private String useraddress;

    /**
     * 邮编
     */
    private String postcode;

    /**
     * 注册时间
     */
    private Date createtime;

    /**
     * 推荐人id（默认为当前登录用户id）
     */
    private Long referid;

    /**
     * 推荐人编码（默认为当前登录用户loginCode）
     */
    private String refercode;

    /**
     * 所属角色ID
     */
    private Long roleid;

    /**
     * 所属角色名称
     */
    private String rolename;

    /**
     * 用户类型id
     */
    private String usertype;

    /**
     * 用户类型名称
     */
    private String usertypename;

    /**
     * 是否启用（1、启用2、未启用）
     */
    private Integer isstart;

    /**
     * 最新更新时间
     */
    private Date lastupdatetime;

    /**
     * 最后登录时间
     */
    private Date lastlogintime;

    /**
     * 开户卡号
     */
    private String bankaccount;

    /**
     * 开户行
     */
    private String bankname;

    /**
     * 开户人
     */
    private String accountholder;

    /**
     * 身份证照片存放路径
     */
    private String idcardpicpath;

    /**
     * 银行卡照片存放路径
     */
    private String bankpicpath;


}