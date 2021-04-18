import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int desks = 0;
        for (int i = 0; i < 3; i++) {
            int temp = scanner.nextInt();
            desks += temp % 2 != 0 ? temp / 2 + 1 : temp / 2;
        }
        System.out.println(desks);

    }
}