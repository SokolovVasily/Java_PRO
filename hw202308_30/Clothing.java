package org.example.Lessons3.HW4.hw202308_30;

public class Clothing extends Product {
    private Size size;

    public Clothing(int id, String name, ProductCategory category, double price, Currency currency, Size size) {
        super(id, name, category, price, currency);
        this.size = size ;
    }


    @Override
    public String toString() {   //метод правило toString
        return "Product{" + "id=" + getId() + ", name='" + getName() + ", category=" + getCategory()+ ", price=" + getPrice() + ", currency=" + getCurrency()
                + " ,Size "+size+'}';
    }


    }




