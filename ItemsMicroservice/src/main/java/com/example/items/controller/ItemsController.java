package com.example.items.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//import com.example.customer.model.Customer;
//import com.example.items.dto.ItemsDataDto;
import com.example.items.model.Items;
import com.example.items.repository.ItemRepo;
import com.example.items.service.ItemsService;

@RestController
public class ItemsController {
	
	@Autowired
	private ItemRepo itemrepo;
	
	@Autowired
	private ItemsService itemsservice;
	
	@GetMapping(path="/check/item/{Itemname}")
	public boolean checkItem(@PathVariable("Itemname") String itemname ) {
        return itemsservice.checkItemService(itemname);
	}
	
	@GetMapping(path="/items")
	public List<Items>getAllItems(){
		return (List<Items>)itemrepo.findAll();
	}
	
	@GetMapping(path="/items/{itemName}")
	public ResponseEntity<String> getItemData(@PathVariable("itemName") String itemName){
		return new ResponseEntity<>(itemsservice.getIndividualItemData(itemName),HttpStatus.OK);
	}
}
