import java.util.*;

public class CommonPrefixFinder {

    public static String findLongestCommonPrefix(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return "";
        }

        Collections.sort(strings);
        String first = strings.get(0);
        String last = strings.get(strings.size() - 1);
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            result.append(first.charAt(i));
            i++;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(findLongestCommonPrefix(Arrays.asList("fadyfadd", "fady faddoul", "fady_faddoul@hotmail.com"))); 
        System.out.println(findLongestCommonPrefix(Arrays.asList(""))); 
        System.out.println(findLongestCommonPrefix(Arrays.asList("fadyfadd"))); 
    }
}
