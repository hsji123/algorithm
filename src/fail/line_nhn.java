package fail;

import java.util.Scanner;

class line_nhn {

    static int N;
    static String[][] map;
    static int[][] mapVisited;
    static int result;
    static boolean moving;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new String[N][N];
        mapVisited = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.next();
            }
        }

        moving = true;

        while(moving){
            moving = false;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j].charAt(0)>=65)
                        System.out.println("j : " + j + " " + i + " " + map[i][j].charAt(0));
                    mapVisited = new int[N][N];
                    bfs(j, i, map[i][j].charAt(0));
                }
            }
        }

        System.out.println(result);

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(map[i][j]);
                if(j!=N-1){
                    System.out.print(" ");
                }
            }System.out.println();
        }System.out.println();

    }


    static void bfs(int x, int y, char country){
        mapVisited[y][x] = 1;
        for(int i=0; i<4; i++){
            int tmpX = x+dx[i];
            int tmpY = y+dy[i];

            if(tmpX>=0 && tmpX<N && tmpY>=0 && tmpY<N){
                if(mapVisited[tmpY][tmpX]==0){
                    if(i==0 && map[tmpY][tmpX].charAt(0)<65){
                        int wall = Integer.parseInt(map[tmpY][tmpX]) & 1;
                        if((map[tmpY][tmpX].equals("0") || wall==1? false : true)){
                            mapVisited[tmpY][tmpX] = 1;
                            map[tmpY][tmpX] = String.valueOf(country);
                            moving = true;
                            bfs(tmpX, tmpY, country);
                        }
                    }else if(i==1 && map[tmpY][tmpX].charAt(0)<65){
                        int wall = Integer.parseInt(map[tmpY][tmpX]) & 4;
                        if((map[tmpY][tmpX].equals("0") || wall==4? false : true)){
                            mapVisited[tmpY][tmpX] = 1;
                            map[tmpY][tmpX] = String.valueOf(country);
                            moving = true;
                            bfs(tmpX, tmpY, country);
                        }
                    }else if(i==2 && map[tmpY][tmpX].charAt(0)<65){
                        int wall = Integer.parseInt(map[tmpY][tmpX]) & 2;
                        if((Integer.parseInt(map[tmpY][tmpX])==0 || wall==2? false : true)){
                            mapVisited[tmpY][tmpX] = 1;
                            map[tmpY][tmpX] = String.valueOf(country);
                            moving = true;
                            bfs(tmpX, tmpY, country);
                        }
                    }else if(i==3 && map[tmpY][tmpX].charAt(0)<65){
                        int wall = Integer.parseInt(map[tmpY][tmpX]) & 8;
                        if((map[tmpY][tmpX].equals("0") || wall==8? false : true)){
                            mapVisited[tmpY][tmpX] = 1;
                            map[tmpY][tmpX] = String.valueOf(country);
                            moving = true;
                            bfs(tmpX, tmpY, country);
                        }
                    }
                }
            }
        }
    }
}








/*import java.util.ArrayList;
import java.util.Scanner;

class Main {

    static int day;
    static int[] price;
    static int result;
    static ArrayList<Integer> coinList;
    static int getPrice;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        day = sc.nextInt();
        price = new int[day];
        coinList = new ArrayList<>();

        for(int i=0; i<day; i++){
            price[i] = sc.nextInt();
        }

        dfs(0);

        System.out.println(result);
    }

    static void dfs(int count){
        if(count==day){
            if(getPrice>result){
                result = getPrice;
            }
            return;
        }


        {// 사다
            coinList.add(0, price[count]);
            dfs(count+1);
            coinList.remove(0);
        }

        {// 팔다
            int coinPrice = 0;
            for(int i=0; i<coinList.size(); i++){
                coinPrice += (price[count]-coinList.get(i));
            }
            if(coinPrice>0){
                getPrice += coinPrice-1;
                ArrayList<Integer> coinTmpList = new ArrayList<>();
                coinTmpList.addAll(coinList);
                coinList = new ArrayList<>();
                dfs(count+1);
                coinList.addAll(coinTmpList);
                getPrice -= coinPrice-1;
            }
        }

        {// 나띵
            dfs(count+1);
        }
    }
}*/












