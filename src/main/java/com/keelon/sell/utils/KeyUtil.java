package com.keelon.sell.utils;

import java.util.Random;

public class KeyUtil{

//+i
//

/*
*生成唯一的主键
* 格式：时间++
*
* */
  public static String genUniquekey(){
      Random random = new Random();
      Integer number = random.nextInt(900000);
//      System.currentTimeMillis();
      Integer a= random.nextInt(900000)+100000;
      return System.currentTimeMillis()+String.valueOf(number);





  }



}
