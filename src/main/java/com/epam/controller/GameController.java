package com.epam.controller;

import com.epam.ConsoleHelper;
import com.epam.players.ComputerPlayerImpl;
import com.epam.players.Player;
import com.epam.players.HumanPlayerImpl;

public class GameController {

    private static final byte MIN_MATCHES_CAN_TAKE = 1;
    private static final byte MAX_MATCHES_CAN_TAKE = 3;

    private byte matchesLeft;
    private byte matchesPlayerTookLastTime;
    private Player nextPlayer;
    private Player computerPlayer;
    private Player humanPlayer;

    public GameController() {
        this.matchesLeft = 20;
        this.matchesPlayerTookLastTime = 1;
        this.nextPlayer = new ComputerPlayerImpl((byte) 1);
        this.computerPlayer = this.nextPlayer;
        this.humanPlayer = new HumanPlayerImpl();
    }

    public void start() {
        while (!isHumanPlayerLost()) {
            ConsoleHelper.printNumberOfMatchesLeft(matchesLeft);
            matchesLeft -= (nextPlayer instanceof HumanPlayerImpl) ? humanMove() : computerMove();
        }
        ConsoleHelper.printPlayerLost();
    }

    public byte computerMove() {
        matchesPlayerTookLastTime = nextPlayer.makeMove();
        ConsoleHelper.printNumberOfMathesComputerTook(matchesPlayerTookLastTime);
        nextPlayer = humanPlayer;
        return matchesPlayerTookLastTime;
    }

    public byte humanMove() {
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
