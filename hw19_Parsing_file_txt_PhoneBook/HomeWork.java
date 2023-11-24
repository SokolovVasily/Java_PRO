package org.example.hw19_08_11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HomeWork {
    public static void main(String[] args) {
        String path = "C:\\Users\\sokol\\IdeaProjects\\Less1\\src\\main\\java\\org\\example\\hw19_08_11\\1.txt";
        List<String> stringListLines = returnListFromFile(path);
        List<String> listName = returnListName(stringListLines);
        Map<Character, Long> characterLongMap = createMapKeyFirstLetterNameValueCount(listName);
        List<String> listStringPhoneNumber = returnListPhoneNumber(stringListLines);
        System.out.println(stringListLines);
        System.out.println(listName);
        System.out.println(createMapKeyFirstLetterNameValueCount(listName));
        System.out.println(returnMostPopularLetterName(characterLongMap));
        System.out.println(returnListPhoneNumber(stringListLines));
        System.out.println(createLongListPhoneNumber(listStringPhoneNumber));
        System.out.println(sortNameByLength(listName));
        System.out.println("Set: LastName:" + returnSetUniqueLastName(stringListLines));
        System.out.println(createListNameReverseOrder(listName));
        System.out.println(transformationDataInNameAndNumberFormat(stringListLines));
        System.out.println(returnAverageLengthNames(listName));
        System.out.println(findContactMaxNameLength(stringListLines));
        System.out.println(findContactMinNameLength(stringListLines));
        System.out.println(createMapKeyPhoneValueName(stringListLines));

    }

    //1.  Написать и протестировать методы которые парсят файл 1.txt и...
    public static List<String> returnListFromFile(String path) {
        if (path == null) {
            throw new IllegalArgumentException();
        }
        List<String> stringList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringList;
        //Posit list != null
        //throw new IllegalArgumentException(): String path == null
        //throw new RuntimeException(e): String path = "iztizrlur"//ерунда
    }

    public static List<String> returnListName(List<String> stringListLines) {
        if (stringListLines == null || stringListLines.isEmpty()) {
            throw new IllegalArgumentException("Warning!!! stringListLines is not be null or be empty");
        }
        String regex = "-\\s(\\p{L}+)\\s+(\\p{L}+)";
        Pattern pattern = Pattern.compile(regex);
        List<String> nameList = new ArrayList<>();
        for (String s : stringListLines) {
            Matcher matcher = pattern.matcher(s); //pattern.contains(s)....
            while (matcher.find()) {
                nameList.add(matcher.group(1));
            }
        }
        return nameList;
        //Posit nameList != null
        //Posit nameList.size()
        //Posit nameList.get()        инфа по индексу -> проверка
        //if (stringListLines == null IllegalArgumentException
        //stringListLines.isEmpty()) IllegalArgumentException
    }

    public static List<String> returnListPhoneNumber(List<String> stringListLines) {
        if (stringListLines == null || stringListLines.isEmpty()) {
            throw new IllegalArgumentException("Warning!!! stringListLines is not be null or be empty");
        }
        String regex = "[0-9]";
        Pattern pattern = Pattern.compile(regex);
        List<String> phoneList = new ArrayList<>();
        for (String s : stringListLines) {
            Matcher matcher = pattern.matcher(s); //pattern.contains(s)....
            StringBuilder stringBuilder = new StringBuilder(); //парсит- добавляет елем -которые склеиваются
            while (matcher.find()) {
                stringBuilder.append(matcher.group());
            }
            phoneList.add(String.valueOf(stringBuilder));
        }
        return phoneList;
        //Posit phoneList != null
        //Posit phoneList.size() //длина проверка
        //Posit phoneList.get()        инфа по индексу -> проверка по васе
        //if (stringListLines == null IllegalArgumentException
        //stringListLines.isEmpty()) IllegalArgumentException
    }


    //2.- Метод для создания мапы, где ключ - первая буква имени, а значение - количество таких имен
    //listName   //stringListLines
    public static Map<Character, Long> createMapKeyFirstLetterNameValueCount(List<String> listName) {
        if (listName == null || listName.isEmpty()) {
            throw new IllegalArgumentException("Warning!!! listName is not be null or be empty");
        }
        return listName.stream()
                .collect(Collectors.groupingBy(el -> el.charAt(0), Collectors.counting()));
        // Posit Map != null
        // Posit Map.size //размер=ожид разм
        // Posit Map.get(Key)
        //  if (listName == null IllegalArgumentException
        // if (listName.isEmpty()) IllegalArgumentException
    }

    //3.- Метод для нахождения самой часто встречающейся первой буквы в именах

    public static String returnMostPopularLetterName(Map<Character, Long> characterLongMap) {// Most -viel
        if (characterLongMap == null) {
            throw new IllegalArgumentException("Warning!!! stringList is not be null or be empty");
        }
        char key = '0';
        long value = 0L; // для лонга!
        for (Map.Entry<Character, Long> entry : characterLongMap.entrySet()) {   //alle
            if (entry.getValue() > value) {
                value = entry.getValue();
                key = entry.getKey();
            }
        }
        return String.valueOf(key);//  в стринг упаковали
        // Positive return not null
        // Posit returnLetter
        // if (characterLongMap == null) {
    }

    //4.- Метод для создания списка номеров телефонов, где каждый номер преобразован в числовой формат

    public static List<Long> createLongListPhoneNumber(List<String> listStringPhoneNumber) {
        if (listStringPhoneNumber == null || listStringPhoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Warning!!! stringList is not be null or be empty");
        }
        List<Long> longListPhone = new ArrayList<>();
        for (String stringEl : listStringPhoneNumber) {
            long phoneNumber = Long.parseLong(stringEl);
            longListPhone.add(phoneNumber);
        }

        return longListPhone;
        //Positive return not null
        //Positive list.size()
        //Positive list.get()
        //if (listStringPhoneNumber == null){
        //if(listStringPhoneNumber.isEmpty()) IllegalArgumentException
    }

    //5.Метод для группировки имен по длине имени

    public static List<String> sortNameByLength(List<String> nameList) {
        if (nameList == null || nameList.isEmpty()) {
            throw new IllegalArgumentException("Warning!!! nameList is not be null or be empty");
        }
        return nameList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();

        //Positive sortedNameList !=null;
        //Positive sortedNameList.size();
        //Positive sortedNameList.get
        //if (nameList == null
        //nameList.isEmpty())

    }
    //6.- returnListUniqueLastName
    // - Метод для поиска уникальных фамилий
    // нужно преобразовать метод извлечения из оригинал листа Name на фамилию через регул\рные выражения ->
    //  в HashSet - для уникальности ?

    public static Set<String> returnSetUniqueLastName(List<String> stringListLines) {
        if (stringListLines == null || stringListLines.isEmpty()) {
            throw new IllegalArgumentException("Warning!!! stringListLines is not be null or be empty");
        }
        String regex = "\\p{L}+$";
        Pattern pattern = Pattern.compile(regex);
        Set<String> lastNameSet = new HashSet<>();
        for (String s : stringListLines) {
            String[] partsString = s.split("\\s+");
            if (partsString.length > 1) {
                Matcher matcher;
                if (partsString.length == 5) {
                    String lastname = partsString[partsString.length - 2];
                    matcher = pattern.matcher(lastname); //pattern.contains(s)..матч ищет совп ,находит и возвращ
                } else {
                    String lastname = partsString[partsString.length - 1];
                    matcher = pattern.matcher(lastname);
                }
                if (matcher.find()) {
                    lastNameSet.add(matcher.group());
                }
            }

        }
        return lastNameSet;
        //Posit lastNameSet != null
        //Posit lastNameSet.size()
        //if (stringListLines == null IllegalArgumentException
        // stringListLines.isEmpty()) IllegalArgumentException
    }


    //7.- Метод для создания списка имен, отсортированного в обратном алфавитном порядке

    public static List<String> createListNameReverseOrder(List<String> nameList) {
        if (nameList == null || nameList.isEmpty()) {
            throw new IllegalArgumentException("Warning!!! nameList is not be null or be empty");
        }
        return nameList.stream()
                .sorted(Collections.reverseOrder())
                .toList();
        //Positive not Null;
        //Positive list.size
        //Positive list.get
        // if (listName == null) {IllegalArgumentException
        // if listName.isEmpty() {IllegalArgumentException
    }


    //8. -Метод для преобразования данных в формат имя=номер
    public static List<String> transformationDataInNameAndNumberFormat(List<String> stringListLines) {
        if (stringListLines == null || stringListLines.isEmpty()) {
            throw new IllegalArgumentException("Warning!!! stringListLines is not be null or be empty");
        }
        List<String> nameNumberList = new ArrayList<>();
        String regexPhoneNumber = "[0-9]";
        String regexName = "-\\s(\\p{L}+)\\s+(\\p{L}+)";
        Pattern patternPhoneNumber = Pattern.compile(regexPhoneNumber);
        Pattern patternName = Pattern.compile(regexName);
        for (String s : stringListLines) {
            Matcher matcherPhoneNumber = patternPhoneNumber.matcher(s);
            Matcher matcherName = patternName.matcher(s);
            String phoneString = returnPhoneString(matcherPhoneNumber);
            while (matcherName.find() && !(phoneString.isEmpty())) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(matcherName.group(1));
                stringBuilder.append("=");
                stringBuilder.append(phoneString);
                nameNumberList.add(String.valueOf(stringBuilder));
            }
        }
        return nameNumberList;
        //Positive test nameNumberList != null
        //Positive nameNumberList.size();
        //Positive nameNumberList.get()
        //stringListLines.isEmpty()){
        //if (stringListLines == null
    }

    // Создан дополн(не тестируемый) метод returnPhoneString()
    // для отработки получения полного номера (while  отрабатывает по номеру один раз-одну цифру!)
    private static String returnPhoneString(Matcher matcherPhoneNumber) {
        StringBuilder stringBuilder2 = new StringBuilder();
        while (matcherPhoneNumber.find()) {
            stringBuilder2.append(matcherPhoneNumber.group());
        }
        return String.valueOf(stringBuilder2);
    }

    //9.- Метод для расчета средней длины имени
    public static Float returnAverageLengthNames(List<String> nameList) {
        if (nameList == null || nameList.isEmpty()) {
            throw new IllegalArgumentException("Warning!!! stringListName is not be null or be empty");
        }
        return (float) nameList.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0);               //.orElse -для исключений.....
        //Positive Test return AVG;
        //if (nameList == null
        //nameList.isEmpty())

    }

    //10.- Метод для создания карты , где ключ - номер телефона, а значение - имя
    public static Map<String, String> createMapKeyPhoneValueName(List<String> stringListLines) {
        if (stringListLines == null || stringListLines.isEmpty()) {
            throw new IllegalArgumentException("Warning!!! stringListLines is not be null or be empty");
        }
        Map<String, String> phoneNameMap = new HashMap<>();
        String regexPhoneNumber = "[0-9]";
        String regexName = "-\\s(\\p{L}+)\\s+(\\p{L}+)";
        Pattern patternPhoneNumber = Pattern.compile(regexPhoneNumber);
        Pattern patternName = Pattern.compile(regexName);
        for (String s : stringListLines) {
            Matcher matcherPhoneNumber = patternPhoneNumber.matcher(s);
            Matcher matcherName = patternName.matcher(s);
            String phoneString = returnPhoneString(matcherPhoneNumber);
            while (matcherName.find() && !(phoneString.isEmpty())) {
                phoneNameMap.put(phoneString, matcherName.group(1));
            }
        }
        // Posit Map != null
        // Posit Map.size //размер=ожид разм
        // Posit Map.get(Key)
        //  if (listName == null IllegalArgumentException
        // if (listName.isEmpty()) IllegalArgumentException
        return phoneNameMap;


    }
    //11.-Метод для поиска контактов с максимальной и метод для контактов с минимальной длиной имени(2метода)
    public static String findContactMaxNameLength(List<String> stringListLines) {
        if (stringListLines == null || stringListLines.isEmpty()) {
            throw new IllegalArgumentException("Warning!!! stringListLines is not be null or be empty");
        }
        String maxName = "";
        String contact = "";
        String regex = "-\\s(\\p{L}+)\\s+(\\p{L}+)";
        Pattern pattern = Pattern.compile(regex);
        for (String lines : stringListLines) {
            Matcher matcher = pattern.matcher(lines); //pattern.contains(s)....
            if (matcher.find()) {
                String name = matcher.group(1);
                if (name.length() > maxName.length()) {
                    maxName = name;
                    contact = lines;
                }
            }
        }
        return contact;
        //Positive stringListLines ! = null;
        //Positive Equals String
        //if (stringListLines == null |
        // stringListLines.isEmpty()) {
    }

    public static String findContactMinNameLength(List<String> stringListLines) {
        if (stringListLines == null || stringListLines.isEmpty()) {
            throw new IllegalArgumentException("Warning!!! stringListLines is not be null or be empty");
        }
        String minName = "";
        String contact = "";
        String regex = "-\\s(\\p{L}+)\\s+(\\p{L}+)";
        Pattern pattern = Pattern.compile(regex);
        for (String lines : stringListLines) {
            Matcher matcher = pattern.matcher(lines); //pattern.contains(s)....
            if (matcher.find()) {
                String name = matcher.group(1);
                if (minName.isEmpty() || name.length() < minName.length()) { //
                    minName = name;
                    contact = lines;
                }
            }
        }
        return contact;
        //Positive stringListLines ! = null;
        //Positive Equals String
        //if (stringListLines == null |
        // stringListLines.isEmpty()) {
    }
}

