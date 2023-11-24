package org.example.Lessons19.Mockito.taski_hw17_Test_Mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {
    //@InjectMocks
    private PaymentService paymentService;    ///ohne relalisation POLe Ex ckl

    @Mock
    private ExternalPaymentApi paymentApi;  //Mock object -obj zagluschka
    Order order = new Order("01", 100, true);

    @BeforeEach
    public void setUp() {
       paymentService = new PaymentService(paymentApi);   //realizuem
    }
    @Test
    public void processPaymentIfRequestPaymentAndVerifyPaymentIsTrueTest() {

        Mockito.when(paymentApi.requestPayment(order)).thenReturn(true);
        Mockito.when(paymentApi.verifyPayment(order.getId())).thenReturn(true);
        Assertions.assertTrue(paymentService.processPayment(order));
        Mockito.verify(paymentApi).requestPayment(order);
        Mockito.verify(paymentApi).verifyPayment(order.getId());
    }
    @Test
    public void processPaymentIfRequestPaymentTrueAndVerifyPaymentFalseTest() {

        Mockito.when(paymentApi.requestPayment(order)).thenReturn(true);
        Mockito.when(paymentApi.verifyPayment(order.getId())).thenReturn(false);
        Assertions.assertFalse(paymentService.processPayment(order));
        Mockito.verify(paymentApi).requestPayment(order);
        Mockito.verify(paymentApi).verifyPayment(order.getId());
    }

    @Test
    public void processPaymentIfRequestPaymentFalseTest() {       //1 -false//alle -false

        Mockito.when(paymentApi.requestPayment(order)).thenReturn(false);
       // Mockito.when(paymentApi.verifyPayment(order.getId())).thenReturn(false);
        Assertions.assertFalse(paymentService.processPayment(order));
        Mockito.verify(paymentApi).requestPayment(order);
       // Mockito.verify(paymentApi).verifyPayment(order.getId());
    }
    @Test
    public void processPaymentIfOrderIsNullIllegalArgumentException() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> paymentService.processPayment(null));
    }

}