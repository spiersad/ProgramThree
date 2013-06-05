package com.spiersad.p3;

/**
 * Created with IntelliJ IDEA.
 * User: spiers
 * Date: 6/5/13
 * Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class ADTLinkList <T>{
    protected LinearNode <T> head, tail, current;
    protected int index;

    public ADTLinkList() {
        head = null;
        tail = null;
        current = null;
        index = 0;
    }

    public T removeFirst(){
        if (index == 0) throw new IndexOutOfBoundsException();
        T temp = head.getElement();
        head = head.getNext();
        index--;
        if (index == 0) tail = null;
        return temp;
    }

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

    public T first(){
        if (index == 0) throw new IndexOutOfBoundsException();
        return head.getElement();
    }

    public T last(){
        if (index == 0) throw new IndexOutOfBoundsException();
        return tail.getElement();
    }

    public boolean isEmpty(){
        return index == 0;
    }

    public int size(){
        return index;
    }

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

