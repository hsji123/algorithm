package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class hs_1912_ContinuousSum {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int max = 0;
        int minus = 0;
        int countZero = 0;
        int tmp = 0;
        int[] numberList = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            numberList[i] = Integer.parseInt(st.nextToken());
            if(numberList[i]==0){
                countZero++;
            }
            if(minus==0 && minus>numberList[i]){
                minus=numberList[i];
            }else if(minus<0 && minus<numberList[i]){
                minus=numberList[i];
            }
            if(tmp+numberList[i]<0){
                tmp=0;
            }else{
                tmp+=numberList[i];
                if(tmp>max)
                    max = tmp;
            }
        }

        if(max==0 && minus<0){
            if(countZero==0){
                System.out.println(minus);
            }else{
                System.out.println(max);
            }
        }else{
            System.out.println(max);
        }
    }
    //10
    //10 -4 3 1 5 6 -35 12 1 -1

}