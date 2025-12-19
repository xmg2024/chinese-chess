package com.example.chinesechess;

public class ChessPiece {
    public enum Type {
        KING, ADVISOR, ELEPHANT, HORSE, CHARIOT, CANNON, PAWN
    }
    
    public enum Color {
        RED, BLACK
    }
    
    private Type type;
    private Color color;
    private int row;
    private int col;
    private boolean alive;
    
    public ChessPiece(Type type, Color color, int row, int col) {
        this.type = type;
        this.color = color;
        this.row = row;
        this.col = col;
        this.alive = true;
    }
    
    // Getters and setters
    public Type getType() { return type; }
    public Color getColor() { return color; }
    public int getRow() { return row; }
    public int getCol() { return col; }
    public boolean isAlive() { return alive; }
    
    public void setRow(int row) { this.row = row; }
    public void setCol(int col) { this.col = col; }
    public void setAlive(boolean alive) { this.alive = alive; }
    
    @Override
    public String toString() {
        return color + " " + type + " at (" + row + "," + col + ")";
    }
}