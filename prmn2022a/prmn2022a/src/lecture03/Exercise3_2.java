package lecture03;

import java.util.Scanner;
import java.util.ArrayList;
public class Exercise3_2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();

        System.out.println("何行分入力しますか？");

        int number = scanner.nextInt();
        String empty = scanner.nextLine();

        for (int i = 0; i < number; i++) {
            System.out.println(i + "行目：");
            String text = scanner.nextLine();
            arrayList.add(text);
        }

        for (String textList : arrayList) {
            System.out.println(textList);
        }
    }
}
