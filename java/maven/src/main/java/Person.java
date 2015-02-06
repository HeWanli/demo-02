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

    public void fight(Person lisi){
        lisi.setBlood(lisi.getBlood()-this.hurt);
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
