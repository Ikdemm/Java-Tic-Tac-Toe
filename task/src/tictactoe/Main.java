package tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[] board = scanBoard();
        printBoard(board);
        int move = getMove(board);
        char[] newBoard = buildBoard(board, transformIndex(move));
        printBoard(newBoard);
        //checkState(board);
    }

    private static char[] buildBoard(char[] board, int move) {

        char[] newBoard = new char[9];

        for (int i = 0; i < 9; i++) {
            if (occupied(i, board)) {
                newBoard[i] = board[i];
            } else if (!occupied(i, board) && i == move) {
                newBoard[move] = 'X';
            } else {
                newBoard[i] = ' ';
            }
        }

        return newBoard;

    }

    private static int getMove(char[] board) {
        Scanner scanner = new Scanner(System.in);

        List accept = new ArrayList();
        accept.add(1);
        accept.add(2);
        accept.add(3);

        int a, b, index;

        do {
            System.out.println("Enter the coordinates");
            a = scanner.nextInt();
            b = scanner.nextInt();
            index = getIndex(a, b);
        } while (!(accept.contains(a) && accept.contains(b)) || occupied(transformIndex(index), board));

        return index;

    }

    private static int transformIndex(int index) {
        switch (index) {
            case 0: return 6;
            case 1: return 3;
            case 2: return 0;
            case 3: return 7;
            case 4: return 4;
            case 5: return 1;
            case 6: return 8;
            case 7: return 5;
            case 8: return 2;
        }
        return (-1);
    }

    private static boolean occupied(int index, char[] board) {
        return board[index] == 'X' || board[index] == 'O';
    }

    private static int getIndex(int x, int y) {

        if (x == 1) {
            if (y == 1) { return 0; }
            if (y == 2) { return 1; }
            if (y == 3) { return 2; }
        } else if (x == 2) {
            if (y == 1) { return 3; }
            if (y == 2) { return 4; }
            if (y == 3) { return 5; }
        } else if (x == 3) {
            if (y == 1) { return 6; }
            if (y == 2) { return 7; }
            if (y == 3) { return 8; }
        }

        return -1;

    }

    private static char[] scanBoard() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        return scanner.nextLine().toCharArray();
    }

    private static void printBoard(char[] input) {
        System.out.println("---------");
        System.out.printf("| %c %c %c |%n", input[0], input[1], input[2]);
        System.out.printf("| %c %c %c |%n", input[3], input[4], input[5]);
        System.out.printf("| %c %c %c |%n", input[6], input[7], input[8]);
        System.out.println("---------");
    }

    private static void checkState(char[] board) {

        if (impossible('X', 'O', board)) {
            System.out.println("Impossible");
            return;
        }

        if (isFinished(board)) {

            if (testWinner('X', board)) {
                System.out.println("X wins");
                return;
            } else if (testWinner('O', board)) {
                System.out.println("O wins");
                return;
            } else {
                System.out.println("Draw");
                return;
            }

        } else {

            if (testWinner('X', board)) {
                System.out.println("X wins");
                return;
            } else if (testWinner('O', board)) {
                System.out.println("O wins");
                return;
            } else {
                System.out.println("Game not finished");
                return;
            }
        }
    }

    private static boolean isFinished(char[] board) {
        for (char c : board) {
            if (c == ' ' || c == '_') {
                return false;
            }
        }
        return true;
    }

    private static boolean testWinner(char x, char[] board) {
        if (board[0] == x && board[1] == x && board[2] == x) {
            return true;
        } else if (board[3] == x && board[4] == x && board[5] == x) {
            return true;
        } else if (board[6] == x && board[7] == x && board[8] == x) {
            return true;
        } else if (board[0] == x && board[3] == x && board[6] == x) {
            return true;
        } else if (board[1] == x && board[4] == x && board[7] == x) {
            return true;
        } else if (board[2] == x && board[5] == x && board[8] == x) {
            return true;
        } else if (board[0] == x && board[4] == x && board[8] == x) {
            return true;
        } else return board[2] == x && board[4] == x && board[6] == x;
    }

    private static boolean excess(char x, char o, char[] board) {
        int countX = 0;
        int countO = 0;
        for (char c : board) {
            if (c == x) {
                countX++;
            } else if (c == o) {
                countO++;
            }
        }
        return (Math.abs(countX - countO) >= 2);
    }

    private static boolean impossible(char x, char o, char[] board) {
        return (excess(x, o, board) || testWinner(x, board) && testWinner(o, board));
    }
}

