package com.aop.access.access.exception;

/**
 * @Author HLX
 * @Date 2018/7/3 15:58
 */
public class MyException extends RuntimeException {

    private String msg;

    public MyException(String msg) {
        this.msg = msg;
    }
}
