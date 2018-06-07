package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hs_7576_Tomato_success_bfs {

    static class Queue_box {
        int x, y, cost;

        Queue_box(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static int qSize;
    static int count = 0;

    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] box = new int[n][m];
        boolean[][] visit = new boolean[n][m];
        Queue<Queue_box> queue = new LinkedList<Queue_box>();
        int day = 0;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<m; j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j]==1){
                    count++;
                    queue.offer(new Queue_box(i, j, 1));
                }else if(box[i][j]==-1){
                    count++;
                }
            }
        }
        if(count==m*n){
            System.out.println(0);
            return;
        }

        qSize = queue.size();

        hs_7576_Tomato_success_bfs q = new hs_7576_Tomato_success_bfs();
        day = q.bfs(queue, box, visit);

        System.out.println(n*m + " " + count + " " + qSize);
        if(n * m - count > 0) {
            day = -1;
        }

        System.out.println(day);

    }

    public int bfs(Queue<Queue_box> queue, int[][] tomato, boolean[][] visit) {
        int n = tomato.length;
        int m = tomato[0].length;

        int max = 0;

        while(!queue.isEmpty()) {
            System.out.println("qSize : " + qSize);
            Queue_box p = queue.poll();

            tomato[p.x][p.y] = p.cost;
            qSize--;

            max = p.cost > max ? p.cost : max;

            for(int i = 0 ; i < 4 ; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(tomato[nx][ny] == 0 && !visit[nx][ny]) {
                        queue.offer(new Queue_box(nx, ny, p.cost + 1));
                        visit[nx][ny] = true;
                        count++;
                        qSize++;
                    }
                }
            }
        }

        return max - 1;
    }
}
