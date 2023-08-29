package org.example;

public class HW2 { //Найти сумму всех элементов в массиве, которые делятся на 3 и
                   // одновременно не делятся на 5.

    public static void main(String[] args) {
        int[] myArr = {11,234,356,66,99,-48,} ;
        int SumDivisibleBy3 = 0; //переменная SumDivisibleBy3 -Сумма делящихся на 3 элементов;

        for (int i = 0; i < myArr.length; i++) { // цикл for
            if (myArr[i] % 3 == 0 && myArr[i] % 5 != 0) { //если i делится на 3 и не делится на 5,то
                SumDivisibleBy3 += myArr[i]; // значение элемента суммируется к Сумме делящихся на 3 элементов

    }
}
        System.out.println(" Cумма делящихся на 3 ,но не на 5 элементов :" +SumDivisibleBy3);
    }
}