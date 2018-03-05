package com.hucheng.rmi.codec;

import java.io.Serializable;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: RMIResult
 * @Package com.hucheng.rmi.codec
 * @Description: TODO
 * @date 2017/12/28 17:52
 */
public class RMIResponse<T extends AbsTransactionResult> implements Serializable{
    private int code=EnumsRmiCode.FAILURE.code;
    private String attr="";
    private String message="";
    private T body;

    public RMIResponse success(String message,T t){
        this.code=EnumsRmiCode.SUCCESS.code;
        this.message=message;
        this.body=t;
        return this;
    }
    public RMIResponse success(String message){
        return success(message,null);
    }
    public RMIResponse success(){
        return success("",null);
    }

    public RMIResponse failure(String message,T t){
        this.code=EnumsRmiCode.FAILURE.code;
        this.message=message;
        this.body=t;
        return this;
    }
    public RMIResponse failure(String message){
        return failure(message,null);
    }
    public RMIResponse failure(){
        return failure("",null);
    }

    public RMIResponse validate(String message,T t){
        this.code=EnumsRmiCode.VALIDATE.code;
        this.message=message;
        this.body=t;
        return this;
    }
    public RMIResponse validate(String message){
        return validate(message,null);
    }

    public RMIResponse attr(String attr){
        this.attr=attr;
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public static enum EnumsRmiCode{
        FAILURE(0),
        SUCCESS(1),
        VALIDATE(2);
        private int code;

        EnumsRmiCode(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }
}
