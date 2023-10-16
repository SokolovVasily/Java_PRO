package org.example.HW7HashSet;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // 1.Создать 10 объектов класса:
        Animal animal1 = new Animal("Lion",10,false);
        Animal animal2 = new Animal("Shark",20,false);
        Animal animal3 = new Animal("Snake",150,true);
        Animal animal4 = new Animal("Boar",5,false);
        Animal animal5 = new Animal("Horse",15,false);
        Animal animal6 = new Animal("Crocodile",10,false);
        Animal animal7 = new Animal("Mosquito",1,true);
        Animal animal8 = new Animal("Rabbit",3,false);
        Animal animal9 = new Animal("Scorpion",2,true);
        Animal animal10 = new Animal("Monkey",4,false);


        // 2.Поместить все в Хэш СЕт и вывести на экран
        Set<Animal> animalSet = new HashSet<>();
        animalSet.add(animal1);
        animalSet.add(animal2);
        animalSet.add(animal3);
        animalSet.add(animal4);
        animalSet.add(animal5);
        animalSet.add(animal6);
        animalSet.add(animal7);
        animalSet.add(animal8);
        animalSet.add(animal9);
        animalSet.add(animal10);


        Methods methods = new Methods();
        methods.iterateSet(animalSet); //print in console каждого животное

       //3. Создайте TreeSet и найдите наименьший и наибольший элементы (int) в нем, перебирая элементы внутри набора.
        TreeSet<Animal>animalTreeSet = new TreeSet<>();//Set<Animal> animal = new TreeSet<>;

        animalTreeSet.add(animal1);
        animalTreeSet.add(animal2);
        animalTreeSet.add(animal3);
        animalTreeSet.add(animal4);
        animalTreeSet.add(animal5);
        animalTreeSet.add(animal6);
        animalTreeSet.add(animal7);
        animalTreeSet.add(animal8);
        animalTreeSet.add(animal9);
        animalTreeSet.add(animal10);

        System.out.println("Живоное с наименьшим возрастом: " + animalTreeSet.first());
        System.out.println("Живоное с наибольшим возрастом: " + animalTreeSet.last());

        //4.Напишите метод, который принимает Set и находит все объекты, содержащие определенную подстроку(из поля стринг),
        // перебирая элементы и используя метод contains.
        System.out.println(methods.findObjectContainsString(animalSet, "co"));

        //5. Напишите метод, которая удаляет все четные инт из HashSet и выводит оставшиеся элементы. Используйте итератор
        methods.removeEven(animalSet);
        System.out.println(animalSet);

        //6.Создайте метод, который принимает два HashSet<Наш Класс> и возвращает новый HashSet, содержащий элементы,
        // которые присутствуют в обоих множествах

        Set<Animal> animals1  = new HashSet<>();
        animals1.add(animal1);
        animals1.add(animal2);
        animals1.add(animal3);
        Set<Animal> animals2 = new HashSet<>();
        animals2.add(animal3);
        animals2.add(animal4);
        animals2.add(animal7);
        Set<Animal>animals3 = new HashSet<>(animals1);
        animals3.retainAll(animals2);//проверка на содержание ищет в обоих множествах и возвр в кач рез  и удаляет все остальн
        System.out.println(animals3);
    }
}
