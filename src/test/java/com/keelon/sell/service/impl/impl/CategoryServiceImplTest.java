package com.keelon.sell.service.impl.impl;

import com.keelon.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CategoryServiceImplTest {

    @Autowired
    private  CategoryServiceImpl categoryService;

    @Test
    public void findOne()throws Exception {

        ProductCategory productCategory =  categoryService.findOne(1);

        Assert.assertEquals(new  Integer(1),productCategory.getCategoryId());



    }

    @Test
    public void findAll() throws Exception {


        List<ProductCategory> productCategorylist = categoryService.findAll();

        Assert.assertNotEquals(0, productCategorylist.size());
    }

    @Test
    public void findCategoryTypeIn() throws Exception{


        List<ProductCategory> productCategoryList = categoryService.findCategoryTypeIn(Arrays.asList(0,2,3,5));

        Assert.assertNotEquals(0, productCategoryList.size());
    }

    @Test
    public void save() throws Exception {

        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("男生专享");
        productCategory.setCategoryType(12);
        ProductCategory productCategory1 = categoryService.save(productCategory);
        Assert.assertNotNull(productCategory1);








    }




}


/*

commond + shift+ 回车，快速换行


 */