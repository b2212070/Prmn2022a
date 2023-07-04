package lecture03;
import java.util.ArrayList;

public class Exercise3_4 {
    public static void main(String[] args) {

        ArrayList<Vegetable> arrayList = new ArrayList<>();
        Vegetable[] vegetables = {
                new Vegetable("にんじん", 117),
                new Vegetable("たまねぎ", 120),
                new Vegetable("じゃがいも", 154)
        };

        for (Vegetable vegetable : vegetables) {
            arrayList.add(vegetable);
        }

        for (Vegetable textlist : arrayList) {
            textlist.print();
        }

    }

}
