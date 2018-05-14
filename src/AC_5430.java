import java.io.IOException;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


public class AC_5430 {

    public static void main(String args[]) throws IOException {
        //File file = new File("test.txt");
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for(int i=0; i<T; i++){
            Deque<Integer> queue = new LinkedList();
            int start = 0;
            int end = 0;
            boolean reverse = false;
            String list = scanner.next();
            char[] list3 = list.toCharArray();
            for(int j=0; j<list3.length; j++){
                if(list3[j]=='R'){
                    if(reverse){
                        reverse=false;
                    }else{
                        reverse=true;
                    }
                }else if(list3[j]=='D'){
                    if(reverse){
                        end++;
                    }else{
                        start++;
                    }
                }
            }
            int n = scanner.nextInt();
            if(start+end>n){
                System.out.println("error");
                scanner.next();
                continue;
            }
            String[] list2 = scanner.next().replace("[", "").replace("]", "").split(",");
            for(int k=0; k<n; k++){
                if(k<start){
                    continue;
                }else if(k>=n-end){
                    break;
                }
                //System.out.println(k);
                queue.offer(Integer.valueOf(list2[k]));
            }

            StringBuilder sb = new StringBuilder();
            if(start+end<=n){
                sb.append("[");
                while(!queue.isEmpty()){
                    if(reverse){
                        sb.append(queue.pollLast());
                    }else{
                        sb.append(queue.poll());
                    }
                    if(!queue.isEmpty()){
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        }

    }

}