package com.keelon.sell.respository;

import com.keelon.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoRespository extends JpaRepository<ProductInfo ,String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);



}
