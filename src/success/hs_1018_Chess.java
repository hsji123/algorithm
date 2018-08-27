package success;

import java.util.Scanner;

public class hs_1018_Chess {

    private static int N, M;
    private static char[][] map;
    private static int[][] mapWhite;
    private static int[][] mapBlack;
    private static int[][] mapWhiteCount;
    private static int[][] mapBlackCount;
    private static int result;


    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new char[N][M];
        mapWhite = new int[N][M];
        mapBlack = new int[N][M];
        mapWhiteCount = new int[N][M];
        mapBlackCount = new int[N][M];
        result = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            String tmp = sc.next();
            for(int j=0; j<M; j++){
                map[i][j] = tmp.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]=='W'){
                    if((i+j)%2==0){
                        mapBlack[i][j]=1;
                    }else{
                        mapWhite[i][j]=1;
                    }
                }else{
                    if((i+j)%2==0){
                        mapWhite[i][j]=1;
                    }else{
                        mapBlack[i][j]=1;
                    }
                }
            }
        }

        /*System.out.println();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(mapWhite[i][j] + " ");
            }
            System.out.print("    ");
            for(int j=0; j<M; j++){
                System.out.print(mapBlack[i][j] + " ");
            }System.out.println();
        }
        System.out.println();*/

        for(int i=0; i<N-7; i++){
            for(int j=0; j<M; j++){
                int whiteCount = 0;
                int blackCount = 0;
                for(int k=0; k<8; k++){
                    whiteCount+=mapWhite[i+k][j];
                    blackCount+=mapBlack[i+k][j];
                }
                mapWhiteCount[i][j]=whiteCount;
                mapBlackCount[i][j]=blackCount;
            }
        }

        /*for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(mapWhiteCount[i][j] + " ");
            }
            System.out.print("    ");
            for(int j=0; j<M; j++){
                System.out.print(mapBlackCount[i][j] + " ");
            }System.out.println();
        }
        System.out.println();*/

        for(int i=0; i<N-7; i++){
            for(int j=0; j<M-7; j++){
                int whiteCount = 0;
                int blackCount = 0;
                for(int k=0; k<8; k++){
                    whiteCount+=mapWhiteCount[i][j+k];
                    blackCount+=mapBlackCount[i][j+k];
                }

                if(whiteCount<result){
                    result = whiteCount;
                }
                if(blackCount<result){
                    result = blackCount;
                }
            }
        }

        System.out.println(result);
    }

}
