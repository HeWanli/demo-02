import org.junit.Test;
import org.mockito.InOrder;

import java.io.PrintStream;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

/**
 * Created by hewanli on 15-2-5.
 */
public class FightEachOtherTest {
    @Test
    public void should_second_fight_person_die() {
        Person zhangsan = mock(Person.class);
        Person lisi = mock(Person.class);
        given(zhangsan.getName()).willReturn("张三");
        given(lisi.getName()).willReturn("李四");

        given(zhangsan.fight(lisi)).willReturn("张三出击.");
        given(lisi.fight(zhangsan)).willReturn("李四出击.");
        given(zhangsan.isAlive()).willReturn(true,true,true);
        given(lisi.isAlive()).willReturn(true,true,false);
        PrintStream out = mock(PrintStream.class);
        InOrder inOrder = inOrder(out);

        new FightUtils(out).fightEachOther(zhangsan,lisi);
        inOrder.verify(out).println("张三出击.");
        inOrder.verify(out).println("李四出击.");
        inOrder.verify(out).println("张三出击.");
        inOrder.verify(out).println("李四出击.");
        inOrder.verify(out).println("张三出击.");
        inOrder.verify(out).println("李四被打败了.");
    }

    @Test
    public void should_first_fight_person_die(){
        Person zhangsan = mock(Person.class);
        Person lisi = mock(Person.class);
        given(zhangsan.getName()).willReturn("张三");
        given(zhangsan.fight(lisi)).willReturn("张三出击.");
        given(lisi.fight(zhangsan)).willReturn("李四出击.");
        given(zhangsan.isAlive()).willReturn(true, false);
        given(lisi.isAlive()).willReturn(true, true);
        PrintStream out = mock(PrintStream.class);
        new FightUtils(out).fightEachOther(zhangsan,lisi);
        InOrder inOrder = inOrder(out);

        inOrder.verify(out).println("张三出击.");
        inOrder.verify(out).println("李四出击.");
        inOrder.verify(out).println("张三被打败了.");
    }
}
