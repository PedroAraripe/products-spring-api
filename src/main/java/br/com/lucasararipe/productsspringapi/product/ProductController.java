package br.com.lucasararipe.productsspringapi.product;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {
  private final ProductService productService;

  ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public List<Product> list() {
    return productService.list();
  }

  // TODO IMPLEMENT CREATE PRODUCT
  @PostMapping
  public Product createTransaction(@RequestBody Product product) {
    return productService.create(product);
  }
}
