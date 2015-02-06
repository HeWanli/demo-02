import org.junit.Test;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by hewanli on 15-2-5.
 */
public class PersonTest {
    @Test
    public void should_reduce_blood_who_was_fighted(){
        Person zhangsan = new Person("zhangsan",10,4);
        Person lisi = new Person("lisi",10,4);
        zhangsan.fight(lisi);
        assertThat(lisi.getBlood()).isEqualTo(6);
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
