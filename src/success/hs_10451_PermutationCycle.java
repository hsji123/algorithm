package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class hs_10451_PermutationCycle {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine(), " " );
            int N = Integer.parseInt(st.nextToken());
            int[] list = new int[N+1];
            int result = 0;
            st = new StringTokenizer(br.readLine(), " " );
            for(int j=1; j<=N; j++){
                list[j] = Integer.parseInt(st.nextToken());
                if(j==list[j]){
                    result++;
                    list[j]=0;
                }
            }

            for(int j=1; j<=N; j++){
                if(list[j]==0){
                    continue;
                }
                int tmp=0;
                ArrayList<Integer> arrayList = new ArrayList<>();
                while(tmp!=j){
                    if(tmp==0){
                        tmp = j;
                    }
                    tmp = list[tmp];
                    arrayList.add(tmp);
                    if(tmp==j){
                        result++;
                        for(int k=0; k<arrayList.size(); k++){
                            list[arrayList.get(k)]=0;
                        }
                    }
                }
            }

            System.out.println(result);
        }

    }


}