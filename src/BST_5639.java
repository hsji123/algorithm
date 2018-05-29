import java.io.IOException;
import java.util.Scanner;

class Node_5639{
    long value;
    Node_5639 leftNode;
    Node_5639 rightNode;
    Node_5639 parentNode;

    Node_5639(long value){
        this.value = value;
    }

    public void setRightNode(Node_5639 rightNode) {
        this.rightNode = rightNode;
    }

    public void setLeftNode(Node_5639 leftNode) {
        this.leftNode = leftNode;
    }

    public void setParentNode(Node_5639 parentNode) {
        this.parentNode = parentNode;
    }
}

public class BST_5639 {

    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);

        Node_5639 root = new Node_5639(Long.parseLong(sc.nextLine()));
        Node_5639 currentNode = root;
        while(sc.hasNextLine()){
            currentNode = root;
            String str = sc.nextLine();
            if(str.equals("")){
                break;
            }
            long n = Long.parseLong(str);
            Node_5639 node = new Node_5639(n);
            while(true){
                if(currentNode.value>n){
                    if(currentNode.leftNode==null){
                        currentNode.setLeftNode(node);
                        break;
                    }else{
                        currentNode = currentNode.leftNode;
                    }

                } else if (currentNode.value<n) {
                    if(currentNode.rightNode==null){
                        currentNode.setRightNode(node);
                        break;
                    }else{
                        currentNode = currentNode.rightNode;
                    }
                }
            }
        }

        postOrder(root);

    }

    static void postOrder(Node_5639 currentNode){
        if(currentNode==null){
            return;
        }
        postOrder(currentNode.leftNode);
        postOrder(currentNode.rightNode);
        System.out.println(currentNode.value);
    }

}