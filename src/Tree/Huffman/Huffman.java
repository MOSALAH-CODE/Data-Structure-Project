package Tree.Huffman;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Huffman {

    public static void printCode(HuffmanNode root, String s){

        if (root.left == null && root.right == null
                && Character.isLetter(root.c)) {
            // c is the character in the node
            System.out.println(root.c + ":" + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    // main function
    public static void main(String[] args)
    {

        Scanner s = new Scanner(System.in);

        // number of characters.
        int n = 6;
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };

        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new MyComparator());

        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode(charfreq[i], charArray[i]);
            q.add(hn);
        }

        System.out.println(q.toString());
        // create a root node
        HuffmanNode root = null;

        while (q.size() > 1) {
            HuffmanNode x = q.poll();
            HuffmanNode y = q.poll();

            HuffmanNode f = new HuffmanNode(x.data + y.data, '-');
            f.left = x;
            f.right = y;
            root = f;

            q.add(f);
            System.out.println(q.toString());

        }
        printCode(root, "");
    }
}
