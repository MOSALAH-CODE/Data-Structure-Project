package Tree.Huffman;

import java.util.Comparator;

public class HuffmanNode {
    int data;
    char c;

    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(int data, char c) {
        this.data = data;
        this.c = c;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "data=" + data +
                ", c=" + c +
                '}';
    }
}

class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.data - y.data;
    }
}