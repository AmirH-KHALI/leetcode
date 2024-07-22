import java.util.*;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String s = input.next();
        String t = input.next();
        Solution solution = new Solution()
        System.out.println(solution.minWindow(s, t));
    }
}

class Solution {
    public String minWindow(String s, String t)
    {
        Map<Character, Integer> map = new HashMap<>(); // Using map to store number of each character


        for (int i = 0; i < t.length(); ++i) // Initializing the map
        {
            Character tChar = t.charAt(i);
            int count = map.getOrDefault(tChar, 0);
            map.put(tChar, count + 1);
        }

        int tCharacterCount = map.size();
        int lIndex = 0; // Start index of current state
        int rIndex = 0; // End index of currect state
        int lAns = -1; // Start index of answer
        int rAns = -1; // End index of answer

        while (rIndex <= s.length())
        {
            if (tCharacterCount > 0) // When these is a character in t, not in s
            {
                if (rIndex == s.length())
                    break;
                rIndex++;
                Character sChar = s.charAt(rIndex - 1);
                if (map.containsKey(sChar))
                {
                    int count = map.get(sChar);
                    if (count == 1) // s find enough cChar character
                        tCharacterCount--;
                    map.put(sChar, count - 1); // Updating map
                }
            }
            else // When all t character there is in s
            {
                int currWindow = rIndex - lIndex;
                int answer = rAns - lAns;
                if (lAns == -1 || currWindow < answer) // Update the answer when current state is better
                {
                    lAns = lIndex;
                    rAns = rIndex;
                }
                lIndex++;
                Character sChar = s.charAt(lIndex - 1);
                if (map.containsKey(sChar)) // Updating the map
                {
                    int count = map.get(sChar);
                    if (count == 0)
                        tCharacterCount++;
                    map.put(sChar, count + 1);
                }
            }
        }
        if (lAns == -1) // It means there is no anweo
            return "";
        else
            return s.substring(lAns, rAns);
    }
}
