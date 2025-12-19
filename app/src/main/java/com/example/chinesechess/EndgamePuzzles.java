package com.example.chinesechess;

import java.util.HashMap;
import java.util.Map;

public class EndgamePuzzles {
    private Map<Integer, Puzzle> puzzles;
    
    public EndgamePuzzles() {
        puzzles = new HashMap<>();
        initPuzzles();
    }
    
    private void initPuzzles() {
        // Sample endgame puzzles
        puzzles.put(1, new Puzzle("单车保胜", "红方：帅五进一，车四进六；黑方：将5退1；红方：车四退一，将5进1；红方：车四平五，绝杀！"));
        puzzles.put(2, new Puzzle("双兵闯宫", "红方：兵四进一，将5平6；红方：兵五进一，将6平5；红方：兵四进一，将5平6；红方：兵五平四，绝杀！"));
        puzzles.put(3, new Puzzle("马兵擒王", "红方：马三进四，将5平6；红方：兵五进一，将6平5；红方：马四进三，将5平6；红方：马三退四，将6平5；红方：马四进六，绝杀！"));
    }
    
    public Puzzle getPuzzle(int puzzleId) {
        return puzzles.get(puzzleId);
    }
    
    public int getTotalPuzzles() {
        return puzzles.size();
    }
    
    public static class Puzzle {
        private String title;
        private String solution;
        
        public Puzzle(String title, String solution) {
            this.title = title;
            this.solution = solution;
        }
        
        public String getTitle() {
            return title;
        }
        
        public String getSolution() {
            return solution;
        }
    }
}