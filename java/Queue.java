// Queue.java

import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> implements Iterable<Item>
{
    private Node first;
    private Node last;
    private int N;

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty() { return first == null; }
    public int size() { return N; }

    public void enqueue(Item item)
    { // add item to end of list
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        N++;
    }

    public Item dequeue()
    { // remove first item in list
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) last = null;
        return item;
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
    { // create a queue and enqueue/dequeue strings
        
        Queue<String> q = new Queue<String>();

        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            if (!item.equals("-"))
                q.enqueue(item);
            else if (!q.isEmpty()) StdOut.print(q.dequeue() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }
}
