package com.epam.players;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayerImpl implements Player {

    @Override
    public int makeMove() {
        try {
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            return 0;
        }
    }
}
