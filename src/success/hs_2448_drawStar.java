package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hs_2448_drawStar {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int tmp = (int) logB(N/3*2, 2);
        char[][] paper = new char[3100][10000];

        drawStar(paper, (int) (6*Math.pow(2, tmp-1)-1)/2, 0, tmp);

        //배열을 출력할때에는 모든 값을 하나하나 출력하지말고 행별로 String에 넣어서 출력해야 시간절약.
        for(int i=0; i<N; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<N*2-1; j++){
                if(paper[i][j]=='*'){
                    sb.append('*');
                }else{
                    sb.append(' ');
                }
            }
            System.out.println(sb);
        }
    }

    static void smallStar(char[][] paper, int x, int y){
        paper[y][x] = '*';

        paper[y+1][x-1] = '*';
        paper[y+1][x+1] = '*';

        paper[y+2][x-2] = '*';
        paper[y+2][x-1] = '*';
        paper[y+2][x] = '*';
        paper[y+2][x+1] = '*';
        paper[y+2][x+2] = '*';
    }

    static void drawStar(char[][] paper, int x, int y, int N) {
        if(N==1){
            smallStar(paper, x, y);
            return;
        }else{
            drawStar(paper, x, y, N-1);
            drawStar(paper, (int) (x-3*Math.pow(2, N-2)), (int) (y+3*Math.pow(2, N-2)), N-1);
            drawStar(paper, (int) (x+3*Math.pow(2, N-2)), (int) (y+3*Math.pow(2, N-2)), N-1);
        }
    }

    // 밑이 다른 로그값을 구하는 함수
    public static double logB(double x, double base) {
        return Math.log(x) / Math.log(base);
    }
}
