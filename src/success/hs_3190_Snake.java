package success;

import java.util.ArrayList;
import java.util.Scanner;

public class hs_3190_Snake {

    private static int N, M;
    private static int[][] map;
    private static int[][] action;
    private static int result;
    private static int dieFlag;
    private static int actionCount;
    private static ArrayList<Node> snake;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

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

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][N];
        snake = new ArrayList<>();
        snake.add(new Node(0, 0));
        dieFlag = 0;
        actionCount = 0;

        for(int i=0; i<M; i++){
            int y = sc.nextInt();
            int x = sc.nextInt();
            map[y-1][x-1] = 1;
        }

        M = sc.nextInt();
        action = new int[M][2];

        for(int i=0; i<M; i++){
            action[i][0] = sc.nextInt();
            char tmp = sc.next().charAt(0);
            if(tmp=='L'){
                action[i][1] = 0;
            }else{
                action[i][1] = 1;
            }

        }

        int direction = 0;
        while(dieFlag==0){
            result++;
            int tmpX = snake.get(0).x + dx[direction];
            int tmpY = snake.get(0).y + dy[direction];

            if(tmpX>=0 && tmpX<N && tmpY>=0 && tmpY<N){
                for(int i=0; i<snake.size(); i++){
                    if(snake.get(i).x==tmpX && snake.get(i).y==tmpY){
                        dieFlag=1;
                        break;
                    }
                }
                if(dieFlag==1){
                    break;
                }

                if(map[tmpY][tmpX]==1){
                    snake.add(0, new Node(tmpX, tmpY));
                    map[tmpY][tmpX] = 0;
                }else{
                    snake.add(0, new Node(tmpX, tmpY));
                    snake.remove(snake.size()-1);
                }
            }else{
                dieFlag = 1;
                break;
            }

            if(actionCount<M){
                if(action[actionCount][0]==result){

                    if(action[actionCount][1]==0){
                        if(direction==0){
                            direction=3;
                        }else{
                            direction -=1;
                        }
                    }else{
                        direction = (direction+1)%4;
                    }
                    actionCount++;
                }
            }

        }

        System.out.println(result);

    }

}
