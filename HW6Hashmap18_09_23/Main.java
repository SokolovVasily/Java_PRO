package org.example.HW6_____18_09_23Hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        Map<String,Integer> integerMap = new HashMap<>();
        integerMap.put("Basil",43);
        integerMap.put("Kirill",36);
        integerMap.put("Adler",24);
        integerMap.put("Anton",25);
        integerMap.put("Bor",27);
        integerMap.put("Rom",28);
        integerMap.put("Beer",29);
        integerMap.put("Gir",23);

        Map<String,Integer> integerMap1 = new TreeMap<>();
        integerMap1.put("Basil",43);
        integerMap1.put("Kirill",36);
        integerMap1.put("Adler",24);
        integerMap1.put("Anton",25);
        integerMap1.put("Bor",27);
        integerMap1.put("Rom",28);
        integerMap1.put("Beer",29);
        integerMap1.put("Gir",23);

        Methods methods = new Methods();
        //1.Переберите все ключи и значения в HashMap и TreeMap и выведите их на экран
        methods.outPuttingKeysValues(integerMap,integerMap1);
        System.out.println("_____________________________________________________________________________________");
        //2.Переберите только ключи в HashMap и TreeMap и найдите сумму их длин.
        methods.sumOfKeyLengths(integerMap,integerMap1);
        System.out.println("______________________________________________________________________________________");
        //3.Переберите только значения в HashMap и TreeMap и найдите их среднее значение.
        methods.averageValues(integerMap,integerMap1);
        System.out.println("______________________________________________________________________________________");
        //4.Переберите HashMap и найдите ключ с максимальным значением.
        methods.findKeyMaxValue(integerMap);
        System.out.println("________________________________________________________________");
        //5.Переберите TreeMap и найдите ключ с минимальным значением.
        methods.findKeyMinValue(integerMap1);
        System.out.println("____________________________________________________________");
        //6.Переберите HashMap и удалите все элементы с четными значениями
        methods.removeEvenElemValue(integerMap);
        System.out.println("______________________________________________________");
        //7.Переберите TreeMap и удалите все элементы с ключами, начинающимися с буквы 'A'
        methods.removeElemStartA(integerMap1);
        System.out.println("_________________________________________________________________________");
        //8.Переберите TreeMap и найдите наибольший ключ, который меньше или равен заданному ключу
        methods.findMaxKeySatCondition(integerMap1,4);
    }
}
