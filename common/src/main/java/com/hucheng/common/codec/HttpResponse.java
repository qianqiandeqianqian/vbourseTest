package com.hucheng.common.codec;

import java.io.Serializable;
import java.util.HashMap;

/**
* @Description: ajax统一返回格式对象
* @author xuchunlin
* @date 2017/11/29 16:17
* @version V1.0
*/
public class HttpResponse<T> implements Serializable{
    private int code=0;
    private String message="";
    private T body;
    public HttpResponse(){}

    public HttpResponse success(String message,T body){
        if(message==null){message="";}
        this.code= HttpCoder.SUCCESS.getCode();
        this.message=message;
        this.body=body;
        return this;
    }
    public HttpResponse success(String message){
        return success(message,null);
    }

    public HttpResponse success(T body){
        return success("",body);
    }

    public HttpResponse failed(String message,T body){
        if(message==null){message="";}
        this.code= HttpCoder.FAILED.getCode();
        this.message=message;
        this.body=body;
        return this;
    }

    public HttpResponse failed(String message){
        return failed(message,null);
    }

    public HttpResponse failed(String... message){
        String[] val=new String[message.length-1];
        for(int i=1;i<message.length;i++){
            val[i-1]=message[i];
        }
        return failed(String.format(message[0],val),null);
    }

    public HttpResponse failed(T body){
        return failed("",body);
    }

    public HttpResponse check(String message,T body){
        if(message==null){message="";}
        this.code= HttpCoder.CHECK.getCode();
        this.message=message;
        this.body=body;
        return this;
    }

    public HttpResponse check(String message){
        return check(message,null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public HttpResponse homeTimeout(String message){
        if(message==null){message="";}
        this.code= HttpCoder.HOME_TIMEOUT.getCode();
        this.message=message;
        this.body=body;
        return this;
    }

    public HttpResponse adminTimeout(String message){
        if(message==null){message="";}
        this.code= HttpCoder.ADMIN_TIMEOUT.getCode();
        this.message=message;
        this.body=body;
        return this;
    }

    public HttpResponse tokenTimeout(String message){
        if(message==null){message="";}
        this.code= HttpCoder.TOKEN_TIMEOUT.getCode();
        this.message=message;
        this.body=body;
        return this;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getBody() {
        if(body==null){
            return new HashMap();
        }
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

}
