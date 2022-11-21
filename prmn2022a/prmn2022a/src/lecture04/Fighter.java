package lecture04;

public class Fighter {
    private int hitPoint;
    private int power;
    private String name;


    public Fighter(int hitPoint,int power,String name){
        this.hitPoint=hitPoint;
        this.power=power;
        this.name=name;
    }

    public void attack(Fighter enemy){
        enemy.setHitPoint(enemy.getHitPoint() - power);
        System.out.println(name +"は"+enemy.name+"に"+power+"ダメージを与えた。");
    }

    public boolean isAlive(){
        if(hitPoint>0) {
            return true;
        }else{
            return false;
        }
    }

    public int getHitPoint(){
        return hitPoint;
    }

    public void setHitPoint(int hitPoint){
        this.hitPoint=hitPoint;
        System.out.println(name + "の残りhitPoint : " + hitPoint);
    }

    public String getName() {
        return name;
    }

}
