
package com.company;

import javafx.fxml.FXML;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import javafx.scene.control.Label;

public class control {
    @FXML
    private Label Yes;
    @FXML
    private Label No;
    @FXML
    private Label Person;
    @FXML
    private Label message;


    @FXML
    void game() throws IOException {
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
        bufferedReader.close();
        CheckIfDead checkIfDead = new CheckIfDead();
        Message_change("The year is " + year + " and the audience of the King begins...");
        long start = System.currentTimeMillis()/1000;
        do {
            Random random = new Random();
            int character = random.nextInt(11);
            int problem;
            switch(character) {
                case 1:
                    person_change("Guard");
                    problem = random.nextInt(6);
                    switch(problem) {
                        case 1:
                            Message_change("King we need new armour sets because the old ones are getting rusty ");
                            if (wybor() == 1) {
                                --iron;
                                --money;
                            } else {
                                --happines;
                            }
                            break;
                        case 2:
                            Message_change("We need more guards we serve a long time and we need more rest");
                            if (wybor() == 1) {
                                --food;
                                --money;
                                ++happines;
                            } else {
                                happines -= 2;
                            }
                            break;
                        case 3:
                            Message_change("We caught a noblemans son stealing should we get money from his father to pay for his freedom?");
                            if (wybor() == 1) {
                                ++money;
                            } else {
                                --happines;
                            }
                            break;
                        case 4:
                            Message_change("Can you fire that servant? He iritates me.");
                            if (wybor() == 0) {
                                --happines;
                            }
                            break;
                        case 5:
                            Message_change("Can we have bigger food rations?");
                            if (wybor() == 1) {
                                --food;
                                ++happines;
                            } else {
                                --happines;
                            }
                            break;
                        default:
                            Message_change("Have a nice day my king may your reign be glorious");
                            ++happines;
                    }

                    death = checkIfDead.check(iron, happines, food, money);
                    break;
                case 2:
                    person_change("General");
                    problem = random.nextInt(6);
                    switch(problem) {
                        case 1:
                            Message_change("We need to get new recruits because the enemy is raiding us");
                            if (wybor() == 1) {
                                --food;
                                money -= 2;
                                happines += 2;
                            } else {
                                --happines;
                                --money;
                            }
                            break;
                        case 2:
                            Message_change("After our last battle the spoils were great should we turn it into money?");
                            if (wybor() == 1) {
                                money += 3;
                            } else {
                                ++happines;
                                ++food;
                                ++iron;
                            }
                            break;
                        case 3:
                            Message_change("Some merchants are getting bossy around town should we arrest one or two to make them stop?");
                            if (wybor() == 1) {
                                --happines;
                                money += 2;
                            } else {
                                ++happines;
                                ++food;
                            }
                            break;
                        case 4:
                            Message_change("We need better armour and weapons or we will lose the upcoming war we can leave the old ones for later");
                            if (wybor() == 1) {
                                money -= 2;
                                ++happines;
                                scrapmetal = true;
                            } else {
                                --food;
                                --money;
                            }
                            break;
                        case 5:
                            Message_change("During one expedition a soldier found an artifact it could fetch a nice sum");
                            if (wybor() == 1) {
                                money += 2;
                            } else {
                                happines += 2;
                            }
                            break;
                        default:
                            Message_change("The military is as strong as ever");
                            ++happines;
                    }

                    death = checkIfDead.check(iron, happines, food, money);
                    break;
                case 3:
                    person_change("Cook");
                    problem = random.nextInt(6);
                    switch(problem) {
                        case 1:
                            Message_change("It's about time we make a feast? ");
                            if (wybor() == 1) {
                                ++happines;
                                ++food;
                                --money;
                            } else {
                                ++money;
                            }
                            break;
                        case 2:
                            Message_change("Want to try this dish of the new species we found last month? ");
                            if (wybor() == 1) {
                                death = true;
                                System.out.println("The food was contaminated ");
                            } else {
                                ++happines;
                            }
                            break;
                        case 3:
                            Message_change("I need more ingredients or i won't be able to serve the required amount of servings could you do something about it.");
                            if (wybor() == 1) {
                                ++happines;
                                --money;
                            } else {
                                food -= 2;
                            }
                            break;
                        case 4:
                            Message_change("After the last party we have many leftovers should i give it to the people or sell to the merchants? ");
                            if (wybor2() == 1) {
                                ++happines;
                            } else {
                                ++money;
                            }
                            break;
                        case 5:
                            Message_change("Can i get some new pans and pots? The old ones are starting to stick ");
                            if (wybor() == 1) {
                                --iron;
                                ++food;
                            } else {
                                --happines;
                            }
                            break;
                        default:
                            Message_change("Here is your dinner my king");
                            ++happines;
                    }

                    if (!death) {
                        death = checkIfDead.check(iron, happines, food, money);
                    }
                    break;
                case 4:
                    person_change("Peasant");
                    problem = random.nextInt(6);
                    switch(problem) {
                        case 1:
                            Message_change("Could you lover the taxes the crops are low this year?");
                            if (wybor() == 1) {
                                ++happines;
                                --money;
                            } else {
                                happines -= 2;
                                ++money;
                            }
                            break;
                        case 2:
                            Message_change("The tools are hard to get and expensive can you do something about it? ");
                            if (wybor() == 1) {
                                --money;
                                --iron;
                                ++happines;
                                ++food;
                            } else {
                                --happines;
                            }
                            break;
                        case 3:
                            Message_change("It's the plague the cows are dying!");
                            if (wybor3() == 1) {
                                food -= 2;
                            } else {
                                --food;
                                ++happines;
                            }
                            break;
                        case 4:
                            Message_change("We had a great harvest what to do with all that grain?");
                            if (wybor2() == 1) {
                                ++happines;
                                ++food;
                            } else {
                                money += 2;
                            }
                            break;
                        case 5:
                            Message_change("I think my neighbour is stealing my chickens and the guards are ignoring me could you give them a word? ?");
                            if (wybor() == 1) {
                                ++happines;
                                --food;
                            } else {
                                --happines;
                                ++money;
                            }
                            break;
                        default:
                            Message_change("I am sorry my problem was just dealt with. ");
                            ++happines;
                    }

                    death = checkIfDead.check(iron, happines, food, money);
                    break;
                case 5:
                    person_change("Merchant");
                    problem = random.nextInt(6);
                    switch(problem) {
                        case 1:
                            Message_change("We come to get the allowance to sell this good from our neighbour will it be possible? ");
                            if (wybor() == 1) {
                                money += 2;
                                --happines;
                            } else {
                                --money;
                            }
                            break;
                        case 2:
                            Message_change("How about you sell us some iron so we can get better weapons from our neighbour?");
                            if (wybor() == 1) {
                                iron -= 2;
                                ++money;
                                ++happines;
                            } else {
                                --money;
                            }
                            break;
                        case 3:
                            Message_change("How about investing some money? ");
                            if (wybor() == 1) {
                                money -= 2;
                                food += 2;
                            } else {
                                Message_change("OK");
                            }
                            break;
                        case 4:
                            Message_change("Care for some of the finest wine?");
                            if (wybor() == 1) {
                                death = true;
                                Message_change("It was poisoned !");
                            } else {
                                ++happines;
                            }
                            break;
                        case 5:
                            Message_change("Want to buy something?");
                            int x = wybor4();
                            if (x == 1) {
                                --money;
                                ++food;
                            } else {
                                ++happines;
                                --money;
                            }
                            break;
                        default:
                            Message_change("The market is blooming");
                            ++happines;
                    }

                    if (!death) {
                        death = checkIfDead.check(iron, happines, food, money);
                    }
                    break;
                case 6:
                    person_change("Nobleman");
                    problem = random.nextInt(6);
                    switch(problem) {
                        case 1:
                            Message_change("How about we get some of the iron reserved for the army?");
                            if (wybor() == 1) {
                                --iron;
                                money += 2;
                            } else {
                                --happines;
                                ++iron;
                            }
                            break;
                        case 2:
                            Message_change("It's time to call all neighbouring kings for a bal");
                            if (wybor() == 1) {
                                --food;
                                --money;
                                happines += 2;
                            } else {
                                --happines;
                                ++food;
                            }
                            break;
                        case 3:
                            Message_change("Can you imprison the merchant? He disrespected me! ");
                            if (wybor() == 1) {
                                ++happines;
                                ++money;
                            } else {
                                --happines;
                                money += 2;
                            }
                            break;
                        case 4:
                            Message_change("Could you lend us some of your guards for our travel?");
                            if (wybor() == 1) {
                                --happines;
                                ++money;
                            } else {
                                --happines;
                            }
                            break;
                        case 5:
                            Message_change("We have to few influence we need more or the other classes will take over");
                            if (wybor() == 1) {
                                money += 2;
                                --happines;
                            } else {
                                ++happines;
                                --money;
                            }
                            break;
                        default:
                            Message_change("We have everything we want or need");
                            ++happines;
                    }

                    death = checkIfDead.check(iron, happines, food, money);
                    break;
                case 7:
                    person_change("Advisor");
                    problem = random.nextInt(6);
                    switch(problem) {
                        case 1:
                            Message_change("We should build more warehouses.");
                            if (wybor() == 1) {
                                ++food;
                                money -= 2;
                                warehouse = true;
                            } else {
                                --happines;
                            }
                            break;
                        case 2:
                            Message_change("We need to tighten our security");
                            if (wybor() == 1) {
                                --iron;
                                --money;
                                ++happines;
                            } else {
                                --happines;
                            }
                            break;
                        case 3:
                            Message_change("We have to get new ceremonial robes for the court");
                            if (wybor() == 1) {
                                happines += 2;
                                --money;
                            } else {
                                --happines;
                                ++money;
                            }
                            break;
                        case 4:
                            Message_change("We need to expand the mine");
                            if (wybor() == 1) {
                                iron += 2;
                                --money;
                            } else {
                                --iron;
                            }
                            break;
                        case 5:
                            Message_change("We have to increase the taxes");
                            if (wybor() == 1) {
                                money += 2;
                                --happines;
                            } else {
                                --money;
                            }
                            break;
                        default:
                            Message_change("Is everything alright my king?");
                            ++happines;
                    }

                    death = checkIfDead.check(iron, happines, food, money);
                    break;
                case 8:
                    person_change("Emissary");
                    problem = random.nextInt(6);
                    switch(problem) {
                        case 1:
                            Message_change("I came to negotiate the peace treaty.");
                            if (wybor() == 1) {
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
                            Message_change("War it is!");
                            if (wybor() == 1) {
                                --iron;
                                --happines;
                            } else {
                                ++money;
                                ++happines;
                                --food;
                            }
                            break;
                        case 3:
                            Message_change("How about creating a trade route between our countries?");
                            if (wybor() == 1) {
                                ++happines;
                                --money;
                                ++food;
                            } else {
                                --money;
                            }
                            break;
                        case 4:
                            Message_change("Could our country borrow money from you we will recompensate you with iron");
                            if (wybor() == 1) {
                                money -= 2;
                                iron += 2;
                            } else {
                                --happines;
                            }
                            break;
                        case 5:
                            Message_change("We came to ask for your help in our war against the King of the West");
                            if (wybor() == 1) {
                                --iron;
                                ++money;
                                ++food;
                                --happines;
                            } else {
                                ++happines;
                            }
                            break;
                        default:
                            Message_change("My king sends his regards");
                            ++happines;
                    }

                    death = checkIfDead.check(iron, happines, food, money);
                    break;
                case 9:
                    person_change("Misionary");
                    problem = random.nextInt(6);
                    switch(problem) {
                        case 1:
                            Message_change("We came in peace to bring the message of our savior.");
                            if (wybor() == 1) {
                                --happines;
                                mision = true;
                            } else {
                                ++money;
                            }
                            break;
                        case 2:
                            Message_change("We are good at cultivating the land we can share some of our knowledge for a bit of founding");
                            if (wybor() == 1) {
                                ++food;
                                --money;
                            } else {
                                --happines;
                            }
                            break;
                        case 3:
                            Message_change("Some people disrespect us and threaten us could you help us?");
                            if (wybor() == 1) {
                                --iron;
                                ++money;
                            } else {
                                ++happines;
                            }
                            break;
                        case 4:
                            Message_change("We help your people and some of us going to other countries could we count on you?");
                            if (wybor() == 1) {
                                --money;
                                ++happines;
                            } else {
                                --happines;
                            }
                            break;
                        case 5:
                            Message_change("Can we get some land to build a place for our believers?");
                            if (wybor() == 1) {
                                money -= 2;
                                ++happines;
                                ++food;
                            } else {
                                --happines;
                            }
                            break;
                        default:
                            Message_change("Grace our savior!");
                            ++happines;
                    }

                    death = checkIfDead.check(iron, happines, food, money);
                    break;
                case 10:
                    person_change("Treasurer");
                    problem = random.nextInt(6);
                    switch(problem) {
                        case 1:
                            Message_change("We need to reform the taxes!");
                            if (wybor() == 1) {
                                money += 2;
                                --happines;
                            } else {
                                ++happines;
                                --money;
                            }
                            break;
                        case 2:
                            Message_change("Some soldiers are hoarding a great sum of money and iron we should increase their taxes");
                            if (wybor() == 1) {
                                ++iron;
                                ++money;
                                --happines;
                            } else {
                                ++happines;
                                --money;
                            }
                            break;
                        case 3:
                            Message_change("We can sell some of our old weapons and armour for money.");
                            if (wybor() == 1) {
                                ++money;
                                --iron;
                            } else {
                                ++happines;
                            }
                            break;
                        case 4:
                            Message_change("We should create a reserve of money for the future");
                            if (wybor() == 1) {
                                money -= 2;
                                bankreserve = true;
                            } else {
                                ++money;
                            }
                            break;
                        case 5:
                            Message_change("The nobles are trying to hoard the money of the regular tax we should collect it as soon as possible");
                            if (wybor() == 1) {
                                money += 2;
                                happines -= 2;
                            } else {
                                ++happines;
                                money -= 2;
                            }
                            break;
                        default:
                            Message_change("Our country is prospering great!");
                            ++happines;
                    }

                    death = checkIfDead.check(iron, happines, food, money);
                    break;
                default:
                    person_change("Queen");
                    problem = random.nextInt(6);
                    switch(problem) {
                        case 1:
                            Message_change("How about we go hunting?");
                            if (wybor() == 1) {
                                if (hunt() == 1) {
                                    death = true;
                                } else {
                                    food += 2;
                                }
                            } else {
                                --happines;
                            }
                            break;
                        case 2:
                            Message_change("I am not feeling safe in the castle increase the security!");
                            if (wybor() == 1) {
                                ++happines;
                                --money;
                            } else {
                                --happines;
                            }
                            break;
                        case 3:
                            Message_change("It's time for a feast my king");
                            if (wybor() == 1) {
                                ++happines;
                                --food;
                            } else {
                                --happines;
                            }
                            break;
                        case 4:
                           Message_change("The general is getting on my nerves you should talk to him");
                            if (wybor() == 1) {
                                --iron;
                                ++happines;
                            } else {
                                --happines;
                            }
                            break;
                        case 5:
                            Message_change("You should finish it fast and go get some rest");
                            if (wybor() == 1) {
                                death = true;
                            } else {
                                ++happines;
                            }
                            break;
                        default:
                            Message_change("Are you feeling alright?");
                            ++happines;
                    }

                    if (!death) {
                        death = checkIfDead.check(iron, happines, food, money);
                    }
            }

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

            System.out.println("Iron: " + iron + " Happiness: " + happines + " Food: " + food + " Money: " + money);
            System.out.println();
        } while(System.currentTimeMillis()/1000-start<600 && !death);

        ++year;
        PrintWriter printWriter;
        if (death) {
            Message_change("Your reign has come to an end but the story continues...");
            printWriter = new PrintWriter("src/zasoby.txt");
            printWriter.println(5);
            printWriter.println(5);
            printWriter.println(5);
            printWriter.println(5);
        } else {
            System.out.println("The 10 minute audience is over rest until the next...");
            printWriter = new PrintWriter("src/zasoby.txt");
            printWriter.println(iron);
            printWriter.println(happines);
            printWriter.println(food);
            printWriter.println(money);
        }
        printWriter.println(year);
        printWriter.close();

    }

    @FXML
    int yes() {
        return 1;
    }

    @FXML
    int no() {
        return 0;
    }

    @FXML
    int wybor() {
        this.Yes.setText("1.Yes");
        this.No.setText("2.No");
        int x = this.yes();
        int y = this.no();
        if (x == 1) {
            return 1;
        } else {
            return y == 0 ? 0 : 0;
        }
    }

    @FXML
    int wybor2() {
        this.Yes.setText("1.People");
        this.No.setText("2.Sell");
        int x = this.yes();
        int y = this.no();
        if (x == 1) {
            return 1;
        } else {
            return y == 0 ? 0 : 0;
        }
    }

    @FXML
    int wybor3() {
        this.Yes.setText("1.Kill");
        this.No.setText("2.They will be good");
        int x = this.yes();
        int y = this.no();
        if (x == 1) {
            return 1;
        } else {
            return y == 0 ? 0 : 0;
        }
    }

    @FXML
    int wybor4() {
        this.Yes.setText("1.Meat");
        this.No.setText("2.Alcohol");
        int x = this.yes();
        int y = this.no();
        if (x == 1) {
            return 1;
        } else {
            return y == 0 ? 0 : 0;
        }
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
    int hunt() {
        this.message.setText("You strive through the wood when you see a dear.\nYou chase after it for a while when you encounter a bear\"\nWhat do you do?\n1.Attack\n2.Run");
        int choice = this.wybor();
        if (choice == 1) {
            return 1;
        } else {
            this.message.setText("While you run you see the dear again after going after it you finally are able to kill it and bring it back with you after the hunters find you.");
            return 0;
        }
    }
}
