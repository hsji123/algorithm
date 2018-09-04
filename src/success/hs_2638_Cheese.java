package success;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hs_2638_Cheese {

    private static int N, M;
    private static int[][] map;
    private static int[][] mapFlag;
    private static int cheezeCount;
    private static int result;
    private static Queue<Node> queue;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        mapFlag = new int[N][M];
        queue = new LinkedList<Node>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j]==1){
                    cheezeCount++;
                }
            }
        }

        while(cheezeCount>0){
            checkAir();
            mapFlag = new int[N][M];
            checkCheeze();
            melting();
            /*for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    System.out.print(map[i][j]+ " ");
                }System.out.println();
            }System.out.println();*/
            result++;
        }

        System.out.println(result);

    }

    static void checkAir(){
        Node firstNode = new Node(0, 0);
        queue.offer(firstNode);
        map[firstNode.y][firstNode.x] = -1;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0; i<4; i++){
                int tmpX = node.x + dx[i];
                int tmpY = node.y + dy[i];
                if(tmpX>=0 && tmpX<M && tmpY>=0 && tmpY<N){
                    if((map[tmpY][tmpX]==0 || map[tmpY][tmpX]==-1) && mapFlag[tmpY][tmpX]==0){
                        mapFlag[tmpY][tmpX]=1;
                        map[tmpY][tmpX]=-1;
                        queue.offer(new Node(tmpX, tmpY));
                    }
                }
            }
        }
    }

    static void checkCheeze(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]==1){
                    int tmpCount=0;
                    for(int k=0; k<4; k++){
                        int tmpX = j + dx[k];
                        int tmpY = i + dy[k];
                        if(tmpX>=0 && tmpX<M && tmpY>=0 && tmpY<N){
                            if(map[tmpY][tmpX]==-1){
                                tmpCount++;
                            }

                        }
                    }
                    if(tmpCount>1){
                        mapFlag[i][j] = 1;
                    }
                }
            }
        }
    }

    static void melting(){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(mapFlag[i][j]==1){
                    cheezeCount--;
                    map[i][j]=0;
                    mapFlag[i][j]=0;
                }
            }
        }
    }
}
