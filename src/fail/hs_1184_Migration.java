package fail;

import java.util.Scanner;

public class hs_1184_Migration {

    private static int N;
    private static int result;
    private static int[][] map;
    private static int[][] mapFlag;
    private static int[][] mapFlag2;


    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new int[N][N];
        mapFlag = new int[N][N];
        mapFlag2 = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        //직사각형 시작점 정하는 포문
        for(int u=0; u<N; u++){
            for(int v=0; v<N-1; v++){

                mapFlag = new int[N][N];
                //직사각형 만드는 포문
                for(int i=u; i<N; i++){
                    for(int j=v; j<N-1; j++){
                        //직사각형의 합을 저장해둠
                        if(i!=u){
                            if(j==v){
                                mapFlag[i][j] = map[i][j] + mapFlag[i-1][j]; // 본인 + 아랫줄
                            }else{
                                mapFlag[i][j] = map[i][j] + mapFlag[i-1][j] + mapFlag[i][j-1] - mapFlag[i-1][j-1]; // 본인 + 아랫줄 + 왼쪽합 - 중복제거
                            }
                        }else{
                            if(j==v){
                                mapFlag[i][j] = map[i][j]; // 본인(시작점)
                            }else{
                                mapFlag[i][j] = map[i][j] + mapFlag[i][j-1]; // 본인 + 왼쪽합
                            }
                        }

                        /*for(int p=0; p<N; p++){
                            System.out.println();
                            for(int q=0; q<N; q++){
                                System.out.print(mapFlag[p][q] + " ");
                            }
                        }System.out.println();*/
                        mapFlag2 = new int[N][N];
                        //오른쪽 위
                        {
                            //두번째 직사각형 만드는 포문
                            for(int y=u-1; y>=0; y--){
                                for(int x=j+1; x<N; x++){
                                    if(y!=i-1){
                                        if(x==j+1){
                                            mapFlag2[y][x] = map[y][x] + mapFlag2[y+1][x];
                                        }else{
                                            mapFlag2[y][x] = map[y][x] + mapFlag2[y+1][x] + mapFlag2[y][x-1] - mapFlag2[y+1][x-1];
                                        }
                                    }else{
                                        if(x==j+1){
                                            mapFlag2[y][x] = map[y][x];
                                        }else{
                                            mapFlag2[y][x] = map[y][x] + mapFlag2[y][x-1];
                                        }
                                    }

                                    if(mapFlag[i][j] == mapFlag2[y][x]){
                                        //System.out.println("1 (j, i) : " + j + ", " + i + " = " + mapFlag[i][j] + " (x, y) : " + x + ", " + y + " = " + mapFlag2[y][x]);
                                        result++;
                                    }
                                }
                            }
                        }

                        mapFlag2 = new int[N][N];
                        //오른쪽 아래
                        {
                            //두번째 직사각형 만드는 포문
                            for(int y=i+1; y<N; y++){
                                for(int x=j+1; x<N; x++){
                                    if(y!=i+1){
                                        if(x==j+1){
                                            mapFlag2[y][x] = map[y][x] + mapFlag2[y-1][x];
                                        }else{
                                            mapFlag2[y][x] = map[y][x] + mapFlag2[y-1][x] + mapFlag2[y][x-1];
                                        }
                                    }else{
                                        if(x==j+1){
                                            mapFlag2[y][x] = map[y][x];
                                        }else{
                                            mapFlag2[y][x] = map[y][x] + mapFlag2[y][x-1];
                                        }
                                    }

                                    if(mapFlag[i][j] == mapFlag2[y][x]){
                                        //System.out.println("2 (j, i) : " + j + ", " + i + " = " + mapFlag[i][j] + " (x, y) : " + x + ", " + y + " = " + mapFlag2[y][x]);
                                        result++;
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }

        System.out.println(result);



    }

}
