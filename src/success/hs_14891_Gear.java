package success;

import java.util.ArrayList;
import java.util.Scanner;

public class hs_14891_Gear {

    static int N, M, K;
    static int result;
    static ArrayList<Integer>[] gear;

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        gear = new ArrayList[4];

        for(int i=0; i<4; i++){
            String tmp = sc.next();
            gear[i] = new ArrayList<>();
            for(int j=0; j<8; j++){
                gear[i].add(Integer.parseInt(String.valueOf(tmp.charAt(j))));
            }
        }

        N = sc.nextInt();
        int[] direction = new int[4];

        for(int i=0; i<N; i++){
            direction = new int[4];
            M = sc.nextInt()-1;
            K = sc.nextInt();
            direction[M] = K;

            for(int j=M; j<3; j++){//오른쪽
                if(gear[j].get(2)!=gear[j+1].get(6)){
                    direction[j+1] = direction[j]*-1;
                }
            }

            for(int j=M; j>0; j--){//왼쪽
                if(gear[j].get(6)!=gear[j-1].get(2)){
                    direction[j-1] = direction[j]*-1;
                }
            }

            for(int j=0; j<4; j++){
                if(direction[j]==1){
                    int tmp = gear[j].get(gear[j].size()-1);
                    gear[j].remove(gear[j].size()-1);
                    gear[j].add(0, tmp);
                }else if(direction[j]==-1){
                    int tmp = gear[j].get(0);
                    gear[j].remove(0);
                    gear[j].add(tmp);
                }
            }
        }

        int count = 1;
        for(int i=0; i<4; i++){
            result += gear[i].get(0)*count;
            count*=2;
        }

        System.out.println(result);
    }


}
