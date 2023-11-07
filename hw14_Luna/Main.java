package org.example.hw14_Luna;

public class Main {
    public static void main(String[] args) {
        Card card = new Card();
        LunaMethod lunaMethod = new LunaMethod();
        String numberCard = card.generateCard();
        System.out.println("Создание новой карты с номером карты, месяц и год окончания срока действия, CVV: "
                + numberCard);

        System.out.println(lunaMethod.cardAccept(numberCard));
    }
}
