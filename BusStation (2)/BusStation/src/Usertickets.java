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
public class Usertickets {
	
	TableView<Ticket> table;
	
	BusStation station;
	Scene scene;
	Stage window;
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
		TableColumn<Ticket , String > SourceColumn = new TableColumn<>("type");
		SourceColumn.setMinWidth(200);
		SourceColumn.setCellValueFactory(new PropertyValueFactory<Ticket,String>("type"));

		// Destination Column
		TableColumn<Ticket , String > DestinationColumn = new TableColumn<>("price");
		DestinationColumn.setMinWidth(200);
		DestinationColumn.setCellValueFactory(new PropertyValueFactory<Ticket,String>("price"));
		
		
		// Destination Column
				TableColumn<Ticket , String > Destination2Column = new TableColumn<>("Trip ID");
				Destination2Column.setMinWidth(200);
				Destination2Column.setCellValueFactory(new PropertyValueFactory<Ticket,String>("tripID"));

		
		// table it self
		
		table = new TableView();
		table.setItems(getManagerTable());
		table.getColumns().addAll(SourceColumn , DestinationColumn , Destination2Column);
		
		//table.getColumns().addAll(DestinationColumn);
		
				// Buttons and Hbox
		Button goBackButton = new Button("Go Back");
		Button deleteButton = new Button("Delete");
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(10,10,10,10));
		hbox.setSpacing(10);
		hbox.getChildren().addAll(goBackButton,deleteButton);
		
		// Buttons set Action

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
		
	public void  goBackButtonClicked()
	{
		Usermenu back=new Usermenu(window,station,user);
		back.prepareScene();
		window.setScene(back.getscene());
		
	}
	
	
	
	public void  deleteButtonClicked()
	{
		
		ObservableList<Ticket> userSelected , allTrips;
		allTrips = table.getItems();
		userSelected = table.getSelectionModel().getSelectedItems();
		ArrayList<Trips> myTrips = user.getMyTrips();
		ArrayList<Ticket> myTickets = user.getMyTickets();
		ObservableList<Trips> allTrips2 = station.getTableTrips();
		
		
		int id = userSelected.get(0).getTicketID();
		int id2=Integer.parseInt(userSelected.get(0).getTripID()); 

		int size = myTrips.size();
		int i =0;
		userSelected.forEach(allTrips::remove);
		
		while(i<size)
		{
			if(myTickets.get(i).getTicketID()==id)
			{
				myTickets.remove(i);
				myTrips.remove(i);
				break;
				
				
			}
			i++;
			
			
		}
		
		


	size = allTrips2.size();
	i=0;
	while(i<size)
	{
		if(allTrips2.get(i).getTripID()==id2)
		{
			allTrips2.get(i).setSeats(allTrips2.get(i).getSeats()+1);
			
		}
		i++;
		
		
	}
	
		
		
		
	}
	
	public ObservableList<Ticket> getManagerTable()
	{

		ObservableList<Ticket> Tickets = FXCollections.observableArrayList();
		ArrayList<Ticket> list = user.getMyTickets();
		Tickets.addAll(list);

		return Tickets;
		
	}
	
	

	
	
		


}
