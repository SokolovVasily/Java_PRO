package org.example.HW3_09_06;

public class Main {
    public static void main(String[] args) { // создали по конструктору
        Teachers teacher1 = new Teachers("Ivan",59);///данные заменить
        Teachers teacher2 = new Teachers("Alexander",69);

        Students student1 = new Students("Anton",14);
        Students student2 = new Students("Kirill",15);
        Students student3 = new Students("Egor",14);

        Teachers[] teachers = {teacher1,teacher2};
        Students[] students = {student1,student2,student3};

        GradeManagementSystem gradeManagementSystem = new GradeManagementSystem(students,teachers);
        gradeManagementSystem.processStudents();
        System.out.println();
        gradeManagementSystem.processTeachers();
        gradeManagementSystem.gradeStudents(teacher1);//? присваемаем оценку
        System.out.println();
        gradeManagementSystem.processStudents(teacher1); //?возвращаем оценку
    }
}
