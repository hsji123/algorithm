import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Stack_box {
    int x, y;

    Stack_box(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class RoboticCleaner_14503 {

    static final int[] dxE = {0, -1, 0, 1};
    static final int[] dyE = {-1, 0, 1, 0};
    static final int[] dxW = {0, 1,  0, -1};
    static final int[] dyW = {1, 0, -1,  0};
    static final int[] dxS = {1,  0, -1, 0};
    static final int[] dyS = {0, -1,  0, 1};
    static final int[] dxN = {-1, 0, 1,  0};
    static final int[] dyN = { 0, 1, 0, -1};

    static int count = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        Stack<Stack_box> stack = new Stack<>();
        stack.push(new Stack_box(x, y));
        int[][] room = new int[50][50];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(stack, room, direction);

        System.out.println(count);
    }

    static void dfs(Stack<Stack_box> stack, int[][] room, int direction){
        int n = room.length;
        int m = room[0].length;
        boolean finish = false;
        while(!stack.empty()){
            Stack_box stack_box = stack.pop();

            if(room[stack_box.y][stack_box.x] == 0){
                room[stack_box.y][stack_box.x] = 2;
                count++;
            }

            /*System.out.println(stack.size() + " " + stack_box.x + " " + stack_box.y + " " + count);
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    System.out.print(room[i][j] + " " );
                }
                System.out.println();
            }*/

            int checkCount = 0;
            for(int i=0; i<4; i++){
                int x = 0;
                int y = 0;
                if(direction==0){
                    x = dxN[i];
                    y = dyN[i];
                }else if(direction==1){
                    x = dxE[i];
                    y = dyE[i];
                }else if(direction==2){
                    x = dxS[i];
                    y = dyS[i];
                }else if(direction==3){
                    x = dxW[i];
                    y = dyW[i];
                }
                int nx = stack_box.x + x;
                int ny = stack_box.y + y;

                if(nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if(room[ny][nx] == 0) {
                        stack.push(stack_box);
                        stack.push(new Stack_box(nx, ny));
                        direction = (direction-i+3)%4;
                        break;
                    }else{
                        checkCount++;
                    }
                    if(checkCount==4){
                        if(direction==0){
                            if(room[stack_box.y+1][stack_box.x]==2){
                                if(!stack.empty())
                                    stack.pop();
                                stack.push(new Stack_box(stack_box.x, stack_box.y+1));
                                break;
                            }else if(room[stack_box.y+1][stack_box.x]==1){
                                finish=true;
                                break;
                            }
                        }else if(direction==1){
                            if(room[stack_box.y][stack_box.x-1]==2){
                                if(!stack.empty())
                                    stack.pop();
                                stack.push(new Stack_box(stack_box.x-1, stack_box.y));
                                break;
                            }else if(room[stack_box.y][stack_box.x-1]==1){
                                finish=true;
                                break;
                            }
                        }else if(direction==2){
                            if(room[stack_box.y-1][stack_box.x]==2){
                                if(!stack.empty())
                                    stack.pop();
                                stack.push(new Stack_box(stack_box.x, stack_box.y-1));
                                break;
                            }else if(room[stack_box.y-1][stack_box.x]==1){
                                finish=true;
                                break;
                            }
                        }else if(direction==3){
                            if(room[stack_box.y][stack_box.x+1]==2){
                                if(!stack.empty())
                                    stack.pop();
                                stack.push(new Stack_box(stack_box.x+1, stack_box.y));
                                break;
                            }else if(room[stack_box.y][stack_box.x+1]==1){
                                finish=true;
                                break;
                            }
                        }
                    }
                }
            }
            if(finish){
                break;
            }
        }

    }

}