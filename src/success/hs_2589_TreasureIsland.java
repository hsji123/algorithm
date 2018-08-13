package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hs_2589_TreasureIsland {

    private static int N, M;
    private static char[][] map;
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        queue = new LinkedList<>();

        for(int i=0 ; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String tmp = st.nextToken();
            for(int j=0; j<M; j++){
                map[i][j] = tmp.charAt(j);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]=='L'){
                    mapCheck = new int[N][M];
                    int tmpResult = bfs(new Node(j,i,0));
                    if(tmpResult>result){
                        result = tmpResult;
                    }
                }
            }
        }

        System.out.println(result);

    }

    static int bfs(Node firstNode){
        queue.offer(firstNode);
        mapCheck[firstNode.y][firstNode.x] = 1;
        Node node;
        Node farNode = new Node(0, 0, 0);
        int farCount=0;
        while(!queue.isEmpty()){
            node = queue.poll();
            //System.out.println(node.x + " " + node.y + " " + node.count);
            if(node.count>farCount){
                farNode = node;
            }
            //mapCheck[node.y][node.x] = 1;

            for(int i=0; i<4; i++){
                int tmpX = node.x + dx[i];
                int tmpY = node.y + dy[i];

                if(tmpX>=0 && tmpX<M && tmpY>=0 && tmpY<N && map[tmpY][tmpX]=='L' && mapCheck[tmpY][tmpX]==0){
                    queue.offer(new Node(tmpX, tmpY, node.count+1));
                    mapCheck[tmpY][tmpX] = 1;
                }
            }
        }

        return farNode.count;
    }

}
