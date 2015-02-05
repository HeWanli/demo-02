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
        assertThat(lisi.getBlood()).isNotEqualTo(6);
    }
}
