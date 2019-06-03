package com.keelon.sell.service.impl.impl;

import com.keelon.sell.dataobject.ProductCategory;
import com.keelon.sell.respository.ProductCategoryRepository;
import com.keelon.sell.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/*
*
* 此处有一个快捷键实现这个方法。
* */


@Service
public class CategoryServiceImpl implements CategoryService {



    @Autowired
    private ProductCategoryRepository repository;


    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.getOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findAllById(categoryTypeList);

    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
