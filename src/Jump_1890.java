import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Jump_1890 {

    static int N;
    static int[][] map;
    static long[][] mapResult;
    static long result = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        mapResult = new long[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                mapResult[i][j] = 0;
            }
        }

        result = dfs(0, 0);
        System.out.println(result);

    }

    static long dfs(int x, int y){
        long count = 0;
        if(x==N-1 && y==N-1){
            mapResult[y][x]=1;
            //System.out.println("1 : " + x + " " + y + " " + 1);
            return 1;
        }
        if(map[y][x]==0){
            return 0;
        }

        if(mapResult[y][x]!=0){
            //System.out.println("2 : " + mapResult[y][x]);
            return mapResult[y][x];
        }else{
            int tmpX = x+map[y][x];
            int tmpY = y+map[y][x];
            if(tmpY<N){
                long result = dfs(x, tmpY);
                mapResult[y][x] += result;
                count += result;
                //System.out.println("3 : x " + x + " y " + y + " tmpY " + tmpY + " " + count);
            }
            if(tmpX<N){
                long result = dfs(tmpX, y);
                mapResult[y][x] += result;
                count += result;
                //System.out.println("3 : x " + x + " tmpX " + tmpX + " y " + y + " " + count);
            }
            if(tmpX>=N || tmpY>=N){
                count += 0;
            }
        }
        return count;
    }

}