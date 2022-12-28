package com.infy.springbootrestapicrudapp.app.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.springbootrestapicrudapp.app.model.Product;
import com.infy.springbootrestapicrudapp.app.repository.ProductRepository;
import com.infy.springbootrestapicrudapp.app.servicei.ProductServiceI;
@Service
public class ProductServiceImpl implements ProductServiceI{
	@Autowired
	ProductRepository pr;
	@Override
	public Product productSave(Product p) {
		return pr.save(p);	
	}
	@Override
	public Iterable<Product> productFetchAllData() {
		return pr.findAll();
	}
	@Override
	public Optional<Product> productFetchSingleData(Integer productId) {
		
		return pr.findByProductId(productId);
	}
	@Override
	public Product productUpdate(Product p) {
		return pr.save(p);
		
	}
	@Override
	public void productDelete(Integer productId) {
		pr.deleteById(productId);
	}

}
