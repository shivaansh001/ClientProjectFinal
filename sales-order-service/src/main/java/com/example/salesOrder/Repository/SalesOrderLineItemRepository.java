package com.example.salesOrder.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.salesOrder.Dto.ItemNameDto;
import com.example.salesOrder.model.OrderLineItem;

@Repository
public interface SalesOrderLineItemRepository extends JpaRepository<OrderLineItem, Integer>  
{
	@Query("select orderName from OrderLineItem where orderId=?1")
	List<ItemNameDto> getOrderItems(Integer orderId);
}
