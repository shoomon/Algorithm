//25.04.20
//모듈러 없이
import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int length = elements.length;
        HashSet<Integer> set = new HashSet<>();
        
        // 배열을 두 배로 복사
        int[] doubled = new int[length * 2];
        for(int i = 0; i < length * 2; i++) {
            doubled[i] = elements[i % length];
        }

        // 시작 인덱스 i에서 길이 j만큼의 부분합 계산
        for(int i = 0; i < length; i++) {
            int sum = 0;
            for(int j = 1; j <= length; j++) {
                sum += doubled[i + j - 1];
                set.add(sum);
            }
        }
        
        return set.size();
    }
}
