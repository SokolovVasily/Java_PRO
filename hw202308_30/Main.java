package org.example.Lessons3.HW4.hw202308_30;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(1, "iPhone1", ProductCategory.ELECTRONICS, 200.0, Currency.EUR);
        Product product2 = new Clothing(2, "Tshirt", ProductCategory.CLOTHING, 100.0, Currency.EUR, Size.LARGE);

        Product product3 = new Clothing(3, "Dress", ProductCategory.CLOTHING, 120.0, Currency.EUR, Size.MEDIUM);
        Product product4 = new Product(4, "Roman", ProductCategory.BOOKS, 10.0, Currency.EUR);
        Product product5 = new Product(5, "SuperBall", ProductCategory.SPORTS_EQUIPMENT, 50.0, Currency.EUR);


        ShopManager shopManager = new ShopManager();   // для использования инфы из Shopmanager


        List<Product> productList = new ArrayList<>();

        shopManager.addProduct(product1,productList);   // этот продукт в этот массив на 20стр
        shopManager.addProduct(product2,productList);
        shopManager.addProduct(product3,productList);
        shopManager.addProduct(product4,productList);
        shopManager.addProduct(product5,productList);
        System.out.println(productList);

        shopManager.getProductsByCategory(ProductCategory.CLOTHING,productList);
        System.out.println();
        double minPrice = 10;
        double maxPrice = 100;
        shopManager.getProductsByPriceRange(minPrice,maxPrice, Currency.EUR,productList);
    }

}
