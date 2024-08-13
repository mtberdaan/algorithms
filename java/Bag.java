// Bag.java

import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Bag<Item> implements Iterable<Item>
{
    private Node first; // top of stack
    private int N; // number of items
    
    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null; }
    public int size() { return N; }
    
    public void add(Item item)
    { // add item to top of stack
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Iterator<Item> iterator()
    { return new ListIterator(); }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext()
        { return current != null; }

        public void remove() {}
        
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    // test client
    public static void main(String[] args)
    { // add items to bag and itterate them 
        
        Bag<String> b = new Bag<String>();

        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            b.add(item);
        }

        for (String item : b) {
            StdOut.println(item);
        }

        StdOut.println("(" + b.size() + " items in bag)");
    }
    

}


