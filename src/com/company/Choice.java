package com.company;

import java.util.Scanner;

public class Choice {
    public static int wybor() {
        System.out.println("1.Tak");
        System.out.println("2.Nie");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if (x == 1) {
            return 1;
        } else if (x == 2) {
            return 0;
        }
        return 0;
    }

    public static int wybor2() {
        System.out.println("1.People");
        System.out.println("2.Sell");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if (x == 1) {
            return 1;
        } else if (x == 2) {
            return 0;
        }
        return 0;
    }
    public static int wybor3() {
        System.out.println("1.Kill");
        System.out.println("2.They will be good");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if (x == 1) {
            return 1;
        } else if (x == 2) {
            return 0;
        }
        return 0;
    }
    public static int wybor4() {
        System.out.println("1.Meat");
        System.out.println("2.Alcohol");
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        if (x == 1) {
            return 1;
        }
        else if(x==2)
        {
            return 0;
        }
        return 0;
    }
}
