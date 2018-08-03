package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class hs_4013_SpecialMagnet {

    static ArrayList<Integer>[] magnetList;
    static int[][] problem;
    static int[] rotation;


    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());

        for(int i=0 ; i<T; i++) {

            rotation = new int[4];
            magnetList = new ArrayList[4];
            magnetList[0] = new ArrayList<>();
            magnetList[1] = new ArrayList<>();
            magnetList[2] = new ArrayList<>();
            magnetList[3] = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");
            int K = Integer.parseInt(st.nextToken());
            problem = new int[K][2];
            for (int m = 0; m < 4; m++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int n = 0; n < 8; n++) {
                    magnetList[m].add(Integer.parseInt(st.nextToken()));
                }
            }
            for (int j = 0; j < K; j++) {
                rotation = new int[4];
                //System.out.println("j : " + j);
                st = new StringTokenizer(br.readLine(), " ");
                problem[j][0] = Integer.parseInt(st.nextToken())-1;
                problem[j][1] = Integer.parseInt(st.nextToken());

                rotationMagnet(problem[j][0], problem[j][1], 1);
                rotationMagnet(problem[j][0], problem[j][1], -1);


                /*for(int q=0; q<4; q++){
                    System.out.println();
                    for(int p=0; p<8; p++){
                        System.out.print(magnetList[q].get(p) + " ");
                    }
                }
                System.out.println();
                System.out.println("rotation");*/
                for(int a=0 ;a<4; a++){
                    //System.out.print(rotation[a] + " " );
                    if(rotation[a]!=0)
                        rotation(a, rotation[a], true);
                }
                /*System.out.println();

                for(int q=0; q<4; q++){
                    System.out.println();
                    for(int p=0; p<8; p++){
                        System.out.print(magnetList[q].get(p) + " ");
                    }
                }
                System.out.println();*/
            }

            int result = 0;
            if(magnetList[0].get(0)==1){
                result+=1;
            }
            if(magnetList[1].get(0)==1){
                result+=2;
            }
            if(magnetList[2].get(0)==1){
                result+=4;
            }
            if(magnetList[3].get(0)==1){
                result+=8;
            }

            System.out.println("#"+(i+1)+ " " + result);

        }
    }

    static void rotationMagnet(int listNumber, int direction, int side){
        //System.out.println(listNumber + " " + direction + " " + side);

        if(listNumber<0 || listNumber>3){
            return;
        }
        if(side==1){
            if(listNumber+side<0 || listNumber+side>3){
            }else{
                if(magnetList[listNumber].get(2)!=magnetList[listNumber+side].get(6)){
                    if(direction==-1){
                        rotationMagnet(listNumber+side, 1, 1);
                    }else if(direction==1){
                        rotationMagnet(listNumber+side, -1, 1);
                    }
                    //rotation(listNumber+side, direction, false);
                }
            }
            rotation[listNumber] = direction;

        }else if(side==-1){
            if(listNumber+side<0 || listNumber+side>3){
            }else{
                if(magnetList[listNumber].get(6)!=magnetList[listNumber+side].get(2)){
                    if(direction==-1){
                        rotationMagnet(listNumber+side, 1, -1);
                    }else if(direction==1){
                        rotationMagnet(listNumber+side, -1, -1);
                    }
                    //rotation(listNumber+side, direction, false);
                }
            }

            rotation[listNumber] = direction;

        }
    }

    static void rotation(int listNumber, int direction, boolean directionFlag){
        int directionTmp = 0;
        if(!directionFlag){
            if(direction==1){
                directionTmp=-1;
            }else{
                directionTmp=1;
            }
        }else{
            directionTmp = direction;
        }
        if(directionTmp==-1){ // 반시계
            int tmp = magnetList[listNumber].get(0);
            magnetList[listNumber].remove(0);
            magnetList[listNumber].add(tmp);
        }else{ // 시계방향
            int tmp = magnetList[listNumber].get(7);
            magnetList[listNumber].remove(7);
            magnetList[listNumber].add(0, tmp);
        }
    }


}
