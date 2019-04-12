import java.io.IOException;

import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class LogInScene {
	
	BusStation station;
	Scene scene;
	Stage window;
	
	public void prepareScene(Stage window , BusStation station) throws Exception
	{
		
		this.station = station;
		this.window = window;

		 window.setHeight(800);
			window.setWidth(1600);
		// Grid Pane
				GridPane grid = new GridPane();
				grid.setPadding(new Insets(10,10,10,10));
				grid.setVgap(8);
				grid.setHgap(10);
										
				// Log-In Button
				Button logInButton = new Button("log-in");
				GridPane.setConstraints(logInButton , 1 ,2);
				
				// Log-In Button2
				Button logInButton2 = new Button("log-in2");
				GridPane.setConstraints(logInButton , 2 ,3);
				
				// Log-In Button3
				Button logInButton3 = new Button("log-in3");
				GridPane.setConstraints(logInButton3 , 3 ,4);
				
				
				// Log-In Button4
				Button logInButton4 = new Button("log-in4");
				GridPane.setConstraints(logInButton4 , 4 ,5);
				
				// Add actors to Grid Pane
				grid.getChildren().addAll(logInButton,logInButton2 , logInButton3,logInButton4);
				
				// Create Scene and show
				Scene scene = new Scene(grid,300,200);
				this.scene = scene;
				
				logInButton.setOnAction(e -> logInButtonClicked());
				logInButton2.setOnAction(e -> logInButtonClicked2());
				logInButton3.setOnAction(e -> logInButtonClicked3());
				logInButton4.setOnAction(e -> logInButtonClicked4());
		
	}
	
	public void logInButtonClicked()
	{
		ManagerManageTripsScene tripsTable = new ManagerManageTripsScene();
		tripsTable.prepareScene(window, station);
		window.setScene(tripsTable.getScene());
	}
	
	
	public void logInButtonClicked2()
	{
		ManagerManageVehiclesScene vehiclesTable = new ManagerManageVehiclesScene();
		vehiclesTable.prepareScene(window, station);
		window.setScene(vehiclesTable.getScene());
	}
	public Scene getScene()
	{
		return this.scene;
		
	}
	
	
	public void logInButtonClicked3()
	{
		ManagerManageDriversScene DriverTable = new ManagerManageDriversScene();
		DriverTable.prepareScene(window, station);
		window.setScene(DriverTable.getScene());
	}
	
	
	public void logInButtonClicked4()
	{
		UserChooseTripScene UserTable = new UserChooseTripScene();
		UserTable.prepareScene(window, station , new User());
		window.setScene(UserTable.getScene());
	}

	

}
