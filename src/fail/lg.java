package fail;

import java.util.ArrayList;
import java.util.Collections;

class lg {

    static public void main(String[] args) {

        Solution2 solution = new Solution2();

        String[][] tmp;

        int[] err = solution.solution(new int[]{200, 120, 150}, new int[][]{{500, 30}, {30, 100}, {100, 400}});
        System.out.println(err);
    }


}


class Solution2 {

    static int[] result;
    static int[][] itemsList;

    public int[] solution(int[] healths, int[][] items) {

        ArrayList<Integer> resultList = new ArrayList<>();
        itemsList = new int[items.length][3];
        int[] itemsListFlag = new int[items.length];

        //오른차순 정리
        for(int i=0; i<healths.length-1; i++){
            for(int j=i+1; j<healths.length; j++){
                if(healths[i]>healths[j]){
                    int tmp = healths[i];
                    healths[i] = healths[j];
                    healths[j] = tmp;
                }
            }
        }

        //내용 + 인덱스 복사
        for(int i=0; i<items.length; i++){
            itemsList[i][0]=items[i][0];
            itemsList[i][1]=items[i][1];
            itemsList[i][2]=i;
        }

        //내림차순 정리
        for(int i=0; i<itemsList.length-1; i++){
            for(int j=i+1; j<itemsList.length; j++){
                if(itemsList[i][0]<itemsList[j][0]){
                    int tmp = itemsList[i][0];
                    itemsList[i][0] = itemsList[j][0];
                    itemsList[j][0] = tmp;
                    tmp = itemsList[i][1];
                    itemsList[i][1] = itemsList[j][1];
                    itemsList[j][1] = tmp;
                    tmp = itemsList[i][2];
                    itemsList[i][2] = itemsList[j][2];
                    itemsList[j][2] = tmp;
                }
            }
        }


        for(int i=0; i<healths.length; i++){
            for(int j=0; j<itemsList.length; j++){
                if(healths[i]-itemsList[j][1]>=100 && itemsListFlag[j]==0){
                    //아이템 사용 및 인덱스 결과에 추가
                    itemsListFlag[j]=1;
                    resultList.add(itemsList[j][2]+1);
                    break;
                }
            }
        }

        //오름차순 정리
        Collections.sort(resultList);

        result = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++){
            result[i] = resultList.get(i);
            //System.out.print(result[i] + " ");
        }

        return result;
    }


}
















//1번문제
//class Solution {
//
//    static int result = 0;
//
//    public int solution(int[] people, int[] tshirts) {
//
//        int[] peopleFlag = new int[people.length];
//
//        for(int i=0; i<people.length-1; i++){
//            for(int j=i+1; j<people.length; j++){
//                if(people[i]<people[j]){
//                    int tmp = people[i];
//                    people[i] = people[j];
//                    people[j] = tmp;
//                }
//            }
//        }
//
//        for(int i=0; i<tshirts.length-1; i++){
//            for(int j=i+1; j<tshirts.length; j++){
//                if(tshirts[i]<tshirts[j]){
//                    int tmp = tshirts[i];
//                    tshirts[i] = tshirts[j];
//                    tshirts[j] = tmp;
//                }
//            }
//        }
//
//        for(int i=0; i<tshirts.length; i++){
//            for(int j=0; j<people.length; j++){
//                if(tshirts[i]>=people[j] && peopleFlag[j]==0){
//                    peopleFlag[j]=1;
//                    result++;
//                    break;
//                }
//            }
//        }
//
//        /*for(int i=0; i<people.length; i++){
//            System.out.print(people[i] + " ");
//        }System.out.println();
//        for(int i=0; i<tshirts.length; i++){
//            System.out.print(tshirts[i] + " ");
//        }System.out.println();*/
//
//
//        return result;
//    }
//
//
//}


