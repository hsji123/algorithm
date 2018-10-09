package success;

import java.util.Scanner;

public class hs_14888_OperatorPutting {

    static int resultMax;
    static int resultMin;
    static int N;
    static int[] numberList;
    static int[] operatorList;
    static int[] settingList;

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        resultMax = Integer.MIN_VALUE;
        resultMin = Integer.MAX_VALUE;

        numberList = new int[N];
        operatorList = new int[4];
        settingList = new int[N];

        for(int i=0; i<N; i++){
            numberList[i] = sc.nextInt();
            settingList[i] = -1;
        }

        for(int i=0; i<4; i++){
            operatorList[i] = sc.nextInt();
        }

        for(int i=0; i<4; i++){
            if(operatorList[i]>=1){
                settingList[0] = i;
                operatorList[i]--;
                operatorSetting(1);
                settingList[0] = -1;
                operatorList[i]++;
            }
        }

        System.out.println(resultMax);
        System.out.println(resultMin);

    }

    static void operatorSetting(int count){
        if(count==N-1){
            int calculation = numberList[0];
            for(int i=1; i<N; i++){
                if(settingList[i-1]==0){
                    calculation+=numberList[i];
                }else if(settingList[i-1]==1){
                    calculation-=numberList[i];
                }else if(settingList[i-1]==2){
                    calculation*=numberList[i];
                }else if(settingList[i-1]==3){
                    calculation = calculation<0? (calculation*-1)/numberList[i]*-1 : calculation/numberList[i];
                }
            }

            if(calculation>resultMax){
                resultMax = calculation;
            }
            if(calculation<resultMin){
                resultMin = calculation;
            }

            return;
        }
        for(int i=0; i<4; i++){
            if(operatorList[i]>=1){
                settingList[count] = i;
                operatorList[i]--;
                operatorSetting(count+1);
                settingList[count] = -1;
                operatorList[i]++;
            }
        }

    }

}
