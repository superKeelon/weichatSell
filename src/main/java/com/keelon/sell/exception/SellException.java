package com.keelon.sell.exception;


import com.keelon.sell.enums.ResultEnum;

//定义一个异常的类
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        /*系统中RuntimeException有一个message*/
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();

    }
}
