package org.example.Lessons3.HW4.hw202308_30;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class  Product {
    private int id;                // Уникальный идентификатор товара
    private String name;           // Название товара
    private ProductCategory category; // Категория товара из перечисления ProductCategory
    private double price;          // Цена товара
    private Currency currency;     // Валюта цены товара из перечисления Currency



    // Конструктор для инициализации полей товара


    public Product(int id, String name, ProductCategory category, double price, Currency currency) {
        this.id = id;   //this.-используется для обращения к текущ экземпляра класса внутри его метода
        this.name = name;
        this.category = category;
        this.price = price;
        this.currency = currency;
    }

    @Override
    public String toString() {   //метод правило toString строчное возвращение
        return "Product{" + "id=" + id + ", name='" + name  + ", category=" + category + ", price=" + price + ", currency=" + currency + '}';
    }
}