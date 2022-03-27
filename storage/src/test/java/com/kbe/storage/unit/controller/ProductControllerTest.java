package com.kbe.storage.unit.controller;

import com.kbe.storage.controller.ProductController;
import com.kbe.storage.models.entities.Product;
import com.kbe.storage.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class ProductControllerTest {

    private ProductService service = Mockito.mock(ProductService.class);

    private ProductController controller;

    private Product product;

    private List<Product> products;

    @BeforeEach
    void setUp(){
        controller = new ProductController(service);
        ArrayList<Product> temp = new ArrayList<>();

        temp.add(new Product(4, "name", new BigDecimal("100.99"), "manufacturer", new BigDecimal("23.5"),
                "black", 144, new BigDecimal("3.2"), 1, "HDMI, USB", "4k"));
        temp.add(new Product(5, "name2", new BigDecimal("550.99"), "manufacturer2", new BigDecimal("27.5"),
                "white", 60, new BigDecimal("4.5"), 5, "HDMI, VGA", "Ultra HD"));

        product = temp.get(0);
        products = temp;
    }

    @Test
    public void getAllProductsTest(){
        when(service.getAllProducts()).thenReturn(products);
        ResponseEntity<List<Product>> responseEntity = controller.getProducts();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody().size()==products.size());
    }

    @Test
    public void findProductByIdTest(){
        when(service.findProductById(4)).thenReturn(product);
        ResponseEntity<Product> responseEntity = controller.findProductById(4);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        assertThat(responseEntity.getBody().equals(product));
    }
}
