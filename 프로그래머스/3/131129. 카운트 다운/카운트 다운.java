//25.04.20
//18:20
//최소한의 다트 -> 싱글 또는 불 최대
//다트판 1~20점, 현재 선택 다음번 시행에 영향을 줌 -> DP

import java.util.*;

class Solution {
    public int[] solution(int target) {
        int[][] dp = new int[target + 1][2]; // [0]: 최소 다트 수, [1]: 싱글/불 개수

        for (int i = 1; i <= target; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }

        List<Integer> scores = new ArrayList<>();
        Set<Integer> singleOrBull = new HashSet<>();

        for (int i = 1; i <= 20; i++) {
            scores.add(i);
            scores.add(i * 2);
            scores.add(i * 3);
            singleOrBull.add(i);
        }
        scores.add(50);
        singleOrBull.add(50);

        for (int i = 1; i <= target; i++) {
            for (int s : scores) {
                if (i - s < 0) continue;

                int total = dp[i - s][0] + 1;
                int singles = dp[i - s][1] + (singleOrBull.contains(s) ? 1 : 0);

                if (total < dp[i][0]) {
                    dp[i][0] = total;
                    dp[i][1] = singles;
                } else if (total == dp[i][0]) {
                    dp[i][1] = Math.max(dp[i][1], singles);
                }
            }
        }

        return dp[target];
    }
}
