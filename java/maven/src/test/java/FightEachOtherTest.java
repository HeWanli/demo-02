import org.junit.Test;

import java.io.PrintStream;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by hewanli on 15-2-5.
 */
public class FightEachOtherTest {
    @Test
    public void should_first_fight_person_die() {
        Person zhangsan = new Person("zhangsan", 10, 4);
        Person lisi = new Person("lisi", 10, 4);
        PrintStream out = mock(PrintStream.class);
        new FightUtils(out).fightEachOther(zhangsan,lisi);
        verify(out).println("lisi被打败了.");
    }

    @Test
    public void should_be_alive_when_blood_is_more_than_0(){
        Person lisi = new Person("lisi",1,3);
        assertThat(lisi.isAlive()).isEqualTo(true);
    }
}
