package com.product.service;

import java.util.List;

import com.product.dto.ProductDTO;

public interface ProductService {
	List<ProductDTO> getProducts();

	ProductDTO productDetailsById(Integer productId);

	ProductDTO addNewProduct(ProductDTO productDTO);

	ProductDTO updateProduct(ProductDTO productDTO);

	String deleteProduct(Integer ProductId);
}
