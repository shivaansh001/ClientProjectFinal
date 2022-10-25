package com.example.salesOrder.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItem 
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int id;
private int orderId;
private String orderName;
private int itemQty;
public int getOrderId() {
	return orderId;
}
public void setOrderId(int orderId) {
	this.orderId = orderId;
}
public String getOrderName() {
	return orderName;
}
public void setOrderName(String orderName) {
	this.orderName = orderName;
}
public int getItemQty() {
	return itemQty;
}
public void setItemQty(int itemQty) {
	this.itemQty = itemQty;
}
}
