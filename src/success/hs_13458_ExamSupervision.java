package success;

import java.util.Scanner;

public class hs_13458_ExamSupervision {

    static int N, A, B;
    static int[] list;
    static int[] result;


    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        list = new int[N];
        result = new int[2];
        for(int i=0; i<N; i++){
            list[i] = sc.nextInt();
        }

        A = sc.nextInt();
        B = sc.nextInt();

        for(int i=0; i<N; i++){
            if(list[i]-A<=0){
                result[0]++;
            }else{
                result[0]++;
                result[0]+=(list[i]-A)%B==0? (list[i]-A)/B : (list[i]-A)/B+1;
            }

            if(result[0]>=100000000){
                result[1]++;
                result[0]-=100000000;
            }
        }

        String resultTmp = result[0]+"";
        for(int i=0; i<8-String.valueOf(result[0]).length(); i++){
            resultTmp = "0"+resultTmp;
        }

        if(result[1]>0){
            System.out.println(result[1]+""+resultTmp);
        }else{
            System.out.println(result[0]);
        }
    }

}
