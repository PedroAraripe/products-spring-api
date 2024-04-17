package br.com.lucasararipe.productsspringapi.product;

import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

@Table("PRODUCTS")
public record Product (
  @Id Long id,
  String name,
  String description,
  BigDecimal price,
  int amount,
  @Version Long version
) {}
