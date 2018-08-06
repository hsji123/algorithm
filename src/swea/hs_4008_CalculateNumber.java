package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class hs_4008_CalculateNumber {

    private static int N;
    private static int[] operatorCount;
    private static int[] list;
    private static int resultMax, resultMin;
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            operatorCount = new int[4];
            list = new int[N];
            resultMax = Integer.MIN_VALUE;
            resultMin = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<4; j++){
                int tmp = Integer.parseInt(st.nextToken());
                operatorCount[j] = tmp;
            }
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                list[j] = Integer.parseInt(st.nextToken());
            }

            dfs(0, list[0]);

            //System.out.println(resultMax + " " + resultMin + " " + (resultMax-resultMin));
            System.out.println("#"+(i+1)+ " " + (resultMax-resultMin));
        }

    }

    static void dfs(int count, int result){
        if(count==N-1){
            if(result>resultMax){
                resultMax = result;
            }
            if(result<resultMin){
                resultMin = result;
            }
            return;
        }
        for(int i=0; i<4; i++){
            if(operatorCount[i]!=0){
                operatorCount[i]--;
                int tmp = result;
                if(i==0){
                    result += list[count+1];
                }else if(i==1){
                    result -= list[count+1];
                }else if(i==2){
                    result *= list[count+1];
                }else if(i==3){
                    result /= list[count+1];
                }
                dfs(count+1, result);
                result = tmp;
                operatorCount[i]++;
            }

        }
    }

}
