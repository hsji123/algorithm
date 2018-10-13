package kakao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class hs_CandidateKey {

    static public void main(String[] args) {

        Solution solution = new Solution();

        /*String[][] tmp = {{"100","ryan","music","2"},{"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "5"}, {"600", "apeach", "music", "2"}};
*/
        String[][] tmp = {{"500","ryan","music","1"},{"500", "ryan", "music", "2"},
                {"500", "ryan", "ryan", "3"}, {"500", "ryan", "music", "4"},
                {"400", "ryan", "music", "4"}, {"500", "ryan", "music", "6"}};

        int err = solution.solution(tmp);
        System.out.println(err);
    }

    static class Solution {

        static int result = 0;
        static ArrayList<ArrayList<String>> resultStr;
        static Queue<Node> queue;

        static class Node{
            int count;
            int colNumber;
            int[] map;

            Node(int count, int colNumber, int[] map, int relationLength){
                this.count = count;
                this.colNumber = colNumber;
                this.map = new int[relationLength];
                for(int i=0; i<map.length; i++){
                    this.map[i] = map[i];
                }
            }
        }

        public int solution(String[][] relation) {

            resultStr = new ArrayList<>();
            queue = new LinkedList<Node>();
            int[] map = new int[relation[0].length];

            for(int i=0; i<relation[0].length; i++){
                map[i] = 1;
                queue.offer(new Node(0, i, map, relation[0].length));
                map[i] = 0;
            }

            combination(relation);

            return result;
        }

        static void combination(String[][] relation){

            while(!queue.isEmpty()){
                Node node = queue.poll();

                if(checking(relation, node.map)){ // 후보키 만족, 더이상 진행 x
                    continue;
                }else{ // 후보키 불만족, 계속 진행
                    for(int i=node.colNumber+1; i<relation[0].length; i++){
                        node.map[i] = 1;
                        node.colNumber = i;

                        queue.offer(new Node(node.count, node.colNumber, node.map, relation[0].length));
                        node.map[i] = 0;
                    }
                }
            }
        }

        static boolean checking(String[][] relation, int[] map){

            String[] combi = new String[relation.length];
            for(int i=0; i<combi.length; i++){
                combi[i] = "";
            }

            for(int i=0; i<map.length; i++){
                if(map[i]==1){
                    for(int j=0; j<combi.length; j++){
                        combi[j]+=i+relation[j][i];
                    }
                }
            }

            for(int i=0; i<resultStr.size(); i++){
                boolean tmp2 = true;
                for(int j=0; j<resultStr.get(i).size(); j++){
                    boolean tmp = false;
                    for(int k=0; k<map.length; k++){
                        if(map[k]==1){
                            if(resultStr.get(i).get(j).equals(k+relation[0][k])){
                                tmp = true;
                                break;
                            }
                        }
                    }
                    if(tmp){
                        continue;
                    }else{
                        tmp2 = false;
                        break;
                    }
                }
                if(tmp2){
                    return false;
                }
            }


            for(int i=0; i<combi.length-1; i++){
                for(int j=i+1; j<combi.length; j++){
                    if(combi[i].equals(combi[j])){
                        return false;
                    }
                }
            }

            /*for(int i=0; i<combi.length; i++){
                System.out.print(combi[i] + " ");
            }System.out.println();
*/
            resultStr.add(0, new ArrayList<>());
            for(int i=0; i<map.length; i++){
                if(map[i]==1){
                    resultStr.get(0).add(i+relation[0][i]);
                }
            }

            /*for(int i=0; i<resultStr.size(); i++){
                for(int j=0; j<resultStr.get(i).size(); j++){
                    System.out.print(resultStr.get(i).get(j) + " ");
                }System.out.println();
            }System.out.println();
*/
            result++;
            return true;
        }

    }

}