package com.keelon.sell.service.impl;


import com.keelon.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    ProductInfo findOne(String productId);

    /*
    * 查询所有在架的商品
    *
    *
    * */

    List<ProductInfo> findAll();


    List<ProductInfo> findUpAll();
    /*
    * 分页查找。
    * */

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存。




    //减库存。






}
