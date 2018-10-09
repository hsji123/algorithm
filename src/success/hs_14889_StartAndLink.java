package success;

import java.util.Scanner;

public class hs_14889_StartAndLink {

    static int result;
    static int N;
    static int[][] map;
    static int[] playerList;

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        result = Integer.MAX_VALUE;
        N = sc.nextInt();
        playerList = new int[N];
        map = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i=0; i<N/2; i++){
            playerList[i] = 1;
            teamBuilding(i, 1);
            playerList[i] = 0;
        }

        System.out.println(result);

    }

    static void teamBuilding(int playerNumber, int count){
        if(count==N/2){
            teamPointCounting();
            return;
        }
        if(N/2-count>(N-1)-playerNumber){
            return; // 남은 인원보다 뽑아야할 인원이 더 많은경우 리턴
        }
        for(int i=playerNumber+1; i<N-(N/2-count); i++){
            playerList[i] = 1;
            teamBuilding(i, count+1);
            playerList[i] = 0;
        }
    }

    static void teamPointCounting(){
        int team0 = 0;
        int team1 = 0;
        for(int i=0; i<playerList.length; i++){
            for(int j=0; j<playerList.length; j++){
                if(i==j){
                    continue;
                }
                if(playerList[i]==0 && playerList[j]==0){
                    team0+=map[i][j];
                }else if(playerList[i]==1 && playerList[j]==1){
                    team1+=map[i][j];
                }
            }
        }
        int tmpResult = team0-team1>0? team0-team1 : (team0-team1)*-1;
        if(tmpResult<result){
            result = tmpResult;
        }
    }
}
