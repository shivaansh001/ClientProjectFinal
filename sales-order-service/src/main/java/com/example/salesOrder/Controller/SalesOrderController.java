package com.example.salesOrder.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.salesOrder.Dto.CreateOrderDto;
import com.example.salesOrder.Dto.OrderDto;
import com.example.salesOrder.Dto.SalesOrderDto;
import com.example.salesOrder.Service.SalesOrderService;
import com.example.salesOrder.client.CustomerClient;
import com.example.salesOrder.client.ItemClient;
import com.example.salesOrder.model.SalesOrder;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class SalesOrderController 
{
@Autowired
private SalesOrderService salesOrderService;
@Autowired
private ItemClient itemclient;
@Autowired
private CustomerClient customerclient;


@PostMapping("/orders")
@HystrixCommand(fallbackMethod="CreateOrderFallback")
public SalesOrderDto CreateOrder(@RequestBody CreateOrderDto createOrderDto)
{
	boolean checkCust=customerclient.checkCustomer(createOrderDto.getCustId());
	boolean checkItem=true;
	for(int i=0;i<createOrderDto.getItemsList().size();i++) {
		if(!itemclient.checkItem(createOrderDto.getItemsList().get(i))){
			checkItem=false;
			break;
		}
	}
	if(checkCust&&checkItem) {
	
//	System.out.println("Object:\n"+createOrderDto.getItemsList());
//	System.out.println("\n"+createOrderDto.getCustId());
	return salesOrderService.createOrderService(createOrderDto);
	}
	return null;
}

public SalesOrderDto CreateOrderFallback(@RequestBody CreateOrderDto createOrderDto)
{
	SalesOrderDto salesOrderDto = new SalesOrderDto();
	salesOrderDto.setOrderId(0);
	salesOrderDto.setOrderDescription("Order Not Created!!!");
	return salesOrderDto;
}

@GetMapping("/myorder/{customerId}")
public ResponseEntity<List<OrderDto>> getAllOrders(@PathVariable("customerId") Integer customerId){
	
	return new ResponseEntity<>(salesOrderService.getAllOrdersService(customerId),HttpStatus.ACCEPTED);
}

@GetMapping(path="/orders/{orderId}")
public ResponseEntity<SalesOrderDto> getOrderDetails(@PathVariable("orderId") Integer orderid){
	SalesOrderDto salesorderdto=salesOrderService.getOrderDetailsService(orderid);
	return new ResponseEntity<>(salesorderdto,HttpStatus.OK);
}
}


