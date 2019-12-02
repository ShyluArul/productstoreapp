package com.productstore.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productstore.model.entities.Orders;

@Repository
public interface OrdersRepo extends JpaRepository<Orders, Long>{
	

}
