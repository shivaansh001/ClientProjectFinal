package com.example.salesOrder.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.salesOrder.Dto.ItemNameDto;
import com.example.salesOrder.Dto.OrderDto;
import com.example.salesOrder.model.SalesOrder;



public interface SalesOrderRepository extends JpaRepository<SalesOrder, Integer> 
{
@Query(value="select orderId,orderDescription from SalesOrder where custId=?1",nativeQuery = true)
List<OrderDto> getAllOrders(Integer custId);

@Query(value="select orderDescription from SalesOrder orderId=?1",nativeQuery = true)
ItemNameDto getOrderDesc(Integer orderId);

}
