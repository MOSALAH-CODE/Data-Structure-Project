package Hashing;


public class HashTable {

    private static class HashNode{
        Integer key;
        String value;
        HashNode next;

        public HashNode(int key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "HashNode{" +
                    "key=" + key +
                    ", value='" + value + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

    private HashNode[] buckets;
    private int numOfBuckets;
    private int size;

    HashTable(int capacity){
        this.numOfBuckets = capacity;
        this.buckets = new HashNode[numOfBuckets];
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void put(Integer key, String value){
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode node = new HashNode(key, value);
        if (head != null) head.next = node;
        else head = node;
        buckets[bucketIndex] = head;
        size++;
    }

    private int getBucketIndex(Integer key){
        return key % numOfBuckets;
    }

    public String get(Integer key){
        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }

        return null;
    }

    public String remove(Integer key){
        int bucketIndex = getBucketIndex(key);

        HashNode head = buckets[bucketIndex];
        HashNode prev = null;
        while (head != null){
            if (head.key.equals(key)) break;
            prev = head;
            head = head.next;
        }

        if (head == null) return null;

        if (prev == null) buckets[bucketIndex] = head.next;
        else prev.next = head.next;

        return head.value;
    }

    public static void main(String[] args) {
        HashTable table = new HashTable(10);
        table.put(1231, "Mo");
        table.put(2231, "Ali");
        table.put(3461, "Dora");
        table.put(1123, "Salah");
        table.put(2312, "Hussain");
        table.put(33269, "Ayse");

        System.out.println(table.remove(33269));
        for (HashNode h : table.buckets) {
            System.out.println(h);
        }

        System.out.println(table.get(3461));
    }


}
