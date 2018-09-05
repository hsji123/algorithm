package swea;

import java.util.Scanner;

public class hs_4014_AirstripBuild {

    private static int T, N, X;
    private static int[][] map;
    private static int[] resultCheck;
    private static int result;

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int t=1; t<=T; t++){
            N = sc.nextInt();
            X = sc.nextInt();

            map = new int[N][N];
            result = 0;
            resultCheck = new int[40];

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            for(int i=0; i<N; i++){
                int[] line = new int[N];
                for(int j=0; j<N; j++){
                    line[j] = map[i][j];
                }
                checking(0, line, i, false);
            }

            for(int j=0; j<N; j++){
                int[] line = new int[N];
                for(int i=0; i<N; i++){
                    line[i] = map[i][j];
                }
                checking(0, line, j+20, false);

            }

            System.out.println("#" + t + " " + result);
        }
    }

    static void checking(int position, int[] line, int resultNumber, boolean bridge){
        //System.out.println(resultNumber + " ");
        if(position==N-1){
            //for(int i=0; i<N; i++){
            //    System.out.print(line[i] + " " );
            //}System.out.println();
            if(resultCheck[resultNumber]==0){
                resultCheck[resultNumber]=1;
                result++;
            }
        }else{
            //올라가는 경사
            if(position+X<N && !bridge) {
                {
                    boolean slope = true;
                    for (int i = 0; i < X; i++) {
                        if (line[position] == line[position + i]) {
                            slope = true;
                        } else {
                            slope = false;
                            break;
                        }
                    }
                    if (slope) {
                        if (line[position] == line[position + X] - 1) {
                            //System.out.println(position + " up");
                            checking(position + X, line, resultNumber, false);
                        }
                    }
                }
            }
            if(position+X<N){
                //내려가는 경사
                {
                    boolean slope = true;
                    for(int i=1; i<=X; i++){
                        if(line[position]==line[position+i]+1){
                            slope = true;
                        }else{
                            slope = false;
                            break;
                        }
                    }
                    if(slope){
                        //System.out.println(position + " down");
                        if(position+X==N-1){
                            checking(position+X, line, resultNumber, false);
                        }else if(position+X+1<N){
                            if(line[position+X] == line[position+X+1]) {
                                checking(position + X + 1, line, resultNumber, false);
                            }else{
                                checking(position + X, line, resultNumber, true);
                            }
                        }
                    }
                }
            }
            //경사 없음
            {
                if(line[position]==line[position+1]){
                    //System.out.println(position + " maintain");
                    checking(position+1, line, resultNumber, false);
                }
            }
        }
    }

}
