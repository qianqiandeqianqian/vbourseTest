package com.hucheng.common.global;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: Constant
 * @Package com.hucheng.common.global
 * @Description: 常用的变量设置
 * @date 2017/11/28 19:23
 */
public class Constant {
    //系统默认版本
    public static final String DEF_SYS_VER="1.0";
    //逻辑删除状态
    public static final int DELETED=1;
    //客户端IP
    public static final String REQ_IP="client_ip";
    //客户端User-Agent
    public static final String REQ_UA="client_userAgent";
    //语言
    public static final String REQ_LANG="client_lang";
    //客户端类型，android,ios,pc
    public static final String REQ_OSTYPE="client_osType";
    //客户端版本
    public static final String REQ_APPVERSION="client_version";
    //客户端登录jwt
    public static final String REQ_LOGIN_USER="client_user";
    //系统版本变量
    public  static final String SYSTEM_VERSION="system_version";

    //系统后台用户登录SESSION存储
    public static final String SESSION_ADMIN="session_admin";
    //系统客户登录SESSION存储
    public static final String SESSION_HOME="session_home";

    public static final String ACCESS_TOKEN="access_token";

    public static final Long TOKEN_TIMEOUT_LONG=60L*1000L*60L*48L;//token超时时间，48小时
}
