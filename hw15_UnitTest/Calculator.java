package org.example.hw15_UnitTest;

import java.util.ArrayList;
import java.util.List;

// Написать тесты на приведенные методы:
public class Calculator {

    // 1. Простое сложение двух чисел
    public int add(int a, int b) {
        return a + b;
    }
    //Positive
    //Positive2

    // 2. Вычитание
    public int subtract(int a, int b) {   //subtract вычитать
        return a - b;
        //Positive
    }

    // 3. Умножение
    public int multiply(int a, int b) {
        return a * b;
        //Positive
    }

    // 4. Деление
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
        //Positive
        //if (b == 0) {
    }

    // 5. Возведение в степень
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
        //positive
    }

    // 6. Вычисление факториала
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        if (n == 0) {
            return 1;
        }
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
        //positive
        //positive if (n == 0) { return 1
        //if(n < 0){

    }

    // 7. Определение четности числа
    public boolean isEven(int n) {
        return n % 2 == 0;
        //Positive true
        //Positive false
    }

    // 8. Поиск максимального числа в массиве
    public int findMax(int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
        //positive
        //if (array == null) {
    }

    // 9. Определение простого числа
    public boolean isPrime(int n) {
        if (n <= 1) {
            throw new IllegalArgumentException();
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
        //Positive if (n % i == 0)return false;
        //Positive if (n % i == 0)return true;
        // if (n <= 1)


    }

    // 10. Перевод числа в строку с указанием системы счисления
    public String toBaseString(int n, int base) {
        if (base < 2 || base > 16) {
            throw new IllegalArgumentException("Base should be between 2 and 16");
        }
        return Integer.toString(n, base);
        //Positiv
        //IllegalArgumentException 1 base < 2
        //IllegalArgumentException 2 base > 16)
    }

    // 11. Вычисление корня числа
    public double sqrt(double a) {
        if (a < 0) {
            throw new IllegalArgumentException("Negative numbers are not supported");
        }
        return Math.sqrt(a);
        //Posit
        //IllegalArgumentException
    }

    // 12. Инвертирование строки // мама амам
    public String reverseString(String input) {
        if (input == null) {
            throw new NullPointerException();
        }
        return new StringBuilder(input).reverse().toString();
        //Posit
        //NullPointerException
    }

    // 13. Проверка, является ли строка палиндромом
    public boolean isPalindrome(String input) {
        if (input == null) {
            throw new NullPointerException();
        }
        String reversed = reverseString(input);
        return input.equals(reversed);
        //posit1 true
        //posit2 false
        //NullPointerException
    }

    // 14. Вычисление НОД двух чисел//наиб делитель
    public int gcd(int a, int b) {
        if (a < 1 || b < 1) {
            throw new IllegalArgumentException();
        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
        //Posit
        //if(a < 1
        //if(b < 1)
    }

    // 15. Перемножение элементов массива
    public long productOfArray(int[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
        long e = array[0];
        for (int i = 1; i < array.length; i++) {
            e = e * array[i];
        }
        return e;
        //posit
        //if (array == null)NullPointerException

    }

    // 16. Определение длины самого длинного слова в строке
    public int lengthOfLongestWord(String sentence) {
        if (sentence == null) {
            throw new NullPointerException("String can't be  Null!");
        }
        String[] words = sentence.split("\\s+");//метод сплит разбивает по пробелам на слова
        int maxLength = 0;
        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
            }
        }
        return maxLength;
        //posit
        //NullPointerException
    }

    // 17. Конвертация температуры из Цельсия в Фаренгейт
    public double celsiusToFahrenheit(double celsius) {
        return celsius * 1.8 + 32;
        //posit
    }

    // 18. Проверка на вхождение подстроки в строку (без использования стандартных методов Java)
    public boolean containsSubstring(String main, String sub) {
        if (main == null || sub == null) {
            throw new NullPointerException();
        }
        if (main.length() < sub.length()) {
            throw new IllegalArgumentException();

        }
        for (int i = 0; i <= main.length() - sub.length(); i++) {
            if (main.substring(i, i + sub.length()).equals(sub)) {
                return true;
            }
        }

        return false;
        //Positiv true
        //Positiv false
        //if(main==null
        //sub==null){
        //f (main.length()<sub.length()) {
    }

    // 19. Сумма цифр числа
    //256 --- 2 + 5 + 6
    public int sumOfDigits(int number) {
        List<Integer> integerList = new ArrayList<>();
        String s = String.valueOf(number);
        for (int i = 0; i < s.length(); i++) {
            int x = Integer.parseInt(String.valueOf(s.charAt(i)));
            integerList.add(x);
        }
        return integerList.stream()
                .mapToInt(Integer::intValue)
                .sum();
        //positiv

    }

    // 20. Проверка, является ли год високосным
    public boolean isLeapYear(int year) {
        if (year < 1582) {
            throw new IllegalArgumentException("начала отсчета Гигорианского календаря с високосными годами");
        }
        if (year % 4 == 0 && year % 100 != 0) {
            return true;
        } else {
            if (year % 4 == 0 && year % 100 == 0) {
                if (year % 100 == 0 && year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    //Posit true
    //Posit false
    //IllegalArgumentException
}