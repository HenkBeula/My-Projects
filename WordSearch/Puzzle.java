
import java.util.Scanner;

public class Puzzle {//Puzzle class

    public Puzzle(char[][] board, String[] hiddenWord) {
        definesPuzzle(board, hiddenWord);
    }

    public static boolean isHidden(char[][] board, String word) {
        //retorna a posicao em que a palavra esta escondida
        return horizontalContains(board, word)
                || verticalContains(board, word)
                || diagonalContains(board, word);
    }

    public static boolean verticalContains(char[][] board, String word) {
        //verifica e retorna true se a palavra estiver escondida na vertical
        for (char[] row : board) {
            if (new String(row).contains(word)) {
                return true;
            }
        }
        return false;
    }

    public static boolean horizontalContains(char[][] board, String word) {
        //verifica e retorna true se a palavra estiver escondida na horiontal
        int wordLength = word.length();
        int max = board.length - wordLength;
        char[] wordArray = word.toCharArray();
        for (int i = 0, length = board[0].length; i < length; i++) {
            loop:
            for (int j = 0; j < max; j++) {
                for (int k = j; k < wordArray.length; k++) {
                    if (wordArray[k - j] != board[k][i]) {
                        continue loop;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean diagonalContains(char[][] board, String word) {
        //verifica e retorna true se a palavra estiver escondida na diagonal
        int wordLength = word.length();
        char[] wordArray = word.toCharArray();
        for (int i = 0, length = board.length; i < length; i++) {
            loop:
            for (int j = 0, k = i, subLength = board[i].length; j < subLength && k >= wordLength; j++, k--) {
                for (int l = 0; l < wordLength; l++) {
                    if (board[j + i][k - l] != wordArray[l]) {
                        continue loop;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean definesPuzzle(char[][] board, String[] hiddenWord) {
        for (int i = 0; i < hiddenWord.length; i++) {
            if (hiddenWord.length > 0 && i >= 0 && i < hiddenWord.length)
                return true;
        }
        return false;
    }

    public int numberHiddenWords() {
        return 1;
    }

    public int rows() {
        return 1;
    }

    public int columns() {
        return 1;
    }

    public char[][] board() {
        // cria um tabuleiro de dimensao n*m
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//column length
        int m = sc.nextInt();//row length
        char[][] board = new char[n][m];
        return board;
    }

    public String getWord(Move move) {
        if (move.rows() == rows() && move.columns() == columns()) {
            //return move.toString();
        }
        return null;
    }
}
