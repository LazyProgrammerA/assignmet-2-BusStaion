
import javafx.scene.control.TextField;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//import atm.gui;
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


public class Mainmenu {
	 Scene scene;
	 Stage stage;
	 Employeemenu tt;
	 BusStation station ;
	 public Mainmenu(Stage stage,BusStation station){
    	 this.stage=stage;
    	 this.station=station;
     }
	public void mainmenu() throws Exception{
		

		stage.setHeight(800);
		stage.setWidth(1600);
		Button employee = new Button("employee");
		Button user = new Button("passenger");
		GridPane grid =new GridPane();
		grid.add(employee, 0, 0);
		grid.add(user, 0, 1);
		employee.setOnAction(new EventHandler<ActionEvent>()  {
			@Override
			public void handle(ActionEvent event)
			{
				
				Employeemenu employee= new Employeemenu(stage,station);
				employee.submenu();
				stage.setScene(employee.getScene());
			}
			});
		user.setOnAction(new EventHandler<ActionEvent>()  {
			@Override
			public void handle(ActionEvent event)
			{
				
				Passengerscene employee= new Passengerscene(stage,station);
				employee.preparescene();
				stage.setScene(employee.getScene());
			}
			});
	
	scene  =new Scene(grid,400,200);
	}
	public Scene getScene(){
		return this.scene;
	}
	public void setemployeemenu(Employeemenu tt){
	     this. tt=tt;
	}
}
