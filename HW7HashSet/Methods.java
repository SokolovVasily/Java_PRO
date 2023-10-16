package org.example.HW7HashSet;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Methods {
    public void iterateSet(Set<Animal> animalSet) {
        for (Animal animal : animalSet) {
            System.out.println(animal);
        }
    }

    //4.Напишите метод, который принимает Set и находит все объекты, содержащие определенную подстроку(из поля стринг),
    // перебирая элементы и используя метод contains.
    public Set<Animal> findObjectContainsString(Set<Animal> animalSet, String str) {
        Set<Animal> animals = new HashSet<>();
        for (Animal animal : animalSet) {
            if (animal.getType().contains(str)) {
                animals.add(animal);
            }
        }
        return animals;
    }

    //5. Напишите метод, которая удаляет все четные инт из HashSet и выводит оставшиеся элементы. Используйте итератор
    public void removeEven(Set<Animal> animalSet) {
        Iterator<Animal> iterator = animalSet.iterator();
        while (iterator.hasNext()) {
            Animal animal = iterator.next();
            if (animal.getAge() % 2 == 0) {
                iterator.remove();
            }
        }
    }
}
