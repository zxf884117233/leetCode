package algorithm.linked;

/**
 * 双向循环链表
 */
public class DoubleNode {
    int data;
    //前一个节点
    DoubleNode pre=this;
    //后一个节点
    DoubleNode next=this;
    public DoubleNode(int data){
        this.data=data;
    }
    public void after(DoubleNode node){
        DoubleNode nextNext=next;
        this.next=node;
        node.pre=this;
        node.next=nextNext;
        nextNext.pre=node;
    }
    public DoubleNode pre(){
        return this.pre;
    }

    public DoubleNode next(){
        return this.next;
    }
    public int getData(){
        return this.data;
    }
}
