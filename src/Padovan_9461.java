import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Padovan_9461 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            long[] sequence = new long[101];
            System.out.println(padovan(sequence, n));

        }

    }

    static long padovan(long[] sequence, int n){
        if(sequence[n]!=0){
            return sequence[n];
        }
        if(n==1){
            sequence[n]=1;
            return 1;
        }else if(n==2){
            sequence[n]=1;
            return 1;
        }else if(n==3){
            sequence[n]=1;
            return 1;
        }else if(n==4){
            sequence[n]=2;
            return 2;
        }else if(n==5){
            sequence[n]=2;
            return 2;
        }else{
            sequence[n]=padovan(sequence, n-1) + padovan(sequence, n-5);
            return sequence[n];
        }

    }

}