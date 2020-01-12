package com.epam.controller;

import com.epam.ConsoleHelper;
import com.epam.players.ComputerPlayerImpl;
import com.epam.players.Player;
import com.epam.players.HumanPlayerImpl;

public class GameController {

    private static final int MIN_MATCHES_CAN_TAKE = 1;
    private static final int MAX_MATCHES_CAN_TAKE = 3;

    private int matchesLeft;
    private int numberOfMatchesPlayerTookLastTime;
    private Player nextPlayer;
    private Player computerPlayer;
    private Player humanPlayer;

    public GameController() {
        this.matchesLeft = 20;
        this.numberOfMatchesPlayerTookLastTime = 1;
        this.nextPlayer = new ComputerPlayerImpl(1);
        this.computerPlayer = this.nextPlayer;
        this.humanPlayer = new HumanPlayerImpl();
    }

    public void start() {
        ConsoleHelper.printStartGame();
        while (!isHumanPlayerLost()) {
            ConsoleHelper.printNumberOfMatchesLeft(matchesLeft);
            matchesLeft -= (nextPlayer instanceof HumanPlayerImpl) ? humanMove() : computerMove();
        }
        ConsoleHelper.printPlayerLost();
    }

    public int computerMove() {
        numberOfMatchesPlayerTookLastTime = nextPlayer.makeMove();
        ConsoleHelper.printNumberOfMathesComputerTook(numberOfMatchesPlayerTookLastTime);
        nextPlayer = humanPlayer;
        return numberOfMatchesPlayerTookLastTime;
    }

    public int humanMove() {
        ConsoleHelper.printTakeMatches();
        numberOfMatchesPlayerTookLastTime = nextPlayer.makeMove();

        if (numberOfMatchesPlayerTookLastTime >= MIN_MATCHES_CAN_TAKE && numberOfMatchesPlayerTookLastTime <= MAX_MATCHES_CAN_TAKE) {
            nextPlayer = computerPlayer;
            ((ComputerPlayerImpl) nextPlayer).setNumberOfMatchesPlayerTookLastTime(numberOfMatchesPlayerTookLastTime);
        } else {
            ConsoleHelper.incorrectNumberOfMatches();
            numberOfMatchesPlayerTookLastTime = 0;
        }

        return numberOfMatchesPlayerTookLastTime;
    }

    public boolean isHumanPlayerLost() {
        return matchesLeft == 1;
    }
}
