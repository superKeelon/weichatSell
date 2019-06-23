package com.keelon.sell.enums;


import lombok.Getter;

//定义一个异常消息枚举
@Getter
public enum ResultEnum {

    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(10,"商品不存在"),

    ;


    private  Integer code;
    private  String message;

    //定义一个构造方法。
    ResultEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
