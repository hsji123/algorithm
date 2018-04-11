import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PaperCut_1780 {
    static int[] result = {0, 0, 0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        int[][] paper = new int[2500][2500];
        int sameTmp = 0;
        boolean same = true;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                paper[i][j]=Integer.parseInt(st.nextToken());
                if(i==0 && j==0){
                    sameTmp=paper[i][j];
                }else{
                    if(sameTmp!=paper[i][j]){
                        same=false;
                    }
                }
            }
        }

        if(same==true){
            if(sameTmp==-1){
                result[0] = 1;
            }else if(sameTmp==0){
                result[1] = 1;
            }else if(sameTmp==1){
                result[2] = 1;
            }
            System.out.println(result[0]+"\n"+result[1]+"\n"+result[2]);
            return;
        }

        getResult(paper, 0, 0, N/3);

        System.out.println(result[0]+"\n"+result[1]+"\n"+result[2]);
    }

    public static void getResult(int[][] paper, int x, int y, int N){
        int number=0;
        boolean complete = true;
        for(int a=0; a<3; a++){
            for(int b=0; b<3; b++){
                for(int i=y+a*N; i<y+a*N+N; i++){
                    for(int j=x+b*N; j<x+b*N+N; j++){
                        if(N==1){
                            number = paper[i][j];
                            if(number==-1){
                                result[0]++;
                            }else if(number==0){
                                result[1]++;
                            }else if(number==1){
                                result[2]++;
                            }
                            complete = false;
                            break;
                        }else{
                            if(i==y+a*N && j==x+b*N){
                                number=paper[i][j];
                            }else{
                                if(number!=paper[i][j]){
                                    //System.out.println("x : " + x + " y : " + y + " N : " + N);
                                    //System.out.println("a : " + a + " b : " + b);
                                    getResult(paper, x+b*N, y+a*N, N/3);
                                    complete = false;
                                    break;
                                }
                            }
                        }
                    }
                    if(!complete){
                        break;
                    }
                }
                if(!complete){
                    complete=true;
                }else{
                    if(number==-1){
                        result[0]++;
                    }else if(number==0){
                        result[1]++;
                    }else if(number==1){
                        result[2]++;
                    }
                }
            }
        }


    }
}