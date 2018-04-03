package com.codemanship.rockpaperscissors;

public class Game
{
    private int _player1Score = 0;
    private int _player2Score = 0;
    private GameListener _listener;

    public Game(GameListener listener)
    {
        _listener = listener;
    }

    public void PlayRound(String player1, String player2) throws InvalidMoveException {
        int result = new Round().play(player1, player2);
        if (result == 1) _player1Score++;
        if (result == 2) _player2Score++;

        if (_player1Score == 2)
        {
            _listener.GameOver(1);
        }

        if (_player2Score == 2)
        {
            _listener.GameOver(2);
        }
    }
}
