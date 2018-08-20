package success;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class hs_1325_Hacking {

    private static int N, M;
    private static int[] hackingCount;
    private static int[] listFlag;
    private static int resultMax;
    private static ArrayList<Integer> result;
    private static ArrayList<Integer>[] list;

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        list = new ArrayList[N+1];
        hackingCount = new int[N+1];
        resultMax = 0;

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[b].add(a);
        }

        for(int i=1; i<=N; i++){
            listFlag = new int[N+1];
            int count = dfs(i);
            hackingCount[i] = count;
            if(count>resultMax){
                resultMax=count;
            }
        }

        result = new ArrayList<>();
        for(int i=1; i<=N; i++){
            if(hackingCount[i]==resultMax){
                result.add(i);
            }
        }

        result.sort(new Ascending());

        for(int i=0; i<result.size(); i++){
            System.out.print(result.get(i) + " ");
        }

        //System.out.println();
        //for(int i=1; i<=N; i++){
        //    System.out.print(hackingCount[i] + " ");
        //}

    }

    static int dfs(int position){
        if(listFlag[position]==1){
            return 0;
        }
        listFlag[position] = 1;
        if(list[position].size()==0){
            return 1;
        }

        int count = 1;
        for(int i=0; i<list[position].size(); i++){
            count += dfs(list[position].get(i));
        }
        return count;
    }

    static class Ascending implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }

    }
}
