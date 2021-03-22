package com.product.dao;

import java.util.List;

import com.product.entity.ProductEntity;

public interface ProductDAO {
	List<ProductEntity> getProducts();

	ProductEntity productDetailsById(Integer productId);

	ProductEntity addNewProduct(ProductEntity productEntity);

	ProductEntity updateProduct(ProductEntity productEntity);

	String deleteProduct(Integer productId);

}
