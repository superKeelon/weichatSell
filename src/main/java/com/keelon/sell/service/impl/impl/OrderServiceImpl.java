package com.keelon.sell.service.impl.impl;


import com.keelon.sell.dataobject.OrderDetail;
import com.keelon.sell.dataobject.OrderMaster;
import com.keelon.sell.dataobject.ProductInfo;
import com.keelon.sell.dto.CartDTO;
import com.keelon.sell.dto.OrderDTO;
import com.keelon.sell.enums.OrderStatusEnum;
import com.keelon.sell.enums.PayStatusEnum;
import com.keelon.sell.enums.ResultEnum;
import com.keelon.sell.exception.SellException;
import com.keelon.sell.respository.OrderDetailRepository;
import com.keelon.sell.respository.OrderMasterRepository;
import com.keelon.sell.service.impl.ProductService;
import com.keelon.sell.utils.KeyUtil;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//快捷键，实现接口中的方法control + O
@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;



    @Override
    @Transactional//加一个事务。
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.genUniquekey();

        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);


        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()
             ) {

            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());

            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }


            //计算价格
            orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);
            //订单详情入库。
            orderDetail.setDetailId(KeyUtil.genUniquekey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo,orderDetail);

            orderDetailRepository.save(orderDetail);


        }
        //写入订单数据库。

        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());


        orderMasterRepository.save(orderMaster);

        //扣库存。
//        List<CartDTO> cartDTOList = new ArrayList<>();

        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(),e.getProductQuantity())

        ).collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
