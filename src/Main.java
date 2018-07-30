import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {

    static int[] list;
    static int[] listFlag;
    static ArrayList<Integer> list1;
    static ArrayList<Integer> list2;
    static ArrayList<Integer> list3;
    static int result1;
    static int result2;
    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        list = new int[N+1];
        listFlag = new int[N+1];
        list3 = new ArrayList<Integer>();


        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            list[i] = Integer.parseInt(st.nextToken());
            if(list[i]==i){
                result1++;
                list3.add(i);
            }
        }

        for(int i=1 ;i<=N; i++){
            list1 = new ArrayList<Integer>();
            list2 = new ArrayList<Integer>();
            if(list[i]==i){
                continue;
            }else{
                dfs(i, 0);
            }
            //System.out.println();
            for(int j=0 ;j<N; j++){
                listFlag[j]=0;
            }
        }



        list3.sort(new Ascending());
        System.out.println(result1+result2);
        for(int i=0; i<list3.size(); i++){
            System.out.println(list3.get(i));
        }

    }

    static void dfs(int i, int count){
        count++;
        //System.out.println("i : " + i + " count : " + count);
        if(listFlag[i]==0 && list[list[i]]!=list[i]){
            listFlag[i]=1;
            list1.add(i);
            list2.add(list[i]);
            dfs(list[i], count);
        }else if(listFlag[i]==1){
            count--;
            list1.sort(new Ascending());
            list2.sort(new Ascending());
            for(int k=0; k<list1.size(); k++){
                if(list1.get(k)!=list2.get(k)){
                    return;
                }
            }
            if(result2<count){
                result2 = count;
                list3.addAll(list2);
                //System.out.println("result2 : " + result2);
            }
        }
    }

//5 6 2 8 3 4 2 7 6
    static class Ascending implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }

    }

}