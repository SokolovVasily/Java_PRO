package org.example.HW8_Stream_04_10.streamMethods;

import java.util.ArrayList;
import java.util.List;

public class Test4_reduce { // Метод reduce позволяет выполнить операцию над всеми элементами потока и получить один результат.
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(9);
        list.add(7);
        list.add(6);


       // int result = list.stream()
         //       .reduce((accumulator,el)->
           //             accumulator * el).get();
        //System.out.println(result);


        int result1 = list.stream()
                .reduce(1,(accumulator,el)->
                        accumulator * el);
        System.out.println("Произведение членов : " + result1);

        List<String>list1 = new ArrayList<>();
        list1.add("Hallo");
        list1.add("Kak dela");
        list1.add("ok");
        list1.add("Gud bay");

        String result = list1.stream()
                .reduce((a,el)-> a + " " +el).get();
        System.out.println(result);


        //List<Integer>list1 = new ArrayList<>();
        /*
        Optional<Integer>o = list.stream()
                .reduce((accumulator,el)->
                        accumulator * el);
        if (o.isPresent()) {
            System.out.println(o.get());
        }
        else {
            System.out.println("not present");
        }

         */
    }
}
