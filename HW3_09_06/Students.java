package org.example.HW3_09_06;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Students extends Person implements Graded  {
    private Grade grade;//где есть приватн модификатор доступа .нужны Геттеры для чтения и Сеттеры для записи
    public Students(String name, int age) {
        super(name, age);
    }

    @Override
    void getDescription() {
        System.out.println("Name Student "+ getName() + ", Age Student " + getAge());
    }

    @Override
    public void getGrade() {
        System.out.println(" Grade Student "+ grade);//перемен заданн сверху 4 строка учитель записывает оценку в Граде ,прийдет сюда
    }


}
