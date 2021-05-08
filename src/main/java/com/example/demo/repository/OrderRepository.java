package com.example.demo.repository;

import com.example.demo.model.Order;
import com.example.demo.model.OrderStatus;
import com.example.demo.model.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByOrderStatusAndTableId(OrderStatus orderStatus, long id);

    @Query(value = "select o.* from cafe_order o inner join cafe_table t on o.cafe_table_id = t.id where t.waiter_id = :waterId", nativeQuery = true)
    List <Order> findByTableUserId(@Param("waterId") long waterId);

}
