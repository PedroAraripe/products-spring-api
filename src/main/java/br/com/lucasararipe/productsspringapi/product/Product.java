package br.com.lucasararipe.productsspringapi.product;

import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "PRODUCTS")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    // TODO MAKE CONFIGURATION FOR VALIDATION BEFORE PERSIST
    @NotNull(message = "Price cannot be null")
    @Column(nullable = false)
    private BigDecimal price;
    
    @NotNull(message = "Amount cannot be null")
    @Column(nullable = false)
    private int amount;

    @Version
    private Long version;

    public Product(String name, String description, BigDecimal price, int amount) {
      this.setName(name);
      this.setDescription(description);
      this.setPrice(price);
      this.setAmount(amount);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
      System.out.println("No set price");
      if (price != null) {
          System.out.println("Set price não é nulo");
          this.price = price.setScale(2, RoundingMode.HALF_UP);
      } else {
          System.out.println("Set price é nulo");
          this.price = null;
      }
      System.out.println("Valor setado do set price");
      System.out.println(this.getPrice());
  }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}