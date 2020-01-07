package com.epam;

import java.util.Scanner;

public class ConsoleHelper {
    public static void printNumberOfMatchesLeft(byte mathesLeft){
        System.out.printf("На столе осталось %d спичек.%n", mathesLeft);
    }

    public static void printTakeMatches(){
        System.out.print("- Ход игрока. Введите количество спичек: ");
    }

    public static void printnumberOfMathesComputerTook(byte matchesTaken){
        System.out.printf("- Количество выбранных компьютером спичек = %d%n", matchesTaken);
    }

    public static byte takeMatches(){
      //  BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        scanner.nextByte();
        return 0;
    }
}
