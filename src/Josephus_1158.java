import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Josephus_1158 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] list = new int[5000];
        LinkedList<Integer> linkedList = new LinkedList<>();
        Queue<Integer> queue = new LinkedList();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++){
            linkedList.add(i);
        }

        int number = 0;
        while(!linkedList.isEmpty()){
            int tmp = 0;
            tmp = m + number;
            number = tmp%linkedList.size();
            //System.out.println(tmp + " " + linkedList.size() + " " + number);
            if(number==0){
                number=linkedList.size();
                tmp = linkedList.remove(linkedList.size()-1);
            }else {
                tmp = linkedList.remove(number - 1);
            }
            number-=1;
            queue.offer(tmp);
        }

        System.out.print("<");
        while(!queue.isEmpty()){
            System.out.print(queue.poll());
            if(!queue.isEmpty()){
                System.out.print(", ");
            }
        }
        System.out.print(">");

    }

}