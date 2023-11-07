package org.example.hw14_Luna;

import java.util.ArrayList;
import java.util.List;

public class LunaMethod {
    public boolean cardAccept(String numberCard){
        List<Integer>integerList = lunaMethod(returnFromStringToListNumberCard(numberCard));
        int sum = integerList.stream()
                .mapToInt(el -> el.intValue())
                .sum();
        return sum % 10 == 0;
    }
    private List<Integer> returnFromStringToListNumberCard(String numberCard) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 16; i++) {
            char c = numberCard.charAt(i);
            integerList.add(Character.getNumericValue(c));
        }
        System.out.println(integerList);
        return integerList;
    }
    private List<Integer> lunaMethod(List<Integer>list){
        for (int i = 0; i < list.size(); i +=2) {
            if((list.get(i) * 2)>9){
                list.set(i,(list.get(i) * 2)-9);
            } else {
                list.set(i,list.get(i) * 2);
            }
        }
        System.out.println(list + " Sum: " + (list.stream().mapToInt(el->el.intValue()).sum()));
        return list;
    }
    
}
