package com.keelon.sell.dataobject;


import lombok.Data;
import org.hibernate.annotations.Proxy;
import javax.persistence.Id;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Proxy(lazy = false)
@Entity
@Data
public class ProductInfo {
    @Id
    private String productId;
    /*名字*/
    private String productName;
    /*单价*/
    private BigDecimal ProductPrice;
    /*库存*/
    private Integer ProductStock;
    /*描述*/
    private String ProductDescription;

    /*小图*/
    private  String productIcon;

    /*状态,0正常 1下架*/

    private Integer productStatus;




    /*状态  0正常 1下架*/
    private Integer categoryType;






}
