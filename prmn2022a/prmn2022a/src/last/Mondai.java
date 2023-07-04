package last;

public class Mondai {
    private String title;
    private String rule;

    Mondai(){
        this.title ="ヒット&ブロー";
        this.rule="自分で指定した桁数に合わせて\n"
                + "隠された数字を当ててください\n"
                + "位置と数字が当たってたらHit、\n"
                + "数字だけあっていたらBlowとカウントします。\n"
                + "隠された数字とその場所を当てたら\n"
                + "終了です\n\n";
    }



    public void print(){
        System.out.println(title);
        System.out.println(rule);
    }


}
