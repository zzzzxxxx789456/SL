package com.qiudaozhang.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * au_user
 * @author 
 */
@Getter
@Setter
public class User implements Serializable {
    private User recommender;

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 登录账号
     */
    private String loginCode;

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
    private String userName;

    /**
     * 性别
     */
    private String sex;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 证件类型id
     */
    private String cardType;

    /**
     * 证件类型名称
     */
    private String cardTypeName;

    /**
     * 证件号码
     */
    private String idCard;

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
    private String userAddress;

    /**
     * 邮编
     */
    private String postCode;

    /**
     * 注册时间
     */
    private LocalDateTime createTime;

    /**
     * 推荐人id（默认为当前登录用户id）
     */
    private Long referId;

    /**
     * 推荐人编码（默认为当前登录用户loginCode）
     */
    private String referCode;

    /**
     * 所属角色ID
     */
    private Long roleId;

    /**
     * 所属角色名称
     */
    private String roleName;

    /**
     * 用户类型id
     */
    private String userType;

    /**
     * 用户类型名称
     */
    private String userTypeName;

    /**
     * 是否启用（1、启用2、未启用）
     */
    private Integer isStart;

    /**
     * 最新更新时间
     */
    private LocalDateTime lastUpdateTime;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginTime;

    /**
     * 开户卡号
     */
    private String bankAccount;

    /**
     * 开户行
     */
    private String bankName;

    /**
     * 开户人
     */
    private String accountHolder;

    /**
     * 身份证照片反面图路径
     */
    private String idCardPicNegPath;

    /**
     * 身份证照片正面图路径
     */
    private String idCardPicPosPath;

    /**
     * 银行卡照片存放路径
     */
    private String bankPicPath;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardTypeName() {
        return cardTypeName;
    }

