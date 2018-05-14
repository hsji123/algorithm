import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class Bracket_2504 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        char[] list = new char[50];
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        int dup = 1;
        String n = st.nextToken();
        for(int i=0; i<n.length(); i++){
            list[i] = n.charAt(i);
        }

        for(int i=0; i<n.length(); i++){
            if(list[i]=='('){
                stack.push(list[i]);
                dup*=2;
                if(i+1<n.length() && list[i+1]==')'){
                    sum+=dup;
                }
            }else if(list[i]=='['){
                stack.push(list[i]);
                dup*=3;
                if(i+1<n.length() && list[i+1]==']'){
                    sum+=dup;
                }
            }else if(list[i]==')'){
                if(!stack.empty()){
                    char tmp = stack.pop();
                    if(tmp=='('){
                        dup/=2;
                    }else{
                        stack.push('(');
                        break;
                    }
                }else{
                    stack.push(list[i]);
                }
            }else if(list[i]==']'){
                if(!stack.empty()){
                    char tmp = stack.pop();
                    if(tmp=='['){
                        dup/=3;
                    }else{
                        stack.push('(');
                        break;
                    }
                }else{
                    stack.push(list[i]);
                }
            }
        }

        if(stack.empty()){
            System.out.println(sum);
        }else{
            System.out.println(0);
        }

    }

}