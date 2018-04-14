import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Kth_11004 {
    static int K = 0;
    static int N = 0;
    static int result = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] data = new int[5000001];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        quick_sort(data, 0, N-1);
        System.out.println(result);
    }

    static void quick_sort(int data[], int left, int right){
        int i, j, key, tmp;
        if(left < right){
            i = left;
            j = right+1;
            key = data[left];
            do{
                do{
                    i++;
                } while(data[i] <= key);
                do{
                    j--;
                } while(data[j] >= key);
                if(i<=j){
                    tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            } while(i<=j);
            tmp = data[left];
            data[left] = data[j];
            data[j] = tmp;
/*
            for(int q=0; q<N; q++){
                System.out.print(data[q] + " ");
            }
            System.out.println();
            System.out.println(j+1 + " " + K);
*/
            if(j+1>=K){
                quick_sort(data, left, j-1);
                result = data[K-1];
            }else if(j+1<K){
                quick_sort(data, j+1, right);
                result = data[K-1];
            }else{
                result = data[K-1];
            }
        }
    }
}
