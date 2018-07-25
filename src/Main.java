import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[][] visit;
    static int resultTmp = 0;
    static int result = 1;
    static int resultFlag = 0;
    static int N;
    static int maxHeight=0;
    static int minHeight=Integer.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visit = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>maxHeight){
                    maxHeight = map[i][j];
                }
                if(map[i][j]<minHeight){
                    minHeight = map[i][j];
                }
            }
        }

        for(int i=minHeight; i<maxHeight; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(map[j][k]>i && visit[j][k]==0){
                        resultTmp++;
                        bfs(k, j, i);
                    }
                }
            }
            if(result<resultTmp){
                result = resultTmp;
                resultFlag= 1;
            }/*else{
                if(resultFlag==1){
                    break;
                }
            }*/
            resultTmp=0;
            visit = new int[N][N];
        }

        System.out.println(result);
    }

    static void bfs(int x, int y, int height){
        visit[y][x] = 1;

        for(int i=0; i<4; i++){
            int tmpX = x+dx[i];
            int tmpY = y+dy[i];
            if(tmpX>=0 && tmpX<N && tmpY>=0 && tmpY<N){
                if(map[tmpY][tmpX]>height && visit[tmpY][tmpX]==0){
                    bfs(tmpX, tmpY, height);
                }
            }
        }
    }

}