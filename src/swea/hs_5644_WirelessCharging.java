package swea;

import java.util.ArrayList;
import java.util.Scanner;

class hs_5644_WirelessCharging {

    static public void main(String[] args) {

        Solution solution = new Solution();

        solution.solution(new String[]{});
        //System.out.println(err);
    }

    static class Solution {

        static int T, M, A;
        static int[] people1;
        static int[] people2;
        static int[] people1Location;
        static int[] people2Location;
        static ArrayList<Node>[][] map;
        static int result;


        static class Node{
            int number;
            int power;

            Node(int number, int power){
                this.number = number;
                this.power = power;
            }
        }

        static public void solution(String[] args) {
            Scanner sc = new Scanner(System.in);

            T = sc.nextInt();

            for(int t=1; t<=T; t++){

                result = 0;
                map = new ArrayList[10][10];
                for(int i=0; i<10; i++){
                    for(int j=0; j<10; j++){
                        map[i][j] = new ArrayList<>();
                    }
                }

                M = sc.nextInt();
                A = sc.nextInt();

                people1 = new int[M+1];
                people2 = new int[M+1];
                people1Location = new int[2];
                people2Location = new int[2];

                for(int i=1; i<=M; i++){
                    people1[i] = sc.nextInt();
                }
                for(int i=1; i<=M; i++){
                    people2[i] = sc.nextInt();
                }

                for(int k=0; k<A; k++){
                    int x = sc.nextInt()-1;
                    int y = sc.nextInt()-1;
                    int range = sc.nextInt();
                    int power = sc.nextInt();

                    for(int i=-range; i<=range; i++){
                        for(int j=-range; j<=range; j++){
                            if(y+i<0 || y+i>=10 || x+j<0 || x+j>=10){
                                continue;
                            }

                            int tmpX = j>0 ? j : j*-1;
                            int tmpY = i>0 ? i : i*-1;

                            if(tmpY+tmpX<=range){
                                map[y+i][x+j].add(new Node(k, power));
                            }
                        }
                    }
                }

                people1Location[0] = 0;
                people1Location[1] = 0;
                people2Location[0] = 9;
                people2Location[1] = 9;

                for(int m=0; m<=M; m++) {
                    if (people1[m] == 1) {
                        people1Location[1] -= 1;
                    } else if (people1[m] == 2) {
                        people1Location[0] += 1;
                    } else if (people1[m] == 3) {
                        people1Location[1] += 1;
                    } else if (people1[m] == 4) {
                        people1Location[0] -= 1;
                    }

                    if (people2[m] == 1) {
                        people2Location[1] -= 1;
                    } else if (people2[m] == 2) {
                        people2Location[0] += 1;
                    } else if (people2[m] == 3) {
                        people2Location[1] += 1;
                    } else if (people2[m] == 4) {
                        people2Location[0] -= 1;
                    }


                    //같은 좌표가아닌 같은 레인지
                    int max = 0;

                    if(map[people1Location[1]][people1Location[0]].size()!=0 && map[people2Location[1]][people2Location[0]].size()!=0){
                        for(int i=0; i<map[people1Location[1]][people1Location[0]].size(); i++){
                            for(int j=0; j<map[people2Location[1]][people2Location[0]].size(); j++){
                                Node people1Tmp = map[people1Location[1]][people1Location[0]].get(i);
                                Node people2Tmp = map[people2Location[1]][people2Location[0]].get(j);
                                if(people1Tmp.number==people2Tmp.number){
                                    if(people1Tmp.power>max)
                                        max = people1Tmp.power;
                                }else{
                                    if(people1Tmp.power + people2Tmp.power>max)
                                        max = people1Tmp.power + people2Tmp.power;
                                }
                            }
                        }
                    }else if(map[people1Location[1]][people1Location[0]].size()==0){
                        for(int j=0; j<map[people2Location[1]][people2Location[0]].size(); j++){
                            Node people2Tmp = map[people2Location[1]][people2Location[0]].get(j);
                            if(people2Tmp.power>max)
                                max = people2Tmp.power;
                        }
                    }else if(map[people2Location[1]][people2Location[0]].size()==0){
                        for(int i=0; i<map[people1Location[1]][people1Location[0]].size(); i++){
                            Node people1Tmp = map[people1Location[1]][people1Location[0]].get(i);
                            if(people1Tmp.power>max)
                                max = people1Tmp.power;
                        }
                    }


                    result+=max;

                    //System.out.println(max);
                }


                System.out.println("#"+t+ " " + result);

            }



        }

    }

}



