package com.epam.players;

public class ComputerPlayerImpl implements Player {
    private int numberOfMatchesPlayerTookLastTime;
    private static final int MAX_MATCHES_PER_ROUND = 4;

    public ComputerPlayerImpl(int numberOfMatchesPlayerTookLastTime) {
        this.numberOfMatchesPlayerTookLastTime = numberOfMatchesPlayerTookLastTime;
    }

    public void setNumberOfMatchesPlayerTookLastTime(int numberOfMatchesPlayerTookLastTime) {
        this.numberOfMatchesPlayerTookLastTime = numberOfMatchesPlayerTookLastTime;
    }

    @Override
    public int makeMove() {
        return MAX_MATCHES_PER_ROUND - numberOfMatchesPlayerTookLastTime;
    }
}
