package com.spiersad.p3;

/**
 * Creator: Adrian Spiers
 * Date: 6/5/13
 * To change this template use File | Settings | File Templates.
 */
public class ADTArrayList<T>{
    protected final int GENERIC_ARRAY_LENGTH = 20000;
    protected T[] array;
    protected int index;
    public ADTArrayList(){
        array = (T[]) new Object[GENERIC_ARRAY_LENGTH];
        index = 0;
    }
    public  ADTArrayList(int size){
        array = (T[]) new Comparable[size];
        index = 0;
    }
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
    public T get(int indexToGet){
        if (index == 0) throw new ArrayIndexOutOfBoundsException();
        if (indexToGet > index) throw new ArrayIndexOutOfBoundsException();
        return array[indexToGet];
    }
    public boolean isEmpty(){
        return index == 0;
    }
    public int size(){
        return index;
    }
    public String toString(){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < index; i++){
            stringBuffer.append(array[i].toString())
                    .append(' ');
            if ((i+1) % 25 == 0) stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }
}
