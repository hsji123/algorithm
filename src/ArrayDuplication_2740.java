import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ArrayDuplication_2740 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr1 = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                arr1[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr2 = new int[M][K];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<K; j++){
                arr2[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = new int[N][K];

        for(int i=0; i<N; i++){
            for(int j=0; j<K; j++){
                int tmp = 0;
                for(int p=0; p<M; p++){
                    tmp+= arr1[i][p]*arr2[p][j];
                }
                result[i][j] = tmp;
                System.out.print(tmp + " ");
            }
            System.out.println();
        }
    }
}