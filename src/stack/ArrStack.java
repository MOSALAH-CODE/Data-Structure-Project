package stack;

import java.util.Arrays;

class ArrStack {
    static final int MAX = 1000;
    int top;
    int[] dataArr = new int[MAX]; // Maximum size of Stack

    boolean isEmpty(){
        return (top < 0);
    }

    ArrStack(){
        top = -1;
    }

    boolean push(int x){
        if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        }
        else {
            dataArr[++top] = x;
            System.out.println(x + " pushed into stack");
            return true;
        }
    }

    int pop(){
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else
            return dataArr[top--];
    }

    int peek(){
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        }
        else
            return dataArr[top];
    }
}

// Driver code
class Main {
    public static void main(String[] args)
    {
        ArrStack s = new ArrStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");

        System.out.println(Arrays.toString(s.dataArr));
    }
}