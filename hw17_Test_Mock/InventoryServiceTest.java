package org.example.Lessons19.Mockito.taski_hw17_Test_Mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryServiceTest {
    private InventoryService inventoryService;

    @BeforeEach
    public void init() {
        inventoryService = new InventoryService();
    }

    @Test
    public void checkProductStockPositiveTest() {
        Assertions.assertEquals(100, inventoryService.checkProductStock("ABC123"));
    }

    @Test
    public void checkProductStockNullPointerExceptionTest() {
        Assertions.assertThrows(NullPointerException.class, () -> inventoryService.checkProductStock(null));
    }


    @Test
    public void updateStockPositiveNotContainsInDatabaseFalseTest() {
        Assertions.assertFalse(inventoryService.updateStock("1111111", 100));
    }

    @Test
    public void updateStockPositiveQuantityChangeMoreCurrentStockFalseTest() {
        Assertions.assertFalse(inventoryService.updateStock("ABC123", -200));
    }

    @Test
    public void updateStockPositiveTrueQuantityChangeMoreZeroTest() {
        Assertions.assertTrue(inventoryService.updateStock("ABC123", 100));
        Assertions.assertEquals(200, inventoryService.checkProductStock("ABC123"));
    }

    @Test
    public void updateStockPositiveTrueQuantityChangeLessZeroLessOrEqualsCurrentStockTest() {
        Assertions.assertTrue(inventoryService.updateStock("ABC123", -100));
        Assertions.assertEquals(0, inventoryService.checkProductStock("ABC123"));
    }
    @Test
    public void updateStockNullPointerExceptionTest() {
        Assertions.assertThrows(NullPointerException.class,()->inventoryService.updateStock(null,1));
    }
}