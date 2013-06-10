package com.spiersad.p3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Driver for the ordered array
 * @author Adrian Spiers
 * @version 06/10/13
 */
public class OrderedArrayDriver {
    public static void main(String[] args) {
        double timerStart, timerStop, timerElapsed;
        File file =  new File("/home/spiers/IdeaProjects/ProgramThree/src/wordfile.txt");
        Scanner scanner = null;
        OrderedArrayList<String> array = new OrderedArrayList<String>();

        timerStart = System.nanoTime();
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNext()){
            array.add(scanner.next());
        }
        scanner.close();
        System.out.println(array.toString());
        timerStop = System.nanoTime();
        timerElapsed = (timerStop - timerStart) / 1000000000;
        System.out.println("Ordered array time in Seconds: " + timerElapsed);
    }
}
