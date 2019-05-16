/**
 * Skeleton for 'Borders.fxml' Controller Class
 */

package it.polito.tdp.borders;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.borders.db.BordersDAO;
import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BordersController {

	Model model;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtAnno"
	private TextField txtAnno; // Value injected by FXMLLoader

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    private ComboBox<Country> cmbBoxNazioni;

    @FXML
    private TextArea txtResultVicini;


	@FXML
	void doCalcolaConfini(ActionEvent event) {

		txtResult.clear();
		int anno = Integer.parseInt(txtAnno.getText());
		model.creaGrafo(anno);
		txtResult.appendText("Numero di componenti connesse: "+model.numeroComponentiConnesse()+"\n");
		for(Country paese : model.getGrafo().vertexSet()) {
			if(!model.getConfinanti(paese).isEmpty()) {
				txtResult.appendText("Paese: "+paese.getNomeCompleto().toUpperCase()+", ecco i suoi confinanti via terra nel "+anno+"\n");
				txtResult.appendText("Sono in totale: "+model.getGrafo().degreeOf(paese)+"\n");
				txtResult.appendText(model.getConfinanti(paese)+"\n\n");
			}
			
		}
	}
	
	  @FXML
	    void doTrovaVicini(ActionEvent event) {

	    }

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Borders.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Borders.fxml'.";
		assert cmbBoxNazioni != null : "fx:id=\"cmbBoxNazioni\" was not injected: check your FXML file 'Borders.fxml'.";
	    assert txtResultVicini != null : "fx:id=\"txtResultVicini\" was not injected: check your FXML file 'Borders.fxml'.";

	}
	
	public void setModel(Model model) {
		this.model = model;
		cmbBoxNazioni.getItems().addAll(model.getPaesi());
	}
}
