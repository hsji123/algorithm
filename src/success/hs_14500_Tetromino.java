package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hs_14500_Tetromino {

    static int[][] map;
    static int result = 0;

    static Tetromino[] tetrominoList;

    static class Tetromino{
        int[] x;
        int[] y;

        Tetromino(int[] x, int[] y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        tetrominoList = new Tetromino[19];
        tetrominoList[0] = new Tetromino(new int[]{0, 1, 2, 3}, new int[]{0, 0, 0, 0});
        tetrominoList[1] = new Tetromino(new int[]{0, 1, 0, 1}, new int[]{0, 0, 1, 1});
        tetrominoList[2] = new Tetromino(new int[]{0, 0, 0, 1}, new int[]{0, 1, 2, 2});
        tetrominoList[3] = new Tetromino(new int[]{0, 1, 2, 0}, new int[]{0, 0, 0, 1});
        tetrominoList[4] = new Tetromino(new int[]{0, 1, 1, 1}, new int[]{0, 0, 1, 2});
        tetrominoList[5] = new Tetromino(new int[]{0, 1, 2, 2}, new int[]{0, 0, 0, -1});
        tetrominoList[6] = new Tetromino(new int[]{0, 1, 1, 1}, new int[]{0, 0, -1, -2});
        tetrominoList[7] = new Tetromino(new int[]{0, 1, 2, 2}, new int[]{0, 0, 0, 1});
        tetrominoList[8] = new Tetromino(new int[]{0, 1, 0, 0}, new int[]{0, 0, 1, 2});
        tetrominoList[9] = new Tetromino(new int[]{0, 0, 1, 2}, new int[]{0, 1, 1, 1});
        tetrominoList[10] = new Tetromino(new int[]{0, 0, 1, 1}, new int[]{0, 1, 1, 2});
        tetrominoList[11] = new Tetromino(new int[]{0, 1, 1, 0}, new int[]{0, 0, -1, 1});
        tetrominoList[12] = new Tetromino(new int[]{0, 1, 1, 2}, new int[]{0, 0, -1, -1});
        tetrominoList[13] = new Tetromino(new int[]{0, 1, 1, 2}, new int[]{0, 0, 1, 1});
        tetrominoList[14] = new Tetromino(new int[]{0, 1, 1, 2}, new int[]{0, 0, 1, 0});
        tetrominoList[15] = new Tetromino(new int[]{0, 1, 1, 1}, new int[]{0, 0, -1, 1});
        tetrominoList[16] = new Tetromino(new int[]{0, 1, 1, 2}, new int[]{0, 0, -1, 0});
        tetrominoList[17] = new Tetromino(new int[]{0, 0, 0, 1}, new int[]{0, 1, 2, 1});
        tetrominoList[18] = new Tetromino(new int[]{0, 0, 0, 0}, new int[]{0, 1, 2, 3});

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " " );
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                for(int k=0; k<19; k++) {
                    int tmp = 0;
                    for(int p=0; p<4; p++){
                        int x = j + tetrominoList[k].x[p];
                        int y = i + tetrominoList[k].y[p];
                        if(x<0 || x>=M || y<0 || y>=N){
                            tmp = 0;
                            break;
                        }else{
                            tmp += map[y][x];
                        }
                    }
                    if(tmp>result){
                        result = tmp;
                    }
                }
                //System.out.println("x : " + j + " y : " + i + " result : " + result);
            }
        }

        System.out.println(result);
    }

}
