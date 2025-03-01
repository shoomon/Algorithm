//25.03.01
//설계: 답 참조
//10:14 10:36 10:50
//수학 공부 하자...
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N;
        long sum=0, answer=0L;
        int[] nums;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            sum += nums[i];
        }

        for(int i = 0; i < N; i++){
            sum -= nums[i];
            answer += sum*nums[i];
        }

        System.out.println(answer);
    }
}