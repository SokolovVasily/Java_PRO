package org.example.HW5ListArray13_09;//Найти сумму всех элементов ArrayList<Integer> //List список

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Methods methods = new Methods();// ??? не работает???
        int size = 30;
        int max = 200;
        ArrayList<Integer> arrayList = methods.createArrayList(size, max);//1.Задание :создать  List<Integer>.
        System.out.println("1.  ArrayList " + arrayList);
        LinkedList<Integer> linkedList = methods.createLinkedList(size, max);
        System.out.println("1.1 LinkedList" + linkedList);

        System.out.println("2.  ArrayList : сумма всех элементов: " + methods.getSumList(arrayList));//Найти сумму всех элементов ArrayList<Integer>.
        System.out.println("2.1 LinkedList: сумма всех элементов: " + methods.getSumList(linkedList));
        System.out.println("3.  ArrayList : среднеарифметическое значение: " + methods.getAverageValue(arrayList));    //Найти среднее арифм.AVERAGE элементов
        System.out.println("3.1 LinkedList: среднеарифметическое значение: " + methods.getAverageValue(linkedList));
        System.out.println("4.  ArrayList : наименьший элемент  " + methods.getSmallestElement(arrayList));   //Найти наименьший элемент ArrayList<Integer>.
        System.out.println("4.1 LinkedList: наименьший елемент: " + methods.getSmallestElement(linkedList));
        System.out.println("5.  ArrayList : наибольший елемент: " + methods.getLargestElement(arrayList));    // Наибольший елемент ArrayList
        System.out.println("5.1 LinkedList: наибольший елемент: " + methods.getLargestElement(linkedList));

        //6.Создать LinkedList с объектами вашего собственного класса и удалить все элементы, удовл опред условию.!!!!!
        int threshold = 100; // Пороговое значение удалить елементы по зад условию - порогу
        methods.removeElementsAboveThreshold(arrayList, threshold); // Удаляем элементы выше threshold ArrayList<Integer>
        System.out.println("6.  ArrayList : удалены елементы по заданному условию: (> 100) " + arrayList);             // выводим измененный список "выше порога удалено"
        methods.removeElementsAboveThreshold(linkedList, threshold);//Удалить элементы выше  threshold LinkedList<Integer>
        System.out.println("6.1 LinkedList: удалены елементы по заданному условию: (> 100) " + linkedList);                // выводим измененный список "выше порога удалено"

        //7.Перебрать List<Integer> и удалить все четные числа.
        methods.removeEvenNumbers(arrayList); // Удаляем все четные числа ArrayList<Integer>
        System.out.println("7.  ArrayList : четные числа  удалены " + arrayList);
        methods.removeEvenNumbers(linkedList); // Удаляем все четные числа LinkedList<Integer>
        System.out.println("7.1 LinkedList: четные числа  удалены " + linkedList);

        //8.Перебрать LinkedList<Integer> и заменить все элементы, кратные 3, на нули
        methods.replaceMultiplesOfThreeWithZeros(arrayList); // Заменяем кратные 3 на нули
        System.out.println("8.  ArrayList : кратные 3 = 0 " + arrayList);
        methods.replaceMultiplesOfThreeWithZeros(linkedList); // Заменяем кратные 3 на нули
        System.out.println("8.1 LinkedList: кратные 3 = 0 " + linkedList);

        //9.Создать ArrayList с объектами вашего собст класса и вывести только те, которые удовл опред условию !!!!!
        Predicate<Integer> customCondition = element -> element > 10; // условие вывода
        System.out.println("9.  List<Integer>: вывод элементов, которые выпоняют заданное условие > 10:");
        methods.printElementsMatchingCondition(arrayList, customCondition);
        System.out.println(": 9.1 ArrayList");
        methods.printElementsMatchingCondition(linkedList, customCondition);
        System.out.println(": 9.2 Linkedlist");

        //10.Перебрать ArrayList<Integer> и найти сумму квадратов всех элементов
        int sumOfSquares = methods.getSumOfSquares(arrayList); // Получаем сумму квадратов элементов
        System.out.println("10.  ArrayList : сумма квадратов элементов : " + sumOfSquares);
        int sumOfSquares1 = methods.getSumOfSquares(linkedList);
        System.out.println("10.1 LinkedList: сумма квадратов элементов : " + sumOfSquares);

        //11.Перебрать List<Integer> и вычислить произведение всех элементов
        int productOfElements = methods.getProductOfElements(arrayList); // Получаем произведение элементов
        System.out.println("11.  ArrayList : произведение всех элементов : " + productOfElements);
        int productOfElements1 = methods.getProductOfElements(linkedList);
        System.out.println("11.1 LinkedList: произведение всех элементов : " + productOfElements);

        System.out.println("____________________________________________________________________________________");


        ArrayList<Integer> arrayList1 = methods.createArrayList(size, max); // Создаем  Array
        System.out.println("ArrayList1  новый список " + arrayList1);
        LinkedList<Integer> linkedList1 = methods.createLinkedList(size, max); // Создаем  Linked
        System.out.println("LinkedList1 новый список " + linkedList1);

        System.out.println("____________________________________________________________________________________");

        //12.Создать List с объектами вашего собственного класса и отсортировать их в порядке убывания. !!!!!!!!!!
        methods.sortDescending(arrayList1); // Сортировка элементов в порядке убывания
        System.out.println("12.  ArrayList :  отсортированный в порядке убывания: " + arrayList1);
        methods.sortDescending(linkedList1);
        System.out.println("12.1 LinkedList:  отсортированный в порядке убывания: " + linkedList1); // Вывод отсортированного списка

        //13.Перебрать List<Integer> и найти второй по величине элемент
        int secondLargest = methods.findSecondLargest(arrayList1); // Находим второй по величине элемент Array
        System.out.println("13.  ArrayList :  второй по величине элемент: " + secondLargest);
        int secondLargest1 = methods.findSecondLargest(linkedList1);
        System.out.println("13.1 LinkedList:  второй по величине элемент: " + secondLargest1);

        //14.Перебрать List<Integer> и вывести все элементы в обратном порядке
        System.out.println("14.  ArrayList :  элементы в обратном порядке: ");
        methods.printInReverseOrder(arrayList1); // Вывод элементов в обратном порядке
        System.out.println();
        System.out.println("14.1 LinkedList:  элементы в обратном порядке:");
        methods.printInReverseOrder(linkedList1);
        System.out.println();

        System.out.println("_________________________________________________________________________");

        //15.Создать ArrayList с объектами вашего собственного класса и отфильтровать только уникальные элементы !!!!!
        List<Integer> uniqueElements = methods.filterUniqueElementsArray(arrayList1); // Получаем список с уникальными элементами
        System.out.println("15.  ArrayList  :  только уникальные элементы:" + uniqueElements);
        List<Integer> uniqueElements1 = methods.filterUniqueElementsLinked(linkedList1);
        System.out.println("15.1 LinkedList :  только уникальные элементы:" + uniqueElements1);

        //16.Перебрать ArrayList<Integer> и найти наибольшую возрастающую последовательность элементов
        List<Integer> longestIncreasingSubsequence = methods.findLongestIncreasingSubsequence(arrayList1); // нахождения наибольшей возрастающей послед.
        System.out.println("16.  ArrayList  :  наибольшая возрастающая последовательность :" + longestIncreasingSubsequence);// Вывод последовательности
        List<Integer> longestIncreasingSubsequence1 = methods.findLongestIncreasingSubsequence(linkedList1); //
        System.out.println("16.1 LinkedList :  наибольшая возрастающая последовательность :" + longestIncreasingSubsequence1);//

        System.out.println();

        //17.Перебрать List<Integer> и удалить все дубликаты элементов
        methods.removeDuplicates(arrayList1); // Удаляем дубликаты елементов
        System.out.println("17.  ArrayList  :  список без дубликатов: " + arrayList1);// Вывод списка елементов без дубликатов
        methods.removeDuplicates(linkedList1); // Удаляем дубликаты елементов
        System.out.println("17.1 LinkedList :  список без дубликатов: " + linkedList1);// Вывод списка елементов без дубликатов

        System.out.println("____________________________________________________________________________");

        ArrayList<Integer> arrayList2 = methods.createArrayList(size, max); // Создаем список Array
        System.out.println("new  ArrayList2 : " + arrayList2);
        LinkedList<Integer> linkedList2 = methods.createLinkedList(size, max); // Создаем  список Linked
        System.out.println("new  LinkedList2: " + linkedList2);
        System.out.println("____________________________________________________________________________");

        //18.Создать List с объектами вашего собственного класса и отсорт их по неск критериям !!!!!!!!!!!!!!!!
        methods.sortListArgument(arrayList2); // Сортировка по нескольким критериям
        System.out.println("18.  ArrayList  :  сортированный по 3 критериям список : " + arrayList2);// Вывод отсортированного списка
        methods.sortListArgument(linkedList2); // Сортировка по нескольким критериям
        System.out.println("18.1 LinkedList :  сортированный по 3 критериям список : " + linkedList2);// Вывод отсортированного списка


        System.out.println("_____________________________________________________________________________");
        //ArrayList<String> stringArrayList = (ArrayList<String>) listStringGeneration();
        //19.List<String> и вывести все элементы на экран
        List<String> stringArrayList = methods.listStringGeneration();
        System.out.println("19.   stringArrayList: выводим список String: " + stringArrayList);

        //20.List<String>  найти самую длинную строку
        System.out.println("20.   stringArrayList: поиск самой длинной строки " + methods.findLongestString(stringArrayList));

        //20.1 List<String> поиск самой длинной строки new
        System.out.println("20.1  stringArrayList: поиск самой длинной строки new " + methods.findLongestString1new(stringArrayList));

        //21.List<String>  найти количество элементов, начинающихся с определенной буквы
        char letterToSearch = 'c';
        int countArrayList = methods.countStringsStartingWith(stringArrayList, letterToSearch);
        System.out.println("21.   stringArrayList: найти количество элементов, начинающихся с  буквы.. " + letterToSearch + " in ArrayList: " + countArrayList);

        //22.List<String> найти первое вхождение определенной строки
        String target = "ac"; // Задаем строку для поиска
        int firstOccurrenceArrayList = methods.findFirstOccurrence(stringArrayList, target);// Вызываем метод поиска в LinkedList
        if (firstOccurrenceArrayList != -1) {
            System.out.println("22.   stringArrayList: найти первое вхождение строки  " + target + " List at index: " + firstOccurrenceArrayList);
        } else {
            System.out.println("22.   stringArrayList: найти первое вхождение строки  " + target + " is not in List.");
        }

        // 23.Соединить все элементы строки в одно слово
        String concatenatedArrayList = methods.concatenateList(stringArrayList);
        System.out.println("23.   stringArrayList: cоединенная строка : " + concatenatedArrayList);


        String substringToRemove = "e"; // Подстрока для удаления

        // 24.Удаляем элементы, содержащие указанную подстроку
        methods.removeElementsContainingSubstring(stringArrayList, substringToRemove);
        System.out.println("24.   stringArrayList: удаление элементов с подстрокой " + substringToRemove + " : " + stringArrayList);

        // 25. Поиск самой короткой строки
        String shortestArrayListString = methods.findShortestString(stringArrayList);
        System.out.println("25.   stringArrayList: самая короткая строка : " + shortestArrayListString);

        // 26. Заменяем гласные буквы на символ '*'
        List<String> modifiedArrayList = methods.replaceVowelsWithAsterisk(stringArrayList);
        System.out.println("26.   stringArrayList: после замены гласных букв на '*': " + modifiedArrayList);

        //27.List<String>  вывести все строки, содержащие только буквы
        List<String> filteredArrayList = methods.filterStringsContainingOnlyLetters(stringArrayList);
        System.out.println("27.   stringArrayList: только строки с буквами: " + filteredArrayList);

        //28.List<String>  найти самую длинную строку, не содержащую пробелов.
        String longestStringArrayList = methods.findLongestStringWithoutSpaces(stringArrayList);
        System.out.println("28.   stringArrayList: cамая длинная строка без пробелов в ArrayList: " + longestStringArrayList);

        //29.List<String> создать новый список, содержащий только уникальные строки
        List<String> uniqueStringsArrayList = methods.findUniqueStrings(stringArrayList);
        System.out.println("29.   stringArrayList: nur yникальные строки : " + uniqueStringsArrayList);

        //30.List<String> объединить все строки в одну с использованием разделителя
        String joinedArrayList = methods.joinStrings(stringArrayList, ",");
        System.out.println("30.   stringArrayList: все строки в одну с использованием разделителя: " + joinedArrayList);







        //LinkedList<String> stringLinkedList = (LinkedList<String>) listStringGeneration();//адапт метода к Линкед листу
        //19.List<String> и вывести все элементы на экран
        List<String> stringLinkedList = methods.listStringGeneration();
        System.out.println("19.  stringLinkedList: " + stringLinkedList);

        //20.List<String> и найти самую длинную строку
        System.out.println("20.  stringLinkedList: поиск самой длинной строки " + methods.findLongestString(stringLinkedList));

        //20.1 List<String> поиск самой длинной строки new
        System.out.println("20.1 stringLinkedList: поиск самой длинной строки new " + methods.findLongestString1new(stringLinkedList));

        // 21.List<String> и найти количество элементов, начинающихся с определенной буквы
        int countLinkedList = methods.countStringsStartingWith(stringLinkedList, letterToSearch);
        System.out.println("21.  stringLinkedList: найти количество элементов, начинающихся с буквы.." + letterToSearch + " in LinkedList: " + countLinkedList);

        // 22.List<String>  найти первое вхождение определенной строки
        int firstOccurrenceLinkedList = methods.findFirstOccurrence(stringLinkedList, target);// Вызываем метод поиска в LinkedList

        // Выводим результат поиска
        if (firstOccurrenceLinkedList != -1) {
            System.out.println("22.  stringLinkedList: найти первое вхождение строки " + target + " List at index: " + firstOccurrenceLinkedList);
        } else {
            System.out.println("22.  stringLinkedList: найти первое вхождение строки " + target + " not in List ");
        }

        // 23. Соединить все элементы строки в одно слово
        String concatenatedLinkedList = methods.concatenateList(stringLinkedList);
        System.out.println("23.  stringLinkedList: соединенная строка : " + concatenatedLinkedList);

        // 24. Удаляем элементы, содержащие указанную подстроку
        methods.removeElementsContainingSubstring(stringLinkedList, substringToRemove);
        System.out.println("24.  stringLinkedList: удаление элементов с подстрокой '" + substringToRemove + "': " + stringLinkedList);

        // 25. Поиск самой короткой строки
        String shortestLinkedListString = methods.findShortestString(stringLinkedList);
        System.out.println("25.  stringLinkedList: самая короткая строка: " + shortestLinkedListString);

        // 26. Заменяем гласные буквы на символ '*'
        List<String> modifiedLinkedList = methods.replaceVowelsWithAsterisk(stringLinkedList);
        System.out.println("26.  stringLinkedList: после замены гласных букв на '*': " + modifiedLinkedList);

        // 27.List<String>  вывести все строки, содержащие только буквы
        List<String> filteredLinkedList = methods.filterStringsContainingOnlyLetters(stringLinkedList);
        System.out.println("27.  stringLinkedList: только строки с буквами: " + filteredLinkedList);


        // 28.List<String>  найти самую длинную строку, не содержащую пробелов.
        String longestStringLinkedList = methods.findLongestStringWithoutSpaces(stringLinkedList);
        System.out.println("28.  stringLinkedList: cамая длинная строка без пробелов : " + longestStringLinkedList);

        // 29.List<String>  создать новый список, содержащий только уникальные строки
        List<String> uniqueStringsLinkedList = methods.findUniqueStrings(stringLinkedList);
        System.out.println("29.  stringLinkedList: nur yникальные строки : " + uniqueStringsLinkedList);

        //30.List<String>  объединить все строки в одну с использованием разделителя
        String joinedLinkedList = methods.joinStrings(stringLinkedList, ";");
        System.out.println("30.  stringLinkedList: " + joinedLinkedList);

    }
}


