import java.util.Scanner;

public class Main {

    private static int T, N, X;
    private static int[][] map;
    private static int[] resultCheck;
    private static int result;

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int t=1; t<=T; t++){
            N = sc.nextInt();
            X = sc.nextInt();


            System.out.println("#" + t + " " + result);
        }
    }


}
