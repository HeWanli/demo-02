/**
 * Created by hewanli on 15-2-3.
 */
public class CompareNumber {
    public String compare(String input, String answer) {
        int a_count = 0,b_count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.contains(String.valueOf(answer.charAt(i)))){
                b_count++;
            }
            if(input.charAt(i)==answer.charAt(i)){
                a_count++;
            }
        }
        return a_count+"A"+(b_count-a_count)+"B";
    }
}