//2번문제
//class Solution {
//
//    static int result;
//    static int[][] map;
//    static ArrayList<Integer> factorys;
//
//    public int solution(int N, int[][] house) {
//
//        map = new int[201][201];
//        factorys = new ArrayList<>();
//        for(int i=0; i<house.length; i++){
//            map[house[i][1]+100][house[i][0]+100] = 1;
//
//        }
//
//        for(int i=-100; i<=100; i++){
//            for(int j=-100; j<=100; j++){
//                if(map[i+100][j+100]==0){
//                    int tmp = Integer.MAX_VALUE;
//                    for(int k=0; k<house.length; k++){
//                        int distance = (int) (Math.pow(j-house[k][0], 2)+Math.pow(i-house[k][1], 2));
//                        if(tmp>distance){
//                            tmp = distance;
//                        }
//                    }
//                    factorys.add(tmp);
//                }
//            }
//        }
//
//        Collections.sort(factorys);
//        Collections.reverse(factorys);
//
//        if(factorys.size()<N){
//            return -1;
//        }else{
//            result = factorys.get(N-1);
//            return result;
//        }
//    }
//
//}


//3번문제
//class Solution {
//
//    static int[] result;
//    static int[][] itemsList;
//
//    public int[] solution(int[] healths, int[][] items) {
//
//        ArrayList<Integer> resultList = new ArrayList<>();
//        itemsList = new int[items.length][2];
//        int[] itemsListFlag = new int[items.length];
//
//        for(int i=0; i<healths.length-1; i++){
//            for(int j=i+1; j<healths.length; j++){
//                if(healths[i]>healths[j]){
//                    int tmp = healths[i];
//                    healths[i] = healths[j];
//                    healths[j] = tmp;
//                }
//            }
//        }
//
//        for(int i=0; i<items.length; i++){
//            itemsList[i]=items[i].clone();
//        }
//
//        for(int i=0; i<itemsList.length-1; i++){
//            for(int j=i+1; j<itemsList.length; j++){
//                if(itemsList[i][0]<itemsList[j][0]){
//                    int tmp = itemsList[i][0];
//                    itemsList[i][0] = itemsList[j][0];
//                    itemsList[j][0] = tmp;
//                    tmp = itemsList[i][1];
//                    itemsList[i][1] = itemsList[j][1];
//                    itemsList[j][1] = tmp;
//                }
//            }
//        }
//
//
//        for(int i=0; i<healths.length; i++){
//            for(int j=0; j<itemsList.length; j++){
//                if(healths[i]-itemsList[j][1]>=100 && itemsListFlag[j]==0){
//                    itemsListFlag[j]=1;
//                    for(int k=0; k<items.length; k++){
//                        if(items[k][0]==itemsList[j][0]){
//                            resultList.add(k+1);
//                        }
//                    }
//                    break;
//                }
//            }
//        }
//
//        Collections.sort(resultList);
//
//        result = new int[resultList.size()];
//        for(int i=0; i<resultList.size(); i++){
//            result[i] = resultList.get(i);
//        }
//
//        return result;
//    }
//
//
//}


//4번문제
//class Solution {
//
//    static int[] result;
//    static Queue<Node> queue;
//    static ArrayList<Integer>[] trees;
//
//    static class Node{
//        int x;
//        int count;
//
//        Node(int x, int count) {
//            this.x = x;
//            this.count = count;
//
//        }
//    }
//
//    public int[] solution(int N, int[][] directory, int[][] query) {
//
//        result = new int[query.length];
//
//
//        trees = new ArrayList[N+1];
//        for(int i=0; i<trees.length; i++){
//            trees[i] = new ArrayList<Integer>();
//        }
//
//        for(int i=0; i<directory.length; i++){
//            trees[directory[i][0]].add(directory[i][1]);
//            trees[directory[i][1]].add(directory[i][0]);
//        }
//
//        //쿼리 돌면서 문제 풀기
//        for(int a=0; a<query.length; a++){
//            queue = new LinkedList<>();
//            result[a] = bfs(query[a][0], query[a][1], 1);
//            System.out.println(result[a]);
//        }
//
//
//        return result;
//    }
//
//    static int bfs(int start, int end, int count){
//        if(start==end){
//            return 1;
//        }
//        queue.offer(new Node(start, count));
//
//        while(!queue.isEmpty()){
//            Node node = queue.poll();
//            for(int i=0; i<trees[node.x].size(); i++){
//                if(trees[node.x].get(i)==end){
//                    return node.count+1;
//                }else{
//                    queue.offer(new Node(trees[node.x].get(i), node.count+1));
//                }
//            }
//        }
//
//        return 0;
//    }
//
//}