package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class hs_2667_ApartmentNumbering {

    static int N;
    static int[][] map;
    static int[] apartment;
    static int apartmentCount = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        apartmentCount = 0;
        apartment = new int[1000];
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String strTmp = st.nextToken();
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(String.valueOf(strTmp.charAt(j)));
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==1){
                    apartmentCount++;
                    queueX.offer(j);
                    queueY.offer(i);
                    bfs(queueX, queueY);
                }
            }
        }

        for(int i=1; i<apartmentCount; i++){
            for(int j=i+1; j<=apartmentCount; j++){
                if(apartment[j]<apartment[i]){
                    int tmp = apartment[i];
                    apartment[i]=apartment[j];
                    apartment[j]=tmp;
                }
            }
        }

        System.out.println(apartmentCount);
        for(int i=1; i<=apartmentCount; i++){
            System.out.println(apartment[i]);
        }

    }

    static void bfs(Queue<Integer> queueX, Queue<Integer> queueY){
        int x = queueX.poll();
        int y = queueY.poll();
        if(map[y][x]==1){
            apartment[apartmentCount]++;
            map[y][x] = apartmentCount+1;
        }
        for(int i=0; i<4; i++){
            int tmpX = x+dx[i];
            int tmpY = y+dy[i];
            if(tmpX>=0 && tmpX<N && tmpY>=0 && tmpY<N){
                if(map[tmpY][tmpX]==1){
                    queueX.offer(tmpX);
                    queueY.offer(tmpY);
                    bfs(queueX, queueY);
                }
            }
        }
    }

}