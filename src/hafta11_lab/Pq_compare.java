package hafta11_lab;

import java.util.Comparator;

public class Pq_compare implements Comparator<Node> {

    @Override
    public int compare(Node a, Node b)
    {
 
        return a.data - b.data;
    }
    
}
