package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class hs_14502_Laboratory {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int result;
    static int[][] mapRef;
    static int[][] mapTest;
    static ArrayList<Virus> virus;

    static class Virus{
        int x;
        int y;

        Virus(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mapRef = new int[N][M];
        mapTest = new int[N][M];
        virus = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                mapRef[i][j] = Integer.parseInt(st.nextToken());
                mapTest[i][j] = mapRef[i][j];
                if(mapRef[i][j]==2){
                    virus.add(new Virus(j, i));
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(mapRef[i][j]==0){
                    mapRef[i][j] = 1;
                    setWall(j, i, 1);
                    mapRef[i][j] = 0;
                }else{
                    continue;
                }
            }
        }

        System.out.println(result);
    }


    static void setWall(int x, int y, int count){
        if(count==3){
            /*for(int i=0; i<N; i++){
                System.out.println();
                for(int j=0; j<M; j++){
                    System.out.print(mapRef[i][j] + " ");
                }
            }
            System.out.println(result);*/

            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    mapTest[j][k] = mapRef[j][k];
                }
            }

            for(int i=0; i<virus.size(); i++){
                int tmpX = virus.get(i).x;
                int tmpY = virus.get(i).y;
                breeding(tmpX, tmpY);

            }

            int resultTmp = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(mapTest[i][j]==0){
                        resultTmp++;
                    }
                }
            }
            if(resultTmp>result){
                result = resultTmp;
            }

            return;
        }
        for(int i=y; i<N; i++){
            for(int j=0; j<M; j++){
                if(mapRef[i][j]==0){
                    mapRef[i][j] = 1;
                    setWall(j, i, count+1);
                    mapRef[i][j] = 0;
                }else{
                    continue;
                }
            }
        }
    }

    static void breeding(int x, int y){
        for(int i=0; i<4; i++){
            int tmpX = x+dx[i];
            int tmpY = y+dy[i];
            if(tmpX>=0 && tmpX<M && tmpY>=0 && tmpY<N){
                if(mapTest[tmpY][tmpX]==0){
                    mapTest[tmpY][tmpX]=2;
                    breeding(tmpX, tmpY);
                }
            }
        }
    }
}
