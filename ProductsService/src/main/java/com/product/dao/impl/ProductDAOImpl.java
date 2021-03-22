package com.product.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.product.dao.ProductDAO;
import com.product.entity.ProductEntity;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ProductEntity> getProducts() {
		final List<ProductEntity> listOfProductEntity = new ArrayList<>();
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet("select * from productdetails");
		while (rowSet.next()) {
			ProductEntity productEntity = new ProductEntity();
			productEntity.setProductId(rowSet.getInt("product_id"));
			productEntity.setProductName(rowSet.getString("product_name"));
			listOfProductEntity.add(productEntity);
		}
		return listOfProductEntity;
	}

	@Override
	public ProductEntity productDetailsById(Integer productId) {
		ProductEntity productEntity = new ProductEntity();
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet("select * from productdetails where product_id = ?", productId);
		while (rowSet.next()) {
			productEntity.setProductId(rowSet.getInt("product_id"));
			productEntity.setProductName(rowSet.getString("product_name"));
		}
		return productEntity;
	}

	@Override
	public ProductEntity addNewProduct(ProductEntity productEntity) {
		Integer insertResult = jdbcTemplate.update("insert into productdetails values(?,?)",
				productEntity.getProductId(), productEntity.getProductName());
		if (insertResult == 1)
			return productEntity;
		return productEntity;
	}

	@Override
	public ProductEntity updateProduct(ProductEntity productEntity) {
		Integer updateResult = jdbcTemplate.update("update productdetails set product_name = ? where product_id = ?",
				productEntity.getProductName(), productEntity.getProductId());
		if (updateResult == 1)
			return productEntity;
		return productEntity;
	}

	@Override
	public String deleteProduct(Integer productId) {
		Integer deleteResult = jdbcTemplate.update("delete from productdetails where product_id = ?", productId);
		if (deleteResult == 1)
			return "deleted successfully";
		return "Enter valid ProductId";
	}

}
