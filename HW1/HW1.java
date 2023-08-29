package org.example;

public class HW1 { // 1.Найти среднее арифметическое положительных элементов массива.
    public static void main(String[] args) {
        int[] myArr = {1,2,3,-6,-8,-4,} ;

        // обьявляем две переменные int - positiveSum (сумма полож) и positiveCount(колич),для
        // подсчета суммы положительных чисел и их количества .
        int positiveSum = 0;
        int positiveCount = 0;

        // Мы объявляем переменную i и инициализируем ее значением 0. Цикл будет
        for (int i = 0; i < myArr.length; i++) {     // выполняться,пока i меньше длины массива myArray
        if (myArr[i] > 0) {
            positiveSum += myArr[i]; //(+= это positiveSum = positiveSum + myArr[i]);
            // значение положит.элем после проверки
            //  суммируется к positiveSum
            positiveCount++; // positiveCount увеличив-ся на 1
        }
        }

        //вычисляем среднее арифметическое положительных элементов и сохраняем его
        // в переменной average
        double average ; //задаем дабл,вместо инт,что бы не терять дробную часть


        if (positiveCount > 0) {      //если больше,то
        average = positiveSum / positiveCount ; //Сред.арифм = сумма полож/колич.полож.элем
        } else {
            average = 0; //  в другом случае = 0 (СреднАрифм) не учитывается // можно пренебречь ELSE
        }

        System.out.println("Среднее Арифметическое полож элементов : " + average);

    }
      }

      //пример // (15 / 4 = 3.75 double (int = 15 / 4 = 3)!!! почему double ,a  не int