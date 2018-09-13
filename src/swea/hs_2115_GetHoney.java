package swea;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class hs_2115_GetHoney {

    private static int T, N, M, C;
    private static int[][] map;
    private static int[][] mapCalculate;
    private static int result;

    static class Node{
        int x;
        int y;
        int value;

        Node(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int t = 1; t<=T; t++){

            N = sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();
            result = 0;

            map = new int[N][N];
            mapCalculate = new int[N][N];

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            ArrayList<Node> honeyList1 = new ArrayList<>();
            ArrayList<Node> honeyList2 = new ArrayList<>();
            for(int i=0; i<N; i++){
                for(int j=0; j<N-M+1; j++){
                    ArrayList<Integer> honeyList = new ArrayList<>();
                    for(int k=0; k<M; k++){
                        honeyList.add(map[i][j+k]);
                    }
                    Collections.sort(honeyList);
                    Collections.reverse(honeyList);
                    int tmp = 0;
                    for(int k=0; k<M; k++){
                        int value = counting(k, C, 0, honeyList);
                        //System.out.println("i : " + i + " j : " + j + " value : " + value);
                        if(tmp<value){
                            tmp = value;
                        }
                    }
                    mapCalculate[i][j] = tmp;
                    honeyList1.add(new Node(j, i, mapCalculate[i][j]));
                    honeyList2.add(new Node(j, i, mapCalculate[i][j]));
                }
            }

            for(int i=0; i<honeyList1.size(); i++){
                for(int j=i+1; j<honeyList2.size(); j++){
                    if(honeyList1.get(i).y==honeyList2.get(j).y){
                        if(honeyList1.get(i).x<=honeyList2.get(j).x && honeyList1.get(i).x+(M-1)>=honeyList2.get(j).x){
                            continue;
                        }
                    }
                    {
                        int tmp = honeyList1.get(i).value + honeyList2.get(j).value;
                        if(result<tmp){
                            result = tmp;
                        }
                    }
                }
            }

            System.out.println("#" + t + " " + result);

            /*for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    System.out.print(mapCalculate[i][j] + " ");
                }System.out.println();
            }System.out.println();*/

        }
    }

    static int counting(int i, int c, int value, ArrayList<Integer> honeyList){
        if(i==M){
            return value;
        }else{
            if(c-honeyList.get(i)<0){
                return counting(i+1, c, value, honeyList);
            }else{
                return counting(i+1, c-honeyList.get(i), value + (int) Math.pow(honeyList.get(i), 2), honeyList);
            }
        }
    }
}