package com.example.chinesechess;

import java.util.Random;

public class AIPlayer {
    private ChessPiece.Color color;
    private int difficulty; // 1-3, 3 being the hardest
    
    public AIPlayer(ChessPiece.Color color, int difficulty) {
        this.color = color;
        this.difficulty = difficulty;
    }
    
    public boolean makeMove(ChessGame game) {
        // Simple AI implementation
        // In a real game, this would use more sophisticated algorithms
        
        Random rand = new Random();
        ChessPiece[][] board = game.getBoard();
        
        // Find all pieces of AI color
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 9; col++) {
                ChessPiece piece = board[row][col];
                if (piece != null && piece.getColor() == color && piece.isAlive()) {
                    // Try to find a valid move
                    for (int i = 0; i < 5; i++) { // Try 5 random moves
                        int toRow = rand.nextInt(10);
                        int toCol = rand.nextInt(9);
                        
                        // Simple heuristic for higher difficulties
                        if (difficulty >= 2) {
                            // Try to move toward opponent's side
                            if (color == ChessPiece.Color.RED) {
                                toRow = row - rand.nextInt(3);
                            } else {
                                toRow = row + rand.nextInt(3);
                            }
                            
                            toRow = Math.max(0, Math.min(9, toRow));
                            toCol = Math.max(0, Math.min(8, col + rand.nextInt(3) - 1));
                        }
                        
                        // Attempt move
                        // In a real implementation, we would validate the move properly
                        if (game.movePiece(row, col, toRow, toCol)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}