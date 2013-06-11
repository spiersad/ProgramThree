package com.spiersad.p3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Driver for the array of ordered link lists
 * @author Adrian Spiers
 * @version 06/10/13
 */
public class ArrayOfOrderedLinkListDriver {
    public static void main(String[] args) {
        final int NUMBER_OF_LETTERS_IN_ALPHABET = 26;
        double timerStart, timerStop, timerElapsed;
        File file =  new File("/home/spiers/IdeaProjects/ProgramThree/src/wordfile.txt");
        Scanner scanner = null;
        OrderedLinkList<String>[] arrayList = (OrderedLinkList<String>[]) new OrderedLinkList[NUMBER_OF_LETTERS_IN_ALPHABET];
        for (int i = 0; i < NUMBER_OF_LETTERS_IN_ALPHABET; i++){
            arrayList[i] = new OrderedLinkList<String>();
        }



        timerStart = System.nanoTime();
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()){
            String scannedIn = scanner.next();
            arrayList[scannedIn.charAt(0) - 'A'].add(scannedIn);
        }
        scanner.close();
        for (int i = 0; i < NUMBER_OF_LETTERS_IN_ALPHABET; i++){
            System.out.println(arrayList[i].toString());
        }
        timerStop = System.nanoTime();
        timerElapsed = (timerStop - timerStart) / 1000000000;
        System.out.println("Array of ordered link list time in Seconds: " + timerElapsed);
    }
}
