package com.codemanship.rockpaperscissors;

public class Program {

    public static void main(String[] args) {
        int testsPassed = 0;
        int testsFailed = 0;

        // output header
        System.out.println("Running RockPaperScissors tests...");

        // Round tests
        System.out.println("Round tests...");

        // rock blunts scissors
        int result = 0;
        try {
            result = new Round().play("Rock", "Scissors");
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        if (result == 1)
        {
            testsPassed++;
            System.out.println("rock blunts scissors (Rock, Scissors): PASS");
        }
        else
        {
            testsFailed++;
            System.out.println(String.format("rock blunts scissors (Rock, Scissors): FAIL - expected 1 but was %d", result));
        }

        try {
            result = new Round().play("Scissors", "Rock");
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        if (result == 2)
        {
            testsPassed++;
            System.out.println("rock blunts scissors (Scissors, Rock): PASS");
        }
        else
        {
            testsFailed++;
            System.out.println(String.format("rock blunts scissors (Scissors, Rock): FAIL - expected 2 but was %d", result));
        }

        // scissors cut paper
        try {
            result = new Round().play("Scissors", "Paper");
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        if (result == 1)
        {
            testsPassed++;
            System.out.println("scissors cut paper (Scissors, Paper): PASS");
        }
        else
        {
            testsFailed++;
            System.out.println(String.format("scissors cut paper (Scissors, Paper): FAIL - expected 1 but was %d", result));
        }

        try {
            result = new Round().play("Paper", "Scissors");
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        if (result == 2)
        {
            testsPassed++;
            System.out.println("scissors cut paper (Paper, Scissors): PASS");
        }
        else
        {
            testsFailed++;
            System.out.println(String.format("scissors cut paper (Paper, Scissors): FAIL - expected 2 but was %d", result));
        }

        // paper wraps rock
        try {
            result = new Round().play("Paper", "Rock");
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        if (result == 1)
        {
            testsPassed++;
            System.out.println("paper wraps rock (Paper, Rock): PASS");
        }
        else
        {
            testsFailed++;
            System.out.println(String.format("paper wraps rock (Paper, Rock): FAIL - expected 1 but was %d", result));
        }

        try {
            result = new Round().play("Rock", "Paper");
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        if (result == 2)
        {
            testsPassed++;
            System.out.println("paper wraps rock (Rock, Paper): PASS");
        }
        else
        {
            testsFailed++;
            System.out.println(String.format("paper wraps rock (Rock, Paper): FAIL - expected 2 but was %d", result));
        }

        // round is a draw
        try {
            result = new Round().play("Rock", "Rock");
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        if (result == 0)
        {
            testsPassed++;
            System.out.println("round is a draw (Rock, Rock): PASS");
        }
        else
        {
            testsFailed++;
            System.out.println(String.format("round is a draw (Rock, Rock): FAIL - expected 0 but was %d", result));
        }

        try {
            result = new Round().play("Scissors", "Scissors");
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        if (result == 0)
        {
            testsPassed++;
            System.out.println("round is a draw (Scissors, Scissors): PASS");
        }
        else
        {
            testsFailed++;
            System.out.println(String.format("round is a draw (Scissors, Scissors): FAIL - expected 0 but was %d", result));
        }

        try {
            result = new Round().play("Paper", "Paper");
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }
        if (result == 0)
        {
            testsPassed++;
            System.out.println("round is a draw (Paper, Paper): PASS");
        }
        else
        {
            testsFailed++;
            System.out.println(String.format("round is a draw (Paper, Paper): FAIL - expected 0 but was %d", result));
        }

        // invalid inputs not allowed
        Exception exception = null;

        try
        {
            new Round().play("Blah", "Foo");
        } catch (InvalidMoveException e) {
            exception = e;
        }

        if (exception.getClass() == InvalidMoveException.class)
        {
            testsPassed++;
            System.out.println("invalid inputs not allowed: PASS");
        }
            else
        {
            testsFailed++;
            System.out.println("invalid inputs not allowed: FAIL - expected InvalidMoveException");
        }

        // Game tests
        System.out.println("Game tests...");

        // player 1 wins game
        SpyGameListener listener = new SpyGameListener();
        Game game = new Game(listener);
        try {
            game.PlayRound("Rock", "Scissors");
            game.PlayRound("Rock", "Scissors");
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }

        result = listener.getWinner();
        if (result == 1)
        {
            testsPassed++;
            System.out.println("player 1 wins game: PASS");
        }
        else
        {
            testsFailed++;
            System.out.println(String.format("player 1 wins game: FAIL - expected 1 but was %d", result));
        }

        // player 2 wins game
        listener = new SpyGameListener();
        game = new Game(listener);
        try {
            game.PlayRound("Rock", "Paper");
            game.PlayRound("Rock", "Paper");
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }

        result = listener.getWinner();
        if (result == 2)
        {
            testsPassed++;
            System.out.println("player 2 wins game: PASS");
        }
        else
        {
            testsFailed++;
            System.out.println(String.format("player 2 wins game: FAIL - expected 2 but was %d", result));
        }

        // drawers not counted
        listener = new SpyGameListener();
        game = new Game(listener);
        try {
            game.PlayRound("Rock", "Rock");
            game.PlayRound("Rock", "Rock");
        } catch (InvalidMoveException e) {
            e.printStackTrace();
        }

        result = listener.getWinner();
        if (result == 0)
        {
            testsPassed++;
            System.out.println("drawers not counted: PASS");
        }
        else
        {
            testsFailed++;
            System.out.println(String.format("drawers not counted: FAIL - expected 0 but was %d", result));
        }

        //invalid moves not counted
        listener = new SpyGameListener();
        game = new Game(listener);
        try
        {
            game.PlayRound("Blah", "Foo");
            game.PlayRound("Rock", "Scissors");
        }
        catch (Exception e)
        {

        }

        result = listener.getWinner();
        if (result == 0)
        {
            testsPassed++;
            System.out.println("invalid moves not counted: PASS");
        }
        else
        {
            testsFailed++;
            System.out.println(String.format("invalid moves not counted: FAIL - expected 0 but was %d", result));
        }


        System.out.println(String.format("Tests run: %d  Passed: %d  Failed: %d", testsPassed + testsFailed, testsPassed, testsFailed));
    }

    private static class SpyGameListener implements GameListener {
        private int winner = 0;

        @Override
        public void GameOver(int winner) {
            this.winner = winner;
        }

        public int getWinner() {
            return winner;
        }
    }
}
