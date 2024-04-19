package br.com.lucasararipe.productsspringapi.product;

import org.springframework.data.repository.ListCrudRepository;

public interface ProductRepository extends ListCrudRepository<Product, Long>{} 
