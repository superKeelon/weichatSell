package com.keelon.sell.respository;

import com.keelon.sell.dataobject.OrderDetail;
import com.keelon.sell.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {


 List<OrderDetail> findByOrderId(String orderId);
}
