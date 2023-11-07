package org.example.hwCasino;

import java.util.List;
import java.util.Objects;

public class Player {
    private String name;
    private int money;


    public Player(String name, int money) {
        this.name = name;
        this.money = money;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void makeBet(int bet) {  //сделать ставку
        this.money = this.money - bet;
    } //списание денег со счета

    public void addMoney(int win) {
        this.money = this.money + win;
    }

    public void takeMoney(int lose) {
        this.money = this.money - lose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return money == player.money && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, money);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}

