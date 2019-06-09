package com.keelon.sell.Controller;


import com.keelon.sell.VO.ProductInfoVO;
import com.keelon.sell.VO.ProductVO;
import com.keelon.sell.VO.ResultVO;
import com.keelon.sell.dataobject.ProductCategory;
import com.keelon.sell.dataobject.ProductInfo;
import com.keelon.sell.service.impl.CategoryService;
import com.keelon.sell.service.impl.ProductService;
import com.keelon.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//返回json所以用RestController注解。
@RestController
@RequestMapping("/buyer/product")
public class buyerProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){


        /**
         * 查询所有上架商品
         */
        List<ProductInfo> productInfoList = productService.findUpAll();

        //查询类目。
//        List<Integer> categoryList = new ArrayList<>();

        //传统方法。for 循环。
        List<Integer> categoTypeList = productInfoList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findCategoryTypeIn(categoTypeList);

        List<ProductVO> productVOList = new ArrayList<>();


        for (ProductCategory productCategory: productCategoryList){

            ProductVO productVO = new ProductVO();

            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();

            for (ProductInfo productInfo :productInfoList){

                if (productInfo.getCategoryType() == productCategory.getCategoryType()){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);

                    productInfoVOList.add(productInfoVO);
                }
            }

            productVO.setProductInfoVOList(productInfoVOList);

            productVOList.add(productVO);

        }


//        ResultVO resultVO = new ResultVO();
//        resultVO.setData(productVOList);
//        resultVO.setCode(0);
//        resultVO.setMsg("成功");
//        //        resultVO.setData(productVO);
        return ResultVOUtil.success(productVOList);
    }
}
