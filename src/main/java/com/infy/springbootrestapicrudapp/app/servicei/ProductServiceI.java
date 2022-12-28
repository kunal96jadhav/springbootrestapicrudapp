package com.infy.springbootrestapicrudapp.app.servicei;

import java.util.Optional;

import com.infy.springbootrestapicrudapp.app.model.Product;

public interface ProductServiceI {

	public Product productSave(Product p);

	public Iterable<Product> productFetchAllData();

	public Optional<Product> productFetchSingleData(Integer productId);

	public Product productUpdate(Product p);

	public void productDelete(Integer productId);

}
