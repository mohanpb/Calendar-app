package simple_calendar.simple_calendar;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.time.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class EventWindow implements javafx.fxml.Initializable
{
	@FXML
	private Label eventLabel;
	@FXML
	private TextArea eventDetails;
	@FXML
	private DatePicker eventDate;
	@FXML
	private Label timeLabel;
//	@FXML
//	private TextField timeField;
	@FXML
	private ComboBox<String> timeHourField;
	@FXML
	private ComboBox<String> timeMinField;
	@FXML
	private Button eventAdd;
	@FXML
	private Label addedLabel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		addedLabel.setVisible(false);
		
//		List<String> hrs = new ArrayList<String>();
//		List<String> mins = new ArrayList<String>();
		
		timeHourField = new ComboBox<String>();	
		timeMinField = new ComboBox<String>();	

//		for(int i=0;i<10;i++)
//			hrs.add('0'+String.valueOf(i));
//		for(int i=10;i<24;i++)
//			hrs.add(String.valueOf(i));
//		
//		for(int i=0;i<10;i++)
//			mins.add('0'+String.valueOf(i));
//		for(int i=0;i<60;i++)
//			mins.add(String.valueOf(i));
//		
//		ObservableList hrList = FXCollections.observableList(hrs);
//		ObservableList minList = FXCollections.observableList(mins);
//		
//		timeHourField.getItems().clear();
//		timeHourField.setItems(hrList);
//		timeMinField.getItems().clear();
//		timeMinField.setItems(minList);
		
		eventAdd.setOnAction(new EventHandler<ActionEvent>() 
		{
		    @Override
			public void handle(ActionEvent event)
			{
				addedLabel.setVisible(true);
			}
		});
	}

}
