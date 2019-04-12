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
public class ManagerManageVehiclesScene {
	
	TableView<Vehicles> table;
	TextField Destination;
	BusStation station;
	Scene scene;
	Stage window;
	
	//  Inputs
	TextField nameInput = new TextField();
	TextField seatsInput = new TextField();
	Label comment = new Label();


	public void  prepareScene (Stage window , BusStation station)
	{
		
		window.setTitle("Manage Trips");
		window.setHeight(800);
		window.setWidth(1600);
		this.window = window;
		this.station =station;
		// Table
		// Name Column
		TableColumn<Vehicles , String > NameColumn = new TableColumn<>("Vehicle");
		NameColumn.setMinWidth(200);
		NameColumn.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("name"));

		// Seats Input Column
		TableColumn<Vehicles , String > SeatsColumn = new TableColumn<>("Number of Seats");
		SeatsColumn.setMinWidth(200);
		SeatsColumn.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("seats"));
				
		// Vehicle ID Column
		TableColumn<Vehicles , String > VehicleIDColumn = new TableColumn<>("Vehicle ID");
		VehicleIDColumn.setMinWidth(200);
		VehicleIDColumn.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("vehicleID"));

		

		// Assigned Trip Column
		TableColumn<Vehicles , String > TripColumn = new TableColumn<>("Trip ID");
		TripColumn.setMinWidth(200);
		TripColumn.setCellValueFactory(new PropertyValueFactory<Vehicles,String>("tripID"));

	
		// table it self
		
		table = new TableView();
		table.setItems(getManagerTable());
		table.getColumns().addAll(NameColumn , SeatsColumn , VehicleIDColumn , TripColumn );
		
		//table.getColumns().addAll(DestinationColumn);
		
				
		
		// Add or delete Functionality
		

		
		nameInput.setPromptText("Vehicle name");
		nameInput.setMinWidth(100);
		
		seatsInput.setPromptText("Number of seats");
		seatsInput.setMinWidth(100);
		
		comment.setMinWidth(100);


		
		

		// Buttons and Hbox
		Button addButton = new Button("Add");
		Button deleteButton = new Button("Delete");
		Button goBackButton = new Button("Go Back");
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10,10,10,10));
		hbox.setSpacing(10);
		hbox.getChildren().addAll(nameInput,seatsInput,addButton,deleteButton , goBackButton,comment);
		
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
		

		
		Vehicles vehicle = new Vehicles();
		
		vehicle.setName(nameInput.getText());
		vehicle.setSeats(Integer.parseInt(seatsInput.getText()));
		vehicle.setCapacity(Integer.parseInt(seatsInput.getText()));
		vehicle.setVehicleID(station.updateAndGetVehicleID());
		vehicle.setBusy(false);
		vehicle.setTripID("No Assigned Trips");

		table.getItems().add(vehicle);
		
		nameInput.clear();
		seatsInput.clear();


		station.setTableVehicles(table.getItems());
		
		
		
	}
	
	// Delete Buttons functionality
	public void  deleteButtonClicked()
	{
		ObservableList<Vehicles> userSelected , allUsers;
		allUsers = table.getItems();
		userSelected = table.getSelectionModel().getSelectedItems();
		if(userSelected.get(0).getBusy() == true)
		{
			comment.setText("A trip is assigned to this vehicle , wait for trip to finish to delete ");
			return;
			
		}
		userSelected.forEach(allUsers::remove);
		station.setTableVehicles(table.getItems());
			
	}
	
	public void  goBackButtonClicked()
	{
		ManagerScene back=new ManagerScene(window,station);
		back. preparescene();
		window.setScene(back.getscene());
			
	}
	
	
	
	
	
	public ObservableList<Vehicles> getManagerTable()
	{

		return station.getTableVehicles();
		
	}
	
	

	
	
		


}
