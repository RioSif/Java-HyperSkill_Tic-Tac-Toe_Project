import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] arr = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        int checknum = sc.nextInt();

        boolean result = false;
        for (int i : arr) {
            if (i == checknum) {
                result = true;
                break;
            }
        }

        System.out.println(result);
    }
}
