package com.epam;

public class ConsoleHelper {

    public static void printNumberOfMatchesLeft(byte mathesLeft) {
        System.out.printf("На столе осталось %d спичек.%n", mathesLeft);
    }

    public static void printTakeMatches() {
        System.out.print("- Ход игрока. Введите количество спичек: ");
    }

    public static void printNumberOfMathesComputerTook(byte matchesTaken) {
        System.out.printf("- Количество выбранных компьютером спичек = %d%n", matchesTaken);
    }

    public static void incorrectNumberOfMatches() {
        System.out.println("Некорректное количество спичек!");
    }

    public static void printPlayerLost() {
        System.out.println("Для игрока осталась последняя спичка. Игрок проиграл!");
    }
}
