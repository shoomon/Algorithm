//25.06.04
//16:14 16:40
//답 참조
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] home;
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = -1, left, right, mid;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        home = new int[N];

        for(int i = 0; i < N; i++){
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);

        left = 1;
        right = home[N-1];
        mid = left+(right-left)/2;

        while(left <= right){
            mid = left+(right-left)/2;
            if(check(mid)){
                left = mid+1;
                answer = mid;
            }else{
                right = mid-1;
            }
        }

        System.out.println(answer);
    }

    static boolean check(int dist){
        int count = 1;
        int last = home[0];

        for(int i = 1; i < N; i++){
            if(home[i]-last >= dist){
                last = home[i];
                count++;
            }
            if(count == C) return true;
        }
        return false;
    }
}
