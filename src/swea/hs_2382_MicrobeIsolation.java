package swea;

import java.util.ArrayList;
import java.util.Scanner;

class hs_2382_MicrobeIsolation {

    static public void main(String[] args) {

        Solution2382 solution = new Solution2382();

        String[][] tmp;

        solution.solution(new String[]{});
        //System.out.println(err);
    }


}


class Solution2382 {

    static int result;
    static int T, N, M, K;
    static ArrayList<Node>[][] map;

    static class Node{
        int count;
        int direction;
        int visited;

        Node(int count, int direction){
            this.count = count;
            this.direction = direction;
            this.visited = 0;
        }

        public void setVisited(int visited) {
            this.visited = visited;
        }
    }

    public void solution(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int t=1; t<=T; t++){
            result = 0;

            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();

            map = new ArrayList[N][N];

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    map[i][j] = new ArrayList<>();
                }
            }

            for(int k=0; k<K; k++){
                int y = sc.nextInt();
                int x = sc.nextInt();
                int count = sc.nextInt();
                int direction = sc.nextInt();

                map[y][x].add(new Node(count, direction));
            }

            for(int m=0; m<M; m++){
                moving();
                acting();
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(map[i][j].size()==1){
                            map[i][j].get(0).setVisited(0);
                        }
                    }
                }

                /*for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        System.out.print(map[i][j].size() + " ");

                        //if(map[i][j].size()==1){
                        //    System.out.println(j + " " + i + " " + map[i][j].get(0).count);
                        //}
                    }System.out.println();
                }System.out.println();*/
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j].size()==1){
                        result += map[i][j].get(0).count;
                    }
                }
            }

            System.out.println("#"+t+" "+result);
        }


    }

    static void moving(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j].size()!=0){
                    for(int a=0; a<map[i][j].size(); a++){
                        if(map[i][j].get(a).visited==0){
                            Node node = map[i][j].get(a);
                            node.setVisited(1);
                            if(node.direction==1){
                                map[i-1][j].add(node);
                            }else if(node.direction==2){
                                map[i+1][j].add(node);
                            }else if(node.direction==3){
                                map[i][j-1].add(node);
                            }else if(node.direction==4){
                                map[i][j+1].add(node);
                            }
                            map[i][j].remove(a--);
                        }
                    }
                }
            }
        }
    }

    static void acting(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if((i==0 || j==0 || i==N-1 || j==N-1) && map[i][j].size()==1){ // medicine
                    Node node = map[i][j].get(0);
                    map[i][j] = new ArrayList<>();
                    if(node.count%2==0){
                        node.count /= 2;
                    }else{
                        node.count = (node.count-1)/2;
                        if(node.count==0){
                            continue;
                        }
                    }
                    map[i][j].add(new Node(node.count, node.direction%2==0 ? node.direction-1 : node.direction+1));
                }else if(map[i][j].size()>1){ // merge
                    int sum = 0;
                    int max = 0;
                    int maxDirection = 0;
                    for(int a=0; a<map[i][j].size(); a++){
                        sum += map[i][j].get(a).count;
                        if(map[i][j].get(a).count>max){
                            max = map[i][j].get(a).count;
                            maxDirection = map[i][j].get(a).direction;
                        }
                    }
                    map[i][j] = new ArrayList<>();
                    map[i][j].add(new Node(sum, maxDirection));
                }
            }
        }
    }

}
