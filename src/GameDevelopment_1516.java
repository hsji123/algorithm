import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class GameDevelopment_1516 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int[] listTime = new int[N+1];
        int[] listTotalTime = new int[N+1];
        int[] listCount = new int[N+1];
        List<Integer>[] listBuild = new List[N+1];
        for(int i=1; i<=N; i++){
            listBuild[i] = new ArrayList<Integer>();
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int time = Integer.parseInt(st.nextToken());
            listTime[i] = time;
            while(true){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp==-1){
                    break;
                }else{
                    listBuild[tmp].add(i);
                    listCount[i]++;
                }
            }
        }

        for (int i=1; i<=N; i++) {
            //System.out.println(listCount[i]);
            if (listCount[i] == 0) {
                listTotalTime[i] = listTime[i];
                queue.add(i);
            }
        }

        for(int i=1; i<=N; i++){
            int value= queue.poll();
            //System.out.println("value : " + value + " listBuild[value] : " + listBuild[value]);
            for(int j=0; j< listBuild[value].size(); j++){
                int tmp = listBuild[value].get(j);
                //System.out.println(value + " " + tmp + " " + listCount[i] + " " + listTotalTime[tmp] + " " + listTotalTime[value] + " " + listTime[tmp]);
                if(listCount[tmp]<=1){
                    if(listTotalTime[tmp]<listTotalTime[value] + listTime[tmp]){
                        listTotalTime[tmp] = listTotalTime[value] + listTime[tmp];
                    }
                    ((LinkedList<Integer>) queue).push(tmp);
                }else{
                    if(listTotalTime[tmp]<listTotalTime[value] + listTime[tmp]){
                        listTotalTime[tmp] = listTotalTime[value] + listTime[tmp];
                    }
                    listCount[tmp]--;
                }
            }
        }

        for(int i=1; i<=N; i++){
            System.out.println(listTotalTime[i]);
        }
    }

}