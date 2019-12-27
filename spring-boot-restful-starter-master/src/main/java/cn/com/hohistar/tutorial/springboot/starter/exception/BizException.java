package cn.com.hohistar.tutorial.springboot.starter.exception;

public class BizException extends RuntimeException {

    public BizException(String msg) {
        super(msg, null);
    }
}
