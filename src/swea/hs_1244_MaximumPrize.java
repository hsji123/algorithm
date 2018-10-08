package swea;

import java.util.Scanner;

class hs_1244_MaximumPrize {

    static public void main(String[] args) {

        Solution1244 solution = new Solution1244();

        String[][] tmp;

        solution.solution(new String[]{});
        //System.out.println(err);
    }


}


class Solution1244 {

    static int result;
    static int T, N, M;
    static boolean check;

    public void solution(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int t=1; t<=T; t++){
            result = 0;
            check = false;

            N = sc.nextInt();
            M = sc.nextInt();

            String NStr = N+"";

            if(NStr.length()<M+1){
                if((M+1-NStr.length())%2==1){
                    check=true;
                }
                M = NStr.length()-1;
            }


            dfs(0, NStr, 0);

            System.out.println("#"+t+" "+result);
        }


    }

    static void dfs(int count, String Nstr, int changeCount){
        if(count==Nstr.length()){
            return;
        }
        if(changeCount==M){
            //System.out.println(Nstr);
            //결산
            if(check){
                char[] NstrTmp = Nstr.toCharArray();
                char tmp1 = Nstr.charAt(Nstr.length()-1);
                char tmp2 = Nstr.charAt(Nstr.length()-2);
                NstrTmp[Nstr.length()-1] = tmp2;
                NstrTmp[Nstr.length()-2] = tmp1;
                int resultTmp = Integer.parseInt(String.valueOf(NstrTmp));
                if(resultTmp>result){
                    result = resultTmp;
                }
            }else{
                int resultTmp = Integer.parseInt(Nstr);
                if(resultTmp>result){
                    //System.out.println(resultTmp + " " + result);
                    result = resultTmp;
                }
            }
            return;
        }


        for(int i=0; i<Nstr.length(); i++){
            if(count==i){
                dfs(i+1, Nstr, changeCount);
                continue;
            }
            char[] NstrTmp = Nstr.toCharArray();
            char tmp1 = Nstr.charAt(count);
            char tmp2 = Nstr.charAt(i);
            NstrTmp[i] = tmp1;
            NstrTmp[count] = tmp2;
            dfs(i, String.valueOf(NstrTmp), changeCount+1);
        }

    }

}
