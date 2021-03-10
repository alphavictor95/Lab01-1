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
	
	Parole elenco ;

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
    void doCancella(ActionEvent event) {

    	long Starttime = System.nanoTime();
    	String s = ""+txtResult.getSelectedText();
    	elenco.removeParola(s);
    	txtResult.clear();
    	txtParola.clear();
    	//txtResult.appendText(elenco.getElenco().get(elenco.getElenco().size()-1));;
    	for(Object s1 :elenco.getElenco().toArray()) {
    		txtResult.appendText(s1.toString()+"\n");
    	}
    	Starttime=System.nanoTime()-Starttime;
    	String time = ""+Starttime;
    	txtTime.setText(time);
    }

    @FXML
    void doInsert(ActionEvent event) {
    	long Starttime = System.nanoTime();
    	txtResult.clear();
    	elenco.addParola(txtParola.getText());
    	txtParola.clear();
    	//txtResult.appendText(elenco.getElenco().get(elenco.getElenco().size()-1));;
    	for(Object s :elenco.getElenco().toArray()) {
    		txtResult.appendText(s.toString()+"\n");
    	}
    	Starttime=System.nanoTime()-Starttime;
    	String time = ""+Starttime;
    	txtTime.setText(time);
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	elenco.reset();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
