package com.keelon.sell.respository;

import com.keelon.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;
    @Test
    public void findOneTest(){


        ProductCategory productCategory = repository.getOne(1);
        System.out.println(productCategory.toString());
    }

    @Test
    public  void  saveTest(){

        ProductCategory productCategory  = new ProductCategory();
        productCategory.setCategoryName("奶奶最爱");
        productCategory.setCategoryId(4);
        productCategory.setCategoryType(4);
        repository.save(productCategory);

    }








}