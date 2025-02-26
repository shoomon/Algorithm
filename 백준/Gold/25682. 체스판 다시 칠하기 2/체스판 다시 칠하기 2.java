//25.02.27
//설계: 분
//구현: 분
//12:16
//누적합 공식 다시 보기
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N, M, K, max=0, min=Integer.MAX_VALUE;
        char[][] map;
        int[][] sum;
        boolean flag = false;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[N+1][M+1];
        sum = new int[N+1][M+1];

        for(int i = 1; i < N+1; i++){
            char[] c = br.readLine().toCharArray();
            for(int j = 1; j < M+1; j++){
                map[i][j] = c[j-1];
            }
        }

        for(int i = 1; i < N+1; i++){
            for(int j = 1; j < M+1; j++){
                if(flag && map[i][j] == 'B'){
                    sum[i][j] = 1;
                }else if(!flag && map[i][j] == 'W'){
                    sum[i][j] = 1;
                }
                flag = !flag;
            }
            if(M%2 == 0) flag = !flag;
        }

        for(int i = 0; i < N+1; i++){
            for(int j = 0; j < M; j++){
                sum[i][j+1] += sum[i][j];
            }
        }

        for(int j = 0; j < M+1; j++){
            for(int i = 0; i < N; i++){
                sum[i+1][j] += sum[i][j];
            }
        }

//        for(int i = 0; i < N-1; i++){
//            for(int j = 0; j < M-1; j++){
//                sum[i+1][j+1] += sum[i+1][j] + sum[i][j+1] - sum[i][j];
//            }
//        }
//
//        for(int i = 0; i < N+1; i++){
//            for(int j = 0; j < M+1; j++){
//                System.out.print(sum[i][j]+" ");
//            }
//            System.out.println();
//        }

        for(int i = K; i < N+1; i++){
            for(int j = K; j < M+1; j++){
                int dup = sum[i-K][j]+sum[i][j-K]-sum[i-K][j-K];
//                System.out.println(sum[i-K][j]+" "+sum[i][j-K]+" "+sum[i-K][j-K]);
                min = Math.min(min, sum[i][j]-dup);
                max = Math.max(max, sum[i][j]-dup);
            }
        }

//        System.out.println(min+" "+max);

        System.out.println(Math.min(min, K*K-max));

    }
}