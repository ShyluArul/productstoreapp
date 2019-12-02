package com.productstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productstore.model.entities.Product;
import com.productstore.model.entities.Store;
import com.productstore.model.entities.User;
import com.productstore.model.repository.ProductRepo;
import com.productstore.model.repository.StoreRepo;
import com.productstore.model.repository.UserRepo;

@SpringBootApplication
public class ProductstoreappApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProductstoreappApplication.class, args);
	}
	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private StoreRepo storeRepo;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Product p1 = new Product("Nokia 105",5,5000,"Dual Sim,Black");
		Product p2 = new Product("Nokia 5.1 plus",7,11000,"Dual sim, Golden");
		Product p3 = new Product("samsung galaxy",8,17000,"Dual sim,Silver");
		Product p4 = new Product("samsung j7",9,18000,"Dual sim,Blue");
		
		
		Store s1  = new Store("Poorvika","ABC address","bangalore",343435,"India");
		Store s2 = new Store("Reliance","DEF address","Chennai",675675,"India");
		
		s1.getProduct().add(p1);
		s1.getProduct().add(p2);
		s1.getProduct().add(p3);
		s1.getProduct().add(p4);
		
		
		s2.getProduct().add(p1);
		s2.getProduct().add(p3);
		
		
		
		p1.getStore().add(s1);
			p2.getStore().add(s1);
			p3.getStore().add(s1);
			p4.getStore().add(s1);
			
			p1.getStore().add(s2);
			p3.getStore().add(s2);
		
			storeRepo.save(s1);
			storeRepo.save(s2);
			productRepo.save(p1);
			productRepo.save(p2);
			productRepo.save(p3);
			productRepo.save(p4);
			 
			
			
		/*
		 * productRepo.save(p1); productRepo.save(p2); productRepo.save(p3);
		 * productRepo.save(p4);
		 */
			/*User user = new User("anu","anu@gmail.com","anu123");
			userRepo.save(user);*/
			User user = new User("shy","shy@gmail.com","shy123");
			userRepo.save(user);
		
	}


}
