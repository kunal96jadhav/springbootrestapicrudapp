package com.infy.springbootrestapicrudapp.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;
import com.infy.springbootrestapicrudapp.app.model.Product;
import com.infy.springbootrestapicrudapp.app.responseentity.BaseResponse;
import com.infy.springbootrestapicrudapp.app.servicei.ProductServiceI;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class ProductController {
	//DEPENDENCIES
	@Autowired
	ProductServiceI ps;
	//POST DATA
	@PostMapping(value="/productSave")
	public ResponseEntity<BaseResponse<Product>> productSave(@RequestBody Product p)
	{
		Product product = ps.productSave(p);
		BaseResponse<Product> base=new BaseResponse<>(201,"Product Saved!",product);
		return new ResponseEntity<BaseResponse<Product>>(base,HttpStatus.CREATED);
		
	}
	//GET ALL DATA
	@GetMapping(value="/productFetchAllData")
	public Iterable<Product>  productFetchAllData()
	{
		Iterable<Product> allData = ps.productFetchAllData();
		return allData;
	}
	//----------------------
//	@GetMapping(value="/productFetchAllData")
//	public ResponseEntity<BaseResponse<Iterable<Product>>> productFetchAllData()
//	{
//		Iterable<Product> allData = ps.productFetchAllData();
//		BaseResponse<Iterable<Product>> base=new BaseResponse<>(200,"Featched Data!", allData);
//		return new ResponseEntity<BaseResponse<Iterable<Product>>>(base,HttpStatus.OK);
//	}
	//GET SINGLE DATA
	@GetMapping(value="/productFetchSingleData/{productId}")
	public Optional<Product> productFetchSingleData(@PathVariable("productId") Integer productId){
		return ps.productFetchSingleData(productId);
	}
	//PUT UPDATE DATA
	@PutMapping("/productUpdate/{productID}")
	public Optional<Product> productUpdate(@PathVariable("productID") Integer productID, @RequestBody Product p){
		
		Optional<Product> productFetchSingleData = ps.productFetchSingleData(productID);
		ps.productUpdate(p);
		return productFetchSingleData;
	}
	//DELETE DATA
	@DeleteMapping("/productDelete/{productId}")
	public String productDelete(@PathVariable("productId") Integer productId)
	{
		ps.productDelete(productId);
		//BaseResponse<String> base=new BaseResponse<>(200,"Success FullDeleted!","deleted");
//		return new ResponseEntity<BaseResponse<String>>(base,HttpStatus.OK);
		return "deleted";
	}
	
}
