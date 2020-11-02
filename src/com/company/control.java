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
    void yes(){
        Yes.setText("No to tak");
    }
    @FXML
    void no(){
        No.setText("No to nie");
    }



}
