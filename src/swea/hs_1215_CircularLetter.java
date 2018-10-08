package swea;

import java.util.Scanner;

class hs_1215_CircularLetter {

    static public void main(String[] args) {

        Solution solution = new Solution();

        String[][] tmp;

        solution.solution(new String[]{});
        //System.out.println(err);
    }

    static class Solution {

        static int result;
        static int T, N, M;
        static char[][] map;

        static public void solution(String[] args) {
            Scanner sc = new Scanner(System.in);

            //T = sc.nextInt();

            for(int t=1; t<=10; t++){
                result = 0;

                N = sc.nextInt();
                map = new char[8][8];

                for(int i=0; i<8; i++){
                    String tmp = sc.next();
                    for(int j=0; j<8; j++){
                        map[i][j] = tmp.charAt(j);
                    }
                }

                for(int i=0; i<8; i++){
                    for(int j=0; j<8; j++){
                        if(j<=8-N){
                            checkRow(j, i);
                        }
                        if(i<=8-N){
                            checkCol(j, i);
                        }
                    }
                }


                System.out.println("#"+t+" "+result);
            }


        }

        static void checkRow(int x, int y){
            boolean checkSame = true;
            for(int i=0; i<N/2; i++){
                if(map[y][x+i]==map[y][x+N-1-i] && checkSame){
                    checkSame = true;
                }else{
                    checkSame = false;
                }
            }
            if(checkSame){
                result++;
            }
        }

        static void checkCol(int x, int y){
            boolean checkSame = true;
            for(int i=0; i<N/2; i++){
                if(map[y+i][x]==map[y+N-1-i][x] && checkSame){
                    checkSame = true;
                }else{
                    checkSame = false;
                }
            }
            if(checkSame){
                result++;
            }
        }

    }

}



