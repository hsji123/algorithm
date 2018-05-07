import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class StepUp_2579 {

    static int[] stairs;
    static int[] stairs_max;
    static int max;
    static int N;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        N+=1;
        stairs = new int[N];
        stairs_max = new int[N];
        max = N;
        int point = 0;

        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            stairs[i] = Integer.parseInt(st.nextToken());
        }
        stairs_max[0]=stairs[0];
        stepUp(0, 0, 0);

        //for(int i=0;i<N;i++){
        //    System.out.print(stairs_max[i] + " ");
        //}
        System.out.println(stairs_max[max-1]);
    }

    static void stepUp(int before_step, int step, int point){

        //System.out.print(before_step + " " + step + " " + point + " ");
        //for(int i=0;i<N;i++){
        //    System.out.print(stairs_max[i] + " ");
        //}
        //System.out.println();
        if(step>=max){
            return;
        }
        if(point+stairs[step]< stairs_max[step]){
            return;
        }

        {

            if(step+1>=max){
                return;
            }
            if(before_step==0 || before_step+1!=step){
                if(point+stairs[step+1]>stairs_max[step+1]){
                    stairs_max[step+1]=point+stairs[step+1];
                }
                stepUp(step, step+1, point+stairs[step+1]);
            }
        }

        {
            if(step+2>=max){
                return;
            }
            if(point+stairs[step+2]>stairs_max[step+2]){
                stairs_max[step+2]=point+stairs[step+2];
            }
            stepUp(step, step+2, point+stairs[step+2]);
        }




    }

}