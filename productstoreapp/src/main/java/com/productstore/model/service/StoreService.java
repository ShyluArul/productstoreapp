package com.productstore.model.service;

import java.util.List;
import java.util.Optional;

import com.productstore.model.entities.Store;

public interface StoreService {
	public List<Store>getAllStore();
	public Optional<Store>findStoreByStoreName(String storeName);
	public Store addStore(Store store);

	/*
	 * public void deleteStore(Long storeId); public Store addStore(Store store);
	 * public Store updateStore(Long storeId,Store store);
	 */

}
