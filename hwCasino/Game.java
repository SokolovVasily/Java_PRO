package org.example.hwCasino;

abstract class Game {
    private int bet;

    public Game(int bet) {
        this.bet = bet;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public abstract void startGame(Player player);


    public abstract void winGame(Player player);

    public abstract void loseGame(Player player);

    public abstract void resultGame(Player player);

}
