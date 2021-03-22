package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.product.dto.ProductDTO;
import com.product.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(value = "/getProducts")
	public List<ProductDTO> getProducts() {
		return productService.getProducts();
	}

	@GetMapping(value = "/getProducts/{productId}")
	public ProductDTO getProductDetailsById(@PathVariable Integer productId) {
		ProductDTO productDTO = productService.productDetailsById(productId);
		return productDTO;
	}

	@PostMapping(value = "/addProduct")
	public ProductDTO addNewProduct(@RequestBody ProductDTO productDTO) {
		return productService.addNewProduct(productDTO);
	}

	@PutMapping(value = "/updateProduct")
	public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
		return productService.updateProduct(productDTO);
	}

	@DeleteMapping(value = "/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable Integer productId) {
		return productService.deleteProduct(productId);
	}

}
