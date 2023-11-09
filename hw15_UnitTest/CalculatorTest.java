package org.example.hw15_UnitTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    //1.
    Calculator calculator = new Calculator();

    @Test
    void addSumNumberPositiveTest() {
        Assertions.assertEquals(4, calculator.add(2, 2));
    }

    @Test
    void addSumNumberPositiveTest2() {
        Assertions.assertEquals(5, calculator.add(3, 2));
    }

    //2.
    @Test
    void subtractNumberPositiveTest() {
        Assertions.assertEquals(0, calculator.subtract(2, 2));
    }

    //3.
    @Test
    void multiplyNumberPositiveTest() {
        Assertions.assertEquals(9, calculator.multiply(3, 3));
    }

    //4.
    @Test
    void divideNumberPositiveTest() {
        Assertions.assertEquals(10, calculator.divide(100, 10));
    }

    @Test
    void divideOfNumberArithmeticExceptionTest() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(100, 0));
    }

    //5.
    @Test
    void powerPositiveTest() {
        Assertions.assertEquals(9, calculator.power(3, 2));
    }

    //6.
    @Test
    void factorialPositiveTest() {
        Assertions.assertEquals(120, calculator.factorial(5));
    }

    @Test
    void factorialZeroPositiveTest() {
        Assertions.assertEquals(1, calculator.factorial(0));
    }

    @Test
    void factorialIllegalArgumentExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1));
    }

    //7.
    @Test
    void isEvenPositiveTrueTest() {
        Assertions.assertTrue(calculator.isEven(10));
    }

    @Test
    void isEvenPositiveFalseTest() {
        Assertions.assertFalse(calculator.isEven(9));
    }

    //8.
    @Test
    void findMaxPositiveTest() {
        int[] array = {1, 2, 30, 2, 5, 10, 100, 3};
        Assertions.assertEquals(100, calculator.findMax(array));
    }

    @Test
    void findMaxNullPointerExceptionTest() {
        Assertions.assertThrows(NullPointerException.class, () -> calculator.findMax(null));
    }
    //9.

    @Test
    void isPrimeNumberPositiveFalseTest() {
        Assertions.assertFalse(calculator.isPrime(10));
    }

    @Test
    void isPrimeNumberPositiveTrueTest() {
        Assertions.assertTrue(calculator.isPrime(7));
    }

    @Test
    void isPrimeIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.isPrime(1));
    }

    // 10. Перевод числа в строку с указанием системы счисления
    @Test
    void toBaseStringPositiveTest() {
        Assertions.assertEquals("101", calculator.toBaseString(5, 2));
    }

    @Test
    void toBaseStringIllegalArgumentExceptionBaseLessTwoTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.toBaseString(5, 1));
    }

    @Test
    void toBaseStringIllegalArgumentExceptionBaseHighThenSixteenTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.toBaseString(5, 17));
    }

    // 11. Вычисление корня числа
    @Test
    void sqrtPositiveTest() {
        Assertions.assertEquals(3, calculator.sqrt(9));
    }

    @Test
    void sqrtIllegalArgumentExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.sqrt(-1));
    }

    // 12. Инвертирование строки // мама амам
    @Test
    void reverseStringPositiveTest() {
        Assertions.assertEquals("Java", calculator.reverseString("avaJ"));
    }

    @Test
    void reverseStringNullPointerExceptionTest() {
        Assertions.assertThrows(NullPointerException.class, () -> calculator.reverseString(null));
    }

    // 13. Проверка, является ли строка палиндромом
    @Test
    void isPalindromePositiveTrueTest() {

        Assertions.assertEquals(true, calculator.isPalindrome("mamam"));
    }

    @Test
    void isPalindromePositiveFalseTest() {
        Assertions.assertEquals(false, calculator.isPalindrome("maman"));
    }

    @Test
    void isPalindromeNullPointerException() {
        Assertions.assertThrows(NullPointerException.class, () -> calculator.isPalindrome(null));
    }

    // 14. Вычисление НОД двух чисел//наиб делитель
    @Test
    void gcdPositiveTest() {
        Assertions.assertEquals(5, calculator.gcd(10, 15));
    }

    @Test
    void gcdIllegalArgumentExceptionALessOneTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.gcd(0, 10));
    }

    @Test
    void gcdIllegalArgumentExceptionBLessOneTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.gcd(10, -10));
    }

    // 15. Перемножение элементов массива
    @Test
    void productOfArrayPositiveTest() {
        int[] array = {1, 2, 3, -4};
        Assertions.assertEquals(-24, calculator.productOfArray(array));
    }

    @Test
    void productOfArrayNullPointerExceptionTest() {
        Assertions.assertThrows(NullPointerException.class, () -> calculator.productOfArray(null));
    }

    // 16. Определение длины самого длинного слова в строке
    @Test
    void lengthOfLongestWordPositiveTest() {
        String sentence = "baobab liebt sohne";
        Assertions.assertEquals(6, calculator.lengthOfLongestWord(sentence));
    }

    @Test
    void lengthOfLongestWordNullPointerExceptionTest() {
        Assertions.assertThrows(NullPointerException.class, () -> calculator.lengthOfLongestWord(null));
    }

    // 17. Конвертация температуры из Цельсия в Фаренгейт
    @Test
    void celsiusToFahrenheitPositiveTest() {
        Assertions.assertEquals(68, calculator.celsiusToFahrenheit(20));
    }

    // 18. Проверка на вхождение подстроки в строку (без использования стандартных методов Java)
    @Test
    void containsSubstringPositiveTrueTest() {
        Assertions.assertTrue(calculator.containsSubstring("mama", "ma"));
    }

    @Test
    void containsSubstringPositiveFalseTest() {
        Assertions.assertFalse(calculator.containsSubstring("mama", "any"));
    }

    @Test
    void containsSubstringNullPointerExceptionMainTest() {
        Assertions.assertThrows(NullPointerException.class, () -> calculator.containsSubstring(null, "any"));
    }

    @Test
    void containsSubstringNullPointerExceptionSubTest() {
        Assertions.assertThrows(NullPointerException.class, () -> calculator.containsSubstring("mama", null));
    }

    @Test
    void containsSubstringSubMoreMainIllegalArgumentExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.containsSubstring("mama", "mamany"));
    }
    //19.Сумма цифр числа
    //    //256 --- 2 + 5 + 6
    @Test
    void sumOfDigitsPositiveSumTest() {
        Assertions.assertEquals(13,calculator.sumOfDigits(256));
    }
    //20.Проверка, является ли год високосным
    @Test
    void isLeapYearPositiveTrueTest(){
        Assertions.assertTrue(calculator.isLeapYear(2024));
    }
    @Test
    void isLeapYearPositiveFalseTest(){
        Assertions.assertFalse(calculator.isLeapYear(1700));
    }
    @Test
    void isLeapYearIllegalArgumentExceptionTest(){
        Assertions.assertThrows(IllegalArgumentException.class,()->calculator.isLeapYear(124));

    }
}