/*import java.util.Scanner;

class Main {

    static int N, W;
    static String[][] map;

    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        W = sc.nextInt();

        map = new String[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.next();
            }
        }

        int count = 0;
        if(N%2==0){
            count = N / 2;
        }else{
            count = (N-1) / 2;
        }

        for(int i=0; i<count; i++){
            int tmpW = W;
            int tmpN = N-i*2;
            if(W>0){
                tmpW = W%((tmpN-1)*4);
                rotation(tmpW, 1, i);
            }else if(W<0){
                tmpW = (W*-1)%((tmpN-1)*4);
                tmpW = tmpW*-1;
                rotation(tmpW, -1, i);
            }
            W *= -1;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(map[i][j]);
                if(j!=N-1){
                    System.out.print(" ");
                }
            }System.out.println();
        }System.out.println();
    }

    static void rotation(int tmpW, int direction, int lineCount){
        int tmpTmpW = 0;
        if(tmpW<0){
            tmpTmpW = tmpW*-1;
        }else{
            tmpTmpW = tmpW;
        }
        for(int k=0; k<tmpTmpW; k++){
            if(direction==1){ // 시계방향
                int x = lineCount;
                int y = lineCount;


                String tmp = map[y][x];
                for(y++; y<N-lineCount; y++){
                    map[y-1][x] = map[y][x];
                }y--;

                for(x++; x<N-lineCount; x++){
                    map[y][x-1] = map[y][x];
                }x--;

                for(y--; y>=lineCount; y--){
                    map[y+1][x] = map[y][x];
                }y++;

                for(x--; x>=lineCount; x--){
                    map[y][x+1] = map[y][x];
                    if(x==lineCount){
                        map[y][x+1] = tmp;
                    }
                }x++;


            }else{ // 반시계방향
                int x = lineCount;
                int y = lineCount;

                String tmp = map[y][x];
                for(x++; x<N-lineCount; x++){
                    map[y][x-1] = map[y][x];
                }x--;

                for(y++; y<N-lineCount; y++){
                    map[y-1][x] = map[y][x];
                }y--;

                for(x--; x>=lineCount; x--){
                    map[y][x+1] = map[y][x];
                }x++;

                for(y--; y>=lineCount; y--){
                    map[y+1][x] = map[y][x];
                    if(y==lineCount){
                        map[y+1][x] = tmp;
                    }
                }y++;


            }
        }
    }
}*/



/*import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int C;
    static int P;
    static ArrayList<Integer> cardList;
    static int[] shuffle;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        C = sc.nextInt();
        cardList = new ArrayList<>();
        for(int i=1; i<=C; i++){
            cardList.add(i);
        }

        P = sc.nextInt();
        shuffle = new int[P];
        for(int i=0; i<P; i++){
            shuffle[i] = sc.nextInt();
        }


        ArrayList<Integer> tmpCardList = new ArrayList<>();
        for(int i=0; i<P; i++){
            ArrayList<Integer> shuffleCardList = new ArrayList<>();
            if(tmpCardList.size()==0){
                tmpCardList.addAll(cardList);
            }
            while(true){
                int cardCount = 0;

                if(shuffleCardList.size()==0) {
                    shuffleCardList = new ArrayList<Integer>(tmpCardList.subList(shuffle[i], tmpCardList.size() - shuffle[i]));
                }else{
                    shuffleCardList = new ArrayList<Integer>(shuffleCardList.subList(shuffle[i], shuffleCardList.size() - shuffle[i]));
                }
                for(int j=0; j<shuffleCardList.size(); j++){
                    tmpCardList.remove(shuffle[i]);
                }
                tmpCardList.addAll(0, shuffleCardList);
                if(shuffle[i]*2>=shuffleCardList.size()){
                    break;
                }
            }


        }

        for(int j=0; j<5; j++){
            System.out.println(tmpCardList.get(j));
        }



    }

}*/












