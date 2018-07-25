package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hs_1206_view {

    static int[] building;
    static int result;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<10; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            result = 0;
            building = new int[N];
            st = new StringTokenizer(br.readLine(), " ");

            for(int j=0; j<N; j++){
                building[j] = Integer.parseInt(st.nextToken());
            }

            for(int j=0; j<N; j++){
                if(j>1 && j<N-2){
                    int height = getHeight(building[j-2], building[j-1], building[j+1], building[j+2]);
                    if(building[j]>height){
                        result += building[j]-height;
                    }
                }
            }

            System.out.println("#"+(i+1)+" "+result);
        }



    }

    static int getHeight(int height1, int height2, int height3, int height4){
        int height = 0;
        int[] heightList = {height1, height2, height3, height4};
        for(int i=0; i<4; i++){
            if(height<heightList[i]){
                height = heightList[i];
            }
        }
        return height;
    }

}
