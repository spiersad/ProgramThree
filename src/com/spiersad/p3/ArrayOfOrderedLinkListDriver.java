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


        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        timerStart = System.nanoTime();
        while (scanner.hasNext()){
            String scannedIn = scanner.next();
            if (scannedIn.compareTo("A") <= 0){
                arrayList[0].add(scannedIn);
            }
            else if (scannedIn.compareTo("Z") >= 0){
                arrayList[NUMBER_OF_LETTERS_IN_ALPHABET-1].add(scannedIn);
            }
            else {
                int index = 0;
                for (char letter = 'B'; letter <= 'Y'; letter++){
                    StringBuffer test = new StringBuffer();
                    test.append(letter);
                    if (scannedIn.compareTo(test.toString()) < 0){
                        arrayList[index].add(scannedIn);
                        break;
                    }
                    index++;
                }
            }
        }
        timerStop = System.nanoTime();
        scanner.close();
        timerElapsed = (timerStop - timerStart) / 1000000000;
        for (int i = 0; i < NUMBER_OF_LETTERS_IN_ALPHABET; i++){
            System.out.println(arrayList[i].toString());
        }

        System.out.println("Array of ordered link list time in Seconds: " + timerElapsed);
    }
}
