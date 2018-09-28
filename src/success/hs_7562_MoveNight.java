package success;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hs_7562_MoveNight {

    private static int T, N;
    private static int[][] map;
    private static int[][] mapVisited;
    private static int result;
    private static Queue<Node> queue;
    private static int[] hx = {1, 2, 2, 1, -1, -2, -2, -1};
    private static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};

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

        T = sc.nextInt();

        for(int t=0; t<T; t++){
            N = sc.nextInt();
            map = new int[N][N];
            mapVisited = new int[N][N];
            queue = new LinkedList<>();

            int y1 = sc.nextInt();
            int x1 = sc.nextInt();

            map[y1][x1] = 1;

            int y2 = sc.nextInt();
            int x2 = sc.nextInt();

            if(y1==y2 && x1==x2){
                System.out.println(0);
                continue;
            }
            map[y2][x2] = 2;
            bfs(x1, y1);

            System.out.println(result);
        }

    }

    static void bfs(int x, int y){
        Node firstNode = new Node(x, y ,0);
        queue.offer(firstNode);
        mapVisited[y][x]=1;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0; i<8; i++){
                int tmpX = node.x + hx[i];
                int tmpY = node.y + hy[i];

                if(tmpX>=0 && tmpX<N && tmpY>=0 && tmpY<N){
                    if(map[tmpY][tmpX]==0 && mapVisited[tmpY][tmpX]==0){
                        mapVisited[tmpY][tmpX]=1;
                        queue.offer(new Node(tmpX, tmpY, node.count+1));
                    }else if(map[tmpY][tmpX]==2){
                        result = node.count+1;
                        return;
                    }
                }
            }

        }
    }
}