//25.02.26
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sum=0, diff = 100;

        for(int i = 0; i < 10; i++){
            int cur = sc.nextInt();
            if(Math.abs(sum+cur-100) <= diff){
                diff = Math.abs(sum+cur-100);
                sum += cur;
            }else{
                break;
            }
        }
        System.out.println(sum);
    }
}