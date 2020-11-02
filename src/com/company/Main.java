package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("gui.fxml"));
        Parent layout = fxmlLoader.load();
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.show();

        int iron,happines,food,money;
        int year;
        boolean warehouse= false;
        boolean bankreserve= false;
        boolean scrapmetal= false;
        boolean mision= false;
        boolean death = false;
        String name;
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
        control control = new control();
        Hunt hunt = new Hunt();
        //pobieranie zasobów z pliku txt, inaczej save
        control.Message_change("The year is "+year+" and the audience of King "+name+" begins...");
        Thread.sleep(1000);
        System.out.println();
	    long start=System.currentTimeMillis()/1000;
	    long stop;
        do{
            stop = System.currentTimeMillis()/1000;
            Random random = new Random();
            int character = random.nextInt(11);
            switch (character){
                case 1:{
                    control.person_change("Guard");
                    int problem = random.nextInt(6);
                        switch (problem){
                            case 1:{
                                control.Message_change("King we need new armour sets because the old ones are getting" +
                                        " rusty" +
                                        " ");
                                if(control.wybor()==1){
                                    iron--;
                                    money--;
                                }
                                else{
                                    happines--;
                                }break;
                            }case 2:{
                                control.Message_change("We need more guards we serve a long time and we need more rest");
                                if(control.wybor()==1){
                                   food--;
                                   money--;
                                   happines++;
                                }
                                else{
                                    happines-=2;
                                }
                                break;
                            }case 3:{control.Message_change("We caught a noblemans son stealing should we get money from " +
                                    "his father to pay for his freedom?");
                                if(control.wybor()==1){
                                money++;}
                                else {
                                    happines--;
                                }break;
                            }case 4:{control.Message_change("Can you fire that servant? He iritates me.");
                            if(control.wybor()==0){
                                happines--;
                            }
                            break;
                            }case 5:{
                                control.Message_change("Can we have bigger food rations?");
                                if(control.wybor()==1){
                                food--;
                                happines++;
                            }
                            else{
                                happines--;
                            }break;
                            }
                            default:
                            {
                                control.Message_change("Have a nice day my king may your reign be glorious");
                                happines++;
                            break;
                            }
                        }
                    death=checkIfDead.check(iron,happines,food,money);
                    break;
                }case 2:{
                    control.person_change("General");
                    int problem = random.nextInt(6);
                    switch (problem){
                        case 1:{control.Message_change("We need to get new recruits because the enemy is raiding us");
                            if(control.wybor()==1){
                                food--;
                                money-=2;
                                happines+=2;
                            }
                            else{
                                happines--;
                                money--;
                            }break;
                        }case 2:{control.Message_change("After our last battle the spoils were great should we turn it " +
                                "into money?");
                            if(control.wybor()==1){
                                money+=3;
                            }
                            else{
                                happines++;
                                food++;
                                iron++;
                            }
                            break;
                        }case 3:{control.Message_change("Some merchants are getting bossy around town should we arrest " +
                                "one or two to make them stop?");
                        if(control.wybor()==1){
                            happines--;
                            money+=2;
                        }
                        else{
                            happines++;
                            food++;
                        }break;
                        }case 4:{
                            control.Message_change("We need better armour and weapons or we will lose the upcoming war we" +
                                    " can " +
                                    "leave the old ones for later");
                            if(control.wybor()==1){
                            money-=2;
                            happines++;
                            scrapmetal=true;
                        }
                        else{
                            food--;
                            money--;

                        }break;
                        }case 5:{control.Message_change("During one expedition a soldier found an artifact it " +
                                "could fetch a nice sum");
                        if(control.wybor()==1){
                            money+=2;
                        }
                        else{
                            happines+=2;

                        }break;
                        }
                        default:
                        {
                            control.Message_change("The military is as strong as ever");
                            happines++;
                        break;
                        }
                    }death= checkIfDead.check(iron,happines,food,money);
                    break;
                }case 3:{
                    control.person_change("Cook");
                    int problem = random.nextInt(6);
                    switch (problem){
                        case 1:{control.Message_change("It's about time we make a feast? ");
                            if(control.wybor()==1){
                                happines++;
                                food++;
                                money--;
                            }
                            else{
                                money++;
                            }break;
                        }case 2:{control.Message_change("Want to try this dish of the new species we found last month? ");
                            if(control.wybor()==1){
                                death=true;
                                System.out.println("The food was contaminated ");
                            }
                            else{
                                happines++;
                            }
                            break;
                        }case 3:{control.Message_change("I need more ingredients or i won't be able to serve the " +
                                "required" +
                                " amount of servings could you do something about it.");
                        if(control.wybor()==1){
                            happines++;
                            money--;
                        }
                        else{
                            food-=2;
                        }break;
                        }case 4:{control.Message_change("After the last party we have many leftovers should i give it to " +
                                "the people or sell to the merchants?" +
                                " ");
                        if(control.wybor2()==1){
                            happines++;
                        }
                        else{
                            money++;
                        }break;
                        }case 5:{control.Message_change("Can i get some new pans and pots? The old ones are starting to " +
                                "stick" +
                                " ");
                            if(control.wybor()==1){
                            iron--;
                            food++;
                        }
                        else{
                            happines--;
                        }break;
                        }
                        default:
                        {
                            control.Message_change("Here is your dinner my king");
                            happines++;
                        break;
                        }
                    }if(!death){death= checkIfDead.check(iron,happines,food,money);}
                    break;
                }case 4:{
                    control.person_change("Peasant");
                    int problem = random.nextInt(6);
                    switch (problem){
                        case 1:{control.Message_change("Could you lover the taxes the crops are low this year?");
                            if(control.wybor()==1){
                                happines++;
                                money--;
                            }
                            else{
                                happines-=2;
                                money++;
                            }break;
                        }case 2:{control.Message_change("The tools are hard to get and expensive can you do something " +
                                "about it?" +
                                " ");
                            if(control.wybor()==1){
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
                            control.Message_change("It's the plague the cows are dying!");
                            if(control.wybor3()==1){
                            food-=2;
                        }
                        else{
                            food--;
                            happines++;
                        }break;
                        }case 4:{control.Message_change("We had a great harvest what to do with all that grain?");
                            if(control.wybor2()==1){
                            happines++;
                            food++;
                        }
                        else{
                            money+=2;
                        }break;
                        }case 5:{
                            control.Message_change("I think my neighbour is stealing my chickens and the guards are " +
                                    "ignoring me could you give them a word?" +
                                    " ?");
                            if(control.wybor()==1){
                            happines++;
                            food--;
                        }
                        else{
                            happines--;
                            money++;
                        }break;
                        }
                        default:
                        {control.Message_change("I am sorry my problem was just dealt with. ");
                            happines++;
                        break;
                        }
                    }death= checkIfDead.check(iron,happines,food,money);
                    break;
                }case 5:{
                    control.person_change("Merchant");
                    int problem = random.nextInt(6);
                    switch (problem){
                        case 1:{control.Message_change("We come to get the allowance to sell this good from our neighbour" +
                                " will it be possible?" +
                                " ");
                            if(control.wybor()==1){
                                money+=2;
                                happines--;
                            }
                            else{
                                money--;
                            }break;
                        }case 2:{control.Message_change("How about you sell us some iron so we can get better weapons " +
                                "from our neighbour?");
                            if(control.wybor()==1){
                                iron-=2;
                                money++;
                                happines++;
                            }
                            else{
                                money--;

                            }
                            break;
                        }case 3:{control.Message_change("How about investing some money? ");
                        if(control.wybor()==1){
                            money-=2;
                            food+=2;
                        }
                        else{
                            control.Message_change("OK");
                        }break;
                        }case 4:{control.Message_change("Care for some of the finest wine?");
                        if(control.wybor()==1){
                            death=true;
                            control.Message_change("It was poisoned !");
                            Thread.sleep(1000);
                        }
                        else{
                            happines++;

                        }break;
                        }case 5:{control.Message_change("Want to buy something?");
                        int x =control.wybor4();
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
                        {control.Message_change("The market is blooming");
                            happines++;
                        }break;

                    }if(!death){death= checkIfDead.check(iron,happines,food,money);}
                    break;
                }case 6:{
                    control.person_change("Nobleman");
                    int problem = random.nextInt(6);
                    switch (problem){
                        case 1:{control.Message_change("How about we get some of the iron reserved for the army?");
                            if(control.wybor()==1){
                                iron--;
                                money+=2;
                            }
                            else{
                                happines--;
                                iron++;
                            }break;
                        }case 2:{control.Message_change("It's time to call all neighbouring kings for a bal");
                            if(control.wybor()==1){
                                food--;
                                money--;
                                happines+=2;
                            }
                            else{
                                happines--;
                                food++;
                            }
                            break;
                        }case 3:{control.Message_change("Can you imprison the merchant? He disrespected me! ");
                        if(control.wybor()==1){
                            happines++;
                            money++;
                        }
                        else{
                            happines--;
                            money+=2;
                        }break;
                        }case 4:{control.Message_change("Could you lend us some of your guards for our travel?");
                        if(control.wybor()==1){
                            happines--;
                            money++;
                        }
                        else{
                            happines--;
                        }break;
                        }case 5:{control.Message_change("We have to few influence we need more or the other classes will" +
                                " take over");
                        if(control.wybor()==1){
                            money+=2;
                            happines--;
                        }
                        else{
                            happines++;
                            money--;
                        }break;
                        }
                        default:
                        {control.Message_change("We have everything we want or need");
                            happines++;
                            break;
                        }
                    }death= checkIfDead.check(iron,happines,food,money);
                    break;
                }case 7:{
                    control.person_change("Advisor");
                    int problem = random.nextInt(6);
                    switch (problem){
                        case 1:{control.Message_change("We should build more warehouses.");
                            if(control.wybor()==1){
                                food++;
                                money-=2;
                                warehouse=true;
                            }
                            else{
                                happines--;
                            }break;
                        }case 2:{control.Message_change("We need to tighten our security");
                            if(control.wybor()==1){
                                iron--;
                                money--;
                                happines++;
                            }
                            else{
                                happines--;
                            }
                            break;
                        }case 3:{control.Message_change("We have to get new ceremonial robes for the court");
                        if(control.wybor()==1){
                            happines+=2;
                            money--;
                        }
                        else{
                            happines--;
                            money++;
                        }break;
                        }case 4:{control.Message_change("We need to expand the mine");
                            if(control.wybor()==1){
                           iron+=2;
                           money--;
                        }
                        else{
                            iron--;
                        }break;
                        }case 5:{control.Message_change("We have to increase the taxes");
                        if(control.wybor()==1){
                            money+=2;
                            happines--;
                        }
                        else{
                            money--;
                        }break;
                        }
                        default:
                        {
                            control.Message_change("Is everything alright my king?");
                            happines++;
                        }break;

                    }death= checkIfDead.check(iron,happines,food,money);
                    break;
                }case 8:{
                    control.person_change("Emissary");
                    int problem = random.nextInt(6);
                    switch (problem){
                        case 1:{control.Message_change("I came to negotiate the peace treaty.");
                            if(control.wybor()==1){
                                if(iron>=5)
                                {food++;
                                money++;}
                                else{
                                    food--;
                                    money--; } }
                            else{
                                iron-=2;
                            }break;
                        }case 2:{control.Message_change("War it is!");
                            if(control.wybor()==1){
                                iron--;
                                happines--;
                            }
                            else{
                                money++;
                                happines++;
                                food--;
                            }
                            break;
                        }case 3:{control.Message_change("How about creating a trade route between our countries?");
                        if(control.wybor()==1){
                            happines++;
                            money--;
                            food++;
                        }
                        else{
                            money--;
                        }break;
                        }case 4:{control.Message_change("Could our country borrow money from you we will recompensate" +
                                " you" +
                                " with iron");
                        if(control.wybor()==1){
                            money-=2;
                            iron+=2;
                        }
                        else{
                            happines--;
                        }break;
                        }case 5:{ control.Message_change("We came to ask for your help in our war against the King of the" +
                                " West");
                            if(control.wybor()==1){
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
                        {control.Message_change("My king sends his regards");
                            happines++;
                        break;
                        }
                    }death= checkIfDead.check(iron,happines,food,money);
                    break;
                }case 9:{
                    control.person_change("Misionary");
                    int problem = random.nextInt(6);
                    switch (problem){
                        case 1:{control.Message_change("We came in peace to bring the message of our savior.");
                            if(control.wybor()==1){
                                happines--;
                                mision=true;
                            }
                            else{
                                money++;
                            }break;
                        }case 2:{control.Message_change("We are good at cultivating the land we can share some of our " +
                                "knowledge for a bit of founding");
                            if(control.wybor()==1){
                                food++;
                                money--;
                            }
                            else{
                                happines--;
                            }
                            break;
                        }case 3:{control.Message_change("Some people disrespect us and threaten us could you help us?");
                        if(control.wybor()==1){
                            iron--;
                            money++;
                        }
                        else{
                            happines++;

                        }break;
                        }case 4:{control.Message_change("We help your people and some of us going to other countries " +
                                "could we count on you?");
                        if(control.wybor()==1){
                            money--;
                            happines++;
                        }
                        else{
                            happines--;
                        }break;
                        }case 5:{control.Message_change("Can we get some land to build a place for our believers?");
                        if(control.wybor()==1){
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
                            control.Message_change("Grace our savior!");
                            happines++;
                            break;
                        }
                    }death= checkIfDead.check(iron,happines,food,money);
                    break;
                }case 10:{
                    control.person_change("Treasurer");
                    int problem = random.nextInt(6);
                    switch (problem){
                        case 1:{control.Message_change("We need to reform the taxes!");
                            if(control.wybor()==1){
                                money+=2;
                                happines--;
                            }
                            else{
                                happines++;
                                money--;
                            }break;
                        }case 2:{control.Message_change("Some soldiers are hoarding a great sum of money and iron we " +
                                "should increase their taxes");
                            if(control.wybor()==1){
                                iron++;
                                money++;
                                happines--;
                            }
                            else{
                                happines++;
                                money--;
                            }
                            break;
                        }case 3:{control.Message_change("We can sell some of our old weapons and armour for money.");
                        if(control.wybor()==1){
                            money++;
                            iron--;
                        }
                        else{
                            happines++;
                        }break;
                        }case 4:{control.Message_change("We should create a reserve of money for the future");
                        if(control.wybor()==1){
                            money-=2;
                            bankreserve=true;
                        }
                        else{
                            money++;
                        }break;
                        }case 5:{control.Message_change("The nobles are trying to hoard the money of the regular tax we " +
                                "should collect it as soon as possible");
                        if(control.wybor()==1){
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
                            control.Message_change("Our country is prospering great!");
                            happines++;
                            break;
                        }
                    }death= checkIfDead.check(iron,happines,food,money);
                    break;
                }
                default:
                    control.person_change("Queen");
                    int problem = random.nextInt(6);
                    switch (problem){
                        case 1:{control.Message_change("How about we go hunting?");
                            if(control.wybor()==1){
                                if(hunt.hunt()==1)
                                {
                                    death=true;
                                }
                                else{
                                    food+=2;
                                }
                            }
                            else{
                                happines--;
                            }break;
                        }case 2:{control.Message_change("I am not feeling safe in the castle increase the security!");
                            if(control.wybor()==1){
                                happines++;
                                money--;
                            }
                            else{
                                happines--;
                            }
                            break;
                        }case 3:{control.Message_change("It's time for a feast my king");
                        if(control.wybor()==1){
                            happines++;
                            food--;
                        }
                        else{
                            happines--;
                        }break;
                        }case 4:{
                            control.Message_change("The general is getting on my nerves you should talk to him");
                            if(control.wybor()==1){
                            iron--;
                            happines++;
                        }
                        else{
                            happines--;
                        }break;
                        }case 5:{control.Message_change("You should finish it fast and go get some rest");
                        if(control.wybor()==1) {
                            death = true;
                        } else{
                            happines++;
                        }break;
                        }
                        default:
                        {control.Message_change("Are you feeling alright?");
                        happines++;
                        break;
                        }
                    }if(!death){death= checkIfDead.check(iron,happines,food,money);}
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

            if(warehouse){
                control.person_change("Advisor");
                if(death && food<=0){
                    death=false;
                    food=3;
                    warehouse=false;
                    control.Message_change("We used our reserves to fight the food shortage");
                    Thread.sleep(1000);
                }
            }if(scrapmetal){
                control.person_change("Advisor");
                if(death && iron<=0){
                    death=false;
                    iron=3;
                    scrapmetal=false;
                    control.Message_change("We used the scrap metal to fix the shortage of iron");
                    Thread.sleep(1000);
                }
            }if(bankreserve){
                control.person_change("Advisor");
                if(death && money<=0){
                    death=false;
                    money=3;
                    bankreserve=false;
                    control.Message_change("We used the money reserve to not go bankrupt");
                    Thread.sleep(1000);
                }
            }if(mision){
                control.person_change("Advisor");
                if(death && food<=0){
                    death=false;
                    happines=3;
                    mision=false;
                    control.Message_change("We used the misionaries for help to quench the riot ");
                    Thread.sleep(1000);
                }
            }
            System.out.println("Iron: "+iron+" Happiness: "+happines +" Food: "+ food+ " Money: "+money);
            System.out.println();
            Thread.sleep(100);
        }while(stop-start<600 && !death);
        year++;
        if(death){
            control.Message_change("Your reign has come to an end but the story continues...");
            PrintWriter printWriter = new PrintWriter("src/zasoby.txt");
            printWriter.println(5);
            printWriter.println(5);
            printWriter.println(5);
            printWriter.println(5);
            printWriter.println(year);
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
            printWriter.close();
        }
        Thread.sleep(1000);
        //zapis do pliku
        //całość działa 10 min około
    }
}
