package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class hs_11559_PuyoPuyo {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static char[][] map;
    static int[][] mapFlag;
    static int result;

    static ArrayList<Node> list;

    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new char[12][6];
        mapFlag = new int[12][6];
        boolean nothingFlag = true;
        boolean boomFlag = false;
        result = 0;

        for(int i=0; i<12; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String tmp = st.nextToken();
            for(int j=0; j<6; j++){
                map[i][j] = tmp.charAt(j);
                if(map[i][j]=='.'){
                    mapFlag[i][j] = 1;
                }else{
                    mapFlag[i][j] = 0;
                }
            }
        }

        while (nothingFlag){

            //for(int i=0; i<12; i++){
            //    System.out.println();
            //    for(int j=0; j<6; j++){
            //        System.out.print(map[i][j]);
            //    }
            //}

            result++;
            for(int i=0; i<12; i++){
                for(int j=0; j<6; j++){
                    if(map[i][j]!='.'){
                        char color = map[i][j];
                        list = new ArrayList<Node>();
                        bfs(j, i, color);
                        if(list.size()>=4){
                            boomFlag = true;
                            for(int k=0; k<list.size(); k++){
                                map[list.get(k).y][list.get(k).x] = '.';
                            }
                        }
                    }
                }
            }

            for(int i=11; i>=1; i--){
                for(int j=0; j<6; j++){
                    if(map[i][j]=='.'){
                        int count=0;
                        while(map[i][j]=='.' && count<12){
                            count++;
                            for(int k = i; k>0; k--){
                                map[k][j]=map[k-1][j];
                            }
                            map[0][j] = '.';
                        }
                    }
                }
            }

            for(int a=0; a<12; a++){
                for(int b=0; b<6; b++) {
                    if(map[a][b]=='.'){
                        mapFlag[a][b] = 1;
                    }else{
                        mapFlag[a][b] = 0;
                    }
                }
            }

            if(boomFlag){
                boomFlag = false;
            }else{
                nothingFlag = false;
            }

        }

        System.out.println(result-1);
    }

    static void bfs(int x, int y, char color){
        //map[y][x] = '.';
        list.add(new Node(x, y));
        mapFlag[y][x] = 2;
        for(int i=0; i<4; i++){
            int tmpX = x+dx[i];
            int tmpY = y+dy[i];
            if(tmpX>=0 && tmpX<6 && tmpY>=0 && tmpY<12){
                if(map[tmpY][tmpX]==color && mapFlag[tmpY][tmpX]!=2){
                    bfs(tmpX, tmpY, color);
                }
            }
        }
    }
}
