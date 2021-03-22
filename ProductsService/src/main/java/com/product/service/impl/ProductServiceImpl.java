package com.product.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.dao.ProductDAO;
import com.product.dto.ProductDTO;
import com.product.entity.ProductEntity;
import com.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDAO productDAO;

	@Override
	public List<ProductDTO> getProducts() {
		final List<ProductDTO> listOfProductDTO = new ArrayList<>();

		// by calling getProducts() we are getting List of Product Entities

		for (ProductEntity productsList : productDAO.getProducts()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductId(productsList.getProductId());
			productDTO.setProductName(productsList.getProductName());
			listOfProductDTO.add(productDTO);
		}
		return listOfProductDTO;
	}

	@Override
	public ProductDTO productDetailsById(Integer productId) {
		ProductEntity productEntity = productDAO.productDetailsById(productId);
		ProductDTO productDTO = new ProductDTO();
		productDTO.setProductId(productEntity.getProductId());
		productDTO.setProductName(productEntity.getProductName());
		return productDTO;
	}

	@Override
	public ProductDTO addNewProduct(ProductDTO productDTO) {

		ProductEntity productEntity = new ProductEntity();
		productEntity.setProductId(productDTO.getProductId());
		productEntity.setProductName(productDTO.getProductName());

		productEntity = productDAO.addNewProduct(productEntity);

		productDTO.setProductId(productEntity.getProductId());
		productDTO.setProductName(productEntity.getProductName());
		return productDTO;
	}

	@Override
	public ProductDTO updateProduct(ProductDTO productDTO) {
		ProductEntity productEntity = new ProductEntity();
		productEntity.setProductId(productDTO.getProductId());
		productEntity.setProductName(productDTO.getProductName());

		productEntity = productDAO.updateProduct(productEntity);
		productDTO.setProductId(productEntity.getProductId());
		productDTO.setProductName(productEntity.getProductName());
		return productDTO;
	}

	@Override
	public String deleteProduct(Integer ProductId) {
		return productDAO.deleteProduct(ProductId);

	}

}
