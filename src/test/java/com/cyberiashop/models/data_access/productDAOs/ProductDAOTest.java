package com.cyberiashop.models.data_access.productDAOs;

import static org.junit.jupiter.api.Assertions.*;

import com.cyberiashop.models.data_models.Category;
import com.cyberiashop.models.data_models.Product;
import org.junit.jupiter.api.BeforeAll;

class ProductDAOTest {

    private static ProductDAO productDAO;
    private static Product product;

    @BeforeAll
    static void setUp() {
        product = new Product();
        product.setName("Apple Watch");
        product.setPrice(3000.00);
        product.setCategory(Category.ACCESSORIES);
        product.setQuantity(34);

        productDAO = new ProductDAO();
    }

}