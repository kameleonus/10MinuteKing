package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Save {
    boolean save(boolean death , int year,int iron,int happines, int food, int money) throws FileNotFoundException {
        PrintWriter printWriter;
        year++;
        if (death) {
            printWriter = new PrintWriter("src/zasoby.txt");
            printWriter.println(5);
            printWriter.println(5);
            printWriter.println(5);
            printWriter.println(5);
            printWriter.println(year);
            printWriter.close();
            return true;
        } else {
            printWriter = new PrintWriter("src/zasoby.txt");
            printWriter.println(iron);
            printWriter.println(happines);
            printWriter.println(food);
            printWriter.println(money);
            printWriter.println(year);
            printWriter.close();
            return false;
        }



    }
}
