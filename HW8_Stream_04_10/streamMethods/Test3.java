package org.example.HW8_Stream_04_10.streamMethods;

import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        int[]array = {2,3,4,5,6,7,8,23,45,67,90};
       // Arrays.stream(array).forEach(el-> {el*=2;
         //   System.out.println(el);});
       // Arrays.stream(array).forEach(el-> System.out.println(el));
        //Arrays.stream(array).forEach(Utils::myMethod);
       Arrays.stream(array).forEach(el->Utils.myMethod(el));
    }
}

class Utils {
    public static void myMethod(int a){
        a += 5;
        System.out.println("Element = : " + a);
    }
}