/*
Уровень сложности 5 из 10:
Найти сумму всех элементов ArrayList<Integer>.(2)
Найти среднее значение элементов LinkedList<Integer>.(3)
Перебрать ArrayList<String> и вывести все элементы на экран.[19]
Перебрать LinkedList<String> и найти самую длинную строку.[20]
Создать ArrayList с объектами вашего собственного класса и вывести их на экран.(1)

Уровень сложности 6 из 10:
Перебрать ArrayList<Integer> и найти наименьший элемент.(4)
Перебрать LinkedList<Integer> и найти наибольший элемент.(5)
Перебрать ArrayList<String> и найти количество элементов, начинающихся с определенной буквы.[21]
Перебрать LinkedList<String> и найти первое вхождение определенной строки.[22]
Создать LinkedList с объектами вашего собственного класса и удалить все элементы, удовл опред условию.(6)

Уровень сложности 7 из 10:
Перебрать ArrayList<Integer> и удалить все четные числа.(7)
Перебрать LinkedList<Integer> и заменить все элементы, кратные 3, на нули.(8)
Перебрать ArrayList<String> и объединить все элементы в одну строку.[23]
Перебрать LinkedList<String> и удалить все элементы, содержащие определенную подстроку.[24]
Создать ArrayList с объектами вашего собст класса и вывести только те, которые удовл опред условию.(9)

Уровень сложности 8 из 10:
Перебрать ArrayList<Integer> и найти сумму квадратов всех элементов.(10)
Перебрать LinkedList<Integer> и вычислить произведение всех элементов.(11)
Перебрать ArrayList<String> и найти самую короткую строку.[25]
Перебрать LinkedList<String> и заменить все гласные буквы в каждой строке на символ '*'.[26]
Создать LinkedList с объектами вашего собственного класса и отсортировать их в порядке убывания.(12)

Уровень сложности 9 из 10:
Перебрать ArrayList<Integer> и найти второй по величине элемент.(13)
Перебрать LinkedList<Integer> и вывести все элементы в обратном порядке.(14)
Перебрать ArrayList<String> и вывести все строки, содержащие только буквы.[27]
Перебрать LinkedList<String> и найти самую длинную строку, не содержащую пробелов.[28]
Создать ArrayList с объектами вашего собственного класса и отфильтровать только уникальные элементы.(15)

Уровень сложности 10 из 10:
Перебрать ArrayList<Integer> и найти наибольшую возрастающую последовательность элементов.(16)
Перебрать LinkedList<Integer> и удалить все дубликаты элементов.(17)
Перебрать ArrayList<String> и создать новый список, содержащий только уникальные строки.[29]
Перебрать LinkedList<String> и объединить все строки в одну с использованием разделителя.[30]
Создать LinkedList с объектами вашего собственного класса и отсортировать их по нескольким критериям.(18)



новая тема

1.
Переберите все ключи и значения в HashMap и TreeMap и выведите их на экран.
Переберите только ключи в HashMap и TreeMap и найдите сумму их длин.
Переберите только значения в HashMap и TreeMap и найдите их среднее значение.
Переберите HashMap и найдите ключ с максимальным значением.
Переберите TreeMap и найдите ключ с минимальным значением.
Переберите HashMap и удалите все элементы с четными значениями.
Переберите TreeMap и удалите все элементы с ключами, начинающимися с буквы 'A'.
Переберите TreeMap и найдите наибольший ключ, который меньше или равен заданному ключу.
**Переберите HashMap и найдите ключ с максимальной суммой значений в его вложенных HashMap: HashMap<String, HashMap<String, Integer>> nestedHashMap = new HashMap<>();

 2.

  Класс состоящий мз 4 полей разного типа
- Создать 10 объектов класса
- Поместить все с Хэш СЕт и вывести на экран
- Создайте TreeSet и найдите наименьший и наибольший элементы (int) в нем, перебирая элементы внутри набора.
- Напишите метод, который принимает Set и находит все объекты, содержащие определенную подстроку(из поля стринг), перебирая элементы и используя метод contains.
- Напишите метод, которая удаляет все четные инт из HashSet и выводит оставшиеся элементы. Используйте итератор.
- Создайте метод, который принимает два HashSet<Наш Класс> и возвращает новый HashSet, содержащий элементы, которые присутствуют в обоих множествах

 */