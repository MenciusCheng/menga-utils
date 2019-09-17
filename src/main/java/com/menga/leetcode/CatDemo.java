package com.menga.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Marvel on 2019/9/16.
 */
public class CatDemo {

    public int superEggDrop(int K, int N) {
        if (K == 1) {
            return N > 0 ? N : 1;
        } else if (N == 1) {
            return 1;
        } else {
            return 1 + superEggDrop(K - 1, N / 2 - 1);
        }
    }

    public int superEggDrop2(int K, int N) {
        // Right now, dp[i] represents dp(1, i)
        int[] dp = new int[N+1];
        for (int i = 0; i <= N; ++i)
            dp[i] = i;

        for (int k = 2; k <= K; ++k) {
            // Now, we will develop dp2[i] = dp(k, i)
            int[] dp2 = new int[N+1];
            int x = 1;
            for (int n = 1; n <= N; ++n) {
                // Let's find dp2[n] = dp(k, n)
                // Increase our optimal x while we can make our answer better.
                // Notice max(dp[x-1], dp2[n-x]) > max(dp[x], dp2[n-x-1])
                // is simply max(T1(x-1), T2(x-1)) > max(T1(x), T2(x)).
                while (x < n && Math.max(dp[x-1], dp2[n-x]) > Math.max(dp[x], dp2[n-x-1]))
                    x++;

                // The final answer happens at this x.
                dp2[n] = 1 + Math.max(dp[x-1], dp2[n-x]);
            }

            dp = dp2;
        }
        return dp[N];
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = n + m - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p >= 0) {
            if (p1 >= 0 && p2 >= 0) {
                nums1[p] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
            } else if (p1 >= 0) {
                nums1[p] = nums1[p1--];
            } else if (p2 >= 0) {
                nums1[p] = nums2[p2--];
            }
            p--;
        }
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int half = nums.length / 2;
        for (Integer n : nums) {
            int value;
            if (map.containsKey(n)) {
                value = map.get(n) + 1;
            } else {
                value = 1;
            }
            if (value > half) {
                return n;
            }
            map.put(n, value);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new CatDemo().superEggDrop2(2, 6));
        System.out.println(new CatDemo().superEggDrop2(2, 4));
        System.out.println(new CatDemo().superEggDrop2(3, 14));

    }
}
