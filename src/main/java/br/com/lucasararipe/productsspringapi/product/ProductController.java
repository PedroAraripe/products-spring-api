package br.com.lucasararipe.productsspringapi.product;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {
  private final ProductService productService;

  ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public List<Product> read() {
    return productService.read();
  }

  @PostMapping
  public Product create(@RequestBody Product product) {
    return productService.create(product);
  }

  @PatchMapping
  public Product update(@RequestBody Product product) {
    return productService.update(product);
  }

  @DeleteMapping
  public String delete(@RequestParam Long productId) {
    productService.deleteById(productId);

    return ProductMessages.successfullDelete();
  }
}
