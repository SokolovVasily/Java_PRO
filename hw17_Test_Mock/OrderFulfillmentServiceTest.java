package org.example.Lessons19.Mockito.taski_hw17_Test_Mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class OrderFulfillmentServiceTest {

    private OrderFulfillmentService orderFulfillmentService;
    @Mock
    private InventoryService inventoryService;
    private Product product;


    @BeforeEach
    public void init() {
        orderFulfillmentService = new OrderFulfillmentService(inventoryService);
        product = new Product("SaftTomaten", 100);
    }

    @Test
    public void fulfillOrderPositiveStockUpdatedTrueTest() {
        String sku = product.getSku();
        int quantity = 50;
        Mockito.when(inventoryService.checkProductStock(sku)).thenReturn(100);
        Mockito.when(inventoryService.updateStock(sku, -quantity)).thenReturn(true);
        Assertions.assertTrue(orderFulfillmentService.fulfillOrder(product, quantity));
        Assertions.assertEquals(50, product.getStockQuantity());
        Mockito.verify(inventoryService).checkProductStock(sku);
        Mockito.verify(inventoryService).updateStock(sku, -quantity);
    }

    @Test
    public void fulfillOrderPositiveStockLessQuantityFalseTest() {
        String sku = product.getSku();
        int quantity = 150;
        Mockito.when(inventoryService.checkProductStock(sku)).thenReturn(100);
        Assertions.assertFalse(orderFulfillmentService.fulfillOrder(product, quantity));
        Assertions.assertEquals(100, product.getStockQuantity());
        Mockito.verify(inventoryService).checkProductStock(sku);
    }

    @Test
    public void fulfillOrderPositiveStockUpdatedFalseTest() {
        String sku = product.getSku();
        int quantity = 50;
        Mockito.when(inventoryService.checkProductStock(sku)).thenReturn(100);
        Mockito.when(inventoryService.updateStock(sku, -quantity)).thenReturn(false);
        Assertions.assertFalse(orderFulfillmentService.fulfillOrder(product, quantity));
        Assertions.assertEquals(100, product.getStockQuantity());
        Mockito.verify(inventoryService).checkProductStock(sku);
        Mockito.verify(inventoryService).updateStock(sku, -quantity); //
    }

    @Test
    public void fulfillOrderNullPointerExceptionTest() {
        Assertions.assertThrows(NullPointerException.class,
                () -> orderFulfillmentService.fulfillOrder(null, 100));
    }

    @Test
    public void returnItemsToInventoryPositiveTrueTest() {
        String sku = product.getSku();
        int quantity = 100;
        Mockito.when(inventoryService.updateStock(sku, quantity)).thenReturn(true);
        Assertions.assertTrue(orderFulfillmentService.returnItemsToInventory(product, quantity));
        Assertions.assertEquals(200, product.getStockQuantity());
        Mockito.verify(inventoryService).updateStock(sku, quantity);
    }

    @Test
    public void returnItemsToInventoryPositiveFalseTest() {
        String sku = product.getSku();
        int quantity = 100;
        Mockito.when(inventoryService.updateStock(sku, quantity)).thenReturn(false);
        Assertions.assertFalse(orderFulfillmentService.returnItemsToInventory(product, quantity));
        Assertions.assertEquals(100, product.getStockQuantity());
        Mockito.verify(inventoryService).updateStock(sku, quantity);

    }
    @Test
    public void returnItemsToInventoryNullPointerExceptionTest() {
        Assertions.assertThrows(NullPointerException.class,
                () -> orderFulfillmentService.returnItemsToInventory(null, 100));
    }

}