package fail;

import java.util.ArrayList;

class fsef {

    private static int T, N;
    private static int[][] map;
    private static int count = 0;
    private static int[][] answer;

    static class Node{
        int x;
        int y;
        int index;

        Node(int x, int y, int index){
            this.x =x ;
            this.y =y ;
            this.index = index;
        }
    }
    static public void main(String[] args) {

        int[][] nodeinfo = {};

        int[] root = new int[2];
        map = new int[10000][50000];

        answer = new int[2][nodeinfo.length];
        int maxY = 0;
        for(int i=0; i<nodeinfo.length; i++){
            if(nodeinfo[i][1]>maxY){
                maxY=nodeinfo[i][1];
                root[0] = nodeinfo[i][0];
                root[1] = nodeinfo[i][1];
            }
            map[nodeinfo[i][1]][nodeinfo[i][0]] = i+1;
        }

        preOrder(root[0], root[1], 0, 100000, nodeinfo);

        count = 0;
        postOrder(root[0], root[1], 0, 100000, nodeinfo);

        //return answer;

    }

    static void preOrder(int x, int y, int minX, int maxX, int[][] nodeinfo){
        if(count==nodeinfo.length){
            count=0;
            return;
        }
        //본인입력
        answer[0][count] = map[y][x];

        int leftY = -1;
        //왼쪽트리
        boolean stop = false;
        for(int i=y-1; i>=0; i--){
            for(int j=minX; j<x; j++){
                if(map[i][j]!=0){
                    leftY = i;
                    count++;
                    preOrder(j, i, minX, x, nodeinfo);
                    stop = true;
                    break;
                }
            }
            if(stop){
                break;
            }
        }

        //오른쪽트리
        stop = false;
        if(leftY==-1){
            for(int i=y-1; i>=0; i--) {
                for (int j = x + 1; j < maxX; j++) {
                    if (map[i][j] != 0) {
                        count++;
                        preOrder(j, i, x, maxX, nodeinfo);
                        stop = true;
                        break;
                    }
                }
                if(stop){
                    break;
                }
            }
        }else{
            for (int j = x + 1; j < maxX; j++) {
                if (map[leftY][j] != 0) {
                    count++;
                    preOrder(j, leftY, x, maxX, nodeinfo);
                    break;
                }
            }
        }
    }

    static void postOrder(int x, int y, int minX, int maxX, int[][] nodeinfo){

        int leftY = -1;
        //왼쪽트리
        boolean stop = false;
        for(int i=y-1; i>=0; i--){
            for(int j=minX; j<x; j++){
                if(map[i][j]!=0){
                    leftY = i;
                    postOrder(j, i, minX, x, nodeinfo);
                    stop = true;
                    break;
                }
            }
            if(stop){
                break;
            }
        }

        //오른쪽트리
        stop = false;
        if(leftY==-1){
            for(int i=y-1; i>=0; i--) {
                for (int j = x + 1; j < maxX; j++) {
                    if (map[i][j] != 0) {
                        postOrder(j, i, x, maxX, nodeinfo);
                        stop = true;
                        break;
                    }
                }
                if(stop){
                    break;
                }
            }
        }else{
            for (int j = x + 1; j < maxX; j++) {
                if (map[leftY][j] != 0) {
                    postOrder(j, leftY, x, maxX, nodeinfo);
                    break;
                }
            }
        }
        //본인입력

        answer[1][count] = map[y][x];
        count++;
        if(count==nodeinfo.length){
            count=0;
            return;
        }

    }
}








//4번 문제

//food_times = new int[]{3, 1, 2, 99, 3};
//        long k = 100;
//
//        int tmp = 0;
//        for(int i=0; i<k; i++){
//            if(food_times[tmp]==0){
//                int start=tmp;
//                while (food_times[tmp]==0){
//                    tmp++;
//                    if(tmp>=food_times.length){
//                        tmp=0;
//                    }
//                    if(tmp==start){
//                        System.out.println(-1);
//                        return;
//                    }
//                }
//            }
//            System.out.println(tmp);
//            food_times[tmp]--;
//            tmp++;
//            if(tmp>=food_times.length){
//                tmp=0;
//            }
//
//        }
//
//        if(food_times[tmp]==0){
//            int start=tmp;
//            while (food_times[tmp]==0){
//                tmp++;
//                if(tmp>=food_times.length){
//                    tmp=0;
//                }
//                if(tmp==start){
//                    System.out.println(-1);
//                    return;
//                }
//            }
//        }
//        System.out.println(tmp+1);
//
//    }


//3번 문제

//relation = new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
//
//        int answer = 0;
//        visited = new int[relation[0].length];
//
//        for (int j = 0; j < relation[0].length; j++) {
//            System.out.println();
//            combination(new String[relation.length], j);
//        }
//
//
//        System.out.println(result);
//
//
//    }
//
//    static void combination(String[] rel, int count){
//        String[] relTmp = new String[rel.length];
//
//        if(count==relation[0].length){
//            result++;
//            System.out.println("succ : " + count);
//            return;
//        }else{
//            System.out.println(count);
//            for (int j = 0; j < rel.length; j++) {
//                relTmp[j] = rel[j];
//            }
//            HashMap<String, Integer> hashMap = new HashMap<>();
//            {
//                for (int j = 0; j < rel.length; j++) {
//                    System.out.print(rel[j] + " ");
//                }
//                System.out.println();
//                combination(rel, count + 1);
//                for (int j = 0; j < rel.length; j++) {
//                    rel[j] = relTmp[j];
//                }
//            }
//            System.out.println("43242343");
//            hashMap = new HashMap<>();
//            {
//                for (int j = 0; j < rel.length; j++) {
//                    if (rel[j] == null) {
//                        rel[j] = relation[j][count];
//                    } else {
//                        rel[j] += relation[j][count];
//                    }
//                    if (!hashMap.containsKey(rel[j])) {
//                        System.out.println("add : " + rel[j]);
//                        hashMap.put(rel[j], 1);
//                    }else {
//                        System.out.println(rel[j]);
//                        for (int k = 0; k < j; k++) {
//                            hashMap.remove(rel[k]);
//                        }
//                        return;
//                    }
//                }
//                for (int j = 0; j < rel.length; j++) {
//                    System.out.print(rel[j] + " ");
//                }
//                System.out.println();
//
//                combination(rel, count + 1);
//                for (int j = 0; j < rel.length; j++) {
//                    hashMap.remove(rel[j]);
//                }
//                for (int j = 0; j < rel.length; j++) {
//                    rel[j] = relTmp[j];
//                }
//            }
//        }
//    }




