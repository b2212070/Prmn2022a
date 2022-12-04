package lecture06;

import java.util.*;
import java.util.ArrayList;

public class Excercise6_2 {
    public static void main(String[] args) {
        List<Integer>integerlist =new ArrayList<>();

        Scanner input =new Scanner(System.in);
        Random random =new Random();

        integerlist.add(random.nextInt(6)+1);
        integerlist.add(random.nextInt(6)+1);
        integerlist.add(random.nextInt(6)+1);
        integerlist.add(random.nextInt(6)+1);
        integerlist.add(random.nextInt(6)+1);

        System.out.println("サイコロを5つ振りました。");
        System.out.println("何番目のサイコロの値を確認しますか。");

        try {
            int a =input.nextInt();
            System.out.println(integerlist.get(a-1));

        }catch (IndexOutOfBoundsException e){
            System.out.println("ArrayListの範囲外アクセスを確認しました。");
            System.out.println("プログラムを終了します。");

        }catch (InputMismatchException e){
            System.out.println("整数以外の値が入力されました。");
            System.out.println("プログラムを終了します。");
        }


    }
}
