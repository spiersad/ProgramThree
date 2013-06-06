package com.spiersad.p3;

/**
 * Abstract data type of an array list.
 * @author Adrian Spiers
 * @version 06/06/13
 *
 */
public class ADTArrayList<T>{
    protected final int GENERIC_ARRAY_LENGTH = 100;
    protected T[] array;
    protected int index;

    /**
     * Default constructor. Initializes the array to a generic length of 100 and the index to 0
     */
    public ADTArrayList(){
        array = (T[]) new Object[GENERIC_ARRAY_LENGTH];
        index = 0;
    }

    /**
     * Constructs a array list of specific size
     * @param size the size of the new array list
     */
    public  ADTArrayList(int size){
        array = (T[]) new Comparable[size];
        index = 0;
    }

    /**
     * Removes and returns a specific item in the array
     * @param indexToRemove the index to be removed
     * @return returns the removed item from the array
     */
    public T remove(int indexToRemove){
        if (index == 0) throw new ArrayIndexOutOfBoundsException();
        if (indexToRemove > index) throw new ArrayIndexOutOfBoundsException();
        T temp = array[indexToRemove];
        for(int i = indexToRemove; i < index-1; i++){
            array[i] = array[i+1];
        }
        index--;
        return  temp;
    }

    /**
     * Returns the object in the array
     * @param indexToGet index of object to be returned
     * @return returns the object
     */
    public T get(int indexToGet){
        if (index == 0) throw new ArrayIndexOutOfBoundsException();
        if (indexToGet > index) throw new ArrayIndexOutOfBoundsException();
        return array[indexToGet];
    }

    /**
     * Checks array to see if it is empty
     * @return returns true if empty else false
     */
    public boolean isEmpty(){
        return index == 0;
    }

    /**
     * Returns the size of the array based on index
     * @return returns the index
     */
    public int size(){
        return index;
    }

    /**
     * Converts the array to a string and then returns it
     * @return returns the created string
     */
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < index; i++){
            stringBuffer.append(array[i].toString())
                    .append(' ');
            if ((i+1) % 25 == 0) stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }

    /**
     * When called this will check the array to make sure that the next added item is not out of bounds
     */
    protected void checkArray(){
        if (index == array.length-1){
            T[] temp = (T[]) new Object[array.length*2];
            for (int i = 0; i < array.length; i++){
                temp[i] = array[i];
            }
            array = temp;
        }
    }
}
