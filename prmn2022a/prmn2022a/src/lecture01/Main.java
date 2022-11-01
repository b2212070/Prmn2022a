package lecture01;
public class Main {
    public static void main(String[] args){
        System.out.println("b2212070 古川理貴");

        int b =2212070;
        System.out.println("b"+b+"古川理貴");

        int age =20;
        if(age>=20){
            System.out.println("I am "+age+"years old so I cannot drink liquor.");
            System.out.println("あっっt");
        }else{
            System.out.println("I am "+age+"years old so I can drink liquor.");
        }

        int sum=0;
        int[] x =new int[100];

        for(int i=0;i<100;i++){
            x[i]=i+1;
            if(x[i]%2==0){
                sum=sum+x[i];
            }
        }
        System.out.println(sum);

    }


}
