package com.example.chinesechess;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ChessGame chessGame;
    private ChessBoard chessBoard;
    private Button startGameButton;
    private Button puzzleButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Initialize views
        chessBoard = findViewById(R.id.chess_board);
        startGameButton = findViewById(R.id.start_game_button);
        puzzleButton = findViewById(R.id.puzzle_button);
        
        // Set up button listeners
        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewGame();
            }
        });
        
        puzzleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPuzzles();
            }
        });
    }
    
    private void startNewGame() {
        chessGame = new ChessGame();
        chessBoard.setGame(chessGame);
        // Update UI to show game screen
    }
    
    private void showPuzzles() {
        // Show endgame puzzles
        EndgamePuzzles puzzles = new EndgamePuzzles();
        EndgamePuzzles.Puzzle puzzle = puzzles.getPuzzle(1);
        // Display puzzle
    }
}