package org.example.hwCasino;

import java.io.*;
import java.util.List;

public class WriterResult {

    public WriterResult() {
    }

    public void writeResult(List<Player> listPlayer) throws IOException {
        System.out.println(listPlayer);
        //"C:\\Users\\sokol\\IdeaProjects\\Less1\\src\\main\\java\\org\\example\\hwCasino\\gamers.txt"
        File file = new File("gamers.txt");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (int i = 0; i < listPlayer.size(); i++) {

            String player = listPlayer.get(i).getName() + " " + listPlayer.get(i).getMoney();

            bufferedWriter.write(player);

            bufferedWriter.newLine();
        }
            bufferedWriter.flush();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
       List<String> list = bufferedReader.lines().toList();
        System.out.println("Test" + list);
        System.out.println(file.exists());
        System.out.println(file.length());
    }

}
