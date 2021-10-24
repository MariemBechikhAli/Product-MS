package com.esprit.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> findAll() {
		List<Product> Products = (List<Product>) productRepository.findAll();
		return Products;
	}
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}
	public String deleteProduct(int id) {
		if (productRepository.findById(id).isPresent()) {
			productRepository.deleteById(id);
			return "Product succfelly deleted";
		} else
			return "Please verify the ID";
	}
	public Product updateProduct(int id, Product newProduct) {
		if (productRepository.findById(id).isPresent()) {
			Product existingProduct = productRepository.findById(id).get();
			existingProduct.setName(newProduct.getName());
			existingProduct.setQuantity(newProduct.getQuantity());
			existingProduct.setPrice(newProduct.getPrice());

			return productRepository.save(existingProduct);
		} else
			return null;
	}
}
