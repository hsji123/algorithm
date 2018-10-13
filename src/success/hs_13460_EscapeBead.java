package success;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hs_13460_EscapeBead {

    static int N, M;
    static char[][] map;
    static int result;
    static Queue<Node> queue;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static class Node{
        int rx;
        int ry;
        int bx;
        int by;
        int count;

        Node(int rx, int ry, int bx, int by, int count){
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.count = count;
        }
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new char[N][M];
        queue = new LinkedList<>();

        result = -1;

        int rx = 0, ry = 0, bx = 0, by = 0;
        for(int i=0; i<N; i++){
            String tmp = sc.next();
            for(int j=0; j<M; j++){
                map[i][j] = tmp.charAt(j);
                if(map[i][j]=='R'){
                    rx = j;
                    ry = i;
                    map[i][j]='.';
                }else if(map[i][j]=='B'){
                    bx = j;
                    by = i;
                    map[i][j]='.';
                }
            }
        }
        queue.offer(new Node(rx, ry, bx, by, 1));

        bfs();


        System.out.println(result);
    }

    static void bfs(){

        while(!queue.isEmpty()){
            Node node = queue.poll();
            //System.out.println(node.rx + " " + node.ry + " " + node.bx + " " + node.by + " " + node.count);

            //움직이기
            for(int i=0; i<4; i++){
                boolean move = true;
                int end = 1;
                int tmprx = node.rx;
                int tmpry = node.ry;
                int tmpbx = node.bx;
                int tmpby = node.by;
                while(move){
                    move = false;
                    boolean back = false;
                    tmprx+=dx[i];
                    tmpry+=dy[i];
                    tmpbx+=dx[i];
                    tmpby+=dy[i];
                    if(end==1){
                        if(map[tmpry][tmprx]=='#'){
                            tmprx-=dx[i];
                            tmpry-=dy[i];
                            back = true;
                        }else if(tmprx==tmpbx-dx[i] && tmpry==tmpby-dy[i]){
                            tmprx-=dx[i];
                            tmpry-=dy[i];
                        }else if(map[tmpry][tmprx]=='.'){
                            move = true;
                        }else if(map[tmpry][tmprx]=='O'){
                            end = 0;
                            tmprx = -1;
                            tmpry = -1;
                        }
                    }

                    if(map[tmpby][tmpbx]=='#'){
                        tmpbx-=dx[i];
                        tmpby-=dy[i];
                    }else if(tmpbx==tmprx-dx[i] && tmpby==tmpry-dy[i]){
                        if(back){

                        }else{
                            tmpbx-=dx[i];
                            tmpby-=dy[i];
                        }
                    }else if(map[tmpby][tmpbx]=='.'){
                        move = true;
                    }else if(map[tmpby][tmpbx]=='O'){
                        end = -1;
                        break;
                    }


                }

                if(end==0){
                    result = node.count;
                    queue = new LinkedList<>();
                    break;
                }else if(end==1){
                    if(node.count<10){
                        queue.offer(new Node(tmprx, tmpry, tmpbx, tmpby, node.count+1));
                    }
                }else if(end==-1){

                }
            }


        }
    }
}

/*
9 6
######
##.B.#
#....#
#....#
#..R.#
#..O.#
###..#
#....#
######*/
