package com.spiersad.p3;

/**
 * Created with IntelliJ IDEA.
 * User: spiers
 * Date: 6/5/13
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinearNode <T>{
    private T element;
    private LinearNode next;

    public LinearNode() {
        element = null;
        next = null;
    }

    public LinearNode(LinearNode next, T element) {
        this.next = next;
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public LinearNode getNext() {
        return next;
    }

    public void setNext(LinearNode next) {
        this.next = next;
    }
}
