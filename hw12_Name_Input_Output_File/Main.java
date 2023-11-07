package org.example.hw12_Name_Input_Output_File;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\sokol\\IdeaProjects\\Less1\\src\\main\\java\\org\\example\\HW12\\names.txt";
        List<String> listNames = returnListName(fileName); // 1
        System.out.println(listNames);
        String substring = "n";
        int minLength = 3;
        int maxLength = 5;
        int n = 10;//
        char c = 'A';
        System.out.println("Подсчет общего числа имен в файле: "
                + countTotalNames(listNames));
        System.out.println("Нахождение уникальных имен в файле: "
                + uniqueNames(listNames));
        System.out.println("Подсчет числа имен, содержащих заданную подстроку: "
                + countNamesContainingSubstring(listNames, substring));
        System.out.println("Нахождение имен, длина которых находится в заданном диапазоне: "
                + namesWithLengthInRange(listNames, minLength, maxLength));
        System.out.println("Вывод первых N имен в алфавитном порядке: "
                + firstNNamesAlphabetically(listNames, n));
        System.out.println("Нахождение пяти самых часто встречающихся имен в файле: "
                + topFiveCommonNames(listNames));
        System.out.println("Нахождение имен, которые начинаются на заданную букву и встречаются больше двух раз: "
                + namesStartingWithAndOccurMoreThanTwice(listNames, c));
        System.out.println("Нахождение двух имен с самой длинной и самой короткой длиной: " + longestAndShortestNames(listNames));

    }

    private static List<String> returnListName(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            List<String> list = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
            return list;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //1.**Подсчет общего числа имен в файле
    private static long countTotalNames(List<String> stringList) {
        return stringList.size();
    }

    //2.**Нахождение уникальных имен в файле
    private static Set<String> uniqueNames(List<String> listName) {
        Set<String> stringSet = new HashSet<>(listName);
        return stringSet;
    }

    //3.**Подсчет числа имен, содержащих заданную подстроку
    private static long countNamesContainingSubstring(List<String> listName, String substring) {
        return listName.stream()
                .filter(el -> el.contains(substring))
                .count();
    }

    //4.**Нахождение имен, длина которых находится в заданном диапазоне
    private static List<String> namesWithLengthInRange(List<String> listName, int minLength, int maxLength) {
        return listName.stream()
                .filter(el -> el.length() > minLength && el.length() < maxLength)
                .toList();
    }

    //5.**Вывод первых N имен в алфавитном порядке
    private static List<String> firstNNamesAlphabetically(List<String> listName, int n) {
        return listName.stream()
                .sorted()
                .limit(n)
                // .collect(Collectors.toList());
                .toList();
    }

    //6.**Нахождение пяти самых часто встречающихся имен в файле
    private static List<String> topFiveCommonNames(List<String> listName) {
        return listName.stream()
                .collect(Collectors.groupingBy(el -> el, Collectors.counting()))
                .entrySet().stream()
                .sorted((el1, el2) -> Math.toIntExact(el2.getValue() - el1.getValue()))
                .limit(5)
                .map(el -> el.getKey())
                .toList();
    }

    //7.*Нахождение имен, которые начинаются на заданную букву и встречаются больше двух раз
    private static Set<String> namesStartingWithAndOccurMoreThanTwice(List<String> listName, char c) {
        return listName.stream()
                .filter(el -> el.startsWith(String.valueOf(c)))
                .collect(Collectors.groupingBy(el -> el, Collectors.counting()))
                .entrySet().stream()
                .filter(el -> el.getValue() > 2)
                .map(el -> el.getKey())
                .collect(Collectors.toSet());
    }

    //8. Нахождение двух имен с самой длинной и самой короткой длиной
    private static Pair<String, String> longestAndShortestNames(List<String> listName) {
        String key = listName.stream()
                .max((el1, el2) -> el1.length() - el2.length())
                .toString();
        String value = listName.stream()
                .min((el1, el2) -> el1.length() - el2.length())
                .toString();
        return new Pair<>(key, value);
    }
}
