package com.company;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.Scanner;


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
        return 1;
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
    void person_change(String person){
        Person.setText(person);
    }
    void Message_change(String mesage){
        message.setText(mesage);
    }

}
