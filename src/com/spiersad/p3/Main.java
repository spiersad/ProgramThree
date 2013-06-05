package com.spiersad.p3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double timerStart, timerStop, timerElapsedArray, timerElapsedSingleList ,  timerElapsedArrayList;
        File file =  new File("/home/spiers/IdeaProjects/ProgramThree/src/wordfile.txt");
        Scanner scanner = null;
        OrderedArrayList<String> array = new OrderedArrayList<String>();
        OrderedLinkList<String> singleList = new OrderedLinkList<String>();
        OrderedLinkList<String>[] arrayList = (OrderedLinkList<String>[]) new OrderedLinkList[26];
        for (int i = 0; i < 26; i++){
            arrayList[i] = new OrderedLinkList<String>();
        }



        //Ordered array list below
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
        timerElapsedArray = (timerStop - timerStart) / 1000000000;
        System.out.println(array.toString());





        //One ordered link list
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        timerStart = System.nanoTime();
        while (scanner.hasNext()){
            singleList.add(scanner.next());
        }
        timerStop = System.nanoTime();
        scanner.close();
        timerElapsedSingleList = (timerStop - timerStart) / 1000000000;
        System.out.println(singleList.toString());




        //Ordered array of link list below
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
        timerElapsedArrayList = (timerStop - timerStart) / 1000000000;
        for (int i = 0; i < 26; i++){
            System.out.println(arrayList[i].toString());
        }



        System.out.println("Ordered array time in Seconds: " + timerElapsedArray);
        System.out.println("Ordered single list time in Seconds: " + timerElapsedSingleList);
        System.out.println("Array of ordered link list time in Seconds: " + timerElapsedArrayList);
    }
}
