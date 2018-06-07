package success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class hs_2606_Virus {

    static int N;
    static int result;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        List<Integer>[] list = new List[N+1];
        boolean[] checkList = new boolean[N+1];
        for(int i=0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());

        result = 0;
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            list[before].add(after);
            list[after].add(before);
        }

        queue.add(1);
        checkList[1] = true;

        while(!queue.isEmpty()){
            int tmp = queue.poll();
            for(int i=0; i<list[tmp].size(); i++){
                if(checkList[list[tmp].get(i)]){

                }else{
                    //System.out.println(list[tmp].get(i) + " " + tmp);
                    checkList[list[tmp].get(i)] = true;
                    Object x = (Integer) (tmp-1);
                    list[i+1].remove(x);
                    queue.offer(list[tmp].get(i));
                    result++;
                }
            }
        }

        System.out.println(result);
    }


}