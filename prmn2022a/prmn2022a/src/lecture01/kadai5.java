package lecture01;

public class Kadai5 {

    public static void main(String[] args) {
        //テストの点数表
        int[] score = {41,85,72,38,80};

        //各点数の成績を表示
        for (int i = 0; i < score.length; i++) {
            if (score[i] >= 90) {
                System.out.println(i + "番 " + score[i] + "点 " + "秀");
            } else if (score[i] >= 80) {
                System.out.println(i + "番 " + score[i] + "点 " + "優");
            } else if (score[i] >= 70) {
                System.out.println(i + "番 " + score[i] + "点 " + "良");
            } else if (score[i] >= 60) {
                System.out.println(i + "番 " + score[i] + "点 " + "可");
            } else {
                System.out.println(i + "番 " + score[i] + "点 " + "不可");
            }
        }

        //各メソッドを呼び出し、最高点と最低点と平均点を表示
        System.out.println(".....");
        System.out.println("最高点:" + max(score) + "点"); //max = Math.max(max, score[i]);で済ませてもOK
        System.out.println("最低点:" + min(score) + "点"); //min = Math.min(min, score[i]);で済ませてもOK
        System.out.println("平均点:" + average(score) + "点");
        System.out.println(".....");

    }

    //最低点を返すメソッド
    static int min(int[] score){
        int min = score[0]; //minに0番目の点数を格納
        for (int i = 0; i < score.length; i++) { //全ての点数について、
            if (min > score[i]) { //minより小さい点数であれば、
                min = score[i]; //minの値をその点数に更新
            }
        }
        return min;
    }

    // 最高点を返すメソッド
    static int max(int[] score){
        int max = score[0]; //maxに0番目の点数を格納
        for (int tensuu: score) { //全ての点数について、
            if (max < tensuu) { //maxより高い点数であれば、
                max = tensuu; //maxの値をその点数に更新
            }
        }
        return max;
    }

    // 平均点を返すメソッド
    static double average(int[] score){
        double ave; //平均点を格納する変数aveを用意
        double sum = 0; //合計点を格納する変数sumを用意
        for (int i = 0; i < score.length; i++) { //全ての点数について、
            sum += score[i]; //sumにscoreの値を累積させる
        }
        ave = sum / score.length; //平均を求める式
        return ave;
    }

}
