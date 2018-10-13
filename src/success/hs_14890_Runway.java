package success;

import java.util.Scanner;

public class hs_14890_Runway {

    static int N, M;
    static int result;
    static int[][] map;



    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int[] subMap = new int[N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                subMap[j] = map[i][j];
            }
            check(-1, subMap);
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                subMap[j] = map[j][i];
            }
            check(-1, subMap);
        }

        System.out.println(result);
    }

    static boolean check(int x, int[] subMap){
        boolean resultTmp = false;

        if(x==N-1){
            result++;
            return true;
        }

        {// 직진
            if(x==-1){
                resultTmp = check(0, subMap);
            }else{
                if(subMap[x]==subMap[x+1]){
                    resultTmp = check(x+1, subMap);
                }
            }
        }

        if(resultTmp){
            return true;
        }

        {// 상승
            if(sameHeight(x+1, subMap) && (x==-1 || subMap[x]==subMap[x+1])){
                subMap[x+M]+=1;
                resultTmp = check(x+M, subMap);
            }
        }

        if(resultTmp){
            return true;
        }

        {// 하강
            if(sameHeight(x+1, subMap) && (x!=-1 && subMap[x]==subMap[x+1]+1)){
                resultTmp = check(x+M, subMap);
            }
        }

        if(resultTmp){
            return true;
        }else{
            return false;
        }
    }

    static boolean sameHeight(int x, int[] subMap){
        int height = subMap[x];
        for(int i=x+1; i<x+M; i++){
            if(i==subMap.length){
                return false;
            }
            if(height!=subMap[i]){
                return false;
            }
        }
        return true;
    }
}