//2번 문제

//stages = new int[]{2, 1, 2, 6, 2, 4, 3, 3};
//        N = 5;
//
//        int[] stage = new int[N+2];
//        ArrayList<Node> failure = new ArrayList<>();
//        int[] answer = new int[N+1];
//
//        for(int i=0; i<stages.length; i++){
//            stage[stages[i]]++;
//        }
//
//        float tmp = 0;
//        for(int i=stage.length-1; i>=1; i--){
//            tmp += stage[i];
//            if(i!=stage.length-1){
//                failure.add(0, new Node(stage[i]*10000/tmp, i));
//            }
//        }
//
//        failure.sort(new Descending());
//
//        for(int i=0; i<failure.size(); i++){
//            answer[i] = failure.get(i).index;
//            System.out.print(failure.get(i).index + " ");
//        }System.out.println();
//
//    }
//    static class Descending implements Comparator<Node> {
//        @Override
//        public int compare(Node o1, Node o2) {
//            if(o2.failure>o1.failure){
//                return 1;
//            }else if(o2.failure==o1.failure){
//                return 0;
//            }else{
//                return -1;
//            }
//        }
//    }
//
//    static class Node{
//        float failure;
//        int index;
//
//        Node(float failure, int index){
//            this.failure = failure;
//            this.index = index;
//        }
//    }






//1번 문제

//record = new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
//
//        ArrayList<String> chatList = new ArrayList<>();
//        HashMap<String,String> userList = new HashMap<>();
//
//        for(int i=0; i<record.length; i++){
//            if(record[i].split(" ")[0].equals("Enter")){
//                boolean userTmp = false;
//                if(userList.get(record[i].split(" ")[1])!=null){
//                    userTmp = true;
//                    userList.remove(record[i].split(" ")[1]);
//                    userList.put(record[i].split(" ")[1], record[i].split(" ")[2]);
//                }
//
//                if(!userTmp){
//                    userList.put(record[i].split(" ")[1], record[i].split(" ")[2]);
//                }
//                chatList.add("Enter " + record[i].split(" ")[1]);
//            }else if(record[i].split(" ")[0].equals("Leave")){
//                chatList.add("Leave " + record[i].split(" ")[1]);
//            }else if(record[i].split(" ")[0].equals("Change")){
//                userList.remove(record[i].split(" ")[1]);
//                userList.put(record[i].split(" ")[1], record[i].split(" ")[2]);
//            }
//        }
//
//        String[] answer = new String[chatList.size()];
//
//        for(int i=0; i<chatList.size(); i++){
//            if(chatList.get(i).split(" ")[0].equals("Enter")){
//                answer[i]=userList.get(chatList.get(i).split(" ")[1])+"님이 들어왔습니다.";
//
//            }else if(chatList.get(i).split(" ")[0].equals("Leave")){
//                answer[i]=userList.get(chatList.get(i).split(" ")[1])+"님이 나갔습니다.";
//
//            }
//        }
//
//        for(int i=0; i<chatList.size(); i++) {
//            System.out.println(answer[i]);
//        }
//        //Ryan님이 들어왔습니다.
//        //Prodo님이 나갔습니다.













//
class Solution {
    static int result = 0;
    static ArrayList<String> arrayList = new ArrayList<>();
    public int solution(String[][] relation) {

        for(int i=0; i<relation[0].length; i++){
            String[] relationStr = new String[relation.length];
            for(int j=0; j<relation.length; j++){
                relationStr[j] = i+relation[j][i];
            }
            combination(relationStr, i, relation);
        }

        return result;
    }

    static void combination(String[] relationStr, int count, String[][] relation){

        if(count>=relation[0].length){
            return;
        }
        boolean candidate = false;
        for(int i=0; i<relationStr.length-1; i++){
            for(int j=i+1; j<relationStr.length; j++){
                if(relationStr[i].equals(relationStr[j])){
                    candidate = true;
                    break;
                }
            }
            if(candidate){
                break;
            }
        }
        if(!candidate){
            for(int i=0; i<relationStr.length; i++){
                System.out.print(relationStr[i] + " ");
            }System.out.println();
            if(arrayList.contains(relationStr[0])){
                return;
            }else{
                arrayList.add(relationStr[0]);
            }

            result++;
            return;
        }

        {
            combination(relationStr, count+1, relation);
        }

        {
            for(int i=count+1; i<relation[0].length; i++){
                String[] tmp = new String[relationStr.length];
                System.arraycopy(relationStr, 0, tmp, 0, relationStr.length);
                for(int j=0; j<relationStr.length; j++){
                    relationStr[j] = relationStr[j]+i+relation[j][i];
                }
                combination(relationStr, count+i, relation);
                System.arraycopy(tmp, 0, relationStr, 0, relationStr.length);
            }

        }
    }

}

