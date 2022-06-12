package Queue;

import java.util.Arrays;

public class ArrQueue {
    private final int maxSize;
    private final long[] queueArr;
    private int front;
    private int rear;
    private int elementNum;

    public ArrQueue(int size){
        maxSize = size;
        queueArr = new long [maxSize];
        front = 0;
        rear = -1;
        elementNum = 0;
    }

    public boolean isEmpty(){
        return elementNum == 0;
    }

    public boolean isFull() {
        return elementNum == maxSize;
    }

    public void enqueue(long data){
        if (rear == maxSize -1)
            rear = -1;

        queueArr[++rear] = data;
        elementNum++;
    }

    public long dequeue(){
        long removedElement = queueArr[front++];
        if (front == maxSize)
            front = 0;
        elementNum--;
        return removedElement;
    }

    public long queuePosition() {
        return queueArr[front];
    }

    public int queueSize() {
        return elementNum;
    }

    public static void main(String[] args) {
        ArrQueue queue = new ArrQueue(5);
        System.out.println(queue.isEmpty());
        System.out.println(queue.isFull());
        queue.enqueue(5);
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(1);
        System.out.println(queue.queuePosition());
        System.out.println(queue.queueSize());

        System.out.println(Arrays.toString(queue.queueArr));

        queue.dequeue();

        System.out.println(Arrays.toString(queue.queueArr));
        System.out.println(queue.queuePosition());
    }
}
