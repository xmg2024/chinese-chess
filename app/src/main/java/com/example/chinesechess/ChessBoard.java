package com.example.chinesechess;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class ChessBoard extends View {
    private static final int BOARD_SIZE = 9;
    private static final int GRID_SIZE = 10;
    private Paint paint;
    private ChessGame game;

    public ChessBoard(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLACK);
    }
    
    public void setGame(ChessGame game) {
        this.game = game;
        invalidate(); // Trigger redraw
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        int width = getWidth();
        int height = getHeight();
        int cellWidth = width / (BOARD_SIZE - 1);
        int cellHeight = height / (GRID_SIZE - 1);
        
        // Draw horizontal lines
        for (int i = 0; i < GRID_SIZE; i++) {
            canvas.drawLine(0, i * cellHeight, width, i * cellHeight, paint);
        }
        
        // Draw vertical lines
        for (int i = 0; i < BOARD_SIZE; i++) {
            canvas.drawLine(i * cellWidth, 0, i * cellWidth, height, paint);
        }
        
        // Draw palace diagonals
        canvas.drawLine(3 * cellWidth, 0, 5 * cellWidth, 2 * cellHeight, paint);
        canvas.drawLine(5 * cellWidth, 0, 3 * cellWidth, 2 * cellHeight, paint);
        canvas.drawLine(3 * cellWidth, 7 * cellHeight, 5 * cellWidth, 9 * cellHeight, paint);
        canvas.drawLine(5 * cellWidth, 7 * cellHeight, 3 * cellWidth, 9 * cellHeight, paint);
        
        // Draw pieces if game is set
        if (game != null) {
            drawPieces(canvas, cellWidth, cellHeight);
        }
    }
    
    private void drawPieces(Canvas canvas, int cellWidth, int cellHeight) {
        ChessPiece[][] board = game.getBoard();
        Paint textPaint = new Paint();
        textPaint.setTextSize(cellWidth / 2);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setAntiAlias(true);
        
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 9; col++) {
                ChessPiece piece = board[row][col];
                if (piece != null && piece.isAlive()) {
                    // Draw piece
                    int x = col * cellWidth;
                    int y = row * cellHeight;
                    
                    // Set color based on piece color
                    if (piece.getColor() == ChessPiece.Color.RED) {
                        textPaint.setColor(Color.RED);
                    } else {
                        textPaint.setColor(Color.BLACK);
                    }
                    
                    // Draw piece type as text (simplified representation)
                    String pieceText = getPieceText(piece.getType());
                    canvas.drawText(pieceText, x + cellWidth / 2, y + cellHeight / 2 + cellHeight / 8, textPaint);
                }
            }
        }
    }
    
    private String getPieceText(ChessPiece.Type type) {
        switch (type) {
            case KING: return "帅";
            case ADVISOR: return "士";
            case ELEPHANT: return "象";
            case HORSE: return "马";
            case CHARIOT: return "车";
            case CANNON: return "炮";
            case PAWN: return "兵";
            default: return "";
        }
    }
}