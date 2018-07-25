package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hs_1767_connectedProcessor {

    static class Core{
        int x;
        int y;

        Core(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static Core[] core;
    static int[][] processor;
    static int N;
    static int coreMaxCount;
    static int coreMinDistance;
    static int coreCount;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int T = Integer.parseInt(st.nextToken());

        for(int i=0; i<T; i++){
            coreMaxCount = 0;
            coreMinDistance = Integer.MAX_VALUE;
            coreCount = 0;

            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            processor = new int[N][N];
            core = new Core[12];
            coreCount = 0;
            for(int j=0; j<N; j++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int k=0; k<N; k++){
                    processor[j][k] = Integer.parseInt(st.nextToken());
                    if(processor[j][k]==1){
                        if(!(j==0 || j==N-1 || k==0 || k==N-1)){
                            core[coreCount++] = new Core(k, j);
                        }
                    }
                }
            }

            for(int j=0; j<5; j++){
                searchProcessor(j, 0, 0, 0);
            }

            System.out.println("#"+(i+1)+" "+coreMinDistance);
        }

    }

    static void searchProcessor(int direction, int count, int coreDistance, int connectedCoreCount){
        //System.out.println(coreCount + " " + count + " " + coreMaxCount + " " + coreMinDistance);
        if(coreCount==count){
            return;
        }
        int x = core[count].x;
        int y = core[count].y;
        boolean stopFlag = false;

        if(direction==0){
            stopFlag = false;
        }else if(direction==1){
            for(int i=x+1; i<N; i++){
                if(processor[y][i]!=0){
                    stopFlag = true;
                    break;
                }
            }
            if(!stopFlag){
                for(int i=x+1; i<N; i++){
                    processor[y][i]=count+2;
                    coreDistance++;
                }
                connectedCoreCount++;
            }
            //System.out.print(count + " " + x + " " + y);
            //for(int i=0; i<N; i++){
            //    System.out.println();
            //    for(int j=0; j<N; j++){
            //        System.out.print(processor[i][j]);
            //    }
            //}
        }else if(direction==2){
            for(int i=y+1; i<N; i++){
                if(processor[i][x]!=0){
                    stopFlag = true;
                    break;
                }
            }
            if(!stopFlag){
                for(int i=y+1; i<N; i++){
                    processor[i][x]=count+2;
                    coreDistance++;
                }
                connectedCoreCount++;
            }
        }else if(direction==3){
            for(int i=x-1; i>=0; i--){
                if(processor[y][i]!=0){
                    stopFlag = true;
                    break;
                }
            }
            if(!stopFlag){
                for(int i=x-1; i>=0; i--){
                    processor[y][i]=count+2;
                    coreDistance++;
                }
                connectedCoreCount++;
            }
        }else if(direction==4){
            for(int i=y-1; i>=0; i--){
                if(processor[i][x]!=0){
                    stopFlag = true;
                    break;
                }
            }
            if(!stopFlag){
                for(int i=y-1; i>=0; i--){
                    processor[i][x]=count+2;
                    coreDistance++;
                }
                connectedCoreCount++;
            }
        }

        //System.out.println(coreMaxCount + " " + connectedCoreCount + " " + coreMinDistance + " " + coreDistance);
        if(coreMaxCount<connectedCoreCount) {

            //최종 정리
            coreMaxCount = connectedCoreCount;
            coreMinDistance = coreDistance;

        }else if(coreMaxCount==connectedCoreCount){
            if (coreMinDistance > coreDistance) {
                coreMinDistance = coreDistance;
            }
        }

        if(!stopFlag){
            for(int j=0; j<5; j++){
                searchProcessor(j, count+1, coreDistance, connectedCoreCount);

            }
            for(int m=0; m<N; m++){
                for(int n=0; n<N; n++){
                    if(processor[m][n]==count+2){
                        processor[m][n]=0;
                    }
                }
            }
        }

    }
}
