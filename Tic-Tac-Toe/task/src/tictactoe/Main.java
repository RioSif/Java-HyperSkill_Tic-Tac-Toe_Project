package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter cells: ");
        String cells = "_________";


        print(cells);
        String newcells = "_________";
        while (check(newcells).equals("Game not finished")) {
            newcells = userinput(newcells);
            print(newcells);
        }
        //check(newcells);
    }

    public static String userinput(String cells) {
        String newc = "";
        Scanner sc = new Scanner(System.in);
        boolean validinput = false;

        while (validinput == false) {
            int m = 0;
            int n = 0;
            String[][] coordinates = new String[3][3];
            boolean done = false;
            System.out.print("Enter the coordinates: ");

            do {
                while (!sc.hasNextInt()) {
                    String input = sc.next();
                    System.out.println("You should enter numbers!");
                    System.out.print("Enter the coordinates: ");
                }
                m = sc.nextInt() - 1;
                n = sc.nextInt() - 1;
                while (m > 2 || n > 2 || m < 0 || n < 0) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    System.out.print("Enter the coordinates: ");
                    m = sc.nextInt() - 1;
                    n = sc.nextInt() - 1;
                }
                done = true;
            } while (done == false);

            int sum = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    coordinates[i][j] = cells.substring(sum, sum + 1);
                    sum++;
                }
            }

            if (!coordinates[m][n].equals("_")) {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                sum = 0;
                for (int i = 0; i < 9; i++) {
                    if (cells.charAt(i) == 'X' || cells.charAt(i) == 'O') {
                        sum++;
                    }
                }
                System.out.println(sum);
                coordinates[m][n] = (sum % 2 != 0) ? "O" : "X";
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        newc += coordinates[i][j];
                    }
                }
                validinput = true;
            }
        }

        return newc;
    }

    public static String check(String cells) {
        int x = 0;
        int o = 0;
        int empty = 0;
        int wins = 0;
        String player = null;
        String result = null;

        //Check Impossible with more Xs or Os
        for (int i = 0; i < cells.length(); i++) {
            if (cells.charAt(i) == 'X') {
                x++;
            } else if (cells.charAt(i) == 'O') {
                o++;
            } else if (cells.charAt(i) == '_') {
                empty++;
            }
        }

        if (x > o + 1 || x < o - 1) {
            result = "Impossible";
        } else if (empty > 0) {
            result = "Game not finished";
        } else {
            result = "Draw";
        }

        //Check rows
        for (int i = 0; i < cells.length(); i = i + 3) {
            if (cells.charAt(i) == cells.charAt(i + 1) && cells.charAt(i) == cells.charAt(i + 2)) {
                if (cells.charAt(i) == 'X') {
                    player = "X";
                    wins++;
                } else if (cells.charAt(i) == 'O') {
                    player = "O";
                    wins++;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            if (cells.charAt(i) == cells.charAt(i + 3) && cells.charAt(i) == cells.charAt(i + 6)) {
                if (cells.charAt(i) == 'X') {
                    player = "X";
                    wins++;
                } else if (cells.charAt(i) == 'O') {
                    player = "O";
                    wins++;
                }
            }
        }

        int i = 0;
        if (cells.charAt(i) == cells.charAt(i + 4) && cells.charAt(i) == cells.charAt(i + 8)) {
            if (cells.charAt(i) == 'X') {
                player = "X";
                wins++;
            } else if (cells.charAt(i) == 'O') {
                player = "O";
                wins++;
            }
        }

        i = 2;
        if (cells.charAt(i) == cells.charAt(i + 2) && cells.charAt(i) == cells.charAt(i + 4)) {
            if (cells.charAt(i) == 'X') {
                player = "X";
                wins++;
            } else if (cells.charAt(i) == 'O') {
                player = "O";
                wins++;
            }
        }

        if (wins == 0) {
        } else if (wins == 1) {
            result = player + " wins";
        } else if (wins > 1) {
            result = "Impossible";
        }

        if (result != "Game not finished") {
            System.out.println(result);
        }
        return result;
    }

    public static void print(String cells) {
        System.out.println("---------");
        System.out.println("| " + cells.charAt(0) + " " + cells.charAt(1) + " " + cells.charAt(2) + " |");
        System.out.println("| " + cells.charAt(3) + " " + cells.charAt(4) + " " + cells.charAt(5) + " |");
        System.out.println("| " + cells.charAt(6) + " " + cells.charAt(7) + " " + cells.charAt(8) + " |");
        System.out.println("---------");
    }

}