package success;

import java.util.Scanner;

public class hs_9517_ILoveCroatia {
    public static void main(String arg[]) {
        int N, bombMan, totalSeconds=0;
        Scanner sc = new Scanner(System.in);
        bombMan = sc.nextInt();
        N = sc.nextInt();
        for(int i=0; i<N; i++){
            totalSeconds += sc.nextInt();
            char answer = sc.next().charAt(0);
            if(totalSeconds>210) break;
            if(answer=='T') bombMan++;
        }
        System.out.println(bombMan%8==0? 8 : bombMan%8);
    }
}