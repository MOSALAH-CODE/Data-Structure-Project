package stack;

public class Stack {
    Node head;

    Stack(){
        this.head = null;
    }

    Stack(int value){
        this.head = new Node(value);
    }

    public void push(int value) {
        Node oldHead = head;
        head = new Node(value);
        head.next = oldHead;
    }
    public int pop(){
        if (head == null){
            System.out.println("Stack is empty");
            return 0;
        }
        else {
            Node temp = this.head;
            this.head = temp.next;
            return temp.value;
        }
    }


    public void printStack(){
        Node temp = this.head;
        while (temp.next != null){
            System.out.print("|  ");
            System.out.print(temp.value);
            System.out.println("  |");
            temp = temp.next;
        }
        System.out.print("|  ");
        System.out.print(temp.value);
        System.out.println("  |");

        System.out.println("--------");
    }

}

class TestStack{
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.pop();

        stack.push(32);
        stack.push(78);
        stack.push(21);
        stack.push(72);
        stack.push(83);
        stack.push(29);
        stack.printStack();

        stack.pop();
        stack.printStack();
    }
}
