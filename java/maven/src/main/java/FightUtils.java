import java.io.PrintStream;

/**
 * Created by hewanli on 15-2-5.
 */
public class FightUtils {

    private PrintStream out;

    public FightUtils(PrintStream out) {
        this.out = out;
    }

    public void fightEachOther(Person zhangsan, Person lisi) {
        while (true){
            if(!zhangsan.isAlive()){
                out.println(zhangsan.getName()+"被打败了.");
                break;
            }
            zhangsan.fight(lisi);
            if(!lisi.isAlive()){
                out.println(lisi.getName()+"被打败了.");
            }
            lisi.fight(zhangsan);
        }
    }
}
