package com.keelon.sell.service.impl.impl;

import com.keelon.sell.dataobject.OrderDetail;
import com.keelon.sell.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;


    private final String BUYER_OPERNID = "1101110";
    private final String ORDER_ID = "1561313509404331770";


    @Test
    public void create() {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("慕课网");
        orderDTO.setBuyerName("廖师兄");
        orderDTO.setBuyerPhone("18666208770");
        orderDTO.setBuyerOpenid(BUYER_OPERNID);
        //购物车。
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123454");
        o1.setProductQuantity(1);
        OrderDetail o2 = new OrderDetail();
        o2.setProductId("123456");
        o2.setProductQuantity(1);
        OrderDetail o3 = new OrderDetail();
        o3.setProductId("123457");
        o3.setProductQuantity(1);


        orderDetailList.add(o1);
        orderDetailList.add(o2);
        orderDetailList.add(o3);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("创建订单 result={}",result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {

        OrderDTO orderDTO =  orderService.findOne(ORDER_ID);
        log.info("【查询订单】result={}",orderDTO);
        Assert.assertNotEquals(orderDTO,orderDTO.getOrderId());



    }

    @Test
    public void findList() throws Exception{

        PageRequest request = new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPERNID,request);

        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}