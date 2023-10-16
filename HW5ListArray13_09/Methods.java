package org.example.HW5ListArray13_09;

import java.util.*;
import java.util.function.Predicate;

public class Methods {
    // 1.Задание :создать  ArrayList<Integer>.
    public static ArrayList<Integer> createArrayList(int size, int max) {//функция ,статик .это метод класса,не обьекта
        ArrayList<Integer> arrayList = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arrayList.add(random.nextInt(max)); // дает цел числ число от нуля до макс
        }
        return arrayList;
    }

    // 1.1 Создать LinkedList<Integer>.
    public static LinkedList<Integer> createLinkedList(int size, int max) {//функция ,статик .это метод класса,не обьекта
        LinkedList<Integer> linkedList = new LinkedList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            linkedList.add(random.nextInt(max)); // дает цел числ число от нуля до макс100
        }
        return linkedList;
    }

    // 2.Найти сумму всех элементов ArrayList<Integer> или LinkedList<Integer>:.
    public static int getSumList(List<Integer> list) {// таким мы избавились от ограничения типа Array un Linked списков
        int sum = 0;
        for (int element : list) {
            sum += element;   // sum = (element > 0) ? += element : sum    - если елем больше 0,тогда сум плюс эл                    //
        }
        return sum;
    }


    // 3.Найти среднее арифм. AVERAGE для всех элементов  LinkedList<Integer> или ArrayList<Integer>.
    public static double getAverageValue(List<Integer> list) {
        double size = list.size();
        return getSumList(list) / size;
    }

    //4. Перебрать ArrayList<Integer> или  LinkedList<Integer> и найти наименьший элемент.

    public static int getSmallestElement(List<Integer> list) {  // least -наименьший
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Список пуст или равен null");//выдать новое исключение недопустимого аргумента
        }
        int smallest = list.get(0); // Предполагаем, что первый элемент наименьший
        for (int i = 1; i < list.size(); i++) {

            if (list.get(i) < smallest) {
                smallest = list.get(i);
            }
        }
        return smallest;
    }

    // 5.Перебрать LinkedList<Integer> и ArrayList<Integer> найти наибольший элемент.

    public static int getLargestElement(List<Integer> list) {  // largest,greatest -наибольший
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Список пуст или равен null");//выдать новое исключение недопустимого аргумента
        }
        int largest = list.get(0); // Предполагаем, что первый элемент наибольший
        for (int i = 1; i < list.size(); i++) {

            if (list.get(i) > largest) {
                largest = list.get(i);
            }
        }
        return largest;
    }

    // 6.Удалить элементы из списков по заданному условию (порогу)
    public static void removeElementsAboveThreshold(List<Integer> list, int threshold) { //removeAboveThreshold удалитьвыше порога
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int element = iterator.next();
            if (element >= threshold) {
                iterator.remove();
            }
        }
    }

    // 7.Перебирать List<Integer> и удалять все "четные" числа.
    // Метод для удаления всех четных чисел из списка
    public static void removeEvenNumbers(List<Integer> list) { //Even четные
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int element = iterator.next();
            if (element % 2 == 0) {
                iterator.remove();
            }
        }
    }

    // 8. Метод для замены всех элементов, кратных 3, на нули...
    public static void replaceMultiplesOfThreeWithZeros(List<Integer> list) { //заменить кратные 3 на нули...

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 3 == 0) {
                list.set(i, 0);
            }
        }
    }

    // 9.  Метод для вывода элементов, из List<Integer> удовлетворяющих определенному условию:
    public static void printElementsMatchingCondition(List<Integer> list, Predicate<Integer> condition) { //импорт класса Predicate
        for (Integer element : list) {
            if (condition.test(element)) {
                System.out.print(element + " ");
            }
        }
    }

    // 10.Метод для нахождения суммы квадратов элементов List<Integer>.
    public static int getSumOfSquares(List<Integer> list) {//получить сумму квадратов
        int sum = 0;
        for (int element : list) {
            sum += element * element;
        }
        return sum;
    }

    // 11. Метод для вычисления произведения всех элементов списка
    public static int getProductOfElements(List<Integer> list) {
        int product = 1;
        for (int element : list) {
            product *= element;
        }
        return product;
    }

    // 12.отсортировать елементы в порядке убывания List <Integer >
    public static void sortDescending(List<Integer> list) {
        Collections.sort(list, Collections.reverseOrder());
    }

    // 13.Перебрать List<Integer> и найти второй по величине элемент.
    public static int findSecondLargest(List<Integer> list) {
        if (list.size() < 2) {
            throw new IllegalArgumentException("Список содержит менее двух элементов");
        }

        int firstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int element : list) {
            if (element > firstLargest) {
                secondLargest = firstLargest;
                firstLargest = element;
            } else if (element > secondLargest && element < firstLargest) {
                secondLargest = element;
            }
        }
        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Нет второго по величине элемента");
        }
        return secondLargest;
    }

    // 14.Перебрать List<Integer> и вывести все элементы в обратном порядке.
    public static void printInReverseOrder(List<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }

    // 15.Создать List с объектами вашего собственного класса и отфильтровать только уникальные элементы.
    // 15.1 ArrayList
    public static List<Integer> filterUniqueElementsArray(List<Integer> list) {
        Set<Integer> uniqueSet = new LinkedHashSet<>(list); // Создаем множество для хранения уникальных элементов
        return new ArrayList<>(uniqueSet); // Преобразуем множество обратно в список
    }

    // 15.2 LinkedList
    public static List<Integer> filterUniqueElementsLinked(List<Integer> list) {
        Set<Integer> uniqueSet = new LinkedHashSet<>(list); // Создаем множество для хранения уникальных элементов
        return new LinkedList<>(uniqueSet); // Преобразуем множество обратно в список
    }

    // 16.Перебрать ?List<Integer> и найти наибольшую возрастающую последовательность элементов.
    public static List<Integer> findLongestIncreasingSubsequence(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList<>(); // Возвращаем пустой список, если входной список пуст
        }
        List<Integer> currentSubsequence = new ArrayList<>();
        List<Integer> longestSubsequence = new ArrayList<>();

        for (int i = 0; i < list.size() - 1; i++) {
            currentSubsequence.add(list.get(i));

            if (list.get(i) >= list.get(i + 1)) {
                // Начинается новая возрастающая последовательность
                if (currentSubsequence.size() > longestSubsequence.size()) {
                    longestSubsequence = new ArrayList<>(currentSubsequence);
                }
                currentSubsequence.clear();
            }
        }
        currentSubsequence.add(list.get(list.size() - 1));// Проверяем последнюю последовательность
        if (currentSubsequence.size() > longestSubsequence.size()) {
            longestSubsequence = new ArrayList<>(currentSubsequence);
        }
        return longestSubsequence;
    }

    // 17.Перебрать ?List<Integer> и удалить все дубликаты элементов.
    public static void removeDuplicates(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return; // Ничего не делаем, если список пуст
        }

        Set<Integer> uniqueElements = new LinkedHashSet<>(list); // Создаем множество для хранения уникальных элементов
        list.clear(); // Очищаем исходный список

        list.addAll(uniqueElements); // Добавляем обратно уникальные элементы в исходный список
    }

    // 18.LinkedList Создать !!! с объектами вашего собственного класса и отсортировать их по нескольким критериям.
    // Метод для сортировки списка по нескольким критериям
    public static void sortListArgument(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return; //  проверка -Ничего не делаем, если список пуст
        }

        // Создаем компаратор для сортировки по нескольким критериям
        Comparator<Integer> comparator = Comparator.comparingInt((Integer num) -> num % 2) // По четности
                .thenComparingInt(num -> num % 5) // По кратности 5
                .thenComparingInt(num -> num) // По значению..четные???
                .thenComparingInt(num -> num > 15 ? 0 : 1); // По больше или равно 15

        list.sort(comparator); // Сортируем список с использованием компаратора
    }

    //19. Создать ArrayList<String>  и (или) LinkedList<String>
    public static List<String> listStringGeneration() { // список стрингов    //уни как и выше некоторые
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter quantity of words");//введ кол слов
        int size = scanner.nextInt();// записываем методом nextInt() число
        System.out.println("Enter min and max length of String without backspace");// длина строки без пробел -без without
        int temp = scanner.nextInt();
        int min = temp / 10;
        int max = temp % 10; // остаток деления
        System.out.println("for ArrayList press 1, for LinkedList press 2");
        int typeOfArray = scanner.nextInt();
        List<String> stringList;
        if (typeOfArray == 1) {
            System.out.println("создан ArrayList");
            stringList = new ArrayList<>();// тип данных Лист,Стринг ,назв перем = нов экз класса Аррей или Линкед
        } else {
            System.out.println("создан LinkedList");
            stringList = new LinkedList<>();
        }

        for (int i = 0; i < size; i++) {
            stringList.add(stringGeneration(min, max));
        }
        return stringList;
    }

    //Заполняем наши ArrayList<String>  и LinkedList<String> рандомными элементами через StringBuilder.
    static String stringGeneration(int min, int max) {
        if (max < min) {
            throw new IllegalArgumentException("Max length should be greater than or equal to min length.");//max > min
        }
        Random random = new Random();
        char[] symbols = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'o'};
        StringBuilder stringBuilder = new StringBuilder();//спец обьект для работы со строкой
        int stringSize = random.nextInt(min, max + 1); //длина строк опр случайно
        for (int i = 0; i < stringSize; i++) {         //цикл по слову для записи в обьект символа из списка чаров случайно
            stringBuilder.append(symbols[random.nextInt(symbols.length)]);  //append добавить симв из массива букв чаров,который
            //выбирает случайно от 0 до длины массивов чаров.выбирает чар один из 8
        }
        return stringBuilder.toString(); //возращ обьект stringBuilder преабраз в строку -метод тустринг
    }

    //20. Перебрать List<String> и найти самую длинную строку.
    public static String findLongestString(List<String> list) {
        if (list.isEmpty()) {
            return "The list is empty."; // пустой список
        }
        StringBuilder stringBuilder = new StringBuilder(list.get(0));//записываем стразу первый элемент
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).length() > stringBuilder.length()) {
                stringBuilder = new StringBuilder(list.get(i));
            }
        }
        return stringBuilder.toString();
    }

    //20.1
    public static String findLongestString1new(List<String> list) {
        if (list.isEmpty()) {
            return "The list is empty."; //ist leer
        }
        String longestString = list.get(0); // Инициализируем самую длинную строку первым элементом списка
        for (String str : list) {
            if (str.length() > longestString.length()) {
                longestString = str; // Если текущая строка длиннее, обновляем самую длинную строку
            }
        }
        return longestString;
    }

    //21.Перебрать List<String> и найти количество элементов, начинающихся с определенной буквы
    public static int countStringsStartingWith(List<String> list, char letter) {//о
        int count = 0;
        for (String str : list) {
            if (!str.isEmpty() && str.charAt(0) == letter) {
                count++;
            }
        }
        return count;
    }

    // 22.
    public static int findFirstOccurrence(List<String> list, String target) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) { // Сравниваем текущий элемент списка с целевой строкой
                return i; // Если нашли совпадение, возвращаем индекс первого вхождения
            }
        }
        return -1; // Если не нашли совпадений, возвращаем -1
    }

    //22.1 LinkedList andere metod
    public static int findFirstOccurrence1(LinkedList<String> list, String target) {
        int index = 0;
        for (String str : list) {
            if (str.equals(target)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    //23.List<String>  объединить все элементы в одну строку.
    public static String concatenateList(List<String> list) {
        StringBuilder result = new StringBuilder();
        for (String str : list) {
            result.append(str);
        }
        return result.toString();
    }

    //24.List<String> и удалить все элементы, содержащие определенную подстроку.
    public static void removeElementsContainingSubstring(List<String> list, String substring) {
        list.removeIf(str -> str.contains(substring));
    }

    //25. List<String> поиск самой короткой строки
    public static String findShortestString(List<String> list) {
        if (list.isEmpty()) {
            return "Список пуст.";
        }

        String shortestString = list.get(0); // Предположим, что первая строка самая короткая

        for (String str : list) {
            if (str.length() < shortestString.length()) {
                shortestString = str; // Если текущая строка короче, обновляем самую короткую строку
            }
        }

        return shortestString;
    }

    //26.List<String>  заменить все гласные буквы в каждой строке на символ '*'
    public static List<String> replaceVowelsWithAsterisk(List<String> list) {
        List<String> modifiedList = new ArrayList<>();
        for (String str : list) {
            String modifiedString = str.replaceAll("[AEIOUaeiou]", "*");
            modifiedList.add(modifiedString);
        }
        return modifiedList;
    }

    //27.List<String>  вывести все строки, содержащие только буквы.
    public static List<String> filterStringsContainingOnlyLetters(List<String> list) {
        List<String> result = new ArrayList<>();

        for (String str : list) {
            if (containsOnlyLetters(str)) {
                result.add(str);
            }
        }
        return result;
    }

    public static boolean containsOnlyLetters(String str) {
        return str.matches("[a-zA-Z]+");
    }

    //28.
    public static String findLongestStringWithoutSpaces(List<String> list) {
        String longestString = null;

        for (String str : list) {
            if (!str.contains(" ") && (longestString == null || str.length() > longestString.length())) {
                longestString = str;
            }
        }

        return longestString;
    }

    //29. List<String> создать новый список, содержащий только уникальные строки
    public static List<String> findUniqueStrings(List<String> list) {
        HashSet<String> uniqueSet = new HashSet<>(list);
        return new ArrayList<>(uniqueSet);
    }

    //30.List<String> объединить все строки в одну с использованием разделителя
    public static String joinStrings(List<String> list, String delimiter) {
        StringJoiner joiner = new StringJoiner(delimiter);

        for (String str : list) {
            joiner.add(str);
        }

        return joiner.toString();
    }
}
