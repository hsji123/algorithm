package success;

import java.util.Scanner;

public class hs_2292_HoneyComb {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int x, n=1, m=1;
        x = sc.nextInt();

        while(true){
            if(x<=3*n*(n-1)+1){
                break;
            }
            n++;
        }

        System.out.println(n);
    }
}
