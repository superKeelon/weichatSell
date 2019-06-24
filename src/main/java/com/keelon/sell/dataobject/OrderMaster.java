package com.keelon.sell.dataobject;



import com.keelon.sell.enums.OrderStatusEnum;
import com.keelon.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
@Proxy(lazy = false)
@Entity
@Data
@DynamicUpdate
public class OrderMaster {


    /** 订单 id. */

    @Id
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
    private  Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /**订单的支付状态*/

    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /**创建时间*/
    private  Date createTime;

    /**更新时间*/
    private Date updateTime;













}
