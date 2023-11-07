package org.example.hwCasino;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MainCasino {
    public static void main(String[] args) throws IOException {
        List<Player> players = new ArrayList<>();
        Player player1 = new Player("Vasily", 1000);
        Player player2 = new Player("Alex", 1000);
        players.add(player1);
        players.add(player2);

        System.out.println(player1);
        System.out.println(player2);
        Roullette roullette = new Roullette(10); // менять ставки
        roullette.startGame(player1);
        WriterResult writerResult = new WriterResult();
        writerResult.writeResult(players);

    }
}
