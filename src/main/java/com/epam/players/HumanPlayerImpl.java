package com.epam.players;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HumanPlayerImpl implements Player {

    @Override
    public byte makeMove() {
        try {
            return new Scanner(System.in).nextByte();
        } catch (InputMismatchException e) {
            return 0;
        }
    }
}