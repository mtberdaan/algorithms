// Queue.java

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

    // iterator
    // test client main
}

