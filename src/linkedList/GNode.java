package linkedList;

public class GNode <T> {
    T data;
    GNode <T> next;

    public GNode(T data){
        this.data = data;
        this.next = null;
    }
}
