package success;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hs_12100_Easy2048 {

    static int N;
    static int result;
    static int[][] map;

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        rotation(0);

        System.out.println(result);
    }

    static void rotation(int count){
        if(count==5){
            int max = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j]>max){
                        max = map[i][j];
                    }
                }
            }
            if(max>result)
                result = max;
            return;
        }



        for(int k=0; k<4; k++){
            int[][] mapCopy = new int[N][N];
            for(int i=0; i<N; i++) {
                for (int j = 0; j < N; j++) {
                    mapCopy[i][j] = map[i][j];
                }
            }

            tilting(k);

            rotation(count+1);

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    map[i][j] = mapCopy[i][j];
                }
            }
        }

    }

    static void tilting(int direction){
        Queue<Integer> queue = new LinkedList<>();
        if(direction==0){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j]!=0){
                        queue.offer(map[i][j]);
                    }
                    map[i][j] = 0;
                }

                int x = 0;
                while (!queue.isEmpty()){
                    int number = queue.poll();
                    if(map[i][x]==0){
                        map[i][x] = number;
                    }else if(map[i][x]==number){
                        map[i][x] += number;
                        x++;
                    }else{
                        x++;
                        map[i][x] = number;
                    }
                }
            }
        }else if(direction==1){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[j][i]!=0){
                        queue.offer(map[j][i]);
                    }
                    map[j][i] = 0;
                }
                int y = 0;
                while (!queue.isEmpty()){
                    int number = queue.poll();
                    if(map[y][i]==0){
                        map[y][i] = number;
                    }else if(map[y][i]==number){
                        map[y][i] += number;
                        y++;
                    }else{
                        y++;
                        map[y][i] = number;
                    }
                }
            }
        }else if(direction==2){
            for(int i=0; i<N; i++){
                for(int j=N-1; j>=0; j--){
                    if(map[i][j]!=0){
                        queue.offer(map[i][j]);
                    }
                    map[i][j] = 0;
                }
                int x = N-1;
                while (!queue.isEmpty()){
                    int number = queue.poll();
                    if(map[i][x]==0){
                        map[i][x] = number;
                    }else if(map[i][x]==number){
                        map[i][x] += number;
                        x--;
                    }else{
                        x--;
                        map[i][x] = number;
                    }
                }
            }
        }else if(direction==3){
            for(int i=0; i<N; i++){
                for(int j=N-1; j>=0; j--){
                    if(map[j][i]!=0){
                        queue.offer(map[j][i]);
                    }
                    map[j][i] = 0;
                }
                int y = N-1;
                while (!queue.isEmpty()){
                    int number = queue.poll();
                    if(map[y][i]==0){
                        map[y][i] = number;
                    }else if(map[y][i]==number){
                        map[y][i] += number;
                        y--;
                    }else{
                        y--;
                        map[y][i] = number;
                    }
                }
            }
        }

    }

}
