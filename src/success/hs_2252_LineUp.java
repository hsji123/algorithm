package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class hs_2252_LineUp {

    static class Node{
        LinkedList<Integer> nodeList;

        Node(){
            nodeList = new LinkedList<>();
        }

        void addNodeList(int value){
            this.nodeList.add(value);
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        Node[] list = new Node[N+1];
        int[] lineCount = new int[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new Node();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int front = Integer.parseInt(st.nextToken());
            int back = Integer.parseInt(st.nextToken());
            lineCount[back]++;

            list[front].addNodeList(back);
        }

        for(int i=1; i<=N; i++){
            if(lineCount[i]==0){
                ((LinkedList<Integer>) queue).add(i);
            }
        }

        StringBuffer stb = new StringBuffer();
        for(int j=0; j<N; j++){
            int nodeValue = ((LinkedList<Integer>) queue).poll();
            stb.append(nodeValue+" ");
            for(int i=0; i<list[nodeValue].nodeList.size(); i++){
                int tmp = list[nodeValue].nodeList.get(i);
                if(lineCount[tmp]<=1){
                    ((LinkedList<Integer>) queue).push(tmp);
                }else{
                    lineCount[tmp]--;
                }
            }
        }
        System.out.println(stb.substring(0, stb.length()-1));

    }

}