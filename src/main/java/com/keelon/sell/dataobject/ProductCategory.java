package com.keelon.sell.dataobject;


import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Entity
@DynamicUpdate
@Proxy(lazy = false)
@Data
public class ProductCategory {


    /*类目id*/
    @Id        //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //自增类型
    private  Integer categoryId;
    /*类目的名字*/
    private  String categoryName;
    /*类目的编号*/
    private  Integer categoryType;

    private Date updateTime;
    private Date createTime;



}
