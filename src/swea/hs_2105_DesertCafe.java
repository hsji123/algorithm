package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hs_2105_DesertCafe {

    private static int N;
    private static int[][] map;
    private static int[] desertFalg;
    private static int resultMax;
    private static int startX, startY;

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());

        for(int i=1; i<=T; i++){
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            desertFalg = new int[101];
            resultMax = -1;
            map = new int[N][N];
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int k=0; k<N; k++){
                    map[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(j!=0 || k!=0){
                        startX = k;
                        startY = j;
                        dfs(k, j, 0, 0, 0, false);
                    }
                }
            }

            System.out.println("#"+i+" "+resultMax);
        }

    }

    static void dfs(int x, int y, int result, int downRight, int downLeft, boolean back){
        if(x<0 || x>=N || y<0 || y>=N){
            return;
        }
        if(!(startX==x && startY==y)){
            if(desertFalg[map[y][x]]==1){
                return;
            }
        }
        if(back){
            if(downRight!=0){
                desertFalg[map[y][x]] = 1;
                dfs(x-1, y-1, result+1, downRight-1, downLeft, true);
                desertFalg[map[y][x]] = 0;
            }else if(downLeft!=0){
                desertFalg[map[y][x]] = 1;
                dfs(x+1, y-1, result+1, downRight, downLeft-1, true);
                desertFalg[map[y][x]] = 0;
            }else if(downRight==0 && downLeft==0){
                if(startX==x && startY==y){
                    if(result>resultMax){
                        resultMax=result;
                    }
                }
            }
        }else{
            if(result==0){
                desertFalg[map[y][x]] = 1;
                dfs(x+1, y+1, result+1, downRight+1, downLeft, false);
                desertFalg[map[y][x]] = 0;
            }else{
                if(downRight!=0 && downLeft!=0){
                    desertFalg[map[y][x]] = 1;
                    dfs(x-1, y+1, result+1, downRight, downLeft+1, false);
                    dfs(x-1, y-1, result+1, downRight-1, downLeft, true);
                    desertFalg[map[y][x]] = 0;
                }else{
                    desertFalg[map[y][x]] = 1;
                    dfs(x+1, y+1, result+1, downRight+1, downLeft, false);
                    dfs(x-1, y+1, result+1, downRight, downLeft+1, false);
                    desertFalg[map[y][x]] = 0;
                }
            }
        }
    }

}
