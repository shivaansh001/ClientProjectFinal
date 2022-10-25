package com.example.salesOrder.Dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@JsonProperty
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SalesOrderDto 
{
private int orderId;
private String orderDescription;
private List<String> itemNames;
//private ItemListDto itemNames;
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public String getOrderDescription() {
	return orderDescription;
}
public void setOrderDescription(String orderDescription) {
	this.orderDescription = orderDescription;
}
public List<String> getItemNames() {
	return itemNames;
}
public void setItemNames(List<String> itemNames) {
	this.itemNames = itemNames;
}
}
