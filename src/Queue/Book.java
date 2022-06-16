package Queue;

import java.util.PriorityQueue;

public class Book implements Comparable<Book>{
    int id;
    String name;
    String author;
    String publisher;
    int quantity;

    public Book(int id, String name, String author, String publisher, int quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
    }
    public int compareTo(Book b) {
        return CharSequence.compare(this.name, b.name);
    }
}

class Test {
    public static void main(String[] args) {
        PriorityQueue<Book> queue=new PriorityQueue<Book>();
        //Creating Books
        Book b1=new Book(121,"c Let us C","Yashwant Kanetkar","BPB",8);
        Book b2=new Book(233,"a Operating System","Galvin","Wiley",6);
        Book b3=new Book(101,"b Data Communications & Networking","Forouzan","Mc Graw Hill",4);
        //Adding Books to the queue
        queue.add(b1);
        queue.add(b2);
        queue.add(b3);

        while (!queue.isEmpty()){
            System.out.println(queue.remove().name);
        }

//        System.out.println("Traversing the queue elements:");
        //Traversing queue elements
//        for(Book b:queue){
//            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
//        }
//        queue.remove();
//        System.out.println("After removing one book record:");
//        for(Book b:queue){
//            System.out.println(b.id+" "+b.name+" "+b.author+" "+b.publisher+" "+b.quantity);
//        }
    }
}
