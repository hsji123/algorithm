package swea;

import java.util.Scanner;

class hs_1216_CircularLetter2 {

    static public void main(String[] args) {

        Solution solution = new Solution();

        String[][] tmp;

        solution.solution(new String[]{});
        //System.out.println(err);
    }

    static class Solution {

        static int result;
        static int T;
        static char[][] map;

        static public void solution(String[] args) {
            Scanner sc = new Scanner(System.in);


            for(int t=1; t<=10; t++){
                T = sc.nextInt();
                result = 1;
                map = new char[100][100];

                for(int i=0; i<100; i++){
                    String mapStr = sc.next();
                    for(int j=0; j<100; j++){
                        map[i][j] = mapStr.charAt(j);
                    }
                }

                for(int i=0; i<100; i++){
                    for(int j=0; j<100; j++){
                        if(j<=100-result){
                            checkRow(j, i);
                        }
                        if(i<=100-result){
                            checkCol(j, i);
                        }
                    }
                }


                System.out.println("#"+t+" "+result);
            }
        }

        static void checkRow(int x, int y){
            for(int i=100-x; i>result; i--){ // 전체길이 긴것부터 검사
                boolean checkSame = true;
                for(int j=0; j<i/2; j++){ // 길이별로 검사
                    if(map[y][x+j]==map[y][x+i-1-j] && checkSame){
                        checkSame = true;
                    }else{
                        checkSame = false;
                        break;
                    }
                }
                if(checkSame){
                    result = i;
                    break;
                }
            }
        }

        static void checkCol(int x, int y){
            for(int i=100-y; i>result; i--){ // 전체길이 긴것부터 검사
                boolean checkSame = true;
                for(int j=0; j<i/2; j++){ // 길이별로 검사
                    if(map[y+j][x]==map[y+i-1-j][x] && checkSame){
                        checkSame = true;
                    }else{
                        checkSame = false;
                        break;
                    }
                }
                if(checkSame){
                    result = i;
                    break;
                }
            }
        }

    }

}