package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class hs_1865_Wormhole {

    static class Node{
        int value;
        int time;

        Node(int value, int time){
            this.value = value;
            this.time = time;
        }
    }

    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int[] distance = new int[N+1];
            List<Node>[] town = new List[N+1];
            for(int j=1; j<=N; j++){
                town[j] = new ArrayList<Node>();
            }

            for(int j=1; j<=M; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                town[s].add(new Node(g, w));
                town[g].add(new Node(s, w));
            }
            for(int j=1; j<=W; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int s = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                town[s].add(new Node(g, -w));
            }

            System.out.println(bellmanFord(1, town, distance));


        }

    }

    static String bellmanFord(int startNode, List<Node>[] town, int[] distance){
        for(int i=1; i<=N; i++)
            distance[i] = Integer.MAX_VALUE;
        distance[startNode] = 0;
        boolean update = false;
        for(int j=1; j<=N; j++){
            update = false;
            for(int k=1; k<=N; k++){
                for(int l=1; l<=town[k].size(); l++){
                    if(distance[k] == Integer.MAX_VALUE){
                        continue;
                    }
                    if(distance[town[k].get(l-1).value] > distance[k] + town[k].get(l-1).time){
                        distance[town[k].get(l-1).value] = distance[k] + town[k].get(l-1).time;
                        update = true;
                    }
                }
            }
            if(!update){
                break;
            }
        }
        if (update) {
            return "YES";
        }else{
            return "NO";
        }
    }
}