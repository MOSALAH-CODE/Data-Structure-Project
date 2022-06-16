package Queue;

import java.util.PriorityQueue;

public class Patient implements Comparable<Patient>{
    int age;
    String name;
    String disease;

    public Patient(int age, String name, String disease) {
        this.age = age;
        this.name = name;
        this.disease = disease;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", disease='" + disease + '\'' +
                '}';
    }

    public int compareTo(Patient patient){
        if (this.age > patient.age)
            return 1;
        else if (this.age < patient.age)
            return -1;
        else
            return 0;
    }
}

class TestPatent{
    public static void main(String[] args) {
        PriorityQueue<Patient> patientQueue = new PriorityQueue<>();

        patientQueue.add(new Patient(35, "mo", "x"));
        patientQueue.add(new Patient(15, "salah", "y"));
        patientQueue.add(new Patient(75, "amro", "z"));
        patientQueue.add(new Patient(25, "fatma", "a"));
        patientQueue.add(new Patient(45, "eyup", "b"));
//        patientQueue.add(new Patient(95, "ali", "c"));

//        for (Patient p : patientQueue) {
//            System.out.println(p.toString());
//        }
        while (!patientQueue.isEmpty()){
            System.out.println(patientQueue.remove());
        }
    }
}