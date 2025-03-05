//25.03.05
//설계: 5분
//구현: 5분
//12:25 12:30 12:35
//문자열 길이 최대 1000자 -> 그냥 순차 탐색 아님?
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] ucpc = {'U','C','P','C'};
        char[] str = br.readLine().toCharArray();
        int index = 0;

        for(int i = 0; i < str.length && index < 4; i++){
            if(str[i] == ucpc[index]) index++;
        }

        if(index == 4){
            System.out.println("I love UCPC");
        }else{
            System.out.println("I hate UCPC");
        }
    }
}
