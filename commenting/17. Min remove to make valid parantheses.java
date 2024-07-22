
class Solution
{
    public String minRemoveToMakeValid(String s) 
    {
        // Indexes of all open parentheses that have not match yet.
        Stack<Integer> openParentheses = new Stack<>();
        // Indexes of all parentheses that should be removed.
        Set<Integer> removeIndexes = new HashSet<>();

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
            {
                openParentheses.push(i);
            }
            else if (s.charAt(i) == ')')
            {
                // If there is an open parenthesis, match with the last one and remove it.
                // Else it should be removed.
                if (!openParentheses.isEmpty())
                {
                    openParentheses.pop();
                }
                else
                {
                    removeIndexes.add(i);
                }
            }
        }
        
        // If any open parentheses remain, they should be removed. 
        while(!openParentheses.isEmpty())
            removeIndexes.add(openParentheses.pop());

        // Remove all indexes in removeIndexes set and build the answer.
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < s.length(); i++)
        {
            if(removeIndexes.contains(i)) continue;
            answer.append(s.charAt(i));
        }
            
        return answer.toString();
    }
}