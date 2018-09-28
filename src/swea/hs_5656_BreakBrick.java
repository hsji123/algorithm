package swea;

import java.util.Scanner;

class hs_5656_BreakBrick {

    static public void main(String[] args) {

        Solution solution = new Solution();

        solution.solution(new String[]{});
        //System.out.println(err);
    }

    static class Solution {

        static int T, N, W, H;
        static int[][] map;
        static int[][] mapCopy;
        static int result;
        static int[] dx = {0, 1, 0 ,-1};
        static int[] dy = {1, 0 ,-1, 0};

        static public void solution(String[] args) {
            Scanner sc = new Scanner(System.in);

            T = sc.nextInt();

            for(int t=1; t<=T; t++){
                result = Integer.MAX_VALUE;
                N = sc.nextInt();
                W = sc.nextInt();
                H = sc.nextInt();

                map = new int[H][W];

                for(int i=0; i<H; i++){
                    for(int j=0; j<W; j++){
                        map[i][j] = sc.nextInt();
                    }
                }

                dfs(1);

                System.out.println("#"+t+ " " +result);
            }


        }


        static void dfs(int count){
            if(count>N){
                countBlock();
                return;
            }
            for(int i=0; i<W; i++){
                int[][] mapCopy = new int[H][W];
                for(int h=0; h<H; h++){
                    for(int w=0; w<W; w++){
                        mapCopy[h][w] = map[h][w];
                    }
                }

                int y = 0;
                for(int a=0; a<H; a++){
                    if(map[a][i]!=0){
                        y = a;
                        break;
                    }
                }
                shootBlock(i, y, map[y][i]);
                downBlock();
                dfs(count+1);
                for(int h=0; h<H; h++){
                    for(int w=0; w<W; w++){
                        map[h][w] = mapCopy[h][w];
                    }
                }
                mapCopy = null;
            }
        }

        static void shootBlock(int x, int y, int power){
            if(map[y][x]==1){
                map[y][x] = 0;
            }else{
                map[y][x] = 0;
                for(int i=0; i<4; i++){
                    for(int j=power-1; j>0; j--){
                        if(y+dy[i]*j>=0 && y+dy[i]*j<H && x+dx[i]*j>=0 && x+dx[i]*j<W){
                            int tmpPower = map[y+dy[i]*j][x+dx[i]*j];
                            map[y+dy[i]*j][x+dx[i]*j] = 0;
                            shootBlock(x+dx[i]*j, y+dy[i]*j, tmpPower);
                        }
                    }
                }
            }
        }

        static void downBlock(){
            for(int j=0; j<W; j++){
                for(int i=H-1; i>0; i--){
                    if(map[i][j]==0){
                        int checkCount = 0;
                        while(map[i][j]==0){
                            for(int k=i; k>0; k--){
                                map[k][j] = map[k-1][j];
                            }
                            map[0][j] = 0;
                            checkCount++;
                            if(checkCount>H){
                                break;
                            }
                        }
                    }
                }
            }
        }

        static void countBlock(){
            int count = 0;
            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    if(map[i][j]!=0){
                        count++;
                    }
                }
            }
            if(result>count){
                result = count;
            }

        }

    }


}

