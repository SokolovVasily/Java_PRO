package org.example.hw13_Serialisation;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student("Vasyl", 32, 7.5),
                new Student("Alexey", 22, 8.5),
                new Student("Ivan", 36, 5.5),
                new Student("Arsen", 39, 6.5)
        );
        String fileName = "StudentList.ser";
        saveStudentsToFile(studentList, fileName);
        System.out.println(loadStudentsFromFile(fileName));
        double gradeStudent = 5;
        String fileName1 = "C:\\Users\\sokol\\OneDrive\\Рабочий стол\\NeuStudentList.txt";
        filterAndSaveStudentsByGrade(studentList, gradeStudent, fileName1);
        System.out.println("среднее значение оценок всех студ:" + calculateAverageGrade(fileName));


    }

    //1.Задание реализовать два метода:
    private static void saveStudentsToFile(List<Student> students, String filename) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(students);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Student> loadStudentsFromFile(String filename) {
        List<Student> studentList;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            studentList = (List<Student>) objectInputStream.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        return studentList;
    }

    //2.Задание: Фильтрация студентов по оценке
    private static void filterAndSaveStudentsByGrade(List<Student> students, double gradeThreshold, String filename) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            for (Student student : students) {
                if (gradeThreshold < student.getGrade()) {
                    objectOutputStream.writeObject(student);
                }
            }
            System.out.println("Реализовано");
        } catch (IOException e) { // IO что за ошибка
            throw new RuntimeException(e); // какая ошибка
        }
    }

    //3.Задание  Средний балл студентов
    //Описание: Напишите метод, который вычисляет средний балл всех студентов из файла.
    //
    //Требования:
    //Реализуйте метод который возвращает средний балл студентов.
    private static OptionalDouble calculateAverageGrade(String filename) {
    List<Student> students = new ArrayList<>();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename));
            students = (List<Student>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return students.stream()
                .mapToDouble(el ->el.getGrade())
                .average();
    }
}
