package org.example.oop;


class GameScore {
    static int totalScore = 0;

    static void addPoints(int points) {
        totalScore += points;
    }
}


class Player {
    String name;
    int personalScore;

    public Player(String name, int points) {
        this.name = name;
        this.personalScore = points;
        GameScore.addPoints(points);
    }
}

public class Task6 {
    public static void main(String[] args) {
        Player player1 = new Player("Alex", 150);
        Player player2 = new Player("Semen", 300);

        System.out.println(GameScore.totalScore);
    }
}
