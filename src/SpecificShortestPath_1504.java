import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class SpecificShortestPath_1504 {

    static class Weight implements Comparable<Weight>{
        int weight;
        int value;

        Weight(int value, int weight){
            this.value = value;
            this.weight = weight;
        }

        public int compareTo(Weight n){
            return weight <= n.weight ? -1 : 1;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] distance = new int[N+1];
        boolean[] check = new boolean[N+1];
        List<Weight>[] maps = new List[N+1];

        for(int i=1 ;i<=N; i++){
            distance[i] = Integer.MAX_VALUE;
            maps[i] = new ArrayList<>();
        }

        int startNode = 1;
        distance[startNode] = 0;
        check[startNode] = true;

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            maps[node1].add(new Weight(node2, weight));
            maps[node2].add(new Weight(node1, weight));
        }

        st = new StringTokenizer(br.readLine(), " " );
        int middleNode1 = Integer.parseInt(st.nextToken());
        int middleNode2 = Integer.parseInt(st.nextToken());

        int[] result = new int[6];

        PriorityQueue<Weight> q = new PriorityQueue<Weight>(); //우선순위 큐

        q.offer(new Weight(startNode,distance[startNode])); //q insert

        while(!q.isEmpty()){
            int K =q.peek().value;
            //System.out.println("value : " +K);
            q.poll();

            for(int j=0;j<maps[K].size();j++){
                int index = maps[K].get(j).value;
                //System.out.println(distance[index] + " " + distance[K] + " " + maps[K].get(j).weight);
                if(distance[index]>distance[K]+maps[K].get(j).weight){
                    distance[index]=distance[K]+maps[K].get(j).weight;
                    q.offer(new Weight(index,distance[index]));
                }
            }
        }

        result[0] = distance[middleNode1];
        result[1] = distance[middleNode2];

        for(int i=1 ;i<=N; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        startNode = middleNode1;
        distance[middleNode1] = 0;

        q.offer(new Weight(middleNode1,distance[middleNode1])); //q insert

        while(!q.isEmpty()){
            int K =q.peek().value;
            //System.out.println("value : " +K);
            q.poll();

            for(int j=0;j<maps[K].size();j++){
                int index = maps[K].get(j).value;
                //System.out.println(distance[index] + " " + distance[K] + " " + maps[K].get(j).weight);
                if(distance[index]>distance[K]+maps[K].get(j).weight){
                    distance[index]=distance[K]+maps[K].get(j).weight;
                    q.offer(new Weight(index,distance[index]));
                }
            }
        }

        result[2] = distance[middleNode2];
        result[3] = distance[N];

        for(int i=1 ;i<=N; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        startNode = middleNode2;
        distance[middleNode2] = 0;

        q.offer(new Weight(middleNode2,distance[middleNode2])); //q insert

        while(!q.isEmpty()){
            int K =q.peek().value;
            //System.out.println("value : " +K);
            q.poll();

            for(int j=0;j<maps[K].size();j++){
                int index = maps[K].get(j).value;
                //System.out.println(distance[index] + " " + distance[K] + " " + maps[K].get(j).weight);
                if(distance[index]>distance[K]+maps[K].get(j).weight){
                    distance[index]=distance[K]+maps[K].get(j).weight;
                    q.offer(new Weight(index,distance[index]));
                }
            }
        }

        result[4] = distance[middleNode1];
        result[5] = distance[N];

        int tmp1 = result[0] + result[2] + result[5];
        int tmp2 = result[1] + result[4] + result[3];

        for(int i=0; i<6; i++){
            if(result[i]==Integer.MAX_VALUE){
                System.out.println(-1);
                return;
            }
        }
        if(tmp1>tmp2){
            System.out.println(tmp2);
        }else{
            System.out.println(tmp1);
        }

    }


}