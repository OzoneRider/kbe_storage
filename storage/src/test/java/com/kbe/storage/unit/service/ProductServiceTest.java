package com.kbe.storage.unit.service;

import com.kbe.storage.exceptions.DataNotFoundException;
import com.kbe.storage.exceptions.NoProductDataException;
import com.kbe.storage.models.entities.DeliveryInformation;
import com.kbe.storage.models.entities.Product;
import com.kbe.storage.repositories.ProductRepository;
import com.kbe.storage.services.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    ProductRepository repository = Mockito.mock(ProductRepository.class);

    ProductService service;

    Product product;

    @BeforeEach
    void InitService(){
        this.service = new ProductService(repository);

        this.product = new Product(4, "name", new BigDecimal("100.99"), "manufacturer", new BigDecimal("23.5"),
                "black", 144, new BigDecimal("3.2"), 1, "HDMI, USB", "4k");

    }

    @Test
    void saveProduct(){
        when(repository.save(any(Product.class))).then(returnsFirstArg());
        Product savedProduct = service.saveProduct(product);
        assertThat(product.equals(savedProduct));
    }

    @Test
    void getProductTest(){
        Assertions.assertThatExceptionOfType(DataNotFoundException.class).isThrownBy(() -> {
            Product newProduct = service.findProductById(4);
        }).withMessage("Data with Id 4 not found");
    }

    @Test
    void getAllProducts(){
        Assertions.assertThatExceptionOfType(NoProductDataException.class).isThrownBy(() ->{
            List<Product> products = service.getAllProducts();
        }).withMessage("No Product Data found");
    }

}
