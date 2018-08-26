package success;

import java.util.ArrayList;
import java.util.Scanner;

public class hs_1339_WordMath {

    private static int N;
    private static String[] wordList;
    private static String[] wordListCopy;
    private static int[] alphabet;
    private static int[] alphabetCount;
    private static int result;

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        wordList = new String[N+1];
        wordListCopy = new String[N+1];
        alphabet = new int[30];
        alphabetCount = new int[30];
        for(int i=0; i<26; i++){
            alphabet[i]=-1;
        }
        ArrayList<Character> alphabetList = new ArrayList<>();

        for(int i=0; i<N; i++){
            wordList[i] = sc.next();
            wordListCopy[i] = wordList[i];
            for(int j=0; j<wordList[i].length(); j++){
                if(!alphabetList.contains(wordList[i].charAt(j))){
                    alphabetList.add(wordList[i].charAt(j));
                }
            }
        }

        // 0 예외처리!!

        //for(int i=0; i<alphabetList.size(); i++){
        //    System.out.print(alphabetList.get(i) + " ");
        //}System.out.println();


        for(int k=8; k>0; k--){
            for(int i=0; i<N; i++){
                if(wordListCopy[i].length()==k){
                    char first = wordList[i].charAt(wordList[i].length()-k);
                    //System.out.println(first);
                    alphabetCount[first-'A'] += Math.pow(10,k-1);
                    wordListCopy[i] = wordListCopy[i].substring(1);
                }
            }
        }

        //for(int i=0; i<26; i++){
        //    System.out.print(alphabetCount[i]+ " ");
        //}System.out.println();


        for(int i=0; i<alphabetList.size()-1; i++){
            for(int j=0; j<alphabetList.size()-i-1; j++){
                //System.out.println("i : " + i + " j : " + j + " N : " + N);
                if(alphabetCount[alphabetList.get(j)-'A']<alphabetCount[alphabetList.get(j+1)-'A']){
                    alphabetList.add(j, alphabetList.get(j+1));
                    alphabetList.remove(j+2);
                }
            }
        }

        //for(int i=0; i<alphabetList.size(); i++){
        //    System.out.print(alphabetList.get(i) + " ");
        //}System.out.println();

        int count = 9;

        for(int i=0; i<alphabetList.size(); i++){
            alphabet[alphabetList.get(i)-'A'] = count--;
        }



        /*boolean zeroCheck = false;

        while(!zeroCheck){
            for(int i=0; i<N; i++){
                char first = wordList[i].charAt(0);
                if(alphabet[first-'A']==0){

                }
            }
        }*/

        for(int k=0; k<8; k++){
            for(int i=0; i<N; i++){
                if(wordList[i].length()>k){
                    char first = wordList[i].charAt(wordList[i].length()-k-1);
                    //System.out.println(first + " " + alphabet[first-'A']*Math.pow(10,k));
                    result += alphabet[first-'A']*Math.pow(10,k);
                }
            }
        }

        System.out.println(result);
    }
}
