import java.util.NoSuchElementException;

/**
A linked list is a sequence of nodes with efficient
element insertion and removal. This class
contains a subset of the methods of the standard
java.util.LinkedList class.
 */
public class LinkedList
{
    private Node first;
    /**
    Constructs an empty linked list.
     */
    public LinkedList()
    {
        first = null;
    }

    /**
    Returns the first element in the linked list.
    @return the first element in the linked list
     */
    public Object getFirst()
    {
        if(first == null) { throw new NoSuchElementException(); }

        return first.data;
    }

    /**
    Removes the first element in the linked list.
    @return the removed element
     */
    public Object removeFirst()
    {
        if (first == null) {throw new NoSuchElementException();}

        Object element = first.data;

        first = first.next;

        return element;
    }

    /**
    Adds an element to the front of the linked list.
    @param element the element to add
     */
    public void addFirst(Object element)
    {
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = first;

        first = newNode;
    }

    

    public Object get(int n)
    {
        Node node = first;
        for (int i = 0; i < n; i++)
        {
            if (node == null) {throw new NoSuchElementException();}
            node = node.next;
        }
        if (node == null) {throw new NoSuchElementException();}
        return node.data;
    }

    public void set(int n, Object element)
    {
        Node node = first;
        for (int i = 0; i < n; i++)
        {
            if (node == null) {throw new NoSuchElementException();}
            node = node.next;
        }
        if (node == null) {throw new NoSuchElementException();}
        node.data = element;
    }
    
    /**
     * Henry Kozurek
     */
    public void reverse()
    {
        reverse(first).next = null;
    }

    public Node reverse(Node current)
    {
        if (current.next == null){ first = current; return current;}
        reverse(current.next).next = current;
        return current;
    }

    /**
    Returns an iterator for iterating through this list.
    @return an iterator for iterating through this list
     */
    public ListIterator listIterator()
    {
        return new LinkedListIterator();
    }

    /*
    /**
     * Henry Kozurek September 17 2019
     * Computes the size of the loinked list
     * @return the number of elements in the list

    public int size()
    {
    int s = 0;
    Node cur;
    cur = first;
    while(cur != null)
    {
    s++;
    cur = cur.next;
    }

    return s;
    }
     */

    public int size()
    {
        int out = 0;
        out += size(first);
        return out;
    }

    public int size(Node node)
    {
        int out = 1;
        if (node.next != null)
            out += size(node.next);
        return out;
    }
    //Class Node
    class Node
    {
        public Object data;
        public Node next;
    }

    class LinkedListIterator implements ListIterator//implements ListIterator
    {
        //private dataI

        private Node position;
        private Node previous;
        private boolean isAfterNext;

        /**
        Constructs an iterator that points to the front
        of the linked list.
         */
        public LinkedListIterator()
        {
            position = null;
            previous = null;
            isAfterNext = false; 
        }

        /**
        Moves the iterator past the next element.
        @return the traversed element
         */
        public Object next()
        {
            if (! hasNext()){ throw new NoSuchElementException(); }

            previous = position; //Remember for remove();

            isAfterNext = true;

            if (position == null) {position = first;}

            else {position = position.next;}

            return position.data;
        }

        /**
        Tests if there is an element after the iterator position.
        @return true if there is an element after the iterator position
         */
        public boolean hasNext()
        {
            if (position == null)
            {
                return first != null;
            }
            else
            {
                return position.next != null;
            }
        }

        /**
        Adds an element before the iterator position
        and moves the iterator past the inserted element.
        @param element the element to add
         */
        public void add(Object element)
        {
            if (position == null)
            {
                addFirst(element);
                position = first;
            }
            else
            {
                Node newNode = new Node();
                newNode.data = element;

                newNode.next = position.next;
                position.next = newNode;
                position=  newNode;
            }
            isAfterNext = false;
        }

        /**
        Removes the last traversed element. This method may
        only be called after a call to the next() method.
         */
        public void remove()
        {
            if (!isAfterNext)//flag flase so next has not been called
            {
                throw new IllegalStateException();
            }

            if (position == first)
            {
                removeFirst(); // calles LL method bc we are an inner Class
            }
            else
            {
                previous.next = position.next;
            }
            position = previous;

            isAfterNext = false;

        }

        /**
        Sets the last traversed element to a different value.
        @param element the element to set
         */
        public void set ( Object element)
        {
            if(!isAfterNext)
            {
                throw new IllegalStateException();
            }
            position.data = element;
        }
    }//LinkedListIterator
}//LinkedList







