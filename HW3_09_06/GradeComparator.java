package org.example.HW3_09_06;

import java.util.Comparator;

public class GradeComparator implements Comparator<Students> {

    @Override
    public int compare(Students o1, Students o2) {
        return o1.getAge() - (o2.getAge());

    } //Srawniwaem


}
