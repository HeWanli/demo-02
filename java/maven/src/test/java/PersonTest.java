import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by hewanli on 15-2-5.
 */
public class PersonTest {
    @Test
    public void should_reduce_blood_who_was_fighted_and_print_details(){
        Person zhangsan = new Person("张三",10,4);
        Person lisi = new Person("李四",10,4);
        String details = zhangsan.fight(lisi);
        assertThat(lisi.getBlood()).isEqualTo(6);
        assertThat(details).isEqualTo("张三攻击了李四,李四受到了4点伤害,剩余生命:6");
    }

    @Test
    public void should_be_alive_when_blood_is_more_than_0(){
        Person lisi = new Person("lisi",1,3);
        assertThat(lisi.isAlive()).isEqualTo(true);
    }

    @Test
    public void should_be_die_when_blood_is_equals_0(){
        Person lisi = new Person("lisi",0,3);
        assertThat(lisi.isAlive()).isEqualTo(false);
    }

    @Test
    public void should_be_die_when_blood_is_less_than_0(){
        Person lisi = new Person("lisi",-2,3);
        assertThat(lisi.isAlive()).isEqualTo(false);
    }
}
