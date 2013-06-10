package com.spiersad.p3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: spiers
 * Date: 6/8/13
 * Time: 9:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class ArrayOfOrderedLinkListDriver {
    public static void main(String[] args) {
        double timerStart, timerStop, timerElapsed;
        File file =  new File("/home/spiers/IdeaProjects/ProgramThree/src/wordfile.txt");
        Scanner scanner = null;
        OrderedLinkList<String>[] arrayList = (OrderedLinkList<String>[]) new OrderedLinkList[26];
        for (int i = 0; i < 26; i++){
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
                arrayList[25].add(scannedIn);
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
        for (int i = 0; i < 26; i++){
            System.out.println(arrayList[i].toString());
        }

        System.out.println("Array of ordered link list time in Seconds: " + timerElapsed);
    }
}
