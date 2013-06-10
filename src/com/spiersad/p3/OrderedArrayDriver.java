package com.spiersad.p3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Driver for the Array list. Reads 19000 words to an ordered array list. It then prints
 * them and and the time it took to complete the opperation
 * @author Adrian Spiers
 * @version 06/08/13
 */
public class OrderedArrayDriver {
    public static void main(String[] args) {
        double timerStart, timerStop, timerElapsed;
        File file =  new File("/home/spiers/IdeaProjects/ProgramThree/src/wordfile.txt");
        Scanner scanner = null;
        OrderedArrayList<String> array = new OrderedArrayList<String>();


        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        timerStart = System.nanoTime();
        while (scanner.hasNext()){
            array.add(scanner.next());
        }
        timerStop = System.nanoTime();
        scanner.close();
        timerElapsed = (timerStop - timerStart) / 1000000000;
        System.out.println(array.toString());
        System.out.println("Ordered array time in Seconds: " + timerElapsed);
    }
}