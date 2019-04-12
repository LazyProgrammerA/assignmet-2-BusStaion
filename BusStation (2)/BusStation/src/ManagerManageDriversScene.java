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
public class ManagerManageDriversScene {
	
	TableView<Driver> table;

	BusStation station;
	Scene scene;
	Stage window;
	
	//  Inputs
	TextField name = new TextField();
//	TextField id = new TextField();
	TextField password = new TextField();
	
			
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
		TableColumn<Driver , String > NameColumn = new TableColumn<>("Name");
		NameColumn.setMinWidth(200);
		NameColumn.setCellValueFactory(new PropertyValueFactory<Driver,String>("name"));
		
		
		
		TableColumn<Driver , String > passwordColumn = new TableColumn<>("password");
		passwordColumn.setMinWidth(200);
		passwordColumn.setCellValueFactory(new PropertyValueFactory<Driver,String>("password"));
		
		

	TableColumn<Driver , String > idColumn = new TableColumn<>("id");
		idColumn.setMinWidth(200);
		idColumn.setCellValueFactory(new PropertyValueFactory<Driver,String>("id"));
//		
//		
	TableColumn<Driver , String >tripidColumn = new TableColumn<>("trip id");
	tripidColumn.setMinWidth(200);
	tripidColumn.setCellValueFactory(new PropertyValueFactory<Driver,String>("tripID"));
	

		table = new TableView();
		table.setItems(getManagerTable());
		table.getColumns().addAll(NameColumn,passwordColumn,idColumn,tripidColumn );
		
		//table.getColumns().addAll(DestinationColumn);
		
				
		
		// Add or delete Functionality
		

		
		name.setPromptText("name ");
		name.setMinWidth(10);
		
//		id.setPromptText("id ");
//		id.setMinWidth(10);

		
		password.setPromptText("password");
		password.setMinWidth(10);

		
		
		comment.setMinWidth(100);


		
		

		//Buttons and Hbox
		Button addButton = new Button("Add");
		Button deleteButton = new Button("Delete");
		Button goBackButton = new Button("Go Back");
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10,10,10,10));
		hbox.setSpacing(10);
		hbox.getChildren().addAll(name,password,addButton,deleteButton , goBackButton,comment);
		
//		 //Buttons set Action
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
	
	
	 //Add Buttons functionality
	public void addButtonClicked()
	{
		

		
		Driver driver = new Driver();
		driver.setName(name.getText());
		//driver.setID(id.getText());
		driver.setPassword(password.getText());
		driver.setID(station.updateAndGetdriverID()); // seeby deeh ya mayar deeh elly betedy le kol wa7ed ID mo5talef
		driver.setTripid("No Assigned Trips");
		table.getItems().add(driver);
		name.clear();
		//id.clear();
		password.clear();


		station.setTableDrivers(table.getItems());
		
		
		
	}
//	
//	// Delete Buttons functionality
	public void  deleteButtonClicked()
	{
		ObservableList<Driver> userSelected , allUsers;
		allUsers = table.getItems();
		userSelected = table.getSelectionModel().getSelectedItems();
		if(userSelected.get(0).getBusy() == true)
		{
			comment.setText("A trip is assigned to this driver , wait for trip to finish to delete ");
			return;
			
		}
		userSelected.forEach(allUsers::remove);
		
		station.setTableDrivers(table.getItems());
			
	}
	
	public void  goBackButtonClicked()
	{
		ManagerScene back=new ManagerScene(window,station);
		back. preparescene();
		window.setScene(back.getscene());
	}
	
	
	
	
	
	public ObservableList<Driver> getManagerTable()
	{

		return station.getTableDriver();
		
	}
	
	

	
	
		


}
