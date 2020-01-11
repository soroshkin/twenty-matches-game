package com.epam.controller;

import com.epam.ConsoleHelper;
import com.epam.players.ComputerPlayerImpl;
import com.epam.players.Player;
import com.epam.players.HumanPlayerImpl;

public class GameController {

    private static final int MIN_MATCHES_CAN_TAKE = 1;
    private static final int MAX_MATCHES_CAN_TAKE = 3;

    private int matchesLeft;
    private int matchesPlayerTookLastTime;
    private Player nextPlayer;
    private Player computerPlayer;
    private Player humanPlayer;

    public GameController() {
        this.matchesLeft = 20;
        this.matchesPlayerTookLastTime = 1;
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
        matchesPlayerTookLastTime = nextPlayer.makeMove();
        ConsoleHelper.printNumberOfMathesComputerTook(matchesPlayerTookLastTime);
        nextPlayer = humanPlayer;
        return matchesPlayerTookLastTime;
    }

    public int humanMove() {
        ConsoleHelper.printTakeMatches();
        matchesPlayerTookLastTime = nextPlayer.makeMove();

        if (matchesPlayerTookLastTime >= MIN_MATCHES_CAN_TAKE && matchesPlayerTookLastTime <= MAX_MATCHES_CAN_TAKE) {
            nextPlayer = computerPlayer;
            ((ComputerPlayerImpl) nextPlayer).setNumberOfMatchesPlayerTookLastTime(matchesPlayerTookLastTime);
        } else {
            ConsoleHelper.incorrectNumberOfMatches();
            matchesPlayerTookLastTime = 0;
        }

        return matchesPlayerTookLastTime;
    }

    public boolean isHumanPlayerLost() {
        return matchesLeft == 1;
    }
}
