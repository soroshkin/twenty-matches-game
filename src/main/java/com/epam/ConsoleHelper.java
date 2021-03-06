package com.epam;

public class ConsoleHelper {

    public static void printStartGame() {
        System.out.println("Добро пожаловать! Игра начинается!");
    }

    public static void printNumberOfMatchesLeft(int mathesLeft) {
        System.out.printf("На столе осталось %d %s.%n", mathesLeft, mathesLeft < 5 ? "спички" : "спичек");
    }

    public static void printTakeMatches() {
        System.out.print("- Ход игрока. Введите количество спичек: ");
    }

    public static void printNumberOfMathesComputerTook(int matchesTaken) {
        System.out.printf("- Количество выбранных компьютером спичек = %d%n", matchesTaken);
    }

    public static void incorrectNumberOfMatches() {
        System.out.println("Некорректное количество спичек!");
    }

    public static void printPlayerLost() {
        System.out.println("Для игрока осталась последняя спичка. Игрок проиграл!");
    }
}
