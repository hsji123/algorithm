import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuadTree_1992 {
    static String result = "";
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        int[][] picture = new int[64][64];
        int colorTmp= 0;
        boolean colorTmp2 = false;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), "");
            String str = st.nextToken();
            for(int j=0; j<N; j++){
                picture[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                if(i==0 && j==0){
                    colorTmp = picture[i][j];
                }else if(colorTmp!=picture[i][j]){
                    colorTmp2 = true;
                }
            }
        }

        if(!colorTmp2){
            System.out.println(colorTmp);
            return;
        }

        pictureCut(picture, 0, 0, N/2);

        System.out.println(result);

    }

    //((110(0101))(0010)1(0001))
    //((110(0101))(0010)1(0001))
    static void pictureCut(int[][] picture, int x, int y, int N) {
        int colorTmp = -1;
        boolean compare = false;
        if (N == 1) {
            result += "(";
            for (int q = 0; q < 2; q++) {
                for (int p = 0; p < 2; p++) {
                    result += picture[y + q][x + p];
                    compare = true;
                }
            }
            result += ")";
        }
        if(compare){
            compare = false;
            return;
        }

        result += "(";
        for(int q=0; q<2; q++){
            for(int p=0; p<2; p++){
                for(int i=y+q*N; i<y+q*N+N; i++){
                    for(int j=x+p*N; j<x+p*N+N; j++){
                        if(i==y+q*N && j==x+p*N){
                            colorTmp = picture[i][j];
                        }else if(colorTmp!=picture[i][j]){
                            pictureCut(picture, x+p*N, y+q*N, N/2);
                            compare = true;
                            break;
                        }
                    }
                    if(compare){
                        break;
                    }
                }
                if(!compare){
                    result += colorTmp;
                }else{
                    compare = false;
                }
            }
        }
        result += ")";
    }

}
