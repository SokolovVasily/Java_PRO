package org.example.HW7HashSet;

import java.util.Objects;

public class Animal implements Comparable<Animal> {
    private String type ;
    private int age;
    private boolean poison;

    public Animal(String type, int age, boolean poison) {
        this.type = type;
        this.age = age;
        this.poison = poison;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    public boolean isPoison() {
        return poison;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "type='" + type + '\'' +
                ", age=" + age +
                ", poison=" + poison +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && poison == animal.poison && Objects.equals(type, animal.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, age, poison);
    }

    @Override
    public int compareTo(Animal o) {
        return this.age - o.age ;   //Long,double,int
    }
}
