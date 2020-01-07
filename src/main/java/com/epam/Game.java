package com.epam;

public class Game {
    private byte matchesLeft = 20;
    private static final byte MIN_MATCHES_TO_TAKE = 1;
    private static final byte MAX_MATCHES_TO_TAKE = 4;
    private byte matchesPlayerTookLastTime = 0;
    private boolean isGameFinished = false;

    public void start(){
        ComputerPlayer computerPlayer = new ComputerPlayer();
        Player player = new Player();
        while (!isGameFinished){
            ConsoleHelper.printNumberOfMatchesLeft(matchesLeft);
            ConsoleHelper.printnumberOfMathesComputerTook(computerPlayer.makeMove(matchesPlayerTookLastTime));
            ConsoleHelper.printTakeMatches();

        }
    }

}
