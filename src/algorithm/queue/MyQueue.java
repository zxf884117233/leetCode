package algorithm.queue;

/**
 * 数组实现队列 顺序存储
 */
public class MyQueue {
    int [] elements;
    public MyQueue(){
        elements=new int[0];
    }

    //入队
    public void add(int element){
        int [] newArr=new int[elements.length+1];
        //把原数组的元素复制到新数组
        for(int i=0;i<elements.length;i++){
            newArr[i]=elements[i];
        }
        newArr[elements.length]=element;
        elements=newArr;
    }

    //出队
    public int poll(){
        int element=elements[0];
        int [] newArr=new int[elements.length-1];
        //把原数组除了队头复制到新数组
        for(int i=0;i<elements.length;i++){
            newArr[i]=elements[i+1];
        }
        elements=newArr;
        return element;
    }
    public  boolean isEmpty(){
        return elements.length==0;
    }
}
