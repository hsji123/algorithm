package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hs_2383_LunchTime {

    private static int N;
    private static int[][] people;
    private static int[] peopleMinute;
    private static int[] peopleMinuteFlag;
    private static int[][] stair;
    private static int peopleCount;
    private static int peopleCountTmp;
    private static int stairCount;
    private static int[] peopleStair;
    private static int resultMin;

    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());

        for(int i=1; i<=T; i++){
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            people = new int[10][3];
            peopleMinute = new int[10];
            peopleMinuteFlag = new int[10];
            stair = new int[2][3];
            peopleStair = new int[2];
            peopleCount = 0;
            stairCount = 0;
            resultMin = Integer.MAX_VALUE;
            peopleStair[0] = 0;
            peopleStair[1] = 0;
            peopleCountTmp = 0;

            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int k=0; k<N; k++){
                    int tmp = Integer.parseInt(st.nextToken());
                    if(tmp==1){
                        people[peopleCount][0] = k;
                        people[peopleCount][1] = j;
                        peopleCount++;
                    }else if(tmp!=0){
                        stair[stairCount][0] = k;
                        stair[stairCount][1] = j;
                        stair[stairCount][2] = tmp*-1-1;
                        stairCount++;
                    }
                }
            }

            select(0);


            System.out.println("#"+i+" "+resultMin);
        }

    }

    static void select(int count){
        if(count<peopleCount){
            people[count][2]=0;
            select(count+1);
            people[count][2]=1;
            select(count+1);
        }else{
            move(0);
        }
    }

    static void move(int minutes){
        if(minutes==0){
            for(int i=0; i<peopleCount; i++){
                int tmpX = people[i][0]-stair[people[i][2]][0];
                int tmpY = people[i][1]-stair[people[i][2]][1];
                if(tmpX<0){
                    tmpX*=-1;
                }
                if(tmpY<0){
                    tmpY*=-1;
                }
                peopleMinute[i] = tmpX + tmpY;
            }
            move(minutes+1);
        }else{
            //System.out.println(peopleCount);
            for(int i=0; i<peopleCount; i++){
                peopleMinute[i]--;
                if(peopleMinute[i]==stair[people[i][2]][2]){
                    peopleStair[people[i][2]]--;
                    peopleCountTmp++;
                }
            }
            for(int i=0; i<peopleCount; i++){
                if(peopleMinute[i]==0 && peopleStair[people[i][2]]==3){
                    peopleMinute[i]++;
                    peopleMinuteFlag[i]=1;
                }else if(peopleMinute[i]==0){
                    if(peopleMinuteFlag[i]==1){
                        peopleMinute[i]--;
                        peopleMinuteFlag[i]=0;
                    }
                    peopleStair[people[i][2]]++;
                }
                //System.out.print(peopleMinute[i] + " ");
            }
            //System.out.println();
            if(peopleCountTmp>=peopleCount){
                //for(int i=0; i<peopleCount; i++){
                //    System.out.print(" people"+i+ " : " + people[i][2] + " ");
                //}
                //System.out.println(minutes);

                if(minutes<resultMin){
                    resultMin = minutes;
                }
                peopleCountTmp = 0;
                peopleStair[0] = 0;
                peopleStair[1] = 0;
            }else{
                move(minutes+1);
            }
        }

    }

}
