package com.keelon.sell.service.impl;

import com.keelon.sell.dataobject.ProductCategory;
import java.util.List;


public interface CategoryService {


    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();

    List<ProductCategory> findCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);


}
