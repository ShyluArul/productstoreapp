package com.productstore.model.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productstore.model.entities.Store;
import com.productstore.model.repository.StoreRepo;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {
	@Autowired
	private StoreRepo storeRepo;

	@Override
	public List<Store> getAllStore() {
		
		return storeRepo.findAll();
	}

	@Override
	public Optional<Store> findStoreByStoreName(String storeName) {
	
		return storeRepo.findStoreByStoreName(storeName);
	}

	@Override
	public Store addStore(Store store) {
		
		return storeRepo.save(store);
	}

	

}
