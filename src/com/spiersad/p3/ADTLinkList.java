package com.spiersad.p3;

/**
 * Abstract data type for link list
 * @author Adrian Spiers
 * @version 06/06/13
 *
 */
public class ADTLinkList <T>{
    protected LinearNode <T> head, tail, current;
    protected int index;

    /**
     * Default constructor. Initializes head tail and current to null and index to 0
     */
    public ADTLinkList() {
        head = null;
        tail = null;
        current = null;
        index = 0;
    }

    /**
     * Remove and returns the head node
     * @return returns the element in the head node
     */
    public T removeFirst(){
        if (index == 0) throw new IndexOutOfBoundsException();
        T temp = head.getElement();
        head = head.getNext();
        index--;
        if (index == 0) tail = null;
        return temp;
    }

    /**
     * Removes and returns the tail node
     * @return returns the element in the tail node
     */
    public T removeLast(){
        if (index == 0) throw new IndexOutOfBoundsException();
        T temp = tail.getElement();
        for (current = head; current.getNext() != tail; current = current.getNext()){}
        current.setNext(null);
        tail = current;
        index--;
        if (index == 0) head = null;
        return temp;
    }

    /**
     * Returns the element in the head node
     * @return returns the element in the head node
     */
    public T first(){
        if (index == 0) throw new IndexOutOfBoundsException();
        return head.getElement();
    }

    /**
     * Returns the element in the tail node
     * @return Returns the element in the tail node
     */
    public T last(){
        if (index == 0) throw new IndexOutOfBoundsException();
        return tail.getElement();
    }

    /**
     * Checks link list to see if it is empty
     * @return returns true if link list is empty
     */
    public boolean isEmpty(){
        return index == 0;
    }

    /**
     * Returns the number of nodes in the list
     * @return returns the index
     */
    public int size(){
        return index;
    }

    /**
     * Creates a string of all the link list elements toString and returns it
     * @return returns the created string
     */
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        int i = 1;
        for (current = head; current != null; current = current.getNext()){
            stringBuffer.append(current.getElement().toString())
                    .append(' ');
            if ((i+1) % 25 == 0) stringBuffer.append('\n');
            i++;
        }
        return stringBuffer.toString();
    }
}

