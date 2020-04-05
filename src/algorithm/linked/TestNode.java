package algorithm.linked;

public class TestNode {
    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        n1.append(n2).append(n3).append(new Node(4));

        n1.show();
        n2.removeNext();
        n1.show();
    }

}
