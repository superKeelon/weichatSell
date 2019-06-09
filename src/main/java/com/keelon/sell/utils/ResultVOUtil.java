package com.keelon.sell.utils;

import com.keelon.sell.VO.ResultVO;

public class ResultVOUtil {



    public static ResultVO success(Object object){

        ResultVO resultVO = new ResultVO();

        resultVO.setMsg("成功");
        resultVO.setCode(0);

        resultVO.setData(object);
        return  resultVO;
    }

    public static ResultVO success(){


        return success(null);
    }

    public static ResultVO error(Integer code,String msg){

        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;

    }








}
