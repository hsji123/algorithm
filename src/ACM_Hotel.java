import java.util.Scanner;

public class ACM_Hotel {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0; i<T; i++){
            int n, h, w;
            h = sc.nextInt();
            w = sc.nextInt();
            n = sc.nextInt();

            if(n%h==0){
                if(n/h<10){
                    System.out.println(h+"0"+n/h);
                }else{
                    System.out.println(h+""+n/h);
                }
            }else{
                if(n/h+1<10){
                    System.out.println(n%h+"0"+(n/h+1));
                }else{
                    System.out.println(n%h+""+(n/h+1));
                }
            }
        }
    }
}
