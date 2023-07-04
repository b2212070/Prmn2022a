package lecture03;
import java.util.Scanner;

public class Exercise3_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1つ目の整数を入力してください：");
        String text1 = scanner.nextLine();
        System.out.println("2つ目の整数を入力してください：");
        String text2 = scanner.nextLine();

        int number1 = Integer.parseInt(text1);
        int number2 = Integer.parseInt(text2);
        int answer = number1 + number2;

        System.out.println(number1 + " + " + number2 + " = " + answer);

    }
}
