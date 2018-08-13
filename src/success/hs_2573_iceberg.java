package success;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hs_2573_iceberg {

    private static int N, M;
    private static int[][] map;
    private static int[][] mapCheck;
    private static Queue<Node> queue;
    private static int result;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    static class Node{
        int x;
        int y;
        int count;

        Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String arg[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        queue = new LinkedList<>();
        result = 0;

        for(int i=0 ; i<N; i++){
            for(int j=0; j<M; j++){
                if (i == 0 || i == N - 1 || j == 0 || j == M - 1){
                    map[i][j] = 0;
                }map[i][j] = sc.nextInt();
            }
        }

        int count = 1;

        mapCheck = new int[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]>0 && mapCheck[i][j]==0){
                    bfs(new Node(j,i,count++));
                }
            }
        }

        if(count>2){
            System.out.println(result);
            return;
        }

        while(count<=2){
            count = 1;
            result++;
            mapCheck = new int[N][M];
            melting();
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j]>0 && mapCheck[i][j]==0){
                        bfs(new Node(j,i,count++));
                    }
                }
            }

            /*
            for(int i=0 ;i<N; i++){
                System.out.println();
                for(int j=0; j<M; j++){
                    System.out.print(map[i][j] + " ");
                }System.out.print("    ");
                for(int j=0; j<M; j++){
                    System.out.print(mapCheck[i][j] + " ");
                }
            }System.out.println();
            */

            int sum = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    sum+=map[i][j];
                }
            }
            if(sum==0){
                result=0;
                break;
            }
        }

        System.out.println(result);

    }

    static void melting(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==0){
                    for(int k=0; k<4; k++){
                        int tmpX = j + dx[k];
                        int tmpY = i + dy[k];
                        if(tmpX>=0 && tmpX<M && tmpY>=0 && tmpY<N){
                            if(map[tmpY][tmpX]>0){
                                if(map[tmpY][tmpX]==1){
                                    map[tmpY][tmpX]=-1;
                                }else{
                                    map[tmpY][tmpX]--;
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++) {
                if(map[i][j]==-1){
                    map[i][j]=0;
                }
            }
        }

    }

    static void bfs(Node firstNode){
        queue.offer(firstNode);
        mapCheck[firstNode.y][firstNode.x] = firstNode.count;
        Node node;
        while(!queue.isEmpty()){
            node = queue.poll();
            //System.out.println(node.x + " " + node.y + " " + node.count);

            for(int i=0; i<4; i++){
                int tmpX = node.x + dx[i];
                int tmpY = node.y + dy[i];

                if(tmpX>=0 && tmpX<M && tmpY>=0 && tmpY<N && map[tmpY][tmpX]>0 && mapCheck[tmpY][tmpX]==0){
                    queue.offer(new Node(tmpX, tmpY, node.count));
                    mapCheck[tmpY][tmpX] = firstNode.count;
                }
            }
        }
    }

}
