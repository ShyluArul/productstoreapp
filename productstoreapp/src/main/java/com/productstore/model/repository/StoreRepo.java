package com.productstore.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productstore.model.entities.Store;

@Repository
public interface StoreRepo extends JpaRepository<Store, Long> {
	
	public Optional<Store>findStoreByStoreName(String storeName);
}
