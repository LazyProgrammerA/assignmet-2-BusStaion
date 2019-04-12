import javafx.scene.control.TextField;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Drivertrip{
	Driver driver;
	Stage stage;
	BusStation station;
	Scene scene;
	 public Drivertrip(Stage stage,BusStation station,Driver driver){
    	 this.stage=stage;
    	 this.station=station;
    	 this.driver=driver;
     }
	 public void prepareScene() {

		 stage.setHeight(800);
			stage.setWidth(1600);
	
		 Trips trip = driver.getTrip();
		Label drivername =new Label();
		Label vehiclename =new Label();
		Label source =new Label();
		Label distance =new Label();
		Label stops=new Label();
		Label seats =new Label();
		Label destination =new Label();
		Label vechileid=new Label();
		Label tripid =new Label();
		Label driverid =new Label();
		
		 Button back=new Button("back");
		 GridPane mm=new GridPane();
		 mm.add(drivername, 0, 1);
		 mm.add(back, 0, 11);
	
		 mm.add(driverid, 0, 3);
		 mm.add(tripid, 0, 4);
		 mm.add(source, 0, 5);
		 mm.add(seats, 0, 6);
		 mm.add(vechileid, 0, 7);
		 mm.add(vehiclename, 0, 8);
		 mm.add(destination, 0, 9);
		 mm.add(stops, 0, 10);
		 mm.add(distance, 0, 2);
		 
		 scene  =new Scene(mm,400,200);
			drivername.setText("Driver Name : " + trip.getDriverName());
			driverid.setText("Driver ID : " + String.valueOf(trip.getDriverID()));
			tripid.setText("Trip ID : " +String.valueOf(trip.getTripID()));
			stops.setText("Stops : " +trip.getStops());
			distance.setText("Distance : " + String.valueOf(trip.getDistance()));
			source.setText("Source : " + String.valueOf(trip.getSource()));
			destination.setText("Destination : " + String.valueOf(trip.getDestination()));
			vechileid.setText("Vehicle ID : " + String.valueOf(trip.getVehicleID()));
			seats.setText("Remaining Seats : " + String.valueOf(trip.getSeats()));
			vehiclename.setText("Vehicle Name : " + String.valueOf(trip.getVehicleName()));
		 
			
			
			
			back.setOnAction(new EventHandler<ActionEvent>()  {
				@Override
				public void handle(ActionEvent event){
					
				Driverinfo back=new Driverinfo(stage,station,driver);
					back.prepareScene();
					stage.setScene(back.getscene());
				}
				});
		 
	 }
	 public Scene getscene() {
		return scene; 
	 }

}
