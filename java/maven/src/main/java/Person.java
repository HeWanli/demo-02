/**
 * Created by hewanli on 15-2-5.
 */
public class Person {
    private String name;
    private int blood;
    private int hurt;

    public Person(String name,int blood,int hurt){
        this.name = name;
        this.blood = blood;
        this.hurt = hurt;
    }

    public String fight(Person lisi){
        lisi.setBlood(lisi.getBlood()-this.hurt);
        return this.name+"攻击了"+lisi.getName()+",李四受到了"+this.hurt
                +"点伤害,剩余生命:"+lisi.getBlood();
    }

    public String getName() {
        return name;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public boolean isAlive() {
        return this.blood>0;
    }
}
