package com.example.customer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@NonNull
public class Customer 
{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
private String email;
private String firstName;
private String lastName;
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
}
