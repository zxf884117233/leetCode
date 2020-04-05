package algorithm.linked;

//一个节点-单链表
public class Node {
    //节点内容
    int data;
    //下一个节点
    Node next;

    public Node(int data) {
        this.data = data;
    }

    //插入节点，插入链表的最后
    public Node append(Node node) {
        Node currentNode = this;
        while (true) {
            Node nextNode = currentNode.next;
            if (nextNode == null) {
                break;
            }
            currentNode = nextNode;
        }
        currentNode.next = node;
        return this;
    }

    //显示全部节点
    public void show() {
        Node currentNode = this;
        while (true) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
            if (currentNode == null) {
                break;
            }
        }
        System.out.println();
    }

    //插入一个节点作为当前节点的下一个节点
    public void after(Node node) {
        //取下一个节点作为下下一个节点
        Node nextNext = next;
        //将新节点作为当前节点的下一个节点
        this.next = node;
        //把下下一个节点设置为新节点的下一个节点
        node.next = nextNext;
    }

    //删除下一个节点
    public void removeNext() {
        //取下下一个节点
        Node newNext = next.next;
        //把下下一个节点设置为当前节点的下一个节点
        this.next = newNext;
    }

    public Node next() {
        return this.next;
    }

    public int getData() {
        return this.data;
    }

    public boolean isLast() {
        return next == null;
    }
}
