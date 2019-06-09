package com.keelon.sell.VO;


import lombok.Data;

/*

http请求的最外层对象。


 */

@Data
public class ResultVO<T>{


    //code当做错误码来使用。


    private Integer code;
    //提示信息；
    private String msg;

    /* 返回具体内容*/

    private T data;





}
