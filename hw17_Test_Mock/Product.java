package org.example.Lessons19.Mockito.taski_hw17_Test_Mock;

import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.Map;

/**
 * InventoryService управляет простой "базой данных" продуктов
 * ключ — это SKU продукта
 * значение — количество товара на складе.
 * updateStock учитывает возможность, что обновление запасов не должно привести к отрицательному количеству товара.
 * <p>
 * OrderFulfillmentService использует InventoryService для проверки и
 * обновления запасов при выполнении заказа.
 * Если запасы достаточны, заказ выполняется и запасы обновляются.
 * returnItemsToInventory может использоваться для возврата товаров на склад,
 * что увеличивает количество запасов для данного SKU.
 */
public class Product {
    private String sku; // Stock Keeping Unit - уникальный идентификатор продукта
    private int stockQuantity;

    public Product(String sku, int stockQuantity) {
        this.sku = sku;
        this.stockQuantity = stockQuantity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}

class InventoryService {
    private Map<String, Integer> productStockDatabase = new HashMap<>();

    public InventoryService() {
        // Инициализация некоторыми тестовыми данными
        productStockDatabase.put("ABC123", 100);
        productStockDatabase.put("XYZ987", 200);
        productStockDatabase.put("IJK654", 150);
    }

    public int checkProductStock(String sku) {//инвентаризация
        if (sku == null) {
            throw new NullPointerException("sku can not be null ");
        }
        return productStockDatabase.getOrDefault(sku, 0);
        //Positiv
        //if (sku == null)
    }

    public boolean updateStock(String sku, int quantityChange) {
        if (sku == null) {
            throw new NullPointerException();
        }
        // Проверяем, существует ли продукт
        if (!productStockDatabase.containsKey(sku)) {
            return false;
        }
        int currentStock = productStockDatabase.get(sku);
        int newStock = currentStock + quantityChange;
        // Проверяем, не становится ли новое количество отрицательным
        if (newStock < 0) {
            return false;
        }
        productStockDatabase.put(sku, newStock);
        return true;
    }

    // 1Positive false!if (!productStockDatabase.containsKey(sku))
    // 2 Positive false!if (newStock < 0)
    // 3Positive true quantityChange > 0
    // 4 Positive true quantityChange < 0 <= currentStock
    // 5 NullPointerException

}

class OrderFulfillmentService {
    private InventoryService inventoryService;

    public OrderFulfillmentService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public boolean fulfillOrder(Product product, int quantity) {
        if (product == null) {
            throw new NullPointerException();
        }
        String sku = product.getSku();
        int stock = inventoryService.checkProductStock(sku);               //возвращает int
        if (stock >= quantity) {
            boolean stockUpdated = inventoryService.updateStock(sku, -quantity);    // true oder false
            if (stockUpdated) { //true
                product.setStockQuantity(stock - quantity);
            }
            return stockUpdated; //boolean
        }
        return false;
        //Positive false (stock < quantity) {
        // if (stockUpdated) { false
        // Positive  stockUpdated - true

    }

    public boolean returnItemsToInventory(Product product, int quantity) { //ВОЗВРАТ ПРИХОД вернуть ариткул в инвентарь
        if (product == null) {
            throw new NullPointerException();
        }
        String sku = product.getSku();
        boolean stockUpdated = inventoryService.updateStock(sku, quantity); // true oder false
        if (stockUpdated) { //тру
            product.setStockQuantity(product.getStockQuantity() + quantity);
        }
        return stockUpdated;
        //Positive if (stockUpdated) { //тру
        //Positive if (stockUpdated) { //фальс
        //Positive if (product == null) {
    }
}