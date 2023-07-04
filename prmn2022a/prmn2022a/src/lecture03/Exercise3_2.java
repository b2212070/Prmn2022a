package lecture03;

import java.util.Scanner;
import java.util.ArrayList;
public class Exercise3_2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();

        System.out.print("何行分入力しますか？:");

        int number = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < number; i++) {
            System.out.print(i + 1+"行目：");
            String text = scanner.nextLine();
            arrayList.add(text);
        }

        for (String textList : arrayList) {
            System.out.println(textList);
        }
    }
}
