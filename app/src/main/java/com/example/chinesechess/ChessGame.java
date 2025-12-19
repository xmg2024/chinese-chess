package com.example.chinesechess;

import java.util.ArrayList;
import java.util.List;

public class ChessGame {
    private ChessPiece[][] board;
    private ChessPiece.Color currentPlayer;
    private List<ChessPiece> redPieces;
    private List<ChessPiece> blackPieces;
    private boolean gameOver;
    private ChessPiece.Color winner;
    
    public ChessGame() {
        board = new ChessPiece[10][9];
        currentPlayer = ChessPiece.Color.RED;
        redPieces = new ArrayList<>();
        blackPieces = new ArrayList<>();
        gameOver = false;
        initBoard();
    }
    
    private void initBoard() {
        // Initialize pieces for both sides
        // Red side (bottom)
        redPieces.add(new ChessPiece(ChessPiece.Type.CHARIOT, ChessPiece.Color.RED, 9, 0));
        redPieces.add(new ChessPiece(ChessPiece.Type.HORSE, ChessPiece.Color.RED, 9, 1));
        redPieces.add(new ChessPiece(ChessPiece.Type.ELEPHANT, ChessPiece.Color.RED, 9, 2));
        redPieces.add(new ChessPiece(ChessPiece.Type.ADVISOR, ChessPiece.Color.RED, 9, 3));
        redPieces.add(new ChessPiece(ChessPiece.Type.KING, ChessPiece.Color.RED, 9, 4));
        redPieces.add(new ChessPiece(ChessPiece.Type.ADVISOR, ChessPiece.Color.RED, 9, 5));
        redPieces.add(new ChessPiece(ChessPiece.Type.ELEPHANT, ChessPiece.Color.RED, 9, 6));
        redPieces.add(new ChessPiece(ChessPiece.Type.HORSE, ChessPiece.Color.RED, 9, 7));
        redPieces.add(new ChessPiece(ChessPiece.Type.CHARIOT, ChessPiece.Color.RED, 9, 8));
        
        redPieces.add(new ChessPiece(ChessPiece.Type.CANNON, ChessPiece.Color.RED, 7, 1));
        redPieces.add(new ChessPiece(ChessPiece.Type.CANNON, ChessPiece.Color.RED, 7, 7));
        
        for (int i = 0; i < 5; i++) {
            redPieces.add(new ChessPiece(ChessPiece.Type.PAWN, ChessPiece.Color.RED, 6, 2*i));
        }
        
        // Black side (top)
        blackPieces.add(new ChessPiece(ChessPiece.Type.CHARIOT, ChessPiece.Color.BLACK, 0, 0));
        blackPieces.add(new ChessPiece(ChessPiece.Type.HORSE, ChessPiece.Color.BLACK, 0, 1));
        blackPieces.add(new ChessPiece(ChessPiece.Type.ELEPHANT, ChessPiece.Color.BLACK, 0, 2));
        blackPieces.add(new ChessPiece(ChessPiece.Type.ADVISOR, ChessPiece.Color.BLACK, 0, 3));
        blackPieces.add(new ChessPiece(ChessPiece.Type.KING, ChessPiece.Color.BLACK, 0, 4));
        blackPieces.add(new ChessPiece(ChessPiece.Type.ADVISOR, ChessPiece.Color.BLACK, 0, 5));
        blackPieces.add(new ChessPiece(ChessPiece.Type.ELEPHANT, ChessPiece.Color.BLACK, 0, 6));
        blackPieces.add(new ChessPiece(ChessPiece.Type.HORSE, ChessPiece.Color.BLACK, 0, 7));
        blackPieces.add(new ChessPiece(ChessPiece.Type.CHARIOT, ChessPiece.Color.BLACK, 0, 8));
        
        blackPieces.add(new ChessPiece(ChessPiece.Type.CANNON, ChessPiece.Color.BLACK, 2, 1));
        blackPieces.add(new ChessPiece(ChessPiece.Type.CANNON, ChessPiece.Color.BLACK, 2, 7));
        
        for (int i = 0; i < 5; i++) {
            blackPieces.add(new ChessPiece(ChessPiece.Type.PAWN, ChessPiece.Color.BLACK, 3, 2*i));
        }
        
        // Place pieces on board
        for (ChessPiece piece : redPieces) {
            board[piece.getRow()][piece.getCol()] = piece;
        }
        
        for (ChessPiece piece : blackPieces) {
            board[piece.getRow()][piece.getCol()] = piece;
        }
    }
    
    public ChessPiece[][] getBoard() {
        return board;
    }
    
    public ChessPiece.Color getCurrentPlayer() {
        return currentPlayer;
    }
    
    public boolean isGameOver() {
        return gameOver;
    }
    
    public ChessPiece.Color getWinner() {
        return winner;
    }
    
    public boolean movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        ChessPiece piece = board[fromRow][fromCol];
        
        if (piece != null && piece.getColor() == currentPlayer) {
            // Simple move validation (in a real game, this would be more complex)
            if (isValidMove(piece, toRow, toCol)) {
                // Capture opponent piece if present
                ChessPiece target = board[toRow][toCol];
                if (target != null) {
                    target.setAlive(false);
                    if (target.getType() == ChessPiece.Type.KING) {
                        gameOver = true;
                        winner = currentPlayer;
                    }
                }
                
                // Move piece
                board[fromRow][fromCol] = null;
                piece.setRow(toRow);
                piece.setCol(toCol);
                board[toRow][toCol] = piece;
                
                // Switch player
                currentPlayer = (currentPlayer == ChessPiece.Color.RED) ? ChessPiece.Color.BLACK : ChessPiece.Color.RED;
                return true;
            }
        }
        return false;
    }
    
    private boolean isValidMove(ChessPiece piece, int toRow, int toCol) {
        // Simplified move validation
        // In a real implementation, each piece type would have its own movement rules
        if (toRow < 0 || toRow > 9 || toCol < 0 || toCol > 8) {
            return false; // Out of bounds
        }
        
        ChessPiece target = board[toRow][toCol];
        if (target != null && target.getColor() == piece.getColor()) {
            return false; // Can't capture own piece
        }
        
        // Simplified validation - just check if move is within board
        return true;
    }
}