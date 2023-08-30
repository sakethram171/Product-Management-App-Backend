package com.practise.productmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practise.productmanagement.model.Product;
import com.practise.productmanagement.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

  @Autowired
  private ProductRepository productRepo;

  @Override
  public void deleteProduct(Integer id) {
    Product product = productRepo.findById(id).get();
    if(product != null){
      productRepo.delete(product);
    }
    
  }

  @Override
  public List<Product> getAllProducts() {
    return productRepo.findAll();
  }

  @Override
  public Product getProductById(Integer id) {
    return productRepo.findById(id).get();
  }

  @Override
  public Product saveProduct(Product product) {
    return productRepo.save(product);
  }

  @Override
  public Product updateProduct(Product product, Integer id) {
    return productRepo.save(product);
  }
}

