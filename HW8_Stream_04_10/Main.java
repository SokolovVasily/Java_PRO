package org.example.HW8_Stream_04_10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        List<Integer> listInteger = Arrays.asList(1, 2, 3, 4, 6, 7, 8, 9, 9, 30, 67, 46, 777);
        List<String> stringList = Arrays.asList("sdf", "kor", "kfdU", "kjodkj", "IGL", "azufo", "Akh");
        List<User>userList = Arrays.asList(
                new User("Vasy",44),
                new User("Alex",25),
                new User("Leon", 35)
        );
        // Задача 1: Фильтрация четных чисел и умножение на 2.
        List<Integer> list = listInteger.stream()
                .filter(el -> el % 2 == 0)   //фильтр
                .map(el -> el * 2)           //преобразуем
                .toList();                   //рез в тулист
        System.out.println("Фильтрация четных чисел и умножение на 2: " + list);
        // Задача 2: Удаление дубликатов из списка строк.
        List<Integer> list1 = listInteger.stream()
                .distinct()   // работает по умолч .удаляет дубликаты
                .toList();
        System.out.println("Удаление дубликатов из списка строк: " + list1);

        // Задача 3: Сортировка списка чисел в порядке убывания и выбор первых трех элементов

        List<Integer> list2 = listInteger.stream()
                .sorted((el1, el2) -> el2 - el1)
                .limit(3)
                .toList();
        System.out.println("Сортировка списка чисел в порядке убывания и выбор первых трех элементов: " + list2);

        // Задача 4 Фильтрация строк, начинающихся на "A" и преобразование в верхний регистр
        List<String> a = stringList.stream()
                .filter(el -> el.startsWith("A"))
                .map(el -> el.toUpperCase())
                .toList();

        System.out.println("Фильтрация строк, начинающихся на \"A\" и преобразование \" в \" верхний регистр: " + a);

        //5.Задача Пропуск первых двух элементов и вывод оставшихся.
        List<Integer> list3 = listInteger.stream()
                .skip(2)
                .toList();
        System.out.println("Задача Пропуск первых двух элементов и вывод оставшихся: " + list3);

        //6.Фильтрация чисел больше 50 и вывод их квадратов.

        List<Integer> list4 = listInteger.stream()
                .filter(el -> el > 50)
                .map(el -> el * el)
                .toList();

        System.out.println("Фильтрация чисел больше 50 и вывод их квадратов: " + list4);

        //7. Оставить только слова, содержащие букву "o" и вывести их в обратном порядке.
        List<String> o = stringList.stream()
                .filter(el -> el.contains("o"))
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println("Оставить только слова, содержащие букву \"o\" и вывести их в обратном порядке: " + o);

        //8. Фильтрация чисел, оставить только нечетные и вывести их в порядке возрастания.

        List<Integer> list5 = listInteger.stream()
                .filter(el -> el % 2 != 0)
                .sorted()
                .toList();

        System.out.println("Фильтрация чисел, оставить только нечетные и вывести их в порядке возрастания: " + list5);

        //9.Получить среднее значение чисел в списке
        OptionalDouble average = listInteger.stream()
                .mapToDouble(Integer::doubleValue)
                .average();

        System.out.println("Получить среднее значение чисел в списке: " + average);

        //10.Получить строку, объединяющую элементы списка через запятую.
        String a1 = String.join(" , ", stringList);
        System.out.println("Получить строку, объединяющую элементы списка через запятую: " + a1);

        //11.Получить список квадратов чисел из другого списка

        List<Integer> list6 = listInteger.stream()
                .map(el -> el * el)
                .toList();
        System.out.println("Получить список квадратов чисел из другого списка-> list6 : " + list6);

        //12.Получить список букв из списка слов и вывести их в алфавитном порядке
        List<Character> list7 = stringList.stream()
                .flatMap(el -> el.chars().mapToObj(ch -> (char) ch))
                .sorted()
                .toList();
        System.out.println("Получить список букв из списка слов и вывести их в алфавитном порядке: " + list7);

        //13.Получить первые 3 строки из списка и вывести их в обратном порядке

        List<String> list8 = stringList.stream()
                .limit(3)
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("Получить первые 3 строки из списка и вывести их в обратном порядке: " + list8);
        //14.Пропустить первые 2 элемента и оставить только уникальные.
        List<Integer> list9 = listInteger.stream()
                .skip(2)
                .distinct()
                .toList();
        System.out.println("Пропустить первые 2 элемента и оставить только уникальные: " + list9);

        //15.Фильтрация и сортировка пользователей по возрасту
        List<User> list10 = userList.stream()
                .filter(el -> el.getAge() > 20)
                .sorted(Comparator.comparingInt(User::getAge))
                .toList();
        System.out.println("Фильтрация и сортировка пользователей по возрасту: " + list10);


    }

}


