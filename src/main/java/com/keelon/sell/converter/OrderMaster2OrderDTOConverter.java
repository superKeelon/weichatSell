package com.keelon.sell.converter;

import com.keelon.sell.dataobject.OrderMaster;
import com.keelon.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class OrderMaster2OrderDTOConverter {



    public static OrderDTO convert( OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;


    }

    public  static  List<OrderDTO> convert(List<OrderMaster> orderMasterList){

        return  orderMasterList.stream().map(e ->
                convert(e)

        ).collect(Collectors.toList());
    }
}