/*import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static Map<String, String> map = new HashMap<>();

    public static void main(String[] args) throws IOException {


        try (final BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                final StringTokenizer tokenizer = new StringTokenizer(br.readLine());
                String method = tokenizer.nextToken();
                String url = tokenizer.nextToken();
                String body = null;
                if (tokenizer.hasMoreTokens()) {
                    body = tokenizer.nextToken();
                }

                String[] urlList = url.split("/");

                if(urlList[1].equals("users")){
                    if(urlList.length==3){ // 사용자 생성
                        if(method.equals("POST")){ //생생 성공 or 이미존재
                            if(map.containsKey(urlList[2])){ // 이미존재
                                System.out.println("403 FORBIDDEN");
                            }else {
                                map.put(urlList[2], "");
                                System.out.println("201 CREATED");
                            }
                        }else{
                            System.out.println("405 METHOD_NOT_ALLOWED");
                        }
                    }else{
                        if(method.equals("POST")){ // 저장
                            if(body==null){
                                System.out.println("404 NOT_FOUND");
                            }else{// 저장 성공
                                if(map.containsKey(urlList[2])){
                                    map.replace(urlList[2], body.split("=")[1]);
                                    System.out.println("200 OK");
                                }else{
                                    System.out.println("403 FORBIDDEN");
                                }

                            }
                        }else if(method.equals("GET")){ // 리턴
                            if(body!=null){
                                System.out.println("405 METHOD_NOT_ALLOWED");
                            }else{ // 리턴 성공
                                if(!map.containsKey(urlList[2])){
                                    System.out.println("403 FORBIDDEN");
                                }else{
                                    String tmp = map.get(urlList[2]);
                                    if(tmp.equals("")){
                                        System.out.println("404 NOT_FOUND");
                                    }else{
                                        System.out.println("200 OK " + tmp);
                                    }
                                }
                            }
                        }else{
                            System.out.println("405 METHOD_NOT_ALLOWED");
                        }
                    }
                }else{
                    System.out.println("404 NOT_FOUND");
                }


            }
        }
    }
}*/

/*import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int result = 20000;

    public static void main(String... args) {
        String input = new Scanner(System.in).nextLine().trim();
        final StringTokenizer tokenizer = new StringTokenizer(input);
        while (tokenizer.hasMoreTokens()) {
            int distance = Integer.parseInt(tokenizer.nextToken());
            // @todo Write your code here.
            while(distance>0){
                if(distance<4 || distance>178){
                    System.out.println(result);
                    return;
                }
                if(distance>40){
                    if(result-800<0){
                        System.out.println(result);
                        return;
                    }else{
                        result-=80;
                        distance-=8;
                    }
                }else{
                    if(result-720<0) {
                        System.out.println(result);
                        return;
                    }else{
                        result-=720;
                        distance-=40;
                        continue;
                    }

                }
            }
        }
        // @todo Write your code here.
        System.out.println(result);
    }
}*/



/*
import java.util.Scanner;

public class Main {

    static String[][] map;
    static int[][][] mapVisited;
    static int resultX;
    static int resultY;

    static class Node{
        int x;
        int y;
        int direction;

        Node(int x, int y, int direction){
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        map = new String[N][N];
        mapVisited = new int[N][N][4];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.next();
            }
        }

        Node me = new Node(0, 0, 2);

        while(true){
            int x = me.x;
            int y = me.y;
            int direction = changeDirection(me.direction, map[me.y][me.x].charAt(0));
            int move = Integer.parseInt(map[me.y][me.x].substring(1));
            mapVisited[y][x][direction] += 1;
            me.direction = direction;
            if(direction==0){
                me.y-=move;
            }else if(direction==1){
                me.x+=move;
            }else if(direction==2){
                me.y+=move;
            }else if(direction==3){
                me.x-=move;
            }

            System.out.println(x + " " + y + " " + me.x + " " + me.y);

            int tmp = 0;
            for(int i=0; i<4; i++){
                tmp += mapVisited[y][x][i];
            }

            if((mapVisited[y][x][0]>=2 || mapVisited[y][x][1]>=2 || mapVisited[y][x][2]>=2 || mapVisited[y][x][3]>=2)){
                resultX = x;
                resultY = y;
                break;
            }

        }

        */
/*for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(map[i][j] + " ");
            }System.out.println();
        }System.out.println();*//*


        System.out.println(resultX + " " + resultY);
    }

    static int changeDirection(int direction, char turn){
        if(turn=='F'){
            return direction;
        }else if(turn=='B'){
            return (direction+2)%4;
        }else if(turn=='R'){
            return (direction+1)%4;
        }else if(turn=='L'){
            return direction-1<0 ? 3 : direction-1;
        }

        return direction+1>3 ? 0 : direction+1;
    }
}*/
