package org.example.HW8_Stream_04_10.streamMethods;

import java.util.*;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Hallo");
        list.add("Kak dela");
        list.add("ok");
        list.add("Gud bay");
        System.out.println(list);

        //   for (int i=0; i<stringList.size();i++) {
        //     stringList.set(i, String.valueOf(stringList.get(i).length()));
        // }

        List<Integer> list1 = list.stream()
                .map(el -> el.length())
                .toList();  //collect /


        System.out.println(list1);

        int[] array = {3, 4, 5, 6, 78, 9};
        array = Arrays.stream(array).map(el
                -> {
            if (el % 3 == 0) {
                el = el / 3;
            }
            return el;
        }).toArray();
        //  System.out.println(Arrays.toString(array));
        Set<String> set = new TreeSet<>();
        set.add("Hallo");
        set.add("Kak dela ?");
        set.add("ok");
        set.add("Gud bay");
        System.out.println(set);

        Set<Integer> set1 = set.stream()
                .map(String::length)
                .collect(Collectors.toSet());
        System.out.println(set1);

        List<Integer> list2 = (List<Integer>) set.stream()
                .map(String::length)
                .toList();
        System.out.println(list2);
    }
}
