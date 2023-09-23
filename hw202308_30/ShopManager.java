package org.example.Lessons3.HW4.hw202308_30;

import java.util.List;

public class ShopManager {

    public void addProduct(Product product, List<Product> productList) {
        productList.add(product);

    }

    public void getProductsByCategory(ProductCategory category, List<Product> productList) {
        for (Product product : productList) {
            if (category == (product.getCategory())) {     //если категория совпадает с категорией продукта в листе
                // тогда выводится наш продукт
                System.out.println(product);
            }
        }

    }
    public  void getProductsByPriceRange(double minPrice, double maxPrice, Currency currency, List<Product> productList) {
        for (Product product : productList) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice && currency == product.getCurrency()) {
                System.out.println(product);
            }

        }
    }
}












/*
Цель: Создать программу для управления списком товаров в интернет-магазине

1. Enums:
1.1. ProductCategory - Перечисление для представления категорий товаров в магазине:
?????? = придумайте сами какие

1.2. Size - Перечисление для представления размеров одежды:
??????

1.3. Currency - Перечисление для представления валют для цен товаров:
??????

2. Классы:
2.1. Product - Класс для представления товара:
Поля:

id (уникальный идентификатор товара)
name (имя товара)
category (категория товара из ProductCategory)
price (цена товара)
currency (валюта цены из Currency)
Конструктор для инициализации полей.

2.2. Clothing - Подкласс класса Product для представления одежды:
Дополнительное поле size (размер одежды из Size).
Конструктор для инициализации полей.

2.3. ShopManager - Класс для управления списком товаров:

Поле products (массив товаров).
Метод addProduct(Product product) для добавления товара в список.
Метод getProductsByCategory(ProductCategory category) для получения списка товаров по заданной категории.
Метод getProductsByPriceRange(double minPrice, double maxPrice, Currency currency) для получения списка товаров в
заданном диапазоне цен и в указанной валюте.

методы надо написать....естественно))

/*
    static  Product[] products = {
        new Product(1, "Dress", ProductCategory.WOMEN_CLOTHES, 25.00, Currency.EUR),
                new Product(2, "Skirt", ProductCategory.WOMEN_CLOTHES, 15.00, Currency.EUR),
                new Product(3, "Trousers", ProductCategory.MENSWEAR, 18.50, Currency.EUR),
                new Product(4, "Blouse", ProductCategory.TEEN_CLOTHES, 13.50, Currency.EUR),
                new Product(5, "T-Shirt", ProductCategory.CHILDREN_CLOTHES, 4.00, Currency.EUR)

     */



