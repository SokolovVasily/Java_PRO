package org.example.hwCasino;

import java.util.*;

public class Roullette extends Game {
    //  private int bet;//ставка
    private int target;//попадание
    private List<Integer> playerChoice; //номера ставок клиента

    public Roullette(int bet) {
        super(bet);
    }


    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public List<Integer> getPlayerChoice() {
        return playerChoice;
    }

    public void setPlayerChoice(List<Integer> playerChoice) {
        this.playerChoice = playerChoice;
    }
    @Override
    public void startGame(Player player) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хотите сыграть? y/n");
        String start = scanner.nextLine();
        while (Objects.equals(start, "y")) {
            playerChoice = stringToInteger(makeBets());
            Random random = new Random();
            target = random.nextInt(37);
            resultGame(player);
            System.out.println("Хотите сыграть еще раз? y/n");
            start = scanner.nextLine();
        }
        System.out.println("Спасибо Вам за Игру!!! " + " " + player.getName() + ", Ваш баланс равняется : "
                + player.getMoney());
    }


    @Override
    public void winGame(Player player) {

        int win = this.getBet() * 36;
        loseGame(player);
        player.addMoney(win);
    }

    @Override
    public void loseGame(Player player) {
        int lose = this.getBet() * playerChoice.size();
        player.takeMoney(lose);
    }

    @Override
    public void resultGame(Player player) {
        System.out.println(playerChoice);
        if (playerChoice.contains(target)) {
            System.out.println("Поздравляю Вы выиграли!!!");
            winGame(player);
        } else {
            System.out.println("К сожалению Вы проиграли ");
            loseGame(player);
        }
    }

    public String makeBets() { //СТАВКИ
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите выбранные номера (0-36) через пробел ");
        String gamerNumbers = scanner.nextLine();
        return gamerNumbers;
    }


    // введенные номера через пробел представляют стринг тип данных,нужен метод для
    //ПРЕОБРАЗ В МАССИВ ЧИСел


    public List<Integer> stringToInteger(String str) {      //
        String[] strArray = str.split(" ");// массив из Стрингов-сплит созд массив по разд
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < strArray.length; i++) {
            numbers.add(Integer.parseInt(strArray[i]));
        }
        return numbers;
    }
}
