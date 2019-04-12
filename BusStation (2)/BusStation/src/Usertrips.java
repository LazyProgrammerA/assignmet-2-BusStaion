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
public class Usertrips {
	
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
	User user;
	

	public void  prepareScene (Stage window , BusStation station , User user)
	{
		
		window.setTitle("Manage Trips");
		 window.setHeight(800);
			window.setWidth(1600);
		this.window = window;
		this.station =station;
		this.user = user;
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
		table.getColumns().addAll(SourceColumn , DestinationColumn , DistanceColumn , VehicleColumn , VehicleNameColumn,DriverIDColumn , DriverNameColumn , StopsColumn , TypeColumn , IDColumn);
		
		//table.getColumns().addAll(DestinationColumn);
		
				
		
		// Add or delete Functionality
		

				
		// Buttons and Hbox
		Button addButton = new Button("Add");
		Button deleteButton = new Button("Delete");
		Button goBackButton = new Button("Go Back");
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10,10,10,10));
		hbox.setSpacing(10);
		hbox.getChildren().addAll(goBackButton , comment);
		
		goBackButton.setOnAction(e -> goBackButtonClicked());
		deleteButton.setOnAction(e -> deleteButtonClicked());
		
		
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
		
	public void  goBackButtonClicked()
	{
		Usermenu back=new Usermenu(window,station,user);
		back. prepareScene();
		window.setScene(back.getscene());
		//LogInScene logIn = new LogInScene();
		//logIn.prepareScene(window , station);
		//window.setScene(logIn.getScene());
			
	}
	
	
	public void  deleteButtonClicked()
	{
		
		ObservableList<Trips> userSelected , allTrips;
		allTrips = table.getItems();
		userSelected = table.getSelectionModel().getSelectedItems();
		ArrayList<Trips> myTrips = user.getMyTrips();
		ArrayList<Ticket> myTickets = user.getMyTickets();
		ObservableList<Trips> allTrips2 = station.getTableTrips();
		
		int id = userSelected.get(0).getTripID();
		
		int size = myTrips.size();
		int i =0;
		userSelected.forEach(allTrips::remove);
		
		while(i<size)
		{
			if(myTrips.get(i).getTripID()==id)
			{
				myTrips.remove(i);
				break;
				
				
			}
			i++;
			
			
		}
		
		i=0;
		size =myTickets.size();
		while(i<size)
		{

			if(myTickets.get(i).getTripID().equals(String.valueOf(id)))
			{
				
				myTickets.remove(i);
				break;
				
			}
			i++;
			
			
		}
		
		

	size = allTrips2.size();
	i=0;
	
	while(i<size)
	{
		if(allTrips2.get(i).getTripID()==id)
		{
			allTrips2.get(i).setSeats(allTrips2.get(i).getSeats()+1);
			
		}
		i++;
		
		
	}
	
		
		
		
	}
	
	
	
	
	
	
	public ObservableList<Trips> getManagerTable()
	{

		ObservableList<Trips> Trips = FXCollections.observableArrayList();
		ArrayList<Trips> list = user.getMyTrips();
		Trips.addAll(list);

		return Trips;
		
	}
	
	

	
	
		


}
