package com.spiersad.p3;

/**
 * Created with IntelliJ IDEA.
 * User: spiers
 * Date: 6/5/13
 * Time: 2:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class OrderedLinkList <T extends Comparable> extends ADTLinkList {
    public void add(T element){
        LinearNode<T> node = new LinearNode<T>();
        node.setElement(element);
        if (index == 0){
            head = tail = node;
            index++;
        }
        else{
            if (element.compareTo(head.getElement()) <= 0){
                node.setNext(head);
                head = node;
                index++;
            }
            else if (element.compareTo(tail.getElement()) >= 0){
                tail.setNext(node);
                tail = node;
                index++;
            }
            else{
                LinearNode<T> previous = head;
                for (current = head.getNext(); current.getNext() != null; current = current.getNext()){
                    if (element.compareTo(current.getElement()) < 0){
                        node.setNext(previous.getNext());
                        previous.setNext(node);
                        index++;
                        break;
                    }
                    previous = current;
                }
            }
        }

    }
}
