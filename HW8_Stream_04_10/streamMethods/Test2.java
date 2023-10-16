package org.example.HW8_Stream_04_10.streamMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test2 {
    public static void main(String[] args) {
        Student student1 = new Student("Vasy1",'m',33,3,8.3);
        Student student2 = new Student("Vasy2",'m',42,2,8.6);
        Student student3 = new Student("Vasy3",'f',21,2,7.3);
        Student student4 = new Student("Vasy4",'m',44,4,3.3);
        Student student5 = new Student("Vasy5",'f',53,1,6.3);
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);

       /*
        list = list.stream().filter(el -> el.getAge()>22 && el.getAvgGrade()< 7.3)
              //  .collect(Collectors.toList());//преобраз Stream in  List
                      .toList();

        */
        Stream<Student> studentStream = Stream.of(student1,student2,student3,student4,student5);
        List<Student> collect = studentStream.filter(el -> el.getAge() > 22 && el.getAvgGrade() < 7.3)
                .collect(Collectors.toList());


        System.out.println(collect);



    }
}
    class Student {
        private String name;
        private char sex;
        private int age;
        private int course;
        private double avgGrade;

        public Student(String name, char sex, int age, int course, double avgGrade) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.course = course;
            this.avgGrade = avgGrade;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", sex=" + sex +
                    ", age=" + age +
                    ", course=" + course +
                    ", avgGrade=" + avgGrade +
                    '}';
        }

        public String getName() {return name;
        }
        public void setName(String name) {this.name = name;
        }
        public char getSex() {return sex;
        }
        public void setSex(char sex) {this.sex = sex;
        }
        public int getAge() {return age;
        }
        public void setAge(int age) {this.age = age;
        }
        public int getCourse() {return course;
        }
        public void setCourse(int course) {this.course = course;
        }
        public double getAvgGrade() {return avgGrade;
        }
        public void setAvgGrade(double avgGrade) {this.avgGrade = avgGrade;
        }
    }

