package org.example.hw14_Luna;

import java.util.Random;

public class Card {  // 4 метода 1-16 цифръ,2-генер 2 услов месяц год плюс 5 лет будущ,3-генр CVV , 4 все собирать
    private static final int year = 2023;
    Random random = new Random();

    public String generateCard() {
        return returnNumbersCard() + returnDataMonthsCard() + returnDataYearCard() + returnCVV();
    }

    private String returnNumbersCard() {
        return String.valueOf(random.nextLong(1_000_000_000_000_000L, 10_000_000_000_000_000L));
    }

    private String returnDataMonthsCard() {
        String months;
        int number = random.nextInt(1, 13);
        if (number >= 1 && number < 10) {
            months = "0" + number;
        } else {
            months = String.valueOf(number);
        }
        return months;
    }
    private String returnDataYearCard(){
        return  String.valueOf(random.nextInt(4, 6) + (Card.year - 2000));
    }

    private String returnCVV() {
        return String.valueOf(random.nextInt(100, 1000));
    }
}
