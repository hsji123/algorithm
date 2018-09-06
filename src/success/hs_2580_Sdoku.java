package success;

import java.util.ArrayList;
import java.util.Scanner;

public class hs_2580_Sdoku {

    private static int[][] map;
    private static int[][] checkNumber;
    private static int[] checkLineNumber;
    private static ArrayList<Node> blank;
    private static boolean finish;

    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        map = new int[9][9];
        checkNumber = new int[90][10];
        checkLineNumber = new int[10];
        blank = new ArrayList<>();
        finish = false;

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                map[i][j] = sc.nextInt();
                if(map[i][j]==0){
                    blank.add(new Node(j, i));
                }
            }
        }

        checking(blank.get(0).x, blank.get(0).y, 0);


        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(map[i][j] + " ");
            }System.out.println();
        }

    }

    static void checking(int x, int y, int count){
        checkLineNumber = new int[10];
        for(int i=0; i<9; i++){
            checkNumber[10*y+x][map[y][i]]=1;
            if(checkLineNumber[map[y][i]]==0){
                checkLineNumber[map[y][i]]=1;
            }else if(map[y][i]==0){

            }else{
                return;
            }
        }
        checkLineNumber = new int[10];
        for(int i=0; i<9; i++){
            checkNumber[10*y+x][map[i][x]]=1;
            if(checkLineNumber[map[i][x]]==0){
                checkLineNumber[map[i][x]]=1;
            }else if(map[i][x]==0){

            }else{
                return;
            }
        }
        checkLineNumber = new int[10];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                checkNumber[10*y+x][map[y-y%3+i][x-x%3+j]]=1;
                if(checkLineNumber[map[y-y%3+i][x-x%3+j]]==0){
                    checkLineNumber[map[y-y%3+i][x-x%3+j]]=1;
                }else if(map[y-y%3+i][x-x%3+j]==0){

                }else{
                    return;
                }
            }
        }

        for(int i=1; i<=9; i++){
            if(checkNumber[10*y+x][i]==0){
                map[y][x]=i;
                //System.out.println(" x : " + blank.get(count).x + " y : " + blank.get(count).y + " count : " + count + " i : " + i);
                if(count+1==blank.size()){
                    finish = true;
                    return;
                }
                checking(blank.get(count+1).x, blank.get(count+1).y, count+1);
                for(int j=1; j<=9; j++) {
                    checkNumber[10 * blank.get(count+1).y + blank.get(count+1).x][j] = 0;
                }
                if(finish){
                    return;
                }
                map[y][x]=0;
            }
        }

    }

}

/*
1 0 3 0 0 0 5 0 9
0 0 2 1 0 9 4 0 0
0 0 0 7 0 4 0 0 0
3 0 0 5 0 2 0 0 6
0 6 0 0 0 0 0 5 0
7 0 0 8 0 3 0 0 4
0 0 0 4 0 1 0 0 0
0 0 9 2 0 5 8 0 0
8 0 4 0 0 0 1 0 7
 */
