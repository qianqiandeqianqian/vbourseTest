package com.hucheng.common.codec;

/**
* @Description: http返回内容状态码
* @author xuchunlin
* @date 2017/11/29 16:19
* @version V1.0
*/
public enum  HttpCoder {
    SUCCESS (1),//成功
    FAILED  (0),//失败
    CHECK   (2),//校验，提示
    TOKEN_TIMEOUT (-1),//token登录超时
    ADMIN_TIMEOUT  (-1),//后台登录超时
    HOME_TIMEOUT (-2);//用户登录超时

    private int code;

    HttpCoder() {
    }

    HttpCoder(int code){
       this.code=code;
    }

    public int getCode() {
        return code;
    }
}
