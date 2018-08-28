package swea;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class hs_1953_RunningMan {
    private static int T, N, M, R, C, L, result;
    private static int[][] map, mapFlag;
    private static int[][] tunnelIn = {{0, 0, 0, 0},{1, 1, 1, 1}, {0, 1, 0, 1}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 1, 1}, {1, 0, 0, 1}, {1, 1, 0, 0}};
    private static int[][] tunnelOut = {{0, 0, 0, 0},{1, 1, 1, 1}, {0, 1, 0, 1}, {1, 0, 1, 0}, {1, 0, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 1, 1}};
    private static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    private static Queue<Node> queue;
    static class Node{
        int x;
        int y;
        int time;
        Node(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int t=1; t<=T; t++){
            N = sc.nextInt();M = sc.nextInt();
            R = sc.nextInt();C = sc.nextInt();
            L = sc.nextInt();
            map = new int[N][M];
            mapFlag = new int[N][M];
            queue = new LinkedList<Node>();
            result = 1;
            for(int i=0; i<N; i++)
                for(int j=0; j<M; j++)
                    map[i][j] = sc.nextInt();
            mapFlag[R][C] = 1;
            bfs(C, R);
            System.out.println("#"+t + " " +result);
        }
    }
    static void bfs(int x, int y){
        queue.offer(new Node(x, y, 1));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.time==L) continue;
            for(int i=0; i<4; i++){
                int tmpX = node.x + dx[i];
                int tmpY = node.y + dy[i];
                if(tmpX>=0 && tmpX<M && tmpY>=0 && tmpY<N)
                    if(mapFlag[tmpY][tmpX]==0)
                        if(tunnelOut[map[node.y][node.x]][i]==1)
                            if(tunnelIn[map[tmpY][tmpX]][i]==1){
                                mapFlag[tmpY][tmpX]=1;
                                queue.offer(new Node(tmpX, tmpY, node.time+1));
                                result++;
                            }
            }
        }
    }
}