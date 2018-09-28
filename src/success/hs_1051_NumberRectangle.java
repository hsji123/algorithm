package success;

import java.util.Scanner;

public class hs_1051_NumberRectangle {

    private static int N, M;
    private static int[][] map;
    private static int result;

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        result = 1;
        
        for(int i=0 ;i<N; i++){
            String tmp = sc.next();
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(String.valueOf(tmp.charAt(j)));
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int width = 1;
                while(i+width<N && j+width<M){
                    if(map[i][j]==map[i][j+width] && map[i][j]==map[i+width][j] && map[i][j]==map[i+width][j+width]){
                        if((width+1)*(width+1)>result){
                            result = (width+1)*(width+1);
                        }
                    }
                    width++;
                }
            }
        }

        System.out.println(result);

    }

}