package org.example.HW3_09_06;
/*
Класс GradeManagementSystem:

Создать класс GradeManagementSystem, который будет управлять системой оценок в университете.
Класс GradeManagementSystem должен содержать следующие поля:
Массив объектов students (Student[]) - массив студентов.
Массив объектов teachers (Teacher[]) - массив преподавателей.
Класс GradeManagementSystem должен иметь методы:
processStudents() - метод для вывода информации о студентах (перебор массива студентов).
processTeachers() - метод для вывода информации о преподавателях (перебор массива преподавателей).
gradeStudents() - метод для автоматической выставления оценок студентам преподавателями (используя метод gradeStudent() из класса Teacher).
Требования к реализации:

 */

public class GradeManagementSystem {
    private Students[] students;
    private Teachers[] teachers;

    public GradeManagementSystem(Students[] students, Teachers[] teachers) {
        this.students = students;
        this.teachers = teachers;
    }

    public void processStudents() {                //метод вывода инфы о каждом студенте
        for (Students students : students) {
            students.getDescription();
        }

    }

    public void processTeachers() {                     //метод для вывода инфы о преподах
        for (Teachers teachers : teachers) {
            teachers.getDescription();
        }
    }

    public void  gradeStudents(Teachers teachers) { //метод :прох циклом по массиву студ и выставляем рандомную оценку студентам
        for (Students students : students) {
            teachers.gradeStudent(students);
        }

    }

    public void processStudents(Teachers teachers) {                //метод
        for (Students students : students) {
            students.getDescription(); //инфа о студенте
            teachers.getDescription(); //инфа о учитель
            students.getGrade();   //инфа о оценке
        }

    }

}
