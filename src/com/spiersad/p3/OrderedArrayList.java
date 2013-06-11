package com.spiersad.p3;

/**
 * Created with IntelliJ IDEA.
 * User: spiers
 * Date: 6/4/13
 * Time: 11:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class OrderedArrayList<T extends Comparable> extends ArrayList {

    /**
     * This method will add an object to the list in order from least to greatest of the objects compareTo
     * @param element object to be added to the list
     */
    public void add(T element){
        checkArray();
        int first = 0;
        int last = index-1;
        int mid = 1;
        if (index == 0){
            array[0] = element;
            index++;
        }
        else if (element.compareTo(array[first]) < 0){
            makeRoom(0);
            array[0] = element;
            index++;
        }
        else if (element.compareTo(array[last]) > 0){
            array[last+1] = element;
            index++;
        }
        else{
            while (true){
                mid = (first + last)/2;
                if((element.compareTo(array[mid]) >= 0) && (element.compareTo((array[mid+1])) <= 0)){
                    mid++;
                    break;
                }
                if (element.compareTo(array[mid]) > 0) first = mid;
                else last = mid;
            }
            makeRoom(mid);
            array[mid] = element;
            index++;
        }

    }
    private void makeRoom(int indexArray){
        checkArray();
        for (int i = index; i >= indexArray; i--){
            array[i+1] = array[i];
        }
    }
}
