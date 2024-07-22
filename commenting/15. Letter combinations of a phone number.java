class Solution
{
    private List<String> combinations = new ArrayList<>(); // Using list for all combinantions of the answer
    private Map<Character, String> letters = Map.of(
        '2', "abc", '3', "def", '4', "ghi", '5', "jkl", 
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
    private String phoneDigits;
    
    public List<String> letterCombinations(String digits)
    {

        if (digits.length() == 0) // If we dont have any digits -> the answer is empty
        {
            return combinations;
        }
        phoneDigits = digits;
        backtrack(0, new StringBuilder()); // Generate all the answers
        return combinations;
    }
    
    private void backtrack(int index, StringBuilder path) // Generate all the answers recursively
    {

        if (path.length() == phoneDigits.length()) // W find a combinantion -> adding to combinantions
        {
            combinations.add(path.toString());
            return;
        }
        

        String possibleLetters = letters.get(phoneDigits.charAt(index));
        for (char letter: possibleLetters.toCharArray()) // For all possible character for current number
        {
            path.append(letter); // Adding the letter to our path
            backtrack(index + 1, path); // Find all possible combinantions with this letter
            path.deleteCharAt(path.length() - 1); // Deleteing the last character of path
        }
    }
}