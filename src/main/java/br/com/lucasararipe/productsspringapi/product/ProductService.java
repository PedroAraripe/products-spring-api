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
  
  @Transactional
  public Product create(Product product) {
    return productRepository.save(product);
  }

  public List<Product> read() {
    return productRepository.findAll();
  }
  
  @Transactional
  public Product update(Product product) {
    checkIfProductExists(product.getId());

    return productRepository.save(product);
  }
  
  @Transactional
  public void deleteById(Long productId) {
    checkIfProductExists(productId);

    productRepository.deleteById(productId);
  }

  private void checkIfProductExists(Long id) {
    Boolean hasSavedProduct = id != null && productRepository.findById(id).isPresent();
    
    if(!hasSavedProduct) {
      throw new ProductNotFoundException(id);
    }
  }
}
