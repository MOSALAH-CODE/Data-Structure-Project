package linkedList;

public class LinkedList {

    Node head;

    LinkedList(int value){
        this.head = new Node(value);
    }

    LinkedList(){
        head = null;
    }

    public void addLast(int value){
        Node temp = this.head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = new Node(value);
    }

    public void delete(int value){
        Node temp = this.head;
        Node deletedNode;

        if (head.value == value){
            deletedNode = head;
            head = deletedNode.next;
        }
        else {
            while (temp.next != null){
                if (temp.next.value == value){
                    deletedNode = temp.next;
                    temp.next = deletedNode.next;
                    break;
                }
                temp = temp.next;
            }
        }

    }

    public void printLinkedList(){
        Node temp = this.head;

        while (temp.next != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public Node getHead(){
        return this.head;
    }

    public void setNode(Node node, int index){
        Node curr = this.head;
        Node temp;
        int c = 0;

        while (curr.next != null){
            if (c == index-1){
                temp = curr.next;
                curr.next = node;
                node.next = temp;
                break;
            }
            curr = curr.next;
            c++;
        }
    }
}

class TestLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(8);

        linkedList.addLast(37);
        linkedList.addLast(68);
        linkedList.addLast(31);
        linkedList.addLast(83);
        linkedList.addLast(55);

        linkedList.printLinkedList();

        linkedList.delete(8);

        linkedList.printLinkedList();

        linkedList.setNode(new Node(10), 2);

        linkedList.printLinkedList();

        System.out.println("Head Value: " + linkedList.getHead().value);
    }
}
