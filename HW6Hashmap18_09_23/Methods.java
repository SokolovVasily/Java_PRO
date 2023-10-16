package org.example.HW6_____18_09_23Hashmap;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Methods {
    //1.Переберите все ключи и значения в HashMap и TreeMap и выведите их на экран
    public void outPuttingKeysValues(Map<String, Integer> integerMap, Map<String, Integer> integerMap1) {
        for (Map.Entry<String, Integer> mapEntry : integerMap.entrySet()) {
            System.out.println("Ключ: " + mapEntry.getKey() + " | Value: " + mapEntry.getValue());
        }
        System.out.println("_______________________________________________________________________________");
        for (Map.Entry<String, Integer> mapEntry : integerMap1.entrySet()) {
            System.out.println("Ключ: " + mapEntry.getKey() + " | Value: " + mapEntry.getValue());
        }
    }

    //2.Переберите только ключи в HashMap и TreeMap и найдите сумму их длин.
    public void sumOfKeyLengths(Map<String, Integer> integerMap, Map<String, Integer> integerMap1) {
        int sumHashMap = 0;
        for (String key : integerMap.keySet()) {
            sumHashMap = sumHashMap + key.length();
        }

        int sumHashMap1 = 0;
        for (String key : integerMap1.keySet()) {
            sumHashMap1 = sumHashMap1 + key.length();
        }
        System.out.println("Сумма длинны HashMap: " + sumHashMap);
        System.out.println("Сумма длинны TreeMap: " + sumHashMap1);
    }

    //3.Переберите только значения в HashMap и TreeMap и найдите их среднее значение.
    public void averageValues(Map<String, Integer> integerMap, Map<String, Integer> integerMap1) {
        int sumHashMap = 0;
        int countHashMap = 0;
        for (Integer values : integerMap.values()) {
            sumHashMap = sumHashMap + values;
            countHashMap++;
        }

        int sumTreeMap = 0;
        int countTreeMap = 0;
        for (Integer values : integerMap1.values()) {
            sumTreeMap = sumTreeMap + values;
            countTreeMap++;
        }
        System.out.println("Среднее значение Values HashMap: " + (sumHashMap / countHashMap));
        System.out.println("Среднее значение Values TreeMap: " + (sumTreeMap / countTreeMap));
    }


    //4.Переберите HashMap  и найдите ключ с максимальным значением

    public void findKeyMaxValue(Map<String, Integer> integerMap) {
        int maxKeyValye = Integer.MIN_VALUE;
        String maxKey = null;
        for (String key : integerMap.keySet()) {
            if (key.length() > maxKeyValye) {
                maxKeyValye = key.length();
                maxKey = key;
            }
        }
        System.out.println("Максимальн ключ: " + maxKey + " длинной " + maxKeyValye);
    }

    //5.Переберите TreeMap и найдите ключ с минимальным значением.
    public void findKeyMinValue(Map<String, Integer> integerMap1) {
        int minKeyValue = Integer.MAX_VALUE;
        String minKey = null;
        for (String key : integerMap1.keySet()) {
            if (key.length() < minKeyValue) {
                minKeyValue = key.length();
                minKey = key;
            }
        }
        System.out.println("Минимальный ключ: " + minKey + " длинной " + minKeyValue);
    }

    //.6 Переберите HashMap и удалите все элементы с четными значениями
    public void removeEvenElemValue(Map<String, Integer> integerMap) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> mapEntry : integerMap.entrySet()) {
            if (mapEntry.getValue() % 2 == 0) {
                list.add(mapEntry.getKey());
            }
        }
        for (String key : list) {
            integerMap.remove(key);
        }
        for (Map.Entry<String, Integer> mapEntry : integerMap.entrySet()) {
            System.out.println("Ключ: " + mapEntry.getKey() + " | Value: " + mapEntry.getValue());
        }
    }
    //.7 Переберите TreeMap и удалите все элементы с ключами, начинающимися с буквы 'A'
    public void removeElemStartA(Map<String,Integer>integerMap1){
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> mapEntry : integerMap1.entrySet()) {
            if (mapEntry.getKey().startsWith("A")) {
                list.add(mapEntry.getKey());
            }
        }
        for (String key : list) {
            integerMap1.remove(key);
        }
        for (Map.Entry<String, Integer> mapEntry : integerMap1.entrySet()) {
            System.out.println("Ключ: " + mapEntry.getKey() + " | Value: " + mapEntry.getValue());
        }
    }
    //8.Переберите TreeMap и найдите наибольший ключ, который меньше или равен заданному ключу.
    public void findMaxKeySatCondition(Map<String,Integer> integerMap1,int keyLengthValue){

        int maxKeyValue = Integer.MIN_VALUE;
        String maxKey = null;
        for (String key : integerMap1.keySet()) {
            if (key.length() > maxKeyValue && key.length() <= keyLengthValue) {
                maxKeyValue = key.length();
                maxKey = key;

            }

        }

        System.out.println("наибольший(макс подход) ключ: " + maxKey + " длинной " + maxKeyValue);
    }
}




