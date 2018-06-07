package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class hs_11657_timeMachine {

    static class Route {
        int weight;
        int value;

        Route(int value, int weight){
            this.value = value;
            this.weight = weight;
        }

    }

    static int[] distance;
    static int vertexNum;
    static List<Route>[] maps;
    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        vertexNum = N;
        distance = new int[N+1];

        maps = new List[N+1];
        for(int i=0 ;i<N+1; i++){
            maps[i] = new ArrayList<Route>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            maps[s].add(new Route(g, w));
        }

        for(int i=2; i<=N; i++){
            int tmp = bellmanFord(i);
            if(tmp == -1){
                System.out.println(-1);
                break;
            }else if(tmp == Integer.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(tmp);
            }
        }

    }

    static int bellmanFord(int edgeNum){
        distance[1] = 0;
        for(int i=2; i<=vertexNum; i++)
            distance[i] = Integer.MAX_VALUE;
        boolean update = false;
        for(int i=0; i<vertexNum; i++){
            //System.out.println("i : " + i);
            update = false;
            for(int vi=1; vi<=vertexNum; vi++){
                //System.out.println("vi : " + vi);
                for(int adj = 1; adj<=maps[vi].size(); adj++){
                    //System.out.println("adj : " + adj);
                    if(distance[vi]==Integer.MAX_VALUE){
                        continue;
                    }
                    if(distance[maps[vi].get(adj-1).value] > distance[vi] + maps[vi].get(adj-1).weight){
                        distance[maps[vi].get(adj-1).value] = distance[vi] + maps[vi].get(adj-1).weight;
                        update = true;
                    }
                }
            }
            if(!update) break; //완화를 전부
        }
        if(update){
            if(distance[edgeNum]==Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            return -1; //(VertexNum - 1)번 한 후 완화 가능하면 사이클이 존재하는 것
        }
        return distance[edgeNum];
    }
}