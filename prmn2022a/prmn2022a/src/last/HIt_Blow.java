package last;

import java.util.Scanner;
import java.util.Random;

public class HIt_Blow {
    public static void main(String[] args) {
        Mondai m = new Mondai();
        m.print();

        Scanner scan=new Scanner(System.in);
        Random rand=new Random();
        final int[] nums=new int[10];
        for(int i=0;i<nums.length;i++){
            nums[i]=i;
        }
        System.out.print("桁数(10以下)：");
        int ansLength=scan.nextInt();
        int[] answer=new int[ansLength];
        int[] userAns=new int[ansLength];


        //問題生成(MondaiSeisei)--------------------------------------------
        for(int i=0;i<answer.length;i++){
            int index=rand.nextInt(nums.length-i);
            answer[i]=nums[index];
            int temp=nums[index];
            nums[index]=nums[nums.length-1-i];
            nums[nums.length-1-i]=temp;
        }
        int count=0;
        while(true){
            System.out.printf("%d桁の数字を入力してください>",ansLength);
            String input=scan.next();
            if(input.length() != ansLength){
                continue;
            }
            count++;
            for(int i=0;i<input.length();i++){
                userAns[i]=Character.getNumericValue(input.charAt(i));
            }


            //判定(Hantei)-----------------------------------------------------------
            int hit=0,blow=0;
            for(int i=0;i<userAns.length;i++){
                if(userAns[i]==answer[i]){
                    hit++;
                }else{
                    for(int j=0;j<answer.length;j++){
                        if(userAns[i]==answer[j]){
                            blow++;
                        }
                    }
                }
            }

            System.out.printf("Hit=%d/Blow=%d%n/Count=%d%n",hit,blow,count);
            if(hit==answer.length) {
                System.out.println("Nice Hit!!");
                System.out.println("正解=" + input);
                System.out.println("Count:" + count);
                break;
            }
        }
        scan.close();
    }
}