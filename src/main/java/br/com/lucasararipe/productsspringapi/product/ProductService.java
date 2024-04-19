package br.com.lucasararipe.productsspringapi.product;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
  private final ProductRepository productRepository;
  
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> list() {
    return productRepository.findAll();
  }
  
  @Transactional
  public Product create(Product product) {
    return productRepository.save(product);
  }
}
