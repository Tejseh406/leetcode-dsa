class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> ls = new ArrayList<>();

       for(int i=0;i<=rowIndex;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j == 0 || j == i){
                    temp.add(1);
                }else{
                    int val = ls.get(i-1).get(j-1) + ls.get(i-1).get(j);
                    temp.add(val);
                }
            }
            ls.add(temp);
       }

       return ls.get(rowIndex);
    }
}