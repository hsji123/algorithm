package success;

import java.util.Scanner;

public class hs_14499_RollingDice {

    private static int N, M, x, y, K;
    private static int[][] map;
    private static int[][] dice;


    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        x = sc.nextInt();
        y = sc.nextInt();
        K = sc.nextInt();

        map = new int[N][M];
        dice = new int[4][3];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int mission = 0;
        for(int i=0; i<K; i++){
            mission = sc.nextInt();
            //for(int k=0; k<4; k++){
            //    for(int l=0; l<3; l++){
            //        System.out.print(dice[k][l] + " ");
            //    }System.out.println();
            //}System.out.println();
            if(mission==1){ // 동
                if(y+1>=M){
                    continue;
                }else{
                    y+=1;
                }
            }else if(mission==2){ // 서
                if(y-1<0){
                    continue;
                }else{
                    y-=1;

                }
            }else if(mission==3){ // 북
                if(x-1<0){
                    continue;
                }else{
                    x-=1;

                }
            }else if(mission==4){ // 남
                if(x+1>=N){
                    continue;
                }else{
                    x+=1;

                }
            }
            //System.out.println("map : " + map[x][y]);
            rolling(mission);
            System.out.println(dice[1][1]);
            if(map[x][y]==0){
                map[x][y] = dice[3][1];
            }else{
                dice[3][1] = map[x][y];
                map[x][y] = 0;
            }
        }

    }

    static void rolling(int mission){
        int tmp = 0;
        if(mission==1){ // 동
            tmp = dice[1][2];
            dice[1][2] = dice[1][1];
            dice[1][1] = dice[1][0];
            dice[1][0] = dice[3][1];
            dice[3][1] = tmp;
        }else if(mission==2){ // 서
            tmp = dice[1][0];
            dice[1][0] = dice[1][1];
            dice[1][1] = dice[1][2];
            dice[1][2] = dice[3][1];
            dice[3][1] = tmp;
        }else if(mission==3){ // 북
            tmp = dice[0][1];
            dice[0][1] = dice[1][1];
            dice[1][1] = dice[2][1];
            dice[2][1] = dice[3][1];
            dice[3][1] = tmp;
        }else if(mission==4){ // 남
            tmp = dice[3][1];
            dice[3][1] = dice[2][1];
            dice[2][1] = dice[1][1];
            dice[1][1] = dice[0][1];
            dice[0][1] = tmp;
        }
    }
}
