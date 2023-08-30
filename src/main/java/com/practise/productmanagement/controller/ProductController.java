package com.practise.productmanagement.controller;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practise.productmanagement.model.Product;
import com.practise.productmanagement.service.ProductService;

@RestController
public class ProductController {

  @Autowired
  private ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping("/saveProduct")
  public ResponseEntity<Product> saveProduct(@RequestBody Product product){
    Product p = null;

    try{
    p = this.productService.saveProduct(product);
    System.out.println("Product saved successful!");
    System.out.println(product);
    return ResponseEntity.of(Optional.of(p));
    }catch(Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

  }

  @GetMapping("/")
  public ResponseEntity<List<Product>> getAllProducts(){
    List<Product> list = this.productService.getAllProducts();

    if(list.size()<=0){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    return ResponseEntity.of(Optional.of(list));
  }

  @GetMapping("/products/{productId}")
  public ResponseEntity<Product> getProductById(@PathVariable("productId") Integer id){
    try{
    Product product = this.productService.getProductById(id);
    return ResponseEntity.of(Optional.of(product));
    }catch(Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
  }

  @GetMapping("/deleteProduct/{productId}")
  public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Integer id){
    try{
    this.productService.deleteProduct(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }catch(Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
  }
    @PutMapping("/product/{productId}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, 
    @PathVariable("productId") Integer id){
      try{
        this.productService.updateProduct(product, id);
        return ResponseEntity.status(HttpStatus.OK).build();
      } catch(Exception e){
      e.printStackTrace();
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    }


  
}
