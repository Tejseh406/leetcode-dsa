class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int low =0 , high = 0;

        for(int weight:weights){
            low = Math.max(weight,low);
            high += weight;
        }

        int ans = -1;

        while(low <= high){
            int mid = low  + (high - low)/2;

            if(check(weights, n, days, mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public static  boolean check(int[] w, int n , int k , int m){
        int d = 0;
        int wt = 1;
        for(int i=0;i<n;i++){
            d += w[i];

            if(d > m){
                d = w[i];
                wt++;
                if(wt > k) return false;
            }
        }

        return true;
    }
}