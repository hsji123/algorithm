package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hs_1952_Swimming {

    private static int N;
    private static int[] charge;
    private static int[] calendar;
    private static int result = 0;

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());

        for(int i=1; i<=T; i++){
            result = Integer.MAX_VALUE;
            charge = new int[4];
            calendar = new int[13];

            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<4; j++){
                charge[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=1; j<=12; j++){
                calendar[j] = Integer.parseInt(st.nextToken());
            }

            dfs(1, 0);

            System.out.println("#"+i+" "+result);
        }

    }

    static void dfs(int month, int resultTmp){
        if(month>12){
            if(resultTmp<result){
                result = resultTmp;
            }
        }else{
            {// 1일권
                dfs(month+1, resultTmp+charge[0]*calendar[month]);
            }
            {// 1달권
                dfs(month+1, resultTmp+charge[1]);
            }
            {// 3달권
                dfs(month+3, resultTmp+charge[2]);
            }

            if(month==1){// 1년권
                dfs(month+12, resultTmp+charge[3]);
            }
        }
    }
}

