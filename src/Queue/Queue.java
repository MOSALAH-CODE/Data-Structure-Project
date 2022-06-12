package Queue;

public class Queue <T>{
    QNode <T> front, rear;

    static class QNode <t>{
        t data;
        QNode <t> next;

        public QNode (t data) {
            this.data = data;
            this.next = null;
        }
    }

    public Queue (){
        this.front = this.rear = null;
    }

    public void enqueue(T data){
        QNode<T> newNode = new QNode<>(data);

        if (this.rear == null){
            this.front = this.rear = newNode;
            return;
        }
        this.rear.next = newNode;
        this.rear = newNode;
    }
    public T dequeue(){
        if (this.front != null){
            QNode<T> temp = this.front;
            this.front = this.front.next;

            if (this.front == null){
                System.out.println("Queue now is empty");
                this.rear = null;
            }
            return temp.data;
        }
        System.out.println("Queue Underflow");
        return null;
    }

    public void printQueue(){
        if (this.front == null){
            System.out.println("null");
            return;
        }
        QNode<T> temp = this.front;
        while (temp.next != null){
            System.out.print(temp.data + " <- ");
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        queue.enqueue("Mo");
        queue.enqueue("Rima");
        queue.enqueue("Anwar");
        queue.enqueue("Hala");
        queue.printQueue();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.printQueue();
        queue.dequeue();
        queue.printQueue();
    }


}
