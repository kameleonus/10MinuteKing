package com.company;

import javafx.fxml.FXML;
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
    int yes(){
        return 1;
    }
    @FXML
    int no(){
        return 0;
    }
    @FXML
     int wybor() {
        Yes.setText("1.Yes");
        No.setText("2.No");
       int x=yes();
       int y=no();
        if (x == 1) {
            return 1;
        } else if (y == 0) {
            return 0;
        }
        return 0;
    }
    @FXML
    int wybor2() {
        Yes.setText("1.People");
        No.setText("2.Sell");
        int x=yes();
        int y=no();
        if (x == 1) {
            return 1;
        } else if (y == 0) {
            return 0;
        }
        return 0;
    }
    @FXML
    int wybor3() {
        Yes.setText("1.Kill");
        No.setText("2.They will be good");
        int x=yes();
        int y=no();
        if (x == 1) {
            return 1;
        } else if (y == 0) {
            return 0;
        }
        return 0;
    }
    @FXML
    int wybor4() {
        Yes.setText("1.Meat");
        No.setText("2.Alcohol");
        int x=yes();
        int y=no();
        if (x == 1) {
            return 1;
        } else if (y == 0) {
            return 0;
        }
        return 0;
    }
    @FXML
    void person_change(String person){
        Person.setText(person);
    }
    @FXML
    void Message_change(String mesage){
        message.setText(mesage);
    }
    @FXML
    int hunt(){
        message.setText("You strive through the wood when you see a dear.\nYou chase after it for a while when you encounter a bear\"" +
                "\nWhat do you do?\n1.Attack\n2.Run");

        int choice = wybor();
        if (choice==1)
        {
            return 1;
        }
        else
        {
            message.setText("While you run you see the dear again after going after it you finally are able to " +
                    "kill it and bring it back with you after the hunters find you.");
            return 0;
        }
    }
}
