class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();

        for(char c:s.toCharArray()){
            if(!st.isEmpty() && Math.abs(c - st.peek()) == 32){
                st.pop();
            }else{
                st.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.insert(0, st.pop());
        }
        
        return result.toString();
    }
}