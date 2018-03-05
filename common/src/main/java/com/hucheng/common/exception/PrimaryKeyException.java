package com.hucheng.common.exception;

import org.springframework.dao.DuplicateKeyException;

/**
 * @author xuchunlin
 * @version V1.0
 * @Title: PrimaryKeyException
 * @Package com.hucheng.common.exception
 * @Description: 更新数据库唯一键异常，当插入重复的内容并且改字段设置唯一的时候触发此异常
 * @date 2017/11/28 19:19
 */
public class PrimaryKeyException extends DuplicateKeyException {

    public PrimaryKeyException(String msg) {
        super(msg);
    }
}
