package swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hs_2117_HomeSecurityService {

    private static int T, N, M;
    private static int[][] map;
    private static int[][] range;
    private static int[][] rangeVisited;
    private static int result;
    private static int maxCost;
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

        T = sc.nextInt();

        for(int t=1; t<=T; t++){
            N = sc.nextInt();
            M = sc.nextInt();

            queue = new LinkedList<>();
            map = new int[N][N];
            range = new int[41][41];
            rangeVisited = new int[41][41];
            range[20][20] = 1;
            maxCost = 0;
            result = 0;

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    map[i][j] = sc.nextInt();
                    if(map[i][j]==1){
                        maxCost+=M;
                    }
                }
            }

            int cost = 0;
            int k=0;
            while(cost<=maxCost){
                k++;
                cost = k*k + (k-1)*(k-1);
            }

            for(int a=1; a<k; a++){
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        rangeVisited = new int[41][41];
                        bfs(j, i, a*a+(a-1)*(a-1));
                    }
                }

                rangeVisited = new int[41][41];
                expansionBfs(20, 20);
            }

            System.out.println("#" + t + " " + result);
        }
    }

    static void bfs(int x, int y, int maxCost){
        int resultHouse = 0;
        Node firstNode = new Node(20, 20);
        queue.offer(firstNode);
        rangeVisited[20][20] = 1;
        if(map[y][x]==1){
            resultHouse++;
        }

        while (!queue.isEmpty()){
            Node node = queue.poll();
            for(int i=0; i<4; i++){
                int tmpX = node.x + dx[i];
                int tmpY = node.y + dy[i];
                if(tmpX>=0 && tmpX<41 && tmpY>=0 && tmpY<41){
                    if(range[tmpY][tmpX]==1 && rangeVisited[tmpY][tmpX]==0){
                        rangeVisited[tmpY][tmpX]=1;
                        int mapTmpX = x + tmpX - 20;
                        int mapTmpY = y + tmpY - 20;
                        if(mapTmpX>=0 && mapTmpX<N && mapTmpY>=0 && mapTmpY<N){
                            if(map[mapTmpY][mapTmpX]==1){
                                resultHouse++;
                            }
                            queue.offer(new Node(tmpX, tmpY));
                        }
                    }
                }
            }
        }

        if(maxCost<=resultHouse*M){
            if(resultHouse>result){
                //System.out.println(" maxCost : " + maxCost + " resultHoust*M" + resultHouse*M);
                result = resultHouse;
            }
        }

    }

    static void expansionBfs(int x, int y){
        Node firstNode = new Node(x, y);
        queue.offer(firstNode);
        rangeVisited[y][x] = 1;

        while (!queue.isEmpty()){
            Node node = queue.poll();

            for(int i=0; i<4; i++){
                int tmpX = node.x + dx[i];
                int tmpY = node.y + dy[i];
                if(tmpX>=0 && tmpX<41 && tmpY>=0 && tmpY<41){
                    if(range[tmpY][tmpX]==0){
                        range[tmpY][tmpX]=-1;
                    }else if(range[tmpY][tmpX]==1 && rangeVisited[tmpY][tmpX]==0){
                        rangeVisited[tmpY][tmpX] = 1;
                        queue.offer(new Node(tmpX, tmpY));
                    }
                }
            }
        }

        for(int i=0; i<41; i++){
            for(int j=0; j<41; j++){
                if(range[i][j]==-1){
                    range[i][j]=1;
                }
            }
        }
    }
}
