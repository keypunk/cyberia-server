package com.cyberiashop.models.utils;

import com.cyberiashop.models.data_models.Category;
import com.cyberiashop.models.data_models.Product;

import java.util.ArrayList;
import java.util.List;

public class MockProductDB {
    private static List<Product> products = new ArrayList<>();

    private static void addAllProducts() {
        addAllLaptops();
        addAllHeadsets();
        addAllWebcams();
        addAllDockingStations();
    }

    private static void addAllLaptops() {
        Product product;

        product = new Product();
        product.setName("Dell Latitude 7400");
        product.setPrice(799.99);
        product.setCategory(Category.LAPTOP);
        product.setQuantity(5);
        product.setImgSrc("/com/cyberiashop/product_images/dell_latitude_7400.jpg");
        products.add(product);

        product = new Product();
        product.setName("Dell Latitude 5540");
        product.setPrice(999.99);
        product.setCategory(Category.LAPTOP);
        product.setQuantity(22);
        product.setImgSrc("/com/cyberiashop/product_images/dell_latitude_5540.jpg");
        products.add(product);

        product = new Product();
        product.setName("Dell Latitude 7320");
        product.setPrice(499.99);
        product.setCategory(Category.LAPTOP);
        product.setQuantity(49);
        product.setImgSrc("/com/cyberiashop/product_images/dell_latitude_7320.jpg");
        products.add(product);
    }

    private static void addAllDockingStations() {
        Product product;

        product = new Product();
        product.setName("Dell Docking Station");
        product.setPrice(99.99);
        product.setCategory(Category.ACCESSORIES);
        product.setQuantity(9);
        product.setImgSrc("/com/cyberiashop/product_images/dell_docking_station.jpg");
        products.add(product);
    }

    private static void addAllHeadsets() {
        Product product;

        product = new Product();
        product.setName("Jabra Evolve 20");
        product.setPrice(39.99);
        product.setCategory(Category.ACCESSORIES);
        product.setQuantity(3);
        product.setImgSrc("/com/cyberiashop/product_images/jabra_evolve_20.jpg");
        products.add(product);

        product = new Product();
        product.setName("Sennheiser SC60");
        product.setPrice(99.99);
        product.setCategory(Category.ACCESSORIES);
        product.setQuantity(32);
        product.setImgSrc("/com/cyberiashop/product_images/sennheiser_sc60_headset.jpg");
        products.add(product);
    }

    private static void addAllWebcams() {
        Product product;

        product = new Product();
        product.setName("Logitech C920");
        product.setPrice(49.99);
        product.setCategory(Category.ACCESSORIES);
        product.setQuantity(19);
        product.setImgSrc("/com/cyberiashop/product_images/logitech_c920.jpg");
        products.add(product);
    }

    public static List<Product> getMockProductList() {
        addAllProducts();
        return products;
    }
}
