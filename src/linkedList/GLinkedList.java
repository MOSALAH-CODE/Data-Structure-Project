package linkedList;

public class GLinkedList <T> {

    GNode <T> head;

    public GLinkedList(){
        this.head = null;
    }

    public GLinkedList(T data){
        this.head = new GNode<>(data);
    }

    public void addLast(T data){
        if (this.head == null)
            this.head = new GNode<>(data);
        else {
            GNode <T> temp = this.head;

            while (temp.next != null)
                temp = temp.next;

            temp.next = new GNode<>(data);
        }
    }

    public void print(){
        if (this.head != null) {
            GNode<T> temp = this.head;

            while (temp.next != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
        }
        System.out.println("null");

    }

    public static void main(String[] args) {
        GLinkedList<Integer> gLinkedList = new GLinkedList<>();
        gLinkedList.print();

        gLinkedList.addLast(1);
        gLinkedList.addLast(7);
        gLinkedList.addLast(9);
        gLinkedList.addLast(6);
        gLinkedList.addLast(2);

        gLinkedList.print();
    }

}
