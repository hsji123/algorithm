import java.util.Scanner;

class Main {

    static public void main(String[] args) {

        Solution solution = new Solution();

        String[][] tmp;

        solution.solution(new String[]{});
        //System.out.println(err);
    }

    static class Solution {

        static int result;
        static int T, N;

        static public void solution(String[] args) {
            Scanner sc = new Scanner(System.in);

            T = sc.nextInt();

            for(int t=1; t<=T; t++){
                result = 0;

                N = sc.nextInt();


                System.out.println("#"+t+" "+result);
            }


        }


    }

}



