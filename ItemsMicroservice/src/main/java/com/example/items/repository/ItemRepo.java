package com.example.items.repository;

import java.util.ArrayList;
import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.items.model.Items;

@Repository
public interface ItemRepo extends JpaRepository<Items,Integer> {
	
	@Query(value = "select * from items where name=?",nativeQuery = true)
	String getIndividualItemByName(String itemName);
	
	@Query(value="select description from Items as c where c.name=?1")
	String checkItem(String itemName);
	
	
	
}
