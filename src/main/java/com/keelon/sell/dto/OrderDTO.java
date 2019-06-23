package com.keelon.sell.dto;

import com.keelon.sell.dataobject.OrderDetail;
import com.keelon.sell.enums.OrderStatusEnum;
import com.keelon.sell.enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
@Data
public class OrderDTO {

    /** 订单 id. */


    private String orderId;

    /**买家的名字*/
    private String buyerName;

    /** 买家的手机号 */

    private String buyerPhone;

    /**买家的地址*/

    private String buyerAddress;

    /**买家的openid*/
    private String buyerOpenid;

    /**订单的金额*/
    private BigDecimal orderAmount;
    /**订单的状态*/
    private  Integer orderStatus;

    /**订单的支付状态*/

    private Integer payStatus;

    /**创建时间*/
    private  Date createTime;

    /**更新时间*/
    private Date updateTime;
    List<OrderDetail> orderDetailList;



}
