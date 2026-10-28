class Solution {
    public List<String> generateParenthesis(int n) {
          ArrayList<String> ls = new ArrayList<>();

        solve("",0,0,ls,n);

        return ls;
    }

    public static void solve(String s, int open, int close, ArrayList<String> ls, int n){
        if(s.length() == 2*n){
            ls.add(s);
            return;
        }

        if(open < n)
            solve(s+"(",open+1, close, ls, n);

        if(open > close)
            solve(s + ")",open,close+1, ls , n);
    }
}