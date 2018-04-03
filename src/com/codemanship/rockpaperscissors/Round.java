package com.codemanship.rockpaperscissors;

public class Round
{

    public int play(String player1, String player2) throws InvalidMoveException {
        if (player1 == "Rock")
        {
            if (player2 == "Scissors")
                return 1;
            if (player2 == "Paper")
                return 2;
            if (player2 == "Rock")
                return 0;
        }
        if (player1 == "Paper")
        {
            if (player2 == "Rock")
                return 1;
            if (player2 == "Scissors")
                return 2;
            if (player2 == "Paper")
                return 0;
        }
        if (player1 == "Scissors")
        {
            if (player2 == "Paper")
                return 1;
            if (player2 == "Rock")
                return 2;
            if (player2 == "Scissors")
                return 0;
        }
        throw new InvalidMoveException();
    }

}
