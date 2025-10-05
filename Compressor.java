import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Compressor {
    public static String compress(String phrase) {
        if (phrase.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        char lastChar = phrase.charAt(0);
        int lastCount = 1;

        for (int i = 1; i < phrase.length(); i++) {
            char c = phrase.charAt(i);
            if (c != lastChar) {
                if (lastCount > 1) {
                    result.append(lastChar).append(lastCount);
                } else {
                    result.append(lastChar);
                }
                lastChar = c;
                lastCount = 1;
            } else {
                lastCount++;
            }
        }

       
        if (lastCount > 1) {
            result.append(lastChar).append(lastCount);
        } else {
            result.append(lastChar);
        }

        return result.toString();
    }

    @Test
    public void compress_1() {
        String result = compress("aaabbbccc");
        assertTrue(result.equals("a3b3c3"));
    }
}
