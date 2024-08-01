// Stack.java

import java.util.Iterator;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stack<Item> implements Iterable<Item>
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
    
    public void push(Item item)
    { // add item to top of stack
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop()
    { // remove item from top of stack
        Item item = first.item;
        first = first.next;
        N--;
        return item; // return old item
    }
   
    // iterator
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
    { // create a stack and push/pop strings from StdIn.
    
        Stack<String> s = new Stack<String>();

        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    } 
}


