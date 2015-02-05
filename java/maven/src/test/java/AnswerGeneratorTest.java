import org.junit.Test;

import java.util.HashSet;
import java.util.Random;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.fest.assertions.api.Fail.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

/**
 * Created by hewanli on 15-2-4.
 */
public class AnswerGeneratorTest {
    @Test
    public void should_be_a_digit(){
        String digit = new NumberGenerator(new Random()).generate();
        try {
            Integer.parseInt(digit);
        }catch (NumberFormatException e){
            fail("result should be a number.");
        }
    }

    @Test
    public void should_be_a_4_digit(){
        String digit = new NumberGenerator(new Random()).generate();
        assertThat(digit.length()).isEqualTo(4);
    }

    @Test
    public void should_generate_no_duplicate_digit(){
        String digit = new NumberGenerator(new Random()).generate();
        for (int i = 0; i < digit.length(); i++) {
            char ch = digit.charAt(i);
            assertThat(digit.indexOf(i)).isNotEqualTo(digit.lastIndexOf(ch));
        }
    }

    @Test
    public void should_not_repeat_in_3_times(){
        Random random = mock(Random.class);
        given(random.nextInt(10))
                .willReturn(1,2,3,4)
                .willReturn(1,2,3,4)
                .willReturn(2,3,4,5)
                .willReturn(3,4,5,6);

        NumberGenerator numberGenerator = new NumberGenerator(random);
        HashSet<String> digits = new HashSet<String>();
        digits.add(numberGenerator.generate());
        digits.add(numberGenerator.generate());
        digits.add(numberGenerator.generate());
        assertThat(digits.size()).isEqualTo(3);
    }

    @Test
    public void should_be_able_to_repeat_out_of_3_times(){
        Random random = mock(Random.class);
        given(random.nextInt(10))
                .willReturn(1,2,3,4)
                .willReturn(2,3,4,5)
                .willReturn(3,4,5,6)
                .willReturn(1,2,3,4)
                .willReturn(4,5,6,7);

        NumberGenerator numberGenerator = new NumberGenerator(random);
        HashSet<String> digits = new HashSet<String>();

        digits.add(numberGenerator.generate());
        digits.add(numberGenerator.generate());
        digits.add(numberGenerator.generate());
        digits.add(numberGenerator.generate());
        digits.add(numberGenerator.generate());
        assertThat(digits.size()).isEqualTo(4);
    }

    @Test
    public void tst_up_method() {
        Random random = mock(Random.class);
        given(random.nextInt(10))
                .willReturn(1,2,3,4)
                .willReturn(2,3,4,5)
                .willReturn(3,4,5,6)
                .willReturn(4,5,6,7);

        NumberGenerator numberGenerator = new NumberGenerator(random);
        HashSet<String> digits = new HashSet<String>();

        digits.add(numberGenerator.generate());
        digits.add(numberGenerator.generate());
        digits.add(numberGenerator.generate());
        assertThat(digits.size()).isEqualTo(3);
    }
}
