import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int j = 0; j < n; j++) {
            System.out.println("");
            for (int i = m - 1; i >= 0; i--) {
                if (i != 0) {
                    System.out.print(arr[i][j] + " ");
                } else {
                    System.out.print(arr[i][j]);
                }
            }
        }

    }
}