import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.scene.control.TextField;

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


public class Passengerscene {
	 Scene scene;
	 Stage stage;
	 Employeemenu tt;
	 BusStation station ;
	 public Passengerscene(Stage stage,BusStation station){
    	 this.stage=stage;
    	 this.station=station;
     }
	public void preparescene(){
		 stage.setHeight(800);
			stage.setWidth(1600);
		Button login = new Button("login");
		Button signup= new Button("signup");
		Button back= new Button("back");
		GridPane grid =new GridPane();
		grid.add(login, 0, 0);
		grid.add(signup, 0, 1);
		grid.add(back, 0, 2);
		scene  =new Scene(grid,400,200);
		
		login.setOnAction(new EventHandler<ActionEvent>()  {
			@Override
			public void handle(ActionEvent event)
			{
				
				Loginwindow employee= new Loginwindow (stage,station);
			
				employee.preparescene();
				stage.setScene(employee.getScene());
			}
			});
		signup.setOnAction(new EventHandler<ActionEvent>()  {
			@Override
			public void handle(ActionEvent event)
			{
				
				Signupwindow employee= new Signupwindow (stage,station);
			
				employee.preparescene();
				stage.setScene(employee.getScene());
			}
			});
		back.setOnAction(new EventHandler<ActionEvent>()  {
			@Override
			public void handle(ActionEvent event)
			{
				
			Mainmenu employee= new Mainmenu (stage,station);
			
				try {
					employee.mainmenu();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				stage.setScene(employee.getScene());
			}
			});
	
	}
	public Scene getScene(){
		return this.scene;
	}
}
