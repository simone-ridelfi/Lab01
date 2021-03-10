package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco;

	 @FXML
     private ResourceBundle resources;

     @FXML
     private URL location;

     @FXML
     private TextField txtParola;

     @FXML
     private Button btnInserisci;

     @FXML
     private TextArea txtResult;

     @FXML
     private Button btnReset;
     
     @FXML
     private Button btnCancella;
     

     @FXML
     private TextArea txtTime;


     @FXML
     void doInsert(ActionEvent event) {
    	 
    	long t0 = System.nanoTime();
    	elenco.addParola(txtParola.getText());
    	txtParola.clear();
    	txtResult.clear();
    	display();
    	txtTime.appendText("Inserisci " + ((System.nanoTime() - t0)/1000) + " us\n");	
     }
     
     void display() {
    	txtResult.clear();
     	for(String s : elenco.getElenco())
     		txtResult.appendText(s + "\n");
     }

    @FXML
    void doReset(ActionEvent event) {
    	long t0 = System.nanoTime();
    	txtResult.clear();
    	elenco.reset();
    	txtTime.appendText("Reset " + ((System.nanoTime() - t0)/1000) + " us\n");
    }


    @FXML
    void doDelete(ActionEvent event) {
    	String s = txtResult.getSelectedText();
    	elenco.remove(s);
    	display();   
    }

    @FXML
    void initialize() {
    	elenco = new Parole();
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";

        }
    }
