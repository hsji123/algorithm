package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class hs_4012_Cook {

    static int N;
    static int[][] list;
    static int result;
    static int result1;
    static int result2;
    static int maxCount;
    static int[] listFlag;

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            list = new int[N][N];
            listFlag = new int[N];

            result = Integer.MAX_VALUE;
            result1 = 0;
            result2 = 0;

            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int k=0; k<N; k++){
                    list[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            maxCount = N/2;
            for(int j=0; j<N; j++){
                listFlag[j]=1;
                dfs(j, 1);
                listFlag[j]=0;
            }

            System.out.println("#"+(i+1)+" " +result);

        }
    }

    static void dfs(int beforeNumber, int count){
        if(count==maxCount){
            result1 = 0;
            result2 = 0;
            calculate();
        }else{
            for(int i=beforeNumber+1; i<N; i++){
                listFlag[i]=1;
                dfs(i, count+1);
                listFlag[i]=0;
            }
        }

    }

    static int calculate(){
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int i=0; i<N; i++){
            if(listFlag[i]==1){
                list1.add(i);
            }else{
                list2.add(i);
            }
        }
/*
        System.out.println("listFlag");
        for(int i=0; i<N; i++){
            System.out.print(listFlag[i] + " ");
        }
        System.out.println();
        System.out.println("list1");
        for(int i=0; i<N/2; i++){
            System.out.print(list1.get(i) + " ");
        }
        System.out.println();
        System.out.println("list2");
        for(int i=0; i<N/2; i++){
            System.out.print(list2.get(i) + " ");
        }
        System.out.println();
*/
        for(int i=0; i<N/2; i++){
            for(int j=i+1; j<N/2; j++){
                result1 += list[list1.get(i)][list1.get(j)] + list[list1.get(j)][list1.get(i)];
                result2 += list[list2.get(i)][list2.get(j)] + list[list2.get(j)][list2.get(i)];
            }
        }

        //System.out.println("result1 : " + result1 + " result2 : " + result2);

        int resultTmp = 0;
        if(result1>result2){
            resultTmp = result1 - result2;
        }else{
            resultTmp = result2 - result1;
        }
        if(resultTmp< result){
            result =resultTmp;
        }

        return  0;
    }

}
