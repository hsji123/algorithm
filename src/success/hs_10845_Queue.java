package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class hs_10845_Queue {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Queue<Integer> queue = new LinkedList<Integer>();

        int n = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String operatorTmp = st.nextToken();
            int number=0;
            if(operatorTmp.equals("push")){
                number = Integer.parseInt(st.nextToken());
            }

            if(operatorTmp.equals("push")){
                queue.offer(number);
            }else if(operatorTmp.equals("pop")){
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else {
                    System.out.println(queue.poll());
                }
            }else if(operatorTmp.equals("size")){
                System.out.println(queue.size());
            }else if(operatorTmp.equals("empty")){
                if(queue.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if(operatorTmp.equals("front")){
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(((LinkedList<Integer>) queue).getFirst());
                }
            }else if(operatorTmp.equals("back")){
                if(queue.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(((LinkedList<Integer>) queue).getLast());
                }
            }
        }


    }

}