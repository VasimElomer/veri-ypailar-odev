/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hafta11_lab;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 *
 * @author w10
 */
public class Canonical_Huffman {
    
    static TreeMap<Integer, TreeSet<Character> > data;
 
    
    public Canonical_Huffman()
    {
        data = new TreeMap< >();
    }
 
    static void code_gen(Node root, int code_length)
    {
        if (root == null)
            return;
 
        if (root.left == null && root.right == null) {
 
            data.putIfAbsent(code_length, new TreeSet<Character>());
 
            data.get(code_length).add(root.c);
            return;
        }
 
        code_gen(root.left, code_length + 1);
        code_gen(root.right, code_length + 1);
    }
 
        static void testCanonicalHC(int n, char chararr[], int freq[])
        {

            PriorityQueue<Node> q
                = new PriorityQueue<Node>(n, new Pq_compare());

            for (int i = 0; i < n; i++) {

                Node node = new Node();

                node.c = chararr[i];
                node.data = freq[i];

                node.left = null;
                node.right = null;

                q.add(node);
            }

            Node root = null;

            while (q.size() > 1) {

                Node x = q.peek();
                q.poll();

                Node y = q.peek();
                q.poll();

                Node nodeobj = new Node();

                nodeobj.data = x.data + y.data;
                nodeobj.c = '-';

                nodeobj.left = x;

                nodeobj.right = y;

                root = nodeobj;

                q.add(nodeobj);
            }

            Canonical_Huffman obj = new Canonical_Huffman();

            code_gen(root, 0);

            Object[] arr = data.keySet().toArray();

            int c_code = 0, curr_len = 0, next_len = 0;

            for (int i = 0; i < arr.length; i++) {
                Iterator it = data.get(arr[i]).iterator();

                curr_len = (int)arr[i];

                while (it.hasNext()) {

                    System.out.println(it.next() + ":"
                                       + Integer.toBinaryString(c_code));

                    if (it.hasNext() || i == arr.length - 1)
                        next_len = curr_len;
                    else
                        next_len = (int)arr[i + 1];

                    c_code = (c_code + 1) << (next_len - curr_len);
                }
            }
    }
}
