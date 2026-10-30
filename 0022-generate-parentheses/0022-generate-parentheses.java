class Solution {
    public List<String> generateParenthesis(int n) {
         ArrayList<String> result = new ArrayList<>();
        // Start backtracking with an empty StringBuilder, 0 open, and 0 close brackets
        backtrack(result, new StringBuilder(), 0, 0, n); 

        return result;    
    }

    private void backtrack(ArrayList<String> result, StringBuilder current, int open, int close, int max) {
        // Base case: If the current string reaches the maximum length allowed
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // Decision 1: We can add an opening parenthesis if we haven't reached the limit 'A'
        if (open < max) {
            current.append("(");
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }

        // Decision 2: We can add a closing parenthesis if it doesn't exceed the opening ones
        if (close < open) {
            current.append(")");
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}