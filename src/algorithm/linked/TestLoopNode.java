package algorithm.linked;

public class TestLoopNode {
    public static void main(String[] args) {
        LoopNode l1=new LoopNode(1);
        LoopNode l2=new LoopNode(2);
        LoopNode l3=new LoopNode(3);
        LoopNode l4=new LoopNode(4);
        //l1.after(l2);
        //l2.after(l3);
        //l3.after(l4);
        System.out.println(l1.next().getData());
        //System.out.println(l2.next().getData());
        //System.out.println(l3.next().getData());
        //System.out.println(l4.next().getData());

    }
}
