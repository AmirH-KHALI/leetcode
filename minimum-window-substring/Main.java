import java.util.*;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String s = input.next();
        String t = input.next();
        Solution solution = new Solution();
        System.out.println(solution.minWindow(s, t));
    }
}

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            Character c = t.charAt(i);
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        int tCharacterCount = map.size();
        int l = 0;
        int r = 0;
        int lAns = -1;
        int rAns = -1;

        while (r <= s.length()) {
            if (tCharacterCount > 0) {
                if (r == s.length()) break;
                r++;
                Character c = s.charAt(r - 1);
                if (!map.containsKey(c)) continue;

                int count = map.get(c);
                if (count == 1) tCharacterCount--;
                map.put(c, count - 1);
            } else {
                if (lAns == -1 || rAns - lAns > r - l) {
                    lAns = l;
                    rAns = r;
                }

                l++;
                Character c = s.charAt(l - 1);
                if (!map.containsKey(c)) continue;

                int count = map.get(c);
                if (count == 0) tCharacterCount++;
                map.put(c, count + 1);
            }
        }
        if (lAns == -1) {
            return "";
        } else {
            return s.substring(lAns, rAns);
        }
    }
}