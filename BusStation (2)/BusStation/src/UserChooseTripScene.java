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
public class UserChooseTripScene {
	
	TableView<Trips> table;
	TextField Destination;
	BusStation station;
	Scene scene;
	Stage window;
	User user;
	Button addButton;
	//  Inputs
	TextField typeInput = new TextField();
	Label comment = new Label();
	double price;
	

	public void  prepareScene (Stage window , BusStation station , User user)
	{
		 window.setHeight(800);
		 window.setWidth(1600);
		
		window.setTitle("Manage Trips");
		window.setHeight(800);
		window.setWidth(1600);
		this.window = window;
		this.station =station;
		this.user=user;
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
				
		
		
		// Vehicle Name Column
		TableColumn<Trips , String > VehicleNameColumn = new TableColumn<>("Vehicle Name");
		VehicleNameColumn.setMinWidth(200);
		VehicleNameColumn.setCellValueFactory(new PropertyValueFactory<Trips,String>("vehicleName"));

		
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
		table.getColumns().addAll(SourceColumn , DestinationColumn , DistanceColumn , VehicleNameColumn , SeatsColumn , StopsColumn , TypeColumn , IDColumn);
		
		//table.getColumns().addAll(DestinationColumn);
		
				
		
		// Add or delete Functionality
		

		typeInput.setPromptText("Type");
		typeInput.setMinWidth(100);

		comment.setMinWidth(100);
		
		// Buttons and Hbox
		addButton = new Button("Add");
		addButton.setDisable(true);
		Button calculateButton = new Button("Calculate Price");
		Button goBackButton = new Button("Go Back");
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10,10,10,10));
		hbox.setSpacing(10);
		hbox.getChildren().addAll(typeInput,calculateButton ,comment ,addButton, goBackButton);
		
		// Buttons set Action
		addButton.setOnAction(e -> addButtonClicked());
		calculateButton.setOnAction(e -> calculateButtonClicked());
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
		ObservableList<Trips> userSelected;
		userSelected = table.getSelectionModel().getSelectedItems();
		Trips trip = userSelected.get(0);
		if(trip.getSeats() == 0)
		{
			comment.setText("No available seats");
			return;
		}
		trip.setSeats(trip.getSeats()-1);
	
		user.addMyTrips(trip);
		
		user.makeTicket(price, String.valueOf(trip.getTripID()), typeInput.getText());
		
		table.getItems().remove(trip);
		table.getItems().add(trip);
		
		
			
	}
	
	// calculate Buttons functionality
	public void  calculateButtonClicked()
	{
		addButton.setDisable(false);
		ObservableList<Trips> userSelected;
		userSelected = table.getSelectionModel().getSelectedItems();
		
		Trips trip = userSelected.get(0);
		
		String type1 = trip.getType();
		String type2 = typeInput.getText();
		
		double ratio1 = 0;
		double ratio2=0;
		
		if(type1.compareToIgnoreCase("internal") == 0)
			ratio1 = 0.5;
		else ratio1 = 0.7;
		
		if(type2.compareToIgnoreCase("round trip") == 0)
			ratio2 = 1;
		else ratio2 = 0.7;
		
		
		price = trip.getDistance()*ratio1*ratio2;
		comment.setText(String.valueOf(price));
	}
	
	public void  goBackButtonClicked()
	{
		
		Usermenu back = new Usermenu(window,station,user);
		back.prepareScene();
		window.setScene(back.getscene());
			
	}
	
	
	
	
	
	public ObservableList<Trips> getManagerTable()
	{

		return station.getTableTrips();
		
	}
	
	

	
	
		


}
