package com.keelon.sell.service.impl.impl;

import com.keelon.sell.dataobject.ProductInfo;
import com.keelon.sell.service.impl.ProductService;
import javassist.expr.Cast;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.data.querydsl.QSort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {

       ProductInfo productInfo = productService.findOne("123456");
        Assert.assertNotEquals("123456",productInfo.getProductId());
    }

    @Test
    public void findAll() throws Exception {


        List<ProductInfo> productInfoList = productService.findAll();
        Assert.assertNotEquals(0,productInfoList.size());



    }

    @Test
    public void findUpAll() throws Exception {


        List<ProductInfo> productInfoList = productService.findUpAll();

        Assert.assertNotEquals(0,productInfoList.size());

    }

    @Test
    public void findAll1() {



        //QSort sort = new QSort(new OrderSpecifier<T>(Order.ASC, [color=#FF0000]Expression<T> target[/color]);

        PageRequest pageable  = PageRequest.of(0,5);
        Page<ProductInfo> productInfoPage =   productService.findAll(pageable);

        System.out.println(productInfoPage.getTotalElements());
    }

    @Test
    public void save() {


        ProductInfo productInfo = new ProductInfo();

        productInfo.setProductId("123457");
        productInfo.setProductName("皮皮虾");
        productInfo.setProductPrice(new BigDecimal(3.3));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("很好喝的粥");
        productInfo.setProductIcon("http://124.png");
        productInfo.setProductStatus(2);
        productInfo.setCategoryType(1);
        productService.save(productInfo);






    }
}