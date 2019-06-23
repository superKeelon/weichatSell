package com.keelon.sell.respository;

import com.keelon.sell.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest

public class OrderMasterRepositoryTest {
    @Autowired
    private OrderMasterRepository repository;
    private final String OPENID = "110110";

    @Test
    public void findByBuyerOpenid()throws Exception{
        PageRequest pageRequest  = PageRequest.of(0,3);
        Page<OrderMaster> orderMasterPage = repository.findByBuyerOpenid(OPENID,pageRequest);
        System.out.println(orderMasterPage.getTotalElements());
        Assert.assertNotEquals(0,orderMasterPage.getTotalElements());




    }

    @Test
    public void  saveTest(){

        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("大师兄");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerOpenid("110110");
        orderMaster.setBuyerPhone("1866208770");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }





}