package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class hs_1003_Pibonacci {

    static int zero = 0;
    static int one = 0;
    static boolean[] count;
    static int[] count_zero;
    static int[] count_one;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++){
            zero = 0;
            one = 0;
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            count = new boolean[n+1];
            count_zero = new int[n+1];
            count_one = new int[n+1];
            fibonacci(n);
            System.out.println(zero + " " + one);
        }

    }

    static void fibonacci(int n) {

        if (n == 0) {
            count[0] = true;
            count_zero[0] = 1;
            //System.out.println("0");
            zero++;
            return;
        } else if (n == 1) {
            count[1] = true;
            count_one[1] = 1;
            //System.out.println("1");
            one++;
            return;
        } else {
            if(count[n]){
                zero += count_zero[n];
                one += count_one[n];
                return;
            }
            fibonacci(n-1);
            fibonacci(n-2);
            count[n] = true;
            count_zero[n] = zero;
            count_one[n] = one;
            return;
        }
    }

}