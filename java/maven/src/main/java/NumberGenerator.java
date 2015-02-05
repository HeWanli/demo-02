import java.util.ArrayList;
import java.util.Random;
/**
 * Created by hewanli on 15-2-4.
 */
public class NumberGenerator {
    private final ArrayList<String> historyGenerateNumbers;
    private Random random;

    public NumberGenerator(Random random) {
        this.historyGenerateNumbers = new ArrayList<String>();
        this.random = random;
    }

    public String generate() {
        String digit = generateOnce();
        while (historyGenerateNumbers.contains(digit)){
            digit = generateOnce();
        }
        if(historyGenerateNumbers.size() == 2){
            historyGenerateNumbers.remove(0);
        }
        historyGenerateNumbers.add(digit);
        return digit;
    }

    public String generateOnce() {
        StringBuilder digits = new StringBuilder();
        while (digits.length() < 4){
            String num = String.valueOf(random.nextInt(10));
            if(digits.indexOf(num) == -1){
                digits.append(num);
            }
        }
        return digits.toString();
    }
}
