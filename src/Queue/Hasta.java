package Queue;

import java.util.PriorityQueue;

class Hasta implements Comparable<Hasta>{
    String name, surname;
    int age;

    public Hasta(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    //Make priority for patients above age of 65
    @Override
    public int compareTo(Hasta o) {
        if(this.age >= 65){
            return Integer.compare(o.age, this.age);
        }
        return -1;
    }

    //To print Hasta object
    @Override
    public String toString(){
        return this.name + " " + this.surname + " " + this.age;
    }
}

class HastaTest{
    public static void main(String[] args) {
        PriorityQueue<Hasta> queue = new PriorityQueue<>();

        //Adding elements to queue
        queue.add(new Hasta("Joshua", "Kimmich",  45));
        queue.add(new Hasta("Manuel", "Neuer", 34));
        queue.add(new Hasta("Thomas", "Muller", 65));
        queue.add(new Hasta("Oliver", "Khan", 70));

        Hasta newHasta = new Hasta("Philip", "Lahm", 37);

        //Displaying added elements
        System.out.println("Displaying patients:");
        for(Hasta hasta : queue)
            System.out.println(">>Name: " + hasta.name + " " + hasta.surname + " | Age: " + hasta.age);

        //Using queue functions to test
        System.out.println("\n\nElement(): " + queue.element());
        queue.offer(newHasta);
        System.out.println("Peek(): " + queue.peek());
        System.out.println("Poll(): " + queue.poll());
        System.out.println("Remove(): " + queue.remove());

        //Displaying queue elements after removing and deleting
        System.out.println("\n\n\nDisplaying patients after edits:");
        for(Hasta hasta : queue)
            System.out.println(">>Name: " + hasta.name + " " + hasta.surname + " | Age: " + hasta.age);
    }
}