package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class hs_1167_TreeDiameter {

    static class Tree{
        int n;

        ArrayList<Node> nodeList;
        static class Node{
            int n;
            int value;
            boolean check;

            Node(int n, int value){
                this.n = n;
                this.value = value;
            }

            void setCheck(boolean check){
                this.check = check;
            }

            boolean getCheck(){
                return check;
            }
        }
        Tree(int n){
            this.n = n;
            this.nodeList = new ArrayList<>();
        }
        void addNode(Node node){
            this.nodeList.add(node);
        }
    }

    static Tree[] trees;
    static int[] distance;
    static int max;
    static int maxNodeid;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int V = Integer.parseInt(st.nextToken());
        trees = new Tree[V+1];
        distance = new int[V+1];
        for(int i=1; i<=V; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            trees[n] = new Tree(n);
            int tmp = 0;
            while(true){
                int nodeId = Integer.parseInt(st.nextToken());
                if(nodeId==-1){
                    break;
                }
                int value = Integer.parseInt(st.nextToken());
                trees[n].addNode(new Tree.Node(nodeId, value));
            }
        }

        /*for(int i=1; i<=V; i++){
            for(int j=0;j<trees[i].nodeList.size();j++){
                System.out.print(trees[i].nodeList.get(j).n + " ");
            }
            System.out.println();
        }*/

        measure(0, 1, 0);
        //distance = new int[V+1];
        max = 0;
        measure(0, maxNodeid, 0);

        System.out.println(max);
    }

    static void measure(int beforeN, int n, int sum){
        //System.out.println(beforeN + " " + n + " " + sum);
        for(int i=1; i<=trees[n].nodeList.size(); i++){
            if(beforeN==trees[n].nodeList.get(i-1).n){
                if(trees[n].nodeList.size()==1){
                    if(sum>max){
                        max=sum;
                        maxNodeid = n;
                    }
                }
                continue;
            }
            measure(n, trees[n].nodeList.get(i-1).n, sum+trees[n].nodeList.get(i-1).value);

        }
    }

}