package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class hs_10828_Stack {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Stack stack = new Stack();

        int n = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String operatorTmp = st.nextToken();
            int number=0;
            if(operatorTmp.equals("push")){
                number = Integer.parseInt(st.nextToken());
            }

            if(operatorTmp.equals("push")){
                stack.push(number);
            }else if(operatorTmp.equals("pop")){
                if(stack.empty()){
                    System.out.println(-1);
                }else {
                    System.out.println(stack.pop());
                }
            }else if(operatorTmp.equals("size")){
                System.out.println(stack.size());
            }else if(operatorTmp.equals("empty")){
                if(stack.empty()){
                    System.out.println(1);
                }else{
                    System.out.println(0);
                }
            }else if(operatorTmp.equals("top")){
                if(stack.empty()){
                    System.out.println(-1);
                }else{
                    System.out.println(stack.lastElement());
                }
            }
        }


    }

}