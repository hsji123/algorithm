import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NavigableMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Node_2957{
    int value;
    long depth;

    Node_2957(int value, long depth){
        this.value = value;
        this.depth = depth;
    }

}

public class BST_2957 {
    static long c;
    static Node_2957[] nodeList;
    static NavigableMap<Integer, Long> navigableMap;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        nodeList = new Node_2957[300002];
        nodeList[0] = new Node_2957(0, -1);
        nodeList[300001] = new Node_2957(0, -1);
        navigableMap = new TreeMap<>();
        navigableMap.put(0, -1l);
        navigableMap.put(300001, -1l);
        st = new StringTokenizer(br.readLine(), " ");
        Node_2957 root = new Node_2957(Integer.parseInt(st.nextToken()), 1);
        nodeList[root.value] = root;
        navigableMap.put(root.value, root.depth);
        System.out.println(c);
        for(int i=2; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            //c = 0;
            insert(x, root);
            System.out.println(c);
        }

    }

    static void insert(int x, Node_2957 n){
        //System.out.println(x + " " + c);
        int minID = navigableMap.lowerEntry(x).getKey();
        int maxID = navigableMap.higherEntry(x).getKey();
        if(nodeList[minID].depth>nodeList[maxID].depth){
            Node_2957 newNode = new Node_2957(x, nodeList[minID].depth+1);
            c+=nodeList[minID].depth;
            nodeList[x] = newNode;
            navigableMap.put(x, nodeList[minID].depth+1);

        }else{
            Node_2957 newNode = new Node_2957(x, nodeList[maxID].depth+1);
            c+=nodeList[maxID].depth;
            nodeList[x] = newNode;
            navigableMap.put(x, nodeList[maxID].depth+1);

        }

    }


}