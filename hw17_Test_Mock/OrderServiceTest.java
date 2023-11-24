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
class OrderServiceTest {
    private OrderService orderService;
    @Mock
    private PaymentService paymentService;
    private Order order;

    @BeforeEach
    public void init() {
        orderService = new OrderService(paymentService);
        order = new Order("Vasy", 150, false);
    }

    @Test
    public void placeOrderPositiveTrueTest() {
        Mockito.when(paymentService.processPayment(order)).thenReturn(true); //заглушили и задали TRUE
        Assertions.assertTrue(orderService.placeOrder(order));
        Assertions.assertTrue(order.isPaid());
        Mockito.verify(paymentService).processPayment(order);
    }

    @Test
    public void placeOrderPositiveFalseTest() {
        Mockito.when(paymentService.processPayment(order)).thenReturn(false); //заглушили и задали false
        Assertions.assertFalse(orderService.placeOrder(order));
        Assertions.assertFalse(order.isPaid());
        Mockito.verify(paymentService).processPayment(order);
    }
    @Test
    public void placeOrderIllegalArgumentExceptionTest(){
        Assertions.assertThrows(IllegalArgumentException.class,()->orderService.placeOrder(null));
    }
}