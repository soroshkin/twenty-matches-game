package com.epam.players;

public class ComputerPlayerImpl implements Player {
    private byte numberOfMatchesPlayerTookLastTime;
    private static final byte MAX_MATCHES_PER_ROUND = 4;

    public ComputerPlayerImpl(byte numberOfMatchesPlayerTookLastTime) {
        this.numberOfMatchesPlayerTookLastTime = numberOfMatchesPlayerTookLastTime;
    }

    public void setNumberOfMatchesPlayerTookLastTime(byte numberOfMatchesPlayerTookLastTime) {
        this.numberOfMatchesPlayerTookLastTime = numberOfMatchesPlayerTookLastTime;
    }

    @Override
    public byte makeMove() {
        return (byte) (MAX_MATCHES_PER_ROUND - numberOfMatchesPlayerTookLastTime);
    }
}
