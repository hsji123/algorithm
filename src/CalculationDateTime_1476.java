import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CalculationDateTime_1476 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = E;
        boolean equal = false;
        while(!equal){
            if(count%28==S%28){
                if(count%19==M%19){
                    System.out.println(count);
                    equal= true;
                }
            }
            count += 15;
        }

    }


}