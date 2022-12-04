package lecture05;

import java.util.ArrayList;
import java.util.List;

public class Excercise5_7 {
    public static void main(String[] args) {
        List<Insect>insectList=new ArrayList<>();

        insectList.add(new Insect());
        insectList.add(new Locust());
        insectList.add(new SwallowtailButterfly());
        insectList.add(new Butterfly());

        for(Insect insect:insectList){
            insect.move();
        }
    }
}
