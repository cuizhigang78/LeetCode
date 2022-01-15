package no36;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {

        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean res = isValidSudoku(board);
        System.out.println("输出：" + res);
    }

    public static boolean isValidSudoku(char[][] board) {

        Set<Character> set;

        for (int i = 0; i < board.length; i++) {
            set = new HashSet<>(9);
            for (int j = 0; j < board.length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            set = new HashSet<>(9);
            for (int j = 0; j < board.length; j++) {
                char c = board[j][i];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }

        set = new HashSet<>(9);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }

        set = new HashSet<>(9);
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }

        set = new HashSet<>(9);
        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }

        set = new HashSet<>(9);
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }

        set = new HashSet<>(9);
        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }

        set = new HashSet<>(9);
        for (int i = 6; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }

        set = new HashSet<>(9);
        for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }

        set = new HashSet<>(9);
        for (int i = 3; i < 6; i++) {
            for (int j = 6; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }

        set = new HashSet<>(9);
        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    }
                    set.add(c);
                }
            }
        }
        return true;
    }
}
