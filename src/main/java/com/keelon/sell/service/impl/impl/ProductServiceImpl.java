package com.keelon.sell.service.impl.impl;

import com.keelon.sell.dataobject.ProductInfo;
import com.keelon.sell.dto.CartDTO;
import com.keelon.sell.enums.ProductStatusEnum;
import com.keelon.sell.enums.ResultEnum;
import com.keelon.sell.exception.SellException;
import com.keelon.sell.respository.ProductInfoRespository;
import com.keelon.sell.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoRespository respository;





    @Override
    public ProductInfo findOne(String productId) {
        return respository.getOne(productId);
    }

    @Override
    public List<ProductInfo> findAll() {
        return respository.findAll();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return respository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override

    public Page<ProductInfo> findAll(Pageable pageable) {

        return respository.findAll(pageable);

    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return respository.save(productInfo);
    }


    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList){

        for (CartDTO cartDTO:cartDTOList){
            ProductInfo productInfo = respository.getOne(cartDTO.getProductId());

            if(productInfo == null){
                throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);

            }

            Integer result =  productInfo.getProductStock()-cartDTO.getProductQuantity();

            if (result<0){

                throw  new SellException(ResultEnum.PRODUCT_STOCK_ERROR);


            }

            productInfo.setProductStock(result);
            respository.save(productInfo);
        }


    }



}
