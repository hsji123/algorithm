package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hs_14501_Resign {

    static int[][] list;
    static int result;
    static int N;

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());

        list = new int[N][2];
        result = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " " );
            list[i][0] = Integer.parseInt(st.nextToken());
            list[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            dfs(i, 0);
        }

        System.out.println(result);

    }

    static void dfs(int i, int count){
        if(i>=N){
            return;
        }
        if(list[i][0]+i<=N){
            count+= list[i][1];
        }
        if(i+list[i][0]>=N){
            if(result<count){
                result = count;
            }
        }else{
            for(int j=i; j<N; j++){
                dfs(j+list[i][0], count);
            }
        }
    }

}
