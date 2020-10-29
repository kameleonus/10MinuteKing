package com.company;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static boolean death = false;
    public static void main(String[] args) throws IOException {
        int iron,happines,food,money;
        int year;
        boolean warehouse= false;
        boolean bankreserve= false;
        boolean scrapmetal= false;
        boolean mision= false;
        String name ="";
        Scanner scanner = new Scanner(System.in);
        File file = new File("src/zasoby.txt");
        FileInputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        iron=parseInt(bufferedReader.readLine());
        happines=parseInt(bufferedReader.readLine());
        food=parseInt(bufferedReader.readLine());
        money=parseInt(bufferedReader.readLine());
        year=parseInt(bufferedReader.readLine());
        name=bufferedReader.readLine();
        bufferedReader.close();
        CheckIfDead checkIfDead = new CheckIfDead();
        SetDead setDead = new SetDead();
        Hunt hunt = new Hunt();
        //pobieranie zasobów z pliku txt, inaczej save
        System.out.println("The year is "+year+" and the audience of King "+name+" begins...");
        System.out.println();
	    long start=System.currentTimeMillis()/1000;
        do{
            Random random = new Random();
            int character = random.nextInt(11);
            switch (character){
                case 1:{
                    System.out.println("Guard");
                    int problem = random.nextInt(6);
                        switch (problem){
                            case 1:{
                                System.out.println("King we need new armour sets because the old ones are getting" +
                                        " rusty" +
                                        " ");
                                if(Choice.wybor()==1){
                                    iron--;
                                    money--;
                                }
                                else{
                                    happines--;
                                }break;
                            }case 2:{
                                System.out.println("We need more guards we serve a long time and we need more rest");
                                if(Choice.wybor()==1){
                                   food--;
                                   money--;
                                   happines++;
                                }
                                else{
                                    happines-=2;
                                }
                                break;
                            }case 3:{System.out.println("We caught a noblemans son stealing should we get money from " +
                                    "his father to pay for his freedom?");
                                if(Choice.wybor()==1){
                                money++;}
                                else {
                                    happines--;
                                }break;
                            }case 4:{System.out.println("Can you fire that servant? He iritates me.");
                            if(Choice.wybor()==0){
                                happines--;
                            }
                            break;
                            }case 5:{
                                System.out.println("Can we have bigger food rations?");
                                if(Choice.wybor()==1){
                                food--;
                                happines++;
                            }
                            else{
                                happines--;
                            }break;
                            }
                            default:
                            {
                                System.out.println("Have a nice day my king may your reign be glorious");
                                happines++;
                            break;
                            }
                        }
                    death=checkIfDead.check(iron,happines,food,money);
                    break;
                }case 2:{
                    System.out.println("General");
                    int problem = random.nextInt(6);
                    switch (problem){
                        case 1:{System.out.println("We need to get new recruits because the enemy is raiding us");
                            if(Choice.wybor()==1){
                                food--;
                                money-=2;
                                happines+=2;
                            }
                            else{
                                happines--;
                                money--;
                            }break;
                        }case 2:{System.out.println("After our last battle the spoils were great should we turn it " +
                                "into money?");
                            if(Choice.wybor()==1){
                                money+=3;
                            }
                            else{
                                happines++;
                                food++;
                                iron++;
                            }
                            break;
                        }case 3:{System.out.println("Some merchants are getting bossy around town should we arrest " +
                                "one or two to make them stop?");
                        if(Choice.wybor()==1){
                            happines--;
                            money+=2;
                        }
                        else{
                            happines++;
                            food++;
                        }break;
                        }case 4:{
                            System.out.println("We need better armour and weapons or we will lose the upcoming war we" +
                                    " can " +
                                    "leave the old ones for later");
                            if(Choice.wybor()==1){
                            money-=2;
                            happines++;
                            scrapmetal=true;
                        }
                        else{
                            food--;
                            money--;

                        }break;
                        }case 5:{System.out.println("During one expedition a soldier found an artifact it " +
                                "could fetch a nice sum");
                        if(Choice.wybor()==1){
                            money+=2;
                        }
                        else{
                            happines+=2;

                        }break;
                        }
                        default:
                        {
                            System.out.println("The military is as strong as ever");
                            happines++;
                        break;
                        }
                    }death= checkIfDead.check(iron,happines,food,money);
                    break;
                }case 3:{
                    System.out.println("Cook");
                    int problem = random.nextInt(6);
                    switch (problem){
                        case 1:{System.out.println("It's about time we make a feast? ");
                            if(Choice.wybor()==1){
                                happines++;
                                food++;
                                money--;
                            }
                            else{
                                money++;
                            }break;
                        }case 2:{System.out.println("Want to try this dish of the new species we found last month? ");
                            if(Choice.wybor()==1){
                                death=true;
                            }
                            else{
                                happines++;
                            }
                            break;
                        }case 3:{System.out.println("I need more ingredients or i won't be able to serve the required" +
                                " amount of servings could you do something about it.");
                        if(Choice.wybor()==1){
                            happines++;
                            money--;
                        }
                        else{
                            food-=2;
                        }break;
                        }case 4:{System.out.println("After the last party we have many leftovers should i give it to " +
                                "the people or sell to the merchants?" +
                                " ");
                        if(Choice.wybor2()==1){
                            happines++;
                        }
                        else{
                            money++;
                        }break;
                        }case 5:{System.out.println("Can i get some new pans and pots? The old ones are starting to " +
                                "stick" +
                                " ");
                            if(Choice.wybor()==1){
                            iron--;
                            food++;
                        }
                        else{
                            happines--;
                        }break;
                        }
                        default:
                        {
                            System.out.println("Here is your dinner my king");
                            happines++;
                        break;
                        }
                    }if(!death){death= checkIfDead.check(iron,happines,food,money);}
                    break;
                }case 4:{
                    System.out.println("Peasant");
                    int problem = random.nextInt(6);
                    switch (problem){
                        case 1:{System.out.println("Could you lover the taxes the crops are low this year?");
                            if(Choice.wybor()==1){
                                happines++;
                                money--;
                            }
                            else{
                                happines-=2;
                                money++;
                            }break;
                        }case 2:{System.out.println("The tools are hard to get and expensive can you do something " +
                                "about it?" +
                                " ");
                            if(Choice.wybor()==1){
                                money--;
                                iron--;
                                happines++;
                                food++;
                            }
                            else{
                                happines--;
                            }
                            break;
                        }case 3:{
                            System.out.println("It's the plague the cows are dying!");
                            if(Choice.wybor3()==1){
                            food-=2;
                        }
                        else{
                            food--;
                            happines++;
                        }break;
                        }case 4:{System.out.println("We had a great harvest what to do with all that grain?");
                            if(Choice.wybor2()==1){
                            happines++;
                            food++;
                        }
                        else{
                            money+=2;
                        }break;
                        }case 5:{
                            System.out.println("I think my neighbour is stealing my chickens can i get revenge?");
                            if(Choice.wybor()==1){
                            happines++;
                            food--;
                        }
                        else{
                            happines--;
                            money++;
                        }break;
                        }
                        default:
                        {System.out.println("I am sorry my problem was just dealt with. ");
                            happines++;
                        break;
                        }
                    }death= checkIfDead.check(iron,happines,food,money);
                    break;
                }case 5:{
                    System.out.println("Merchant");
                    int problem = random.nextInt(6);
                    switch (problem){
                        case 1:{System.out.println("We come to get the allowance to sell this good from our neighbour" +
                                " will it be possible?" +
                                " ");
                            if(Choice.wybor()==1){
                                money+=2;
                                happines--;
                            }
                            else{
                                money--;
                            }break;
                        }case 2:{System.out.println("How about you sell us some iron so we can get better weapons " +
                                "from our neighbour?");
                            if(Choice.wybor()==1){
                                iron-=2;
                                money++;
                                happines++;
                            }
                            else{
                                money--;

                            }
                            break;
                        }case 3:{System.out.println("How about investing some money? ");
                        if(Choice.wybor()==1){
                            money-=2;
                            food+=2;
                        }
                        else{
                            System.out.println("OK");
                        }break;
                        }case 4:{System.out.println("Care for some of the finest wine?");
                        if(Choice.wybor()==1){
                            death=true;
                        }
                        else{
                            happines++;

                        }break;
                        }case 5:{System.out.println("Want to buy something?");
                        int x =Choice.wybor4();
                        if(x==1){
                            money--;
                            food++;
                        }
                        else{
                            happines++;
                            money--;

                        }break;
                        }
                        default:
                        {System.out.println("The market is blooming");
                            happines++;
                        }break;

                    }if(!death){death= checkIfDead.check(iron,happines,food,money);}
                    break;
                }case 6:{
                    System.out.println("Nobleman");
                    int problem = random.nextInt(6);
                    switch (problem){
                        case 1:{System.out.println("How about we get some of the iron reserved for the army?");
                            if(Choice.wybor()==1){
                                iron--;
                                money+=2;
                            }
                            else{
                                happines--;
                                iron++;
                            }break;
                        }case 2:{System.out.println("It's time to call all neighbouring kings for a bal");
                            if(Choice.wybor()==1){
                                food--;
                                money--;
                                happines+=2;
                            }
                            else{
                                happines--;
                                food++;
                            }
                            break;
                        }case 3:{System.out.println("Can you imprison the merchant? He disrespected me! ");
                        if(Choice.wybor()==1){
                            happines++;
                            money++;
                        }
                        else{
                            happines--;
                            money+=2;
                        }break;
                        }case 4:{System.out.println("Could you lend us some of your guards for our travel?");
                        if(Choice.wybor()==1){
                            happines--;
                            money++;
                        }
                        else{
                            happines--;
                        }break;
                        }case 5:{System.out.println("We have to few influence we need more or the other classes will" +
                                " take over");
                        if(Choice.wybor()==1){
                            money+=2;
                            happines--;
                        }
                        else{
                            happines++;
                        }break;
                        }
                        default:
                        {System.out.println("We have everything we want or need");
                            happines++;
                            break;
                        }
                    }death= checkIfDead.check(iron,happines,food,money);
                    break;
                }case 7:{
                    System.out.println("Advisor");
                    int problem = random.nextInt(6);
                    switch (problem){
                        case 1:{System.out.println("We should build more warehouses.");
                            if(Choice.wybor()==1){
                                food++;
                                money-=2;
                                warehouse=true;
                            }
                            else{
                                happines--;
                            }break;
                        }case 2:{System.out.println("We need to tighten our security");
                            if(Choice.wybor()==1){
                                iron--;
                                money--;
                                happines++;
                            }
                            else{
                                happines--;
                            }
                            break;
                        }case 3:{System.out.println("We have to get new ceremonial robes for the court");
                        if(Choice.wybor()==1){
                            happines+=2;
                            money--;
                        }
                        else{
                            happines--;
                            money++;
                        }break;
                        }case 4:{System.out.println("We need to expand the mine");
                            if(Choice.wybor()==1){
                           iron+=2;
                           money--;
                        }
                        else{
                            iron--;
                        }break;
                        }case 5:{System.out.println("We have to increase the taxes");
                        if(Choice.wybor()==1){
                            money+=2;
                            happines--;
                        }
                        else{
                            money--;
                        }break;
                        }
                        default:
                        {
                            System.out.println("Is everything alright my king?");
                            happines++;
                        }break;

                    }death= checkIfDead.check(iron,happines,food,money);
                    break;
                }case 8:{
                    System.out.println("Emissary");
                    int problem = random.nextInt(6);
                    switch (problem){
                        case 1:{System.out.println("I came to negotiate the peace treaty.");
                            if(Choice.wybor()==1){
                                if(iron>=5)
                                {food++;
                                money++;}
                                else{
                                    food--;
                                    money--; } }
                            else{
                                iron-=2;
                            }break;
                        }case 2:{System.out.println("War it is!");
                            if(Choice.wybor()==1){
                                iron--;
                                happines--;
                            }
                            else{
                                money++;
                                happines++;
                                food--;
                            }
                            break;
                        }case 3:{System.out.println("How about creating a trade route between our countries?");
                        if(Choice.wybor()==1){
                            happines++;
                            money--;
                            food++;
                        }
                        else{
                            money--;
                        }break;
                        }case 4:{System.out.println("Could our country borrow money from you we will recompensate you" +
                                " with iron");
                        if(Choice.wybor()==1){
                            money-=2;
                            iron+=2;
                        }
                        else{
                            happines--;
                        }break;
                        }case 5:{ System.out.println("We came to ask for your help in our war against the King of the" +
                                " West");
                            if(Choice.wybor()==1){
                            iron--;
                            money++;
                            food++;
                            happines--;
                        }
                        else{
                            happines++;
                        }break;
                        }
                        default:
                        {System.out.println("My king sends his regards");
                            happines++;
                        break;
                        }
                    }death= checkIfDead.check(iron,happines,food,money);
                    break;
                }case 9:{
                    System.out.println("Misionary");
                    int problem = random.nextInt(6);
                    switch (problem){
                        case 1:{System.out.println("We came in peace to bring the message of our savior.");
                            if(Choice.wybor()==1){
                                happines--;
                                mision=true;
                            }
                            else{
                                money++;
                            }break;
                        }case 2:{System.out.println("We are good at cultivating the land we can share some of our " +
                                "knowledge for a bit of founding");
                            if(Choice.wybor()==1){
                                food++;
                                money--;
                            }
                            else{
                                happines--;
                            }
                            break;
                        }case 3:{System.out.println("Some people disrespect us and threaten us could you help us?");
                        if(Choice.wybor()==1){
                            iron--;
                            money++;
                        }
                        else{
                            happines++;

                        }break;
                        }case 4:{System.out.println("We help your people and some of us going to other countries " +
                                "could we count on you?");
                        if(Choice.wybor()==1){
                            money--;
                            happines++;
                        }
                        else{
                            happines--;
                        }break;
                        }case 5:{System.out.println("Can we get some land to build a place for our believers?");
                        if(Choice.wybor()==1){
                            money-=2;
                            happines++;
                            food++;
                        }
                        else{
                            happines--;
                        }break;
                        }
                        default:
                        {
                            System.out.println("Grace our savior!");
                            happines++;
                            break;
                        }
                    }death= checkIfDead.check(iron,happines,food,money);
                    break;
                }case 10:{
                    System.out.println("Treasurer");
                    int problem = random.nextInt(6);
                    switch (problem){
                        case 1:{System.out.println("We need to reform the taxes!");
                            if(Choice.wybor()==1){
                                money+=2;
                                happines--;
                            }
                            else{
                                happines++;
                                money--;
                            }break;
                        }case 2:{System.out.println("Some soldiers are hoarding a great sum of money and iron we " +
                                "should increase their taxes");
                            if(Choice.wybor()==1){
                                iron++;
                                money++;
                                happines--;
                            }
                            else{
                                happines++;
                                money--;
                            }
                            break;
                        }case 3:{System.out.println("We can sell some of our old weapons and armour for money.");
                        if(Choice.wybor()==1){
                            money++;
                            iron--;
                        }
                        else{
                            happines++;
                        }break;
                        }case 4:{System.out.println("We should create a reserve of money for the future");
                        if(Choice.wybor()==1){
                            money-=2;
                            bankreserve=true;
                        }
                        else{
                            money++;
                        }break;
                        }case 5:{System.out.println("The nobles are trying to hoard the money of the regular tax we " +
                                "should collect it as soon as possible");
                        if(Choice.wybor()==1){
                            money+=2;
                            happines-=2;
                        }
                        else{
                            happines++;
                            money-=2;
                        }break;
                        }
                        default:
                        {
                            System.out.println("Our country is prospering great!");
                            happines++;
                            break;
                        }
                    }death= checkIfDead.check(iron,happines,food,money);
                    break;
                }
                default:
                    System.out.println("Queen");
                    int problem = random.nextInt(6);
                    switch (problem){
                        case 1:{System.out.println("How about we go hunting?");
                            if(Choice.wybor()==1){
                                if(hunt.hunt()==1)
                                {
                                    death=setDead.dead();
                                }
                                else{
                                    food+=2;
                                }
                            }
                            else{
                                happines--;
                            }break;
                        }case 2:{System.out.println("I am not feeling safe in the castle increase the security!");
                            if(Choice.wybor()==1){
                                happines++;
                                money--;
                            }
                            else{
                                happines--;
                            }
                            break;
                        }case 3:{System.out.println("It's time for a feast my king");
                        if(Choice.wybor()==1){
                            happines++;
                            food--;
                        }
                        else{
                            happines--;
                        }break;
                        }case 4:{
                            System.out.println("The general is getting on my nerves you should talk to him");
                            if(Choice.wybor()==1){
                            iron--;
                            happines++;
                        }
                        else{
                            happines--;
                        }break;
                        }case 5:{System.out.println("You should finish it fast and go get some rest");
                        if(Choice.wybor()==1) {
                            death = setDead.dead();
                        } else{
                            happines++;
                        }break;
                        }
                        default:
                        {System.out.println("Are you feeling alright?");
                        happines++;
                        break;
                        }
                    }death= checkIfDead.check(iron,happines,food,money);
                    break;
            }
            if(iron>=10){
                iron=10;
            }if(food>=10){
                food=10;
            }if(happines>=10){
                happines=10;
            }if(money>=10){
                money=10;
            }
            System.out.println();
            if(warehouse){
                if(death && food<=0){
                    death=false;
                    food=3;
                    warehouse=false;
                    System.out.println("We used our reserves to fight the food shortage");
                }
            }if(scrapmetal){
                if(death && iron<=0){
                    death=false;
                    iron=3;
                    scrapmetal=false;
                    System.out.println("We used the scrap metal to fix the shortage of iron");
                }
            }if(bankreserve){
                if(death && money<=0){
                    death=false;
                    money=3;
                    bankreserve=false;
                    System.out.println("We used the money reserve to not go bankrupt");
                }
            }if(mision){
                if(death && food<=0){
                    death=false;
                    happines=3;
                    mision=false;
                    System.out.println("We used the misionaries for help to quench the riot ");
                }
            }
            System.out.println("Iron: "+iron+" Happiness: "+happines +" Food: "+ food+ " Money: "+money);
            System.out.println();
        }while(System.currentTimeMillis()/1000-start<600 && !death);
        year++;
        if(death){
            System.out.println("Your reign has come to an end but the story continues...");
            PrintWriter printWriter = new PrintWriter("src/zasoby.txt");
            printWriter.println(5);
            printWriter.println(5);
            printWriter.println(5);
            printWriter.println(5);
            printWriter.println(year);
            System.out.println("Podaj imię następcy: ");
            printWriter.println(scanner.nextLine());
            printWriter.close();
        }else {
            System.out.println("The 10 minute audience is over rest until the next...");
            PrintWriter printWriter = new PrintWriter("src/zasoby.txt");
            printWriter.println(iron);
            printWriter.println(happines);
            printWriter.println(food);
            printWriter.println(money);
            printWriter.println(year);
            printWriter.close(); }
            //zapis do pliku
        //całość działa 10 min około
    }
}
