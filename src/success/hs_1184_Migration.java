package success;

import java.util.Scanner;

public class hs_1184_Migration {

    private static int N;
    private static int[][] map;
    private static int[][] mapFlag;
    private static int[] mapCount;
    private static int result = 0;


    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                //왼쪽위, 오른쪽 아래
                mapFlag = new int[N][N];
                mapCount = new int[1250001];
                int x1 = j;
                int y1 = i;
                int x2 = j+1;
                int y2 = i+1;
                for(int m=y1; m>=0; m--){
                    for(int n=x1; n>=0; n--){
                        if(m!=y1){
                            if(n==x1){
                                mapFlag[m][n] = map[m][n] + mapFlag[m+1][n]; // 본인 + 아랫줄
                            }else{
                                mapFlag[m][n] = map[m][n] + mapFlag[m+1][n] + mapFlag[m][n+1] - mapFlag[m+1][n+1]; // 본인 + 아랫줄 + 오른쪽합 - 중복제거
                            }
                        }else{
                            if(n==x1){
                                mapFlag[m][n] = map[m][n]; // 본인(시작점)
                            }else{
                                mapFlag[m][n] = map[m][n] + mapFlag[m][n+1]; // 본인 + 오른쪽합
                            }
                        }
                        if(mapFlag[m][n]<=625000 && mapFlag[m][n]>=-625000)
                            mapCount[mapFlag[m][n]+625000]++;
                    }
                }

                for(int m=y2; m<N; m++){
                    for(int n=x2; n<N; n++){
                        if(m!=y2){
                            if(n==x2){
                                mapFlag[m][n] = map[m][n] + mapFlag[m-1][n]; // 본인 + 윗줄
                            }else{
                                mapFlag[m][n] = map[m][n] + mapFlag[m-1][n] + mapFlag[m][n-1] - mapFlag[m-1][n-1]; // 본인 + 윗줄 + 왼쪽합 - 중복제거
                            }
                        }else{
                            if(n==x2){
                                mapFlag[m][n] = map[m][n]; // 본인(시작점)
                            }else{
                                mapFlag[m][n] = map[m][n] + mapFlag[m][n-1]; // 본인 + 왼쪽합
                            }
                        }
                        if(mapFlag[m][n]<=625000 && mapFlag[m][n]>=-625000)
                            if(mapCount[mapFlag[m][n]+625000]!=0)
                                result += mapCount[mapFlag[m][n]+625000];
                    }
                }

                //왼쪽아래, 오른쪽 위
                mapFlag = new int[N][N];
                mapCount = new int[1250001];
                x1 = j;
                y1 = i;
                x2 = j+1;
                y2 = i-1;

                for(int m=y1; m<N; m++){
                    for(int n=x1; n>=0; n--){
                        if(m!=y1){
                            if(n==x1){
                                mapFlag[m][n] = map[m][n] + mapFlag[m-1][n]; // 본인 + 윗줄
                            }else{
                                mapFlag[m][n] = map[m][n] + mapFlag[m-1][n] + mapFlag[m][n+1] - mapFlag[m-1][n+1]; // 본인 + 윗줄 + 오른쪽합 - 중복제거
                            }
                        }else{
                            if(n==x1){
                                mapFlag[m][n] = map[m][n]; // 본인(시작점)
                            }else{
                                mapFlag[m][n] = map[m][n] + mapFlag[m][n+1]; // 본인 + 오른쪽합
                            }
                        }
                        if(mapFlag[m][n]<=625000 && mapFlag[m][n]>=-625000)
                            mapCount[mapFlag[m][n]+625000]++;
                    }
                }

                for(int m=y2; m>=0; m--){
                    for(int n=x2; n<N; n++){
                        if(m!=y2){
                            if(n==x2){
                                mapFlag[m][n] = map[m][n] + mapFlag[m+1][n]; // 본인 + 아랫줄
                            }else{
                                mapFlag[m][n] = map[m][n] + mapFlag[m+1][n] + mapFlag[m][n-1] - mapFlag[m+1][n-1]; // 본인 + 아랫줄 + 왼쪽합 - 중복제거
                            }
                        }else{
                            if(n==x2){
                                mapFlag[m][n] = map[m][n]; // 본인(시작점)
                            }else{
                                mapFlag[m][n] = map[m][n] + mapFlag[m][n-1]; // 본인 + 왼쪽합
                            }
                        }
                        if(mapFlag[m][n]<=625000 && mapFlag[m][n]>=-625000)
                            if(mapCount[mapFlag[m][n]+625000]!=0)
                                result += mapCount[mapFlag[m][n]+625000];
                    }
                }
            }
        }

        System.out.println(result);

    }
}