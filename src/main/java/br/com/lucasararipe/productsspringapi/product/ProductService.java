package br.com.lucasararipe.productsspringapi.product;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
  private final ProductRepository productRepository;
  
  public ProductService( ProductRepository productRepository ) {
    this.productRepository = productRepository;
  }

  public List<Product> list() {
    Iterable<Product> iterableProducts = productRepository.findAll();
    List<Product> productList = StreamSupport.stream(iterableProducts.spliterator(), false)
      .collect(Collectors.toList());
    
    return productList;
  } 
}
