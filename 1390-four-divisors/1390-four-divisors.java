class Solution {
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int maxi = nums[0];

        for (int i = 1; i < n; i++) {
            maxi = Math.max(maxi, nums[i]);
        }

        int[] spf = getSpf(maxi);
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            int val = nums[i];
            int divisorCount = 1;
            int distinctPrimes = 0;
            int p1 = 0, p2 = 0;
            int tempVal = val;
            
            while (tempVal > 1) {
                int s = spf[tempVal];
                int count = 0;
                while (tempVal % s == 0) {
                    tempVal /= s;
                    count++;
                }
                distinctPrimes++;
                if (distinctPrimes == 1) p1 = s;
                else if (distinctPrimes == 2) p2 = s;
                
                divisorCount *= (count + 1);
            }

            // Check if it has exactly 4 divisors
            if (divisorCount == 4) {
                if (distinctPrimes == 1) {
                    int p = p1;
                    totalSum += 1 + p + (p * p) + (p * p * p);
                } else if (distinctPrimes == 2) {
                    totalSum += 1 + p1 + p2 + val;
                }
            }
        }

        return totalSum;
    }

    public int[] getSpf(int n) {
        int[] spf = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            spf[i] = i;
        }

        for (int i = 2; i * i <= n; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    if (spf[j] == j) spf[j] = i;
                }
            }
        }

        return spf;
    }
}