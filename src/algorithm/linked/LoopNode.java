package algorithm.linked;

/**
 * 循环单链表
 */
public class LoopNode {
    int data;
    //下一个节点，只有一个节点时就是自己
    LoopNode next = this;

    //插入一个节点作为当前节点的下一个节点
    public void after(LoopNode node) {
        //取下一个节点，作为下下一个节点（循环链表单节点指向自己）
        LoopNode nextNext = next;
        //把新节点作为当前节点的下一个节点
        this.next = node;
        //把下下一个节点设置为新节点的下一个节点
        node.next = nextNext;
    }

    public LoopNode(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    public LoopNode next() {
        return this.next;
    }
}
