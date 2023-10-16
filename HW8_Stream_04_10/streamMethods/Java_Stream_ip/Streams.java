package org.example.HW8_Stream_04_10.streamMethods.Java_Stream_ip;

import org.junit.jupiter.api.Test;

import java.util.List;

public class Streams {


    private List<Employee>employees = List.of(
            new Employee("Максим1","Васин1",2221,21,Position.MANAGER),
            new Employee("Максим2","Васин2",2222,22,Position.CHEF),
            new Employee("Максим3","Васин3",2223,25,Position.WORKER),
            new Employee("Максим4","Васин4",2224,24,Position.WORKER),
            new Employee("Максим5","Васин5",2225,26,Position.WORKER),
            new Employee("Максим6","Васин6",2226,27,Position.WORKER),
            new Employee("Максим7","Васин7",2227,29,Position.WORKER),
            new Employee("Максим8","Васин8",2228,23,Position.MANAGER),
            new Employee("Максим9","Васин9",2229,25,Position.CHEF),
            new Employee("Максим10","Васин10",2210,35,Position.MANAGER)

    );
    private List<Department>departments = List.of(
        new Department(241,0, "Nord"),
        new Department(242,1, "Sud"),
        new Department(243,2, "West"),
        new Department(244,3, "Ost"),
        new Department(245,0, "Nord"),
        new Department(246, 4,"Mitte")
    );

    @Test
    public void creation(){


    }

}
