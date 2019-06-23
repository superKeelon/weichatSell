package com.keelon.sell.dto;


import lombok.Data;

/**
 *
 * 购物车
 * created by
 * 2017
 *
 */

@Data
public class CartDTO {

    /*商品的id.*/
    private String productId;
    private Integer productQuantity;

    public CartDTO(String productId,Integer productQuantity){

        this.productId = productId;
        this.productQuantity = productQuantity;




    }












}