    public void setCardTypeName(String cardTypeName) {
        this.cardTypeName = cardTypeName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Long getReferId() {
        return referId;
    }

    public void setReferId(Long referId) {
        this.referId = referId;
    }

    public String getReferCode() {
        return referCode;
    }

    public void setReferCode(String referCode) {
        this.referCode = referCode;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public Integer getIsStart() {
        return isStart;
    }

    public void setIsStart(Integer isStart) {
        this.isStart = isStart;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public String getIdCardPicNegPath() {
        return idCardPicNegPath;
    }

    public void setIdCardPicNegPath(String idCardPicNegPath) {
        this.idCardPicNegPath = idCardPicNegPath;
    }

    public String getIdCardPicPosPath() {
        return idCardPicPosPath;
    }

    public void setIdCardPicPosPath(String idCardPicPosPath) {
        this.idCardPicPosPath = idCardPicPosPath;
    }

    public String getBankPicPath() {
        return bankPicPath;
    }

    public void setBankPicPath(String bankPicPath) {
        this.bankPicPath = bankPicPath;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLoginCode() == null ? other.getLoginCode() == null : this.getLoginCode().equals(other.getLoginCode()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getPassword2() == null ? other.getPassword2() == null : this.getPassword2().equals(other.getPassword2()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getCardType() == null ? other.getCardType() == null : this.getCardType().equals(other.getCardType()))
            && (this.getCardTypeName() == null ? other.getCardTypeName() == null : this.getCardTypeName().equals(other.getCardTypeName()))
            && (this.getIdCard() == null ? other.getIdCard() == null : this.getIdCard().equals(other.getIdCard()))
            && (this.getCountry() == null ? other.getCountry() == null : this.getCountry().equals(other.getCountry()))
            && (this.getMobile() == null ? other.getMobile() == null : this.getMobile().equals(other.getMobile()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getUserAddress() == null ? other.getUserAddress() == null : this.getUserAddress().equals(other.getUserAddress()))
            && (this.getPostCode() == null ? other.getPostCode() == null : this.getPostCode().equals(other.getPostCode()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getReferId() == null ? other.getReferId() == null : this.getReferId().equals(other.getReferId()))
            && (this.getReferCode() == null ? other.getReferCode() == null : this.getReferCode().equals(other.getReferCode()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getRoleName() == null ? other.getRoleName() == null : this.getRoleName().equals(other.getRoleName()))
            && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
            && (this.getUserTypeName() == null ? other.getUserTypeName() == null : this.getUserTypeName().equals(other.getUserTypeName()))
            && (this.getIsStart() == null ? other.getIsStart() == null : this.getIsStart().equals(other.getIsStart()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastLoginTime() == null ? other.getLastLoginTime() == null : this.getLastLoginTime().equals(other.getLastLoginTime()))
            && (this.getBankAccount() == null ? other.getBankAccount() == null : this.getBankAccount().equals(other.getBankAccount()))
            && (this.getBankName() == null ? other.getBankName() == null : this.getBankName().equals(other.getBankName()))
            && (this.getAccountHolder() == null ? other.getAccountHolder() == null : this.getAccountHolder().equals(other.getAccountHolder()))
            && (this.getIdCardPicNegPath() == null ? other.getIdCardPicNegPath() == null : this.getIdCardPicNegPath().equals(other.getIdCardPicNegPath()))
            && (this.getIdCardPicPosPath() == null ? other.getIdCardPicPosPath() == null : this.getIdCardPicPosPath().equals(other.getIdCardPicPosPath()))
            && (this.getBankPicPath() == null ? other.getBankPicPath() == null : this.getBankPicPath().equals(other.getBankPicPath()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLoginCode() == null) ? 0 : getLoginCode().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getPassword2() == null) ? 0 : getPassword2().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getCardType() == null) ? 0 : getCardType().hashCode());
        result = prime * result + ((getCardTypeName() == null) ? 0 : getCardTypeName().hashCode());
        result = prime * result + ((getIdCard() == null) ? 0 : getIdCard().hashCode());
        result = prime * result + ((getCountry() == null) ? 0 : getCountry().hashCode());
        result = prime * result + ((getMobile() == null) ? 0 : getMobile().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getUserAddress() == null) ? 0 : getUserAddress().hashCode());
        result = prime * result + ((getPostCode() == null) ? 0 : getPostCode().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getReferId() == null) ? 0 : getReferId().hashCode());
        result = prime * result + ((getReferCode() == null) ? 0 : getReferCode().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getUserTypeName() == null) ? 0 : getUserTypeName().hashCode());
        result = prime * result + ((getIsStart() == null) ? 0 : getIsStart().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastLoginTime() == null) ? 0 : getLastLoginTime().hashCode());
        result = prime * result + ((getBankAccount() == null) ? 0 : getBankAccount().hashCode());
        result = prime * result + ((getBankName() == null) ? 0 : getBankName().hashCode());
        result = prime * result + ((getAccountHolder() == null) ? 0 : getAccountHolder().hashCode());
        result = prime * result + ((getIdCardPicNegPath() == null) ? 0 : getIdCardPicNegPath().hashCode());
        result = prime * result + ((getIdCardPicPosPath() == null) ? 0 : getIdCardPicPosPath().hashCode());
        result = prime * result + ((getBankPicPath() == null) ? 0 : getBankPicPath().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loginCode=").append(loginCode);
        sb.append(", password=").append(password);
        sb.append(", password2=").append(password2);
        sb.append(", userName=").append(userName);
        sb.append(", sex=").append(sex);
        sb.append(", birthday=").append(birthday);
        sb.append(", cardType=").append(cardType);
        sb.append(", cardTypeName=").append(cardTypeName);
        sb.append(", idCard=").append(idCard);
        sb.append(", country=").append(country);
        sb.append(", mobile=").append(mobile);
        sb.append(", email=").append(email);
        sb.append(", userAddress=").append(userAddress);
        sb.append(", postCode=").append(postCode);
        sb.append(", createTime=").append(createTime);
        sb.append(", referId=").append(referId);
        sb.append(", referCode=").append(referCode);
        sb.append(", roleId=").append(roleId);
        sb.append(", roleName=").append(roleName);
        sb.append(", userType=").append(userType);
        sb.append(", userTypeName=").append(userTypeName);
        sb.append(", isStart=").append(isStart);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", bankName=").append(bankName);
        sb.append(", accountHolder=").append(accountHolder);
        sb.append(", idCardPicNegPath=").append(idCardPicNegPath);
        sb.append(", idCardPicPosPath=").append(idCardPicPosPath);
        sb.append(", bankPicPath=").append(bankPicPath);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}