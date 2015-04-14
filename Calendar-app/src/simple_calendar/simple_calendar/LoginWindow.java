package simple_calendar.simple_calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginWindow implements javafx.fxml.Initializable
{

	@FXML
	private Label loginLabel; // Add moodle logo in the window
	@FXML
	private TextField usernameField;
	@FXML
	private PasswordField passwordField;
	@FXML
	private Button loginButton;

	@Override
	public void initialize(URL location, ResourceBundle resources)
	{
		loginButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				String username = usernameField.getText();
				String password = passwordField.getText();

				try
				{
					getMoodleCalendar(username, password);
				} 
				catch (IOException e)
				{
					System.out.println("Couldn't open Python Script to export iCalendar from Moodle");
					e.printStackTrace();
				}

				new Timer().schedule(new TimerTask()
				{
					public void run()
					{
						Platform.runLater(new Runnable()
						{
							public void run()
							{
								(((Node) event.getSource())).getScene()
										.getWindow().hide();
							}
						});
					}
				}, 1 * 1000); // After 1*1000 ms
			}
		});

	}

	public static void getMoodleCalendar(String username, String password)
			throws IOException
	{
		String getCalFileName = "get_ical.py";
		String outFileName = "icalexport.ics";
		String pwd = System.getProperty("user.dir");

		ProcessBuilder pb = new ProcessBuilder("/usr/bin/python", pwd + '/' + 
				getCalFileName, username, password, outFileName);
		Process p = pb.start();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
		int ret = new Integer(in.readLine()).intValue();
		if(ret==1)
			Event.integrateMoodleCalendar(outFileName);
		else
			System.out.println("Script ran into an error...");
	}
}
