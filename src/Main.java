import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int tmp1=0, tmp2=1, tmp3=0;
        int a=0, b=1;
        int count = 0;
        for(int i=0; i<2000000; i++){
            if(i%3==0){
                tmp3=(tmp1+tmp2)%1000000;
                System.out.println(tmp3);
                if(tmp3==8 && count==2){
                    System.out.println(i);
                    break;
                }
                if(tmp3==8)
                    count=2;
            }else if(i%3==1){
                tmp1=(tmp2+tmp3)%1000000;
                System.out.println(tmp1);
                if(tmp1==8 && count==2){
                    System.out.println(i);
                    break;
                }
                if(tmp1==8)
                    count=2;
            }else if(i%3==2){
                tmp2=(tmp1+tmp3)%1000000;
                System.out.println(tmp2);
                if(tmp2==8 && count==2){
                    System.out.println(i);
                    break;
                }
                if(tmp2==8)
                    count=2;
            }

        }
    }
}