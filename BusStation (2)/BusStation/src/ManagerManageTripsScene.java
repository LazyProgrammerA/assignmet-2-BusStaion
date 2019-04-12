import java.util.ArrayList;

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

// This Scene Displays admin Table
public class ManagerManageTripsScene {
	
	TableView<Trips> table;
	TextField Destination;
	BusStation station;
	Scene scene;
	Stage window;
	
	//  Inputs
	TextField sourceInput = new TextField();
	TextField destinationInput = new TextField();
	TextField distanceInput = new TextField();
	TextField vehicleIDInput = new TextField();
	TextField driverIDInput = new TextField();
	TextField stopsInput = new TextField();
	TextField typeInput = new TextField();
	Label comment = new Label();
	

	public void  prepareScene (Stage window , BusStation station)
	{
		
		window.setTitle("Manage Trips");
		window.setHeight(800);
		window.setWidth(1600);
		this.window = window;
		this.station =station;
		// Table
		// Source Column
		TableColumn<Trips , String > SourceColumn = new TableColumn<>("Source");
		SourceColumn.setMinWidth(200);
		SourceColumn.setCellValueFactory(new PropertyValueFactory<Trips,String>("source"));

		// Destination Column
		TableColumn<Trips , String > DestinationColumn = new TableColumn<>("Destination");
		DestinationColumn.setMinWidth(200);
		DestinationColumn.setCellValueFactory(new PropertyValueFactory<Trips,String>("destination"));
				
		// Distance Column
		TableColumn<Trips , String > DistanceColumn = new TableColumn<>("Distnace");
		DistanceColumn.setMinWidth(200);
		DistanceColumn.setCellValueFactory(new PropertyValueFactory<Trips,String>("distance"));
				
		// Vehicle Column
		TableColumn<Trips , String > VehicleColumn = new TableColumn<>("Vehicle ID");
		VehicleColumn.setMinWidth(200);
		VehicleColumn.setCellValueFactory(new PropertyValueFactory<Trips,String>("vehicleID"));
		
		
		// Vehicle Name Column
		TableColumn<Trips , String > VehicleNameColumn = new TableColumn<>("Vehicle Name");
		VehicleNameColumn.setMinWidth(200);
		VehicleNameColumn.setCellValueFactory(new PropertyValueFactory<Trips,String>("vehicleName"));

		// driverID Column
		TableColumn<Trips , String > DriverIDColumn = new TableColumn<>("Driver ID");
		DriverIDColumn.setMinWidth(200);
		DriverIDColumn.setCellValueFactory(new PropertyValueFactory<Trips,String>("driverID"));
		
		
		// driverName Column
		TableColumn<Trips , String > DriverNameColumn = new TableColumn<>("Driver Name");
		DriverNameColumn.setMinWidth(200);
		DriverNameColumn.setCellValueFactory(new PropertyValueFactory<Trips,String>("driverName"));


		// seats Column
		TableColumn<Trips , String > SeatsColumn = new TableColumn<>("Remaining Seats");
		SeatsColumn.setMinWidth(200);
		SeatsColumn.setCellValueFactory(new PropertyValueFactory<Trips,String>("seats"));

		// Stops Column
		TableColumn<Trips , String > StopsColumn = new TableColumn<>("Stops");
		StopsColumn.setMinWidth(200);
		StopsColumn.setCellValueFactory(new PropertyValueFactory<Trips,String>("stops"));

		// type Column
		TableColumn<Trips , String > TypeColumn = new TableColumn<>("Type");
		TypeColumn.setMinWidth(200);
		TypeColumn.setCellValueFactory(new PropertyValueFactory<Trips,String>("type"));

		// ID Column
		TableColumn<Trips , String > IDColumn = new TableColumn<>("Trip ID");
		IDColumn.setMinWidth(200);
		IDColumn.setCellValueFactory(new PropertyValueFactory<Trips,String>("tripID"));

		
		// table it self
		
		table = new TableView();
		table.setItems(getManagerTable());
		table.getColumns().addAll(SourceColumn , DestinationColumn , DistanceColumn , VehicleColumn , VehicleNameColumn,DriverIDColumn , DriverNameColumn , SeatsColumn , StopsColumn , TypeColumn , IDColumn);
		
		//table.getColumns().addAll(DestinationColumn);
		
				
		
		// Add or delete Functionality
		

		
		sourceInput.setPromptText("Source");
		sourceInput.setMinWidth(100);
		
		destinationInput.setPromptText("Destination");
		destinationInput.setMinWidth(100);

		distanceInput.setPromptText("Distance");
		distanceInput.setMinWidth(100);
		
		vehicleIDInput.setPromptText("Vehicle ID");
		vehicleIDInput.setMinWidth(100);
		
		driverIDInput.setPromptText("Driver ID");
		driverIDInput.setMinWidth(100);
		

		stopsInput.setPromptText("Stops");
		stopsInput.setMinWidth(100);

		typeInput.setPromptText("Type");
		typeInput.setMinWidth(100);

		comment.setMinWidth(100);
		
		// Buttons and Hbox
		Button addButton = new Button("Add");
		Button deleteButton = new Button("Delete");
		Button goBackButton = new Button("Go Back");
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10,10,10,10));
		hbox.setSpacing(10);
		hbox.getChildren().addAll(sourceInput,destinationInput,distanceInput,vehicleIDInput,driverIDInput,stopsInput,typeInput,addButton,deleteButton , goBackButton , comment);
		
		// Buttons set Action
		addButton.setOnAction(e -> addButtonClicked());
		deleteButton.setOnAction(e -> deleteButtonClicked());
		goBackButton.setOnAction(e -> goBackButtonClicked());
		
		
		// add to scene
		VBox vbox = new VBox();
		vbox.getChildren().addAll(table,hbox);
		Scene tableScene = new Scene(vbox,200,200);
		this.scene = tableScene;
		
		
		
		
		
	}
	
	public Scene getScene()
	{
		
		return this.scene;
	}
	
	
	// Add Buttons functionality
	public void addButtonClicked()
	{
		Trips trip = new Trips();
		trip.setSource(sourceInput.getText());
		trip.setDestination(destinationInput.getText());
		trip.setVehicleID(Integer.parseInt(vehicleIDInput.getText()));
		trip.setStops(stopsInput.getText());
		trip.setType(typeInput.getText());
		trip.setDistance(Double.parseDouble(distanceInput.getText()));
		trip.setDriverID(Integer.parseInt(driverIDInput.getText()));
		trip.setTripID(station.updateAndGetTripID());
		
		// check if vehicle exist
		ObservableList<Vehicles> tableVehicles = station.getTableVehicles();
		Vehicles vehicle = null;
		int num = tableVehicles.size();
		boolean busy = false;
		int i =0;
		while(i<num)
		{
			if(tableVehicles.get(i).getVehicleID() == Integer.parseInt(vehicleIDInput.getText()) )
			{
				vehicle = tableVehicles.get(i);
				busy = vehicle.getBusy();
				break;
			}
			i++;
		}
		
		if(vehicle == null)
		{
			comment.setText("No vehicle with requiered ID");
			return;
			
		}
		if(busy == true)
		{
			comment.setText("Vehicle already booked for another trip , choose another vehicle");
			return;
		}	
		
		// Check if driver exist
		
		ObservableList<Driver> tableDriver = station.getTableDriver();
		Driver driver= null;
		num = tableDriver.size();
		busy = false;
		i =0;
		while(i<num)
		{
			if(tableDriver.get(i).getId() == Integer.parseInt(driverIDInput.getText()) )
			{
				driver = tableDriver.get(i);
				busy = driver.getBusy();
				break;
			}
			i++;
		}
		
		if(driver == null)
		{
			comment.setText("No Driver with requiered ID");
			return;
			
		}
		if(busy == true)
		{
			comment.setText("Driver already booked for another trip , choose another Driver");
			return;
		}	
		
		
			
		// change vehicle settings
		vehicle.setTripID(String.valueOf( trip.getTripID()));
		trip.setSeats(vehicle.getSeats());
		vehicle.setBusy(true);
		trip.setVehicleName(vehicle.getName());
		trip.setVehicle(vehicle);
		
		
		// change driver settings
		driver.setTripid(String.valueOf(trip.getTripID()));
		driver.setBusy(true);
		driver.setTrip(trip);
		trip.setDriver(driver);
		trip.setDriverName(driver.getName());
		
		
		// adding to table
		
		
		table.getItems().add(trip);
		sourceInput.clear();
		destinationInput.clear();
		distanceInput.clear();
		vehicleIDInput.clear();
		stopsInput.clear();
		typeInput.clear();
		driverIDInput.clear();
		comment.setText("");
		station.setTableTrips(table.getItems());
		
		
	}
	
	// Delete Buttons functionality
	public void  deleteButtonClicked()
	{
		ObservableList<Trips> userSelected , allUsers;
		allUsers = table.getItems();
		userSelected = table.getSelectionModel().getSelectedItems();
		
		
		
		int id = userSelected.get(0).getVehicleID();
		int i = 0; 
		ObservableList<Vehicles> list1 = station.getTableVehicles();
		int size = list1.size();
		
		while(i<size)
		{
			if(list1.get(i).getVehicleID() == id)
			{
				list1.get(i).setTripID("No Assigned Trips");
				list1.get(i).setBusy(false);
				list1.get(i).setSeats(list1.get(i).getcapacity());
							
			}
			
			
			i++;
		}

		 id = userSelected.get(0).getDriverID();
		 i = 0; 
		ObservableList<Driver> list2 = station.getTableDriver();
		 size = list2.size();
		while(i<size)
		{
			if(list2.get(i).getId() == id)
			{
				list2.get(i).setTripid("No Assigned Trips");
				list2.get(i).setBusy(false);
				list2.get(i).setTrip(null);
				
							
			}
			
			
			i++;
		}
		
		
		


		ObservableList<User> users = station.getTableUser();
		int num = users.size();
		 i =0;
		
		while(i<num)
		{
			User user = users.get(i);
			ArrayList<Trips> trips = user.getMyTrips();
			 size = trips.size();
			int j =0;
			while(j<size)
			{
				if(trips.get(j) == userSelected.get(0))
					trips.remove(trips.get(j));
			j++;	
			}
			
			i++;
		}

		userSelected.forEach(allUsers::remove);
		station.setTableTrips(table.getItems());
			
	}
	
	public void  goBackButtonClicked()
	{
		ManagerScene back=new ManagerScene(window,station);
		back. preparescene();
		window.setScene(back.getscene());
		//LogInScene logIn = new LogInScene();
		//logIn.prepareScene(window , station);
		//window.setScene(logIn.getScene());
			
	}
	
	
	
	
	
	public ObservableList<Trips> getManagerTable()
	{

		return station.getTableTrips();
		
	}
	
	

	
	
		


}
