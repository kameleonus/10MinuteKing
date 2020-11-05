package com.company;

import javafx.fxml.FXML;

import java.io.*;
import java.util.Random;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class control {
    @FXML
    private Button Yes;
    @FXML
    private Button No;
    @FXML
    private Label Person;
    @FXML
    private Label message;
    @FXML
    private Label stuff;
    long start = System.currentTimeMillis()/1000;
//start game poyem wywal teksty komunikatu i z losu tego zrobićwarośći w chocie io na to z tych danych game
// wywołujesz co zmienia
    boolean warehouse = false;
    boolean bankreserve = false;
    boolean scrapmetal = false;
    boolean mision = false;
    boolean death = false;
    File file = new File("src/zasoby.txt");
    FileInputStream inputStream = new FileInputStream(file);
    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    int iron = Integer.parseInt(bufferedReader.readLine());
    int happines = Integer.parseInt(bufferedReader.readLine());
    int food = Integer.parseInt(bufferedReader.readLine());
    int money = Integer.parseInt(bufferedReader.readLine());
    int year = Integer.parseInt(bufferedReader.readLine());
    Random random = new Random();
    CheckIfDead checkIfDead = new CheckIfDead();
    Save save = new Save();

    public control() throws IOException {
        bufferedReader.close();
    }
    int character,problem;
    @FXML
    void game() throws InterruptedException {
        Message_change("Welcome to the game");
        Message_change("The year is " + year + " and the audience of the King begins...");
        Yes.setDisable(false);
        No.setDisable(false);
        character = random.nextInt(11);
        switch (character) {
            case 1:
                person_change("Guard");
                problem = random.nextInt(6);
                switch (problem) {
                    case 1:
                        Message_change("King we need new armour sets because the old ones are getting rusty ");
                        break;
                    case 2:
                        Message_change("We need more guards we serve a long time and we need more rest");
                        break;
                    case 3:
                        Message_change("We caught a noblemans son stealing \nshould we get money from his father to pay for his freedom?");

                        break;
                    case 4:
                        Message_change("Can you fire that servant? He iritates me.");

                        break;
                    case 5:
                        Message_change("Can we have bigger food rations?");

                        break;
                    default:
                        Message_change("Have a nice day my king may your reign be glorious");
                }
                break;
            case 2:
                person_change("General");
                problem = random.nextInt(6);
                switch (problem) {
                    case 1:
                        Message_change("We need to get new recruits because the enemy is raiding us");
                        break;
                    case 2:
                        Message_change("After our last battle the spoils were great should we turn it into money?");
                        break;
                    case 3:
                        Message_change("Some merchants are getting bossy around town \nshould we arrest one or two to make them stop?");
                        break;
                    case 4:
                        Message_change("We need better armour and weapons or we will lose the upcoming war\n we can leave the old ones for later");
                        break;
                    case 5:
                        Message_change("During one expedition a soldier found an artifact \nit could fetch a nice sum");
                        break;
                    default:
                        Message_change("The military is as strong as ever");
                }
                break;
            case 3:
                person_change("Cook");
                problem = random.nextInt(6);
                switch (problem) {
                    case 1:
                        Message_change("It's about time we make a feast? ");
                        break;
                    case 2:
                        Message_change("Want to try this dish of the new species we found last month? ");
                        break;
                    case 3:
                        Message_change("I need more ingredients or i won't be able to serve the required amount of servings\n could you do something about it.");
                        break;
                    case 4:
                        Message_change("After the last party we have many leftovers\n should i give it to the people or sell to the merchants? ");
                        break;
                    case 5:
                        Message_change("Can i get some new pans and pots? The old ones are starting to stick ");
                        break;
                    default:
                        Message_change("Here is your dinner my king");
                }
                break;
            case 4:
                person_change("Peasant");
                problem = random.nextInt(6);
                switch (problem) {
                    case 1:
                        Message_change("Could you lover the taxes the crops are low this year?");
                        break;
                    case 2:
                        Message_change("The tools are hard to get and expensive can you do something about it? ");
                        break;
                    case 3:
                        Message_change("It's the plague the cows are dying!");
                        break;
                    case 4:
                        Message_change("We had a great harvest what to do with all that grain?");
                        break;
                    case 5:
                        Message_change("I think my neighbour is stealing my chickens and the guards are ignoring me \ncould you give them a word? ?");
                        break;
                    default:
                        Message_change("I am sorry my problem was just dealt with. ");
                }
                break;
            case 5:
                person_change("Merchant");
                problem = random.nextInt(6);
                switch (problem) {
                    case 1:
                        Message_change("We come to get the allowance to sell \nthis good from our neighbour will it be possible? ");
                        break;
                    case 2:
                        Message_change("How about you sell us some iron so we can \nget better weapons from our neighbour?");
                        break;
                    case 3:
                        Message_change("How about investing some money? ");
                        break;
                    case 4:
                        Message_change("Care for some of the finest wine?");
                        break;
                    case 5:
                        Message_change("Want to buy something?");
                        break;
                    default:
                        Message_change("The market is blooming");
                }
                break;
            case 6:
                person_change("Nobleman");
                problem = random.nextInt(6);
                switch (problem) {
                    case 1:
                        Message_change("How about we get some of the iron reserved for the army?");
                        break;
                    case 2:
                        Message_change("It's time to call all neighbouring kings for a bal");
                        break;
                    case 3:
                        Message_change("Can you imprison the merchant? He disrespected me! ");
                        break;
                    case 4:
                        Message_change("Could you lend us some of your guards for our travel?");
                        break;
                    case 5:
                        Message_change("We have to few influence \nwe need more or the other classes will take over");
                        break;
                    default:
                        Message_change("We have everything we want or need");
                }
                break;
            case 7:
                person_change("Advisor");
                problem = random.nextInt(6);
                switch (problem) {
                    case 1:
                        Message_change("We should build more warehouses.");
                        break;
                    case 2:
                        Message_change("We need to tighten our security");
                        break;
                    case 3:
                        Message_change("We have to get new ceremonial robes for the court");
                        break;
                    case 4:
                        Message_change("We need to expand the mine");
                        break;
                    case 5:
                        Message_change("We have to increase the taxes");
                        break;
                    default:
                        Message_change("Is everything alright my king?");
                }
                break;
            case 8:
                person_change("Emissary");
                problem = random.nextInt(6);
                switch (problem) {
                    case 1:
                        Message_change("I came to negotiate the peace treaty.");
                        break;
                    case 2:
                        Message_change("War it is!");
                        break;
                    case 3:
                        Message_change("How about creating a trade route between our countries?");
                        break;
                    case 4:
                        Message_change("Could our country borrow money from you \nwe will recompensate you with iron");
                        break;
                    case 5:
                        Message_change("We came to ask for your help in our war against \nthe King of the West");
                        break;
                    default:
                        Message_change("My king sends his regards");
                }
                break;
            case 9:
                person_change("Misionary");
                problem = random.nextInt(6);
                switch (problem) {
                    case 1:
                        Message_change("We came in peace to bring the message of our savior.");
                        break;
                    case 2:
                        Message_change("We are good at cultivating the land we can share some of our \nknowledge for a bit of founding");
                        break;
                    case 3:
                        Message_change("Some people disrespect us and threaten us could you help us?");
                        break;
                    case 4:
                        Message_change("We help your people and some of us going to other countries \ncould we count on you?");
                        break;
                    case 5:
                        Message_change("Can we get some land to build a place for our believers?");
                        break;
                    default:
                        Message_change("Grace our savior!");
                }
                break;
            case 10:
                person_change("Treasurer");
                problem = random.nextInt(6);
                switch (problem) {
                    case 1:
                        Message_change("We need to reform the taxes!");
                        break;
                    case 2:
                        Message_change("Some soldiers are hoarding a great sum of money and iron \nwe should increase" +
                                " their taxes");
                        break;
                    case 3:
                        Message_change("We can sell some of our old weapons and armour for money.");
                        break;
                    case 4:
                        Message_change("We should create a reserve of money for the future");
                        break;
                    case 5:
                        Message_change("The nobles are trying to hoard the money of the regular tax\n we should collect it as soon as possible");
                        break;
                    default:
                        Message_change("Our country is prospering great!");
                }
                break;
            default:
                person_change("Queen");
                problem = random.nextInt(6);
                switch (problem) {
                    case 1:
                        Message_change("How about we go hunting?");
                        break;
                    case 2:
                        Message_change("I am not feeling safe in the castle increase the security!");
                        break;
                    case 3:
                        Message_change("It's time for a feast my king");
                        break;
                    case 4:
                        Message_change("The general is getting on my nerves you should talk to him");
                        break;
                    case 5:
                        Message_change("You should finish it fast and go get some rest");
                        break;
                    default:
                        Message_change("Are you feeling alright?");
                } } }
    @FXML
    void checker() throws FileNotFoundException, InterruptedException {
            if (iron >= 10) {
                iron = 10;
            }
            if (food >= 10) {
                food = 10;
            }
            if (happines >= 10) {
                happines = 10;
            }
            if (money >= 10) {
                money = 10;
            }
            if (warehouse) {
                person_change("Advisor");
                if (death && food <= 0) {
                    death = false;
                    food = 3;
                    warehouse = false;
                    Message_change("We used our reserves to fight the food shortage");
                }
            }

            if (scrapmetal) {
                person_change("Advisor");
                if (death && iron <= 0) {
                    death = false;
                    iron = 3;
                    scrapmetal = false;
                    Message_change("We used the scrap metal to fix the shortage of iron");
                }
            }

            if (bankreserve) {
                person_change("Advisor");
                if (death && money <= 0) {
                    death = false;
                    money = 3;
                    bankreserve = false;
                    Message_change("We used the money reserve to not go bankrupt");
                }
            }

            if (mision) {
                person_change("Advisor");
                if (death && food <= 0) {
                    death = false;
                    happines = 3;
                    mision = false;
                    Message_change("We used the misionaries for help to quench the riot ");
                }
            }

            stuff.setText("Iron: " + iron + " Happiness: " + happines + " Food: " + food + " Money: " + money);
            save.save(death,year,iron,happines,food,money);
            if(death)
            {
                message.setText("You are dead");
                end end= new end();
                end.end();

            }
            else if(System.currentTimeMillis()/1000-start>300){
                message.setText("we see you next time");
                end end= new end();
                end.end();
            }
          }



    @FXML
    void yes() throws InterruptedException, FileNotFoundException {
        wybor(1,character,problem);
        game();
    }

    @FXML
    void no() throws InterruptedException, FileNotFoundException {
        wybor(0,character,problem);
        game();
    }

    @FXML
    void wybor(int w,int character,int problem) throws FileNotFoundException, InterruptedException {
        this.Yes.setText("1.Yes");
        this.No.setText("2.No");
        switch (character) {
            case 1:
                switch (problem) {
                    case 1:
                        if (w == 1) {
                            --iron;
                            --money;
                        } else {
                            --happines;
                        }
                        break;
                    case 2:
                        if (w == 1) {
                            --food;
                            --money;
                            ++happines;
                        } else {
                            happines -= 2;
                        }
                        break;
                    case 3:
                        if (w == 1) {
                            ++money;
                        } else {
                            --happines;
                        }
                        break;
                    case 4:
                        if (w == 0) {
                            --happines;
                        }
                        break;
                    case 5:
                        if (w == 1) {
                            --food;
                            ++happines;
                        } else {
                            --happines;
                        }
                        break;
                    default:
                        ++happines;
                }
                death = checkIfDead.check(iron, happines, food, money);
                break;
            case 2:
                switch (problem) {
                    case 1:
                        if (w == 1) {
                            --food;
                            money -= 2;
                            happines += 2;
                        } else {
                            --happines;
                            --money;
                        }
                        break;
                    case 2:
                        if (w == 1) {
                            money += 3;
                        } else {
                            ++happines;
                            ++food;
                            ++iron;
                        }
                        break;
                    case 3:
                        if (w == 1) {
                            --happines;
                            money += 2;
                        } else {
                            ++happines;
                            ++food;
                        }
                        break;
                    case 4:
                        if (w== 1) {
                            money -= 2;
                            ++happines;
                            scrapmetal = true;
                        } else {
                            --food;
                            --money;
                        }
                        break;
                    case 5:
                        if (w == 1) {
                            money += 2;
                        } else {
                            happines += 2;
                        }
                        break;
                    default:
                        ++happines;
                }

                death = checkIfDead.check(iron, happines, food, money);
                break;
            case 3:
                switch (problem) {
                    case 1:
                        if (w== 1) {
                            ++happines;
                            ++food;
                            --money;
                        } else {
                            ++money;
                        }
                        break;
                    case 2:
                        if (w== 1) {
                            death = true;
                            Message_change("The food was contaminated ");
                        } else {
                            ++happines;
                        }
                        break;
                    case 3:
                        if (w== 1) {
                            ++happines;
                            --money;
                        } else {
                            food -= 2;
                        }
                        break;
                    case 4:
                        if (w == 1) {
                            ++happines;
                        } else {
                            ++money;
                        }
                        break;
                    case 5:
                        if (w== 1) {
                            --iron;
                            ++food;
                        } else {
                            --happines;
                        }
                        break;
                    default:
                        ++happines;
                }
                if (!death) {
                    death = checkIfDead.check(iron, happines, food, money);
                }
                break;
            case 4:
                switch (problem) {
                    case 1:
                        if (w== 1) {
                            ++happines;
                            --money;
                        } else {
                            happines -= 2;
                            ++money;
                        }
                        break;
                    case 2:
                        if (w == 1) {
                            --money;
                            --iron;
                            ++happines;
                            ++food;
                        } else {
                            --happines;
                        }
                        break;
                    case 3:
                        if (w == 1) {
                            food -= 2;
                        } else {
                            --food;
                            ++happines;
                        }
                        break;
                    case 4:
                        if (w== 1) {
                            ++happines;
                            ++food;
                        } else {
                            money += 2;
                        }
                        break;
                    case 5:
                        if (w== 1) {
                            ++happines;
                            --food;
                        } else {
                            --happines;
                            ++money;
                        }
                        break;
                    default:
                        ++happines;
                }
                death = checkIfDead.check(iron, happines, food, money);
                break;
            case 5:
                switch (problem) {
                    case 1:
                        if (w== 1) {
                            money += 2;
                            --happines;
                        } else {
                            --money;
                        }
                        break;
                    case 2:
                        if (w== 1) {
                            iron -= 2;
                            ++money;
                            ++happines;
                        } else {
                            --money;
                        }
                        break;
                    case 3:
                        if (w== 1) {
                            money -= 2;
                            food += 2;
                        }
                        break;
                    case 4:
                        if (w== 1) {
                            death = true;
                            Message_change("It was poisoned !");
                        } else {
                            ++happines;
                        }
                        break;
                    case 5:
                        if (w== 1) {
                            --money;
                            ++food;
                        } else {
                            ++happines;
                            --money;
                        }
                        break;
                    default:
                        ++happines;
                }
                if (!death) {
                    death = checkIfDead.check(iron, happines, food, money);
                }
                break;
            case 6:
                switch (problem) {
                    case 1:
                        if (w== 1) {
                            --iron;
                            money += 2;
                        } else {
                            --happines;
                            ++iron;
                        }
                        break;
                    case 2:
                        if (w == 1) {
                            --food;
                            --money;
                            happines += 2;
                        } else {
                            --happines;
                            ++food;
                        }
                        break;
                    case 3:
                        if (w == 1) {
                            ++happines;
                            ++money;
                        } else {
                            --happines;
                            money += 2;
                        }
                        break;
                    case 4:
                        if (w== 1) {
                            --happines;
                            ++money;
                        } else {
                            --happines;
                        }
                        break;
                    case 5:
                        if (w== 1) {
                            money += 2;
                            --happines;
                        } else {
                            ++happines;
                            --money;
                        }
                        break;
                    default:
                        ++happines;
                }
                death = checkIfDead.check(iron, happines, food, money);
                break;
            case 7:
                switch (problem) {
                    case 1:
                        if (w == 1) {
                            ++food;
                            money -= 2;
                            warehouse = true;
                        } else {
                            --happines;
                        }
                        break;
                    case 2:
                        if (w== 1) {
                            --iron;
                            --money;
                            ++happines;
                        } else {
                            --happines;
                        }
                        break;
                    case 3:
                        if (w== 1) {
                            happines += 2;
                            --money;
                        } else {
                            --happines;
                            ++money;
                        }
                        break;
                    case 4:
                        if (w == 1) {
                            iron += 2;
                            --money;
                        } else {
                            --iron;
                        }
                        break;
                    case 5:

                        if (w == 1) {
                            money += 2;
                            --happines;
                        } else {
                            --money;
                        }
                        break;
                    default:
                        ++happines;
                }
                death = checkIfDead.check(iron, happines, food, money);
                break;
            case 8:
                switch (problem) {
                    case 1:
                        if (w== 1) {
                            if (iron >= 5) {
                                ++food;
                                ++money;
                            } else {
                                --food;
                                --money;
                            }
                        } else {
                            iron -= 2;
                        }
                        break;
                    case 2:
                        if (w == 1) {
                            --iron;
                            --happines;
                        } else {
                            --money;
                            ++happines;
                            --food;
                        }
                        break;
                    case 3:
                        if (w == 1) {
                            ++happines;
                            --money;
                            ++food;
                        } else {
                            --money;
                        }
                        break;
                    case 4:
                        if (w== 1) {
                            money -= 2;
                            iron += 2;
                        } else {
                            --happines;
                        }
                        break;
                    case 5:
                        if (w == 1) {
                            --iron;
                            ++money;
                            ++food;
                            --happines;
                        } else {
                            ++happines;
                        }
                        break;
                    default:
                        ++happines;
                }
                death = checkIfDead.check(iron, happines, food, money);
                break;
            case 9:
                switch (problem) {
                    case 1:
                        if (w== 1) {
                            --happines;
                            mision = true;
                        } else {
                            ++money;
                        }
                        break;
                    case 2:
                        if (w == 1) {
                            ++food;
                            --money;
                        } else {
                            --happines;
                        }
                        break;
                    case 3:
                        if (w == 1) {
                            --iron;
                            ++money;
                        } else {
                            ++happines;
                        }
                        break;
                    case 4:
                        if (w== 1) {
                            --money;
                            ++happines;
                        } else {
                            --happines;
                        }
                        break;
                    case 5:
                        if (w == 1) {
                            money -= 2;
                            ++happines;
                            ++food;
                        } else {
                            --happines;
                        }
                        break;
                    default:
                        ++happines;
                }
                death = checkIfDead.check(iron, happines, food, money);
                break;
            case 10:
                switch (problem) {
                    case 1:

                        if (w == 1) {
                            money += 2;
                            --happines;
                        } else {
                            ++happines;
                            --money;
                        }
                        break;
                    case 2:
                        if (w== 1) {
                            ++iron;
                            ++money;
                            --happines;
                        } else {
                            ++happines;
                            --money;
                        }
                        break;
                    case 3:
                        if (w == 1) {
                            ++money;
                            --iron;
                        } else {
                            ++happines;
                        }
                        break;
                    case 4:
                        if (w == 1) {
                            money -= 2;
                            bankreserve = true;
                        } else {
                            ++money;
                        }
                        break;
                    case 5:
                        if (w== 1) {
                            money += 2;
                            happines -= 2;
                        } else {
                            ++happines;
                            money -= 2;
                        }
                        break;
                    default:
                        ++happines;
                }
                death = checkIfDead.check(iron, happines, food, money);
                break;
            default:
                switch (problem) {
                    case 1:
                        Message_change("How about we go hunting?");
                        if (w == 1) {
                            if (hunt(w) == 1) {
                                death = true;
                            } else {
                                food += 2;
                            }
                        } else {
                            --happines;
                        }
                        break;
                    case 2:
                        if (w== 1) {
                            ++happines;
                            --money;
                        } else {
                            --happines;
                        }
                        break;
                    case 3:
                        if (w == 1) {
                            ++happines;
                            --food;
                        } else {
                            --happines;
                        }
                        break;
                    case 4:
                        if (w == 1) {
                            --iron;
                            ++happines;
                        } else {
                            --happines;
                        }
                        break;
                    case 5:
                        if (w== 1) {
                            death = true;
                        } else {
                            ++happines;
                        }
                        break;
                    default:
                        ++happines;
                }
                if (!death) {
                    death = checkIfDead.check(iron, happines, food, money); } }
                    checker();
    }


    @FXML
    void person_change(String person) {
        this.Person.setText(person);
    }

    @FXML
    void Message_change(String mesage) {
        this.message.setText(mesage);
    }
    @FXML
    int wybori(int w) {
        return 1;
    }
  @FXML
    int hunt(int w){
        this.message.setText("You strive through the wood when you see a dear.\nYou chase after it for a while when you encounter a bear\"\nWhat do you do?\n1.Attack\n2.Run");
        int choice = this.wybori(w);
        if (choice == 1) {
            return 1;
        } else {
            this.message.setText("While you run you see the dear again after going after it you finally are able to kill it and bring it back with you after the hunters find you.");
            return 0;
        }
    }
}
