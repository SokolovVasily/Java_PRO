package org.example.HW3_09_06;

public class Teachers extends Person {
    private Grade teacherGrade;

    public Teachers(String name, int age) {   //Констуктор это метод ,пишется с большой буквы и как Класс !!!
        super(name, age);
    }

    @Override
    void getDescription() {
        System.out.println("Name Teachers " + getName() + ", Age Teachers  " + getAge());
    }

    public void gradeStudent(Students students) { // привязываем метод к студенту персоон
        Grade[] grades = {Grade.A, Grade.B, Grade.C, Grade.D, Grade.F};//massiv s tipom dannuch Grade
        int n = (int) (Math.random()*grades.length);
        students.setGrade(grades[n]);
        // при вызове метода указыв перс студента-рандом способом присваиваем Сеттером оценку (значение от 0 до 1 *длинну массива)
    }

}
//Компаратор это интерфейс для сортивки по зад знач