import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;


public class Deque_10866 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Deque<Integer> deque = new LinkedBlockingDeque<>();

        int n = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String operatorTmp = st.nextToken();
            int number=0;
            if(operatorTmp.equals("push_front") || operatorTmp.equals("push_back")){
                number = Integer.parseInt(st.nextToken());
            }

            if(operatorTmp.equals("push_front")){
                deque.offerFirst(number);
            }else if(operatorTmp.equals("push_back")){
                deque.offerLast(number);
            }else if(operatorTmp.equals("pop_front")){
                if(deque.isEmpty()){
                    System.out.println(-1);
                }else {
                    System.out.println(deque.pollFirst());
                }
            }else if(operatorTmp.equals("pop_back")){
                if(deque.isEmpty()){
                    System.out.println(-1);
                }else {
                    System.out.println(deque.pollLast());
                }
            }else if(operatorTmp.equals("size")){
                System.out.println(deque.size());
            }else if(operatorTmp.equals("empty")){
                if(deque.isEmpty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if(operatorTmp.equals("front")){
                if(deque.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(deque.getFirst());
                }
            }else if(operatorTmp.equals("back")){
                if(deque.isEmpty()){
                    System.out.println(-1);
                }else{
                    System.out.println(deque.getLast());
                }
            }
        }


    }

}