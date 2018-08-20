package success;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hs_2146_MakeBridge {

    private static int N;
    private static int[][] map;
    private static int[][] mapCopy;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static Queue<Node> queue;
    private static int result = 999;
    private static int resultMin = 999;
    private static int nextFlag = 0;

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

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        queue = new LinkedList<>();

        N = sc.nextInt();

        map = new int[N][N];
        mapCopy = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        int islandCount = 2;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==1) {
                    bfs(new Node(j, i, islandCount));
                    islandCount++;
                }
            }
        }

        /*for(int a=0; a<N; a++){
            System.out.println();
            for(int b=0; b<N; b++){
                System.out.print(map[a][b]+" ");
            }
        }System.out.println();*/

        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                mapCopy[i][j] = map[i][j];
            }
        }


        for(int i=2; i<islandCount; i++){
            queue = new LinkedList<>();
            nextFlag = 0;
            int bridgeCount = 1;
            result = 999;

            for(int j=0; j<N; j++) {
                for (int k = 0; k < N; k++) {
                    map[j][k] = mapCopy[j][k];
                }
            }

            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(map[j][k]==i) {
                        while(result==999) {
                            building(new Node(k, j, i), bridgeCount);
                            bridgeCount++;

                            for(int a=0; a<N; a++){
                                for(int b=0; b<N; b++){
                                    if(map[a][b]==-1){
                                        map[a][b]=i;
                                    }
                                }
                            }

                            /*for(int a=0; a<N; a++){
                                System.out.println();
                                for(int b=0; b<N; b++){
                                    System.out.print(map[a][b]+" ");
                                }
                            }System.out.println();*/

                        }
                    }
                    if(resultMin>result-1){
                        resultMin = result-1;
                    }
                    if(result!=999){
                        nextFlag = 1;
                    }
                    if(nextFlag==1){
                        break;
                    }
                }

                if(nextFlag==1){
                    break;
                }
            }

        }

        System.out.println(resultMin);

    }

    static void building(Node firstNode, int bridgeCount){
        queue.offer(firstNode);
        Node node;
        while(!queue.isEmpty()){
            node = queue.poll();

            for(int i=0; i<4; i++){
                int tmpX = node.x + dx[i];
                int tmpY = node.y + dy[i];

                if(tmpX>=0 && tmpX<N && tmpY>=0 && tmpY<N){
                    if(map[tmpY][tmpX]==firstNode.count){
                        queue.offer(new Node(tmpX, tmpY, node.count));
                        map[tmpY][tmpX] = -1;
                    } else if (map[tmpY][tmpX]==0) {
                        map[tmpY][tmpX] = -1;
                    } else if (map[tmpY][tmpX] >= 2 && map[tmpY][tmpX] != node.count) {
                        result = bridgeCount;
                        //System.out.println("count : " + node.count + " result : " + result);
                        queue = new LinkedList<>();
                        return;
                    }
                }
            }
        }
    }

    static void bfs(Node firstNode){
        queue.offer(firstNode);
        map[firstNode.y][firstNode.x] = firstNode.count;
        Node node;
        while(!queue.isEmpty()){
            node = queue.poll();
            for(int i=0; i<4; i++){
                int tmpX = node.x + dx[i];
                int tmpY = node.y + dy[i];

                if(tmpX>=0 && tmpX<N && tmpY>=0 && tmpY<N && map[tmpY][tmpX]==1){
                    queue.offer(new Node(tmpX, tmpY, node.count));
                    map[tmpY][tmpX] = firstNode.count;
                }
            }
        }
    }

}
