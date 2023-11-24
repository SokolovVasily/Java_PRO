package org.example.Lessons19.Mockito.taski_hw17_Test_Mock;

/**
 * Задание 1: Сервис заказов с внешним API для проверки статуса платежа
 * Бизнес логика:
 * <p>
 * Order - класс заказа, содержащий данные о заказе.
 * PaymentService - сервис для обработки платежей, который взаимодействует с внешним платежным API.
 * OrderService - сервис для управления заказами, который использует PaymentService.
 */

public class Order {
    private String id;
    private double amount;
    private boolean isPaid;

    public Order(String id, double amount, boolean isPaid) {
        this.id = id;
        this.amount = amount;
        this.isPaid = isPaid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}


interface ExternalPaymentApi {
    boolean requestPayment(Order order);//запросить оплату

    boolean verifyPayment(String orderId);//проверить платеж
}


class PaymentService {
    private ExternalPaymentApi paymentApi;

    public PaymentService(ExternalPaymentApi paymentApi) {
        this.paymentApi = paymentApi;
    }

    public boolean processPayment(Order order) { //процесс оплаты
        if (order == null) {
            throw new IllegalArgumentException();
        }
        return paymentApi.requestPayment(order) && paymentApi.verifyPayment(order.getId());
    }
    // Posit true und true
    //posit true und false
    //Posit false(when 1 =false;2 ist nicht actuell)
    // if(order == null){
}

class OrderService {
    private PaymentService paymentService;  //ohne R-y

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public boolean placeOrder(Order order) {   //aufgeben Order
        if (order == null) {
            throw new IllegalArgumentException();
        }
        boolean paymentProcessed = paymentService.processPayment(order);
        if (paymentProcessed) {
            order.setPaid(true);
        }
        return paymentProcessed;
        //Positiv true
        //Positive false
        //if (order == null){
    }
}