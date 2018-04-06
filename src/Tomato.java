import java.util.Scanner;

public class Tomato {
    public static void main(String args[]){
        //실패한 이유는 DFS를 하는 과정에서 비효율적으로 이중배열을 사용함.
        // QUEUE를 사용했다면 훨씬 좋은 코드가 되었을 것.
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[][] box = new int[N][M];
        int[][] tomatoX = new int[50][10000];
        int[][] tomatoY = new int[50][10000];
        int count = 0;
        int tomatoCount = 0;
        int day = 0;
        boolean change = false;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                box[i][j] = sc.nextInt();
                if(box[i][j]==1){
                    count++;
                    tomatoX[0][tomatoCount] = j;
                    tomatoY[0][tomatoCount++] = i;
                }else if(box[i][j]==-1){
                    count++;
                }else if(box[i][j]==0){

                }
            }
        }
        if(count==M*N){
            System.out.println(0);
            return;
        }

        while(true){
            day++;
            System.out.println(day + " " + tomatoCount);
            int tomatoCountTmp = tomatoCount;
            tomatoCount=0;
            for(int i=0; i<tomatoCountTmp; i++){
                if(tomatoY[day-1][i]-1>=0 && box[tomatoY[day-1][i]-1][tomatoX[day-1][i]]==0){ // y-1
                    box[tomatoY[day-1][i]-1][tomatoX[day-1][i]]=1;
                    tomatoX[day][tomatoCount] = tomatoX[day-1][i];
                    tomatoY[day][tomatoCount++] = tomatoY[day-1][i]-1;
                    count++;
                    change = true;
                }
                if(tomatoY[day-1][i]+1 < N && box[tomatoY[day-1][i]+1][tomatoX[day-1][i]]==0){ // y+1
                    box[tomatoY[day-1][i]+1][tomatoX[day-1][i]]=1;
                    tomatoX[day][tomatoCount] = tomatoX[day-1][i];
                    tomatoY[day][tomatoCount++] = tomatoY[day-1][i]+1;
                    count++;
                    change = true;
                }
                if(tomatoX[day-1][i]-1>=0 && box[tomatoY[day-1][i]][tomatoX[day-1][i]-1]==0){ // x-1
                    box[tomatoY[day-1][i]][tomatoX[day-1][i]-1]=1;
                    tomatoX[day][tomatoCount] = tomatoX[day-1][i]-1;
                    tomatoY[day][tomatoCount++] = tomatoY[day-1][i];
                    count++;
                    change = true;
                }
                if(tomatoX[day-1][i]+1 < M && box[tomatoY[day-1][i]][tomatoX[day-1][i]+1]==0){ // x+1
                    box[tomatoY[day-1][i]][tomatoX[day-1][i]+1]=1;
                    tomatoX[day][tomatoCount] = tomatoX[day-1][i]+1;
                    tomatoY[day][tomatoCount++] = tomatoY[day-1][i];
                    count++;
                    change = true;
                }
            }
            if(change==false){
                if(count==M*N){
                    System.out.println(day-1);
                }else{
                    System.out.println(-1);
                }
                break;
            }else{
                change = false;
            }
        }
    }
}
