package org.example;

public class HW3 {
    public static void main(String[] args) { //" Найти в массиве наибольшую сумму подряд идущих элементов".
        int[] myArr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        //                       *** 4, -1, 2, 1,**   -наибольшая сумма (6)
        int maxSum = myArr[0];  //максим сумма
        int currentSum = myArr[0]; // текущая сумма
        //инициализируем maxSum и currentSum значениями первого
        // элемента [].Эти переменные будут  для выведения наибольшей суммы.

        for (int i = 1; i < myArr.length; i++) {
            currentSum = Math.max(myArr[i], currentSum + myArr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println("Наибольшая сумма подряд идущих элементов: " + maxSum);
    }
}

