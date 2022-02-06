package com.boutiqueEnLigne.fngcine;


import com.boutiqueEnLigne.fngcine.entity.Product;
import com.boutiqueEnLigne.fngcine.service.ProductService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductTest {
    @Autowired
    private ProductService productService;

    Product fakeProduct = new Product();
    Long productId;

    public void setFakeProduct(){
        fakeProduct.setId(11L);
        fakeProduct.setLabel("La petite Sirène");
        fakeProduct.setDescription("une histoire de queues de poisson");
        fakeProduct.setGenre("X");
        fakeProduct.setUnitPrice(5.99f);
        fakeProduct.setQtyStock(10);

        productService.createProduct(fakeProduct);
        productId= fakeProduct.getId();
    }

    @BeforeEach
    public void set_up() {
        setFakeProduct();
    }

    @Test
    @Order(1)
    void getAllProductsTest() {
        List<Product> products = productService.getProducts();
        Assertions.assertTrue(products != null);
        Assertions.assertTrue(products.size() >= 1);
    }

    @Test
    @Order(2)
    void createProductTest() {
        List<Product> productList = productService.getProducts();
        Boolean founded = false;
        for (Product product: productList) {
            if (product.getId() == productId){
                founded = true;
            }
        }
        Assertions.assertTrue(founded == true,
                "Did not find the expected product in the productList");
        Assertions.assertNotNull(productService.getProduct((productId)));
    }



    @Test
    @Order(3)
    void readOneProductTest() {
        Assertions.assertEquals(fakeProduct.getLabel(), productService.getProduct(productId).getLabel());
        Assertions.assertEquals(fakeProduct.getDescription(), productService.getProduct(productId).getDescription());
        Assertions.assertEquals(fakeProduct.getUrlImg(), productService.getProduct(productId).getUrlImg());
        Assertions.assertEquals(fakeProduct.getGenre(), productService.getProduct(productId).getGenre());
        Assertions.assertEquals(fakeProduct.getUnitPrice(), productService.getProduct(productId).getUnitPrice());
        Assertions.assertEquals(fakeProduct.getQtyStock(), productService.getProduct(productId).getQtyStock());
    }

    @Test
    @Order(4)
    void updateProductByIdTest() {
        Product productTest = productService.getProduct(productId);
        fakeProduct.setLabel("La sirène");
        productService.updateProduct(fakeProduct);
        Assertions.assertEquals("La sirène", productService.getProduct(productId).getLabel());
    }

    @Test
    @Order(5)
    void deleteProductByIdTest() {
        productService.deleteProduct(productId);
        List<Product> productList = productService.getProducts();
        Boolean deleted = true;
        for (Product product: productList) {
            if (product.getId() == productId){
                deleted = false;
            }
        }
        Assertions.assertTrue(deleted = true);
    }
}

