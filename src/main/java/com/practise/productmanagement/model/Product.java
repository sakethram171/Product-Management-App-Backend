package com.practise.productmanagement.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  public Product(Integer id) {
    this.id = id;
  }

  public Product(){}
  private String productName;
  private String productDesciption;
  private Double productPrice;
  private String productStatus;
  
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public String getProductName() {
    return productName;
  }
  public void setProductName(String productName) {
    this.productName = productName;
  }
  public String getProductDesciption() {
    return productDesciption;
  }
  public void setProductDesciption(String productDesciption) {
    this.productDesciption = productDesciption;
  }
  public Double getProductPrice() {
    return productPrice;
  }
  public Product(Integer id, String productName, String productDesciption, Double productPrice, String productStatus) {
    this.id = id;
    this.productName = productName;
    this.productDesciption = productDesciption;
    this.productPrice = productPrice;
    this.productStatus = productStatus;
  }
  public void setProductPrice(Double productPrice) {
    this.productPrice = productPrice;
  }
  public String getProductStatus() {
    return productStatus;
  }
  public void setProductStatus(String productStatus) {
    this.productStatus = productStatus;
  }

  
  
}

