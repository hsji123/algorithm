package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hs_1012_cabbage {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] farm;
    static int result = 0;
    static int M;
    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());

        for(int t=0; t<T; t++){
            result=0;
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int bCount = Integer.parseInt(st.nextToken());

            farm = new int[N][M];
            for(int i=0; i<bCount; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                farm[y][x] = 1;
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(farm[i][j]==1){
                        bfs(j, i);
                        result++;
                    }
                }
            }

            System.out.println(result);

        }

    }

    static void bfs(int x, int y){
        farm[y][x] = 2;
        for(int i=0; i<4; i++){
            int tmpX = x+dx[i];
            int tmpY = y+dy[i];
            if(tmpX>=0 && tmpX<M && tmpY>=0 && tmpY<N){
                if(farm[tmpY][tmpX]==1){
                    bfs(tmpX, tmpY);
                }
            }
        }
    }
}
