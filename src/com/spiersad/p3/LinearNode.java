package com.spiersad.p3;

/**
 * Linear Nodes for use in link lists
 * @author Adrian Spiers
 * @version 06/06/13
 */
public class LinearNode <T>{
    private T element;
    private LinearNode next;

    /**
     * Default constructor. Initializes element and next to null
     */
    public LinearNode() {
        element = null;
        next = null;
    }

    /**
     * Constructor for quick initialization of a new node
     * @param next
     * @param element
     */
    public LinearNode(LinearNode next, T element) {
        this.next = next;
        this.element = element;
    }

    /**
     * Returns the elements of the node
     * @return returns the element
     */
    public T getElement() {
        return element;
    }

    /**
     * Sets the element of the node
     * @param element element to be set
     */
    public void setElement(T element) {
        this.element = element;
    }

    /**
     * Returns the next node in the list
     * @return returns next
     */
    public LinearNode getNext() {
        return next;
    }

    /**
     * Sets the next node in the list
     * @param next sets next
     */
    public void setNext(LinearNode next) {
        this.next = next;
    }
}
