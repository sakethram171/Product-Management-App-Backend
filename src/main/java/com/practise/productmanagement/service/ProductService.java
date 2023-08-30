package com.practise.productmanagement.service;

import java.util.List;


import com.practise.productmanagement.model.Product;

public interface ProductService {
  
  public Product saveProduct(Product product);

  public List<Product> getAllProducts();

  public Product getProductById(Integer id);

  public void deleteProduct(Integer id);

  public Product updateProduct(Product product, Integer id);
}
