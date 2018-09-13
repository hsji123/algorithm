package success;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hs_1600_HorseMonkey {

    private static int K, W, H;
    private static int[][] map;
    private static int[][][] mapVisited;
    private static Queue<Node> queue;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static int[] hx = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};

    static class Node{
        int x;
        int y;
        int move;
        int k;
        int beforeMove;

        Node(int x, int y, int move, int k, int beforeMove){
            this.x = x;
            this.y = y;
            this.move = move;
            this.k = k;
            this.beforeMove = beforeMove;
        }
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();

        map = new int[H][W];
        mapVisited = new int[200][200][31];
        queue = new LinkedList<>();

        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j]==1){
                    for(int a=0; a<=30; a++)
                        mapVisited[i][j][a] = -1;
                }else{
                    for(int a=0; a<=30; a++)
                        mapVisited[i][j][a] = Integer.MAX_VALUE;
                }
            }
        }

        bfs();

        int result = Integer.MAX_VALUE;
        for(int i=0; i<=30; i++){
            if(result>mapVisited[H-1][W-1][i]){
                result = mapVisited[H-1][W-1][i];
            }
        }

        System.out.println(result==Integer.MAX_VALUE? -1 : result);

    }

    static void bfs(){
        Node firstNode = new Node(0,0, 0, K, Integer.MAX_VALUE);
        for(int a=0; a<=30; a++)
            mapVisited[0][0][a] = -1;
        queue.offer(firstNode);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            //System.out.println(node.x + " " + node.y + " " + node.move + " " + node.k);
            for(int i=0; i<4; i++){
                int tmpX = node.x + dx[i];
                int tmpY = node.y + dy[i];
                if(tmpX>=0 && tmpX<W && tmpY>=0 && tmpY<H){
                    boolean tmp = true;
                    for(int j=node.k; j<=30; j++){
                        if(node.move+1>=mapVisited[tmpY][tmpX][j]){
                            tmp = false;
                            break;
                        }
                    }
                    if(tmp){
                        queue.offer(new Node(tmpX, tmpY, node.move+1, node.k, mapVisited[tmpY][tmpX][node.k]));
                        mapVisited[tmpY][tmpX][node.k]=node.move+1;
                    }
                }
            }

            if(node.k>0){
                for(int i=0; i<8; i++){
                    int tmpX = node.x + hx[i];
                    int tmpY = node.y + hy[i];
                    if(tmpX>=0 && tmpX<W && tmpY>=0 && tmpY<H){
                        boolean tmp = true;
                        for(int j=node.k-1; j<=30; j++){
                            if(node.move+1>=mapVisited[tmpY][tmpX][j]){
                                tmp = false;
                                break;
                            }
                        }
                        if(tmp){
                            queue.offer(new Node(tmpX, tmpY, node.move+1, node.k-1, mapVisited[tmpY][tmpX][node.k]));
                            mapVisited[tmpY][tmpX][node.k-1]=node.move+1;
                        }
                    }
                }
            }
        }
    }
}


/*

1
4 4
0 1 1 1
0 0 1 1
1 0 1 1
1 1 1 0


 */