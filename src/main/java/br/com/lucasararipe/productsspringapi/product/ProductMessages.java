package br.com.lucasararipe.productsspringapi.product;

public class ProductMessages {
  static String productNotFound = "Product not found";
  static String productIdNotProvided = "Product id not provided";
  static String productDeletedeSucessfully = "Product has been deleted";

  public static String notFound(Long id) {
    if(id == null) {
      return ProductMessages.productIdNotProvided;
    }

    return ProductMessages.productNotFound;
  }
  
  public static String successfullDelete() {
    return ProductMessages.productDeletedeSucessfully;
  }
}
