package com.company;

import java.util.Random;
import java.util.Scanner;

public class Hunt {
    int hunt(){
        Random random = new Random();
        System.out.println("You strive through the wood when you see a dear.");
        System.out.println("You chase after it for a while when you encounter a bear");
        System.out.println("What do you do?");
        System.out.println("1.Attack");
        System.out.println("2.Run");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice==1)
        {
            return 1;
        }
        else
        {
            System.out.println("While you run you see the dear again after going after it you finally are able to " +
                    "kill it and bring it back with you after the hunters find you.");
            return 0;
        }
    }
}
