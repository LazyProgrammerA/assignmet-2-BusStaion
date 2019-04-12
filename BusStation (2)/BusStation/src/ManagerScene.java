import javafx.scene.control.TextField;

import java.io.IOException;

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

public class ManagerScene {
	Stage stage;
	BusStation station;
	Scene scene;
	public ManagerScene(Stage stage,BusStation station) {
		this.stage=stage;
		this.station=station;
	}
	public void preparescene() {
		 stage.setHeight(800);
			stage.setWidth(1600);
		GridPane grid = new GridPane();
		Button b1=new Button("mange trips");
		Button b2=new Button("mange vechiles");
		Button b3=new Button("mange drivers");
		Button b4=new Button("BACK");
		Button b5=new Button("Save");
		grid.add(b1, 0, 1);
		grid.add(b2, 0, 2);
		grid.add(b3, 0, 3);
		grid.add(b4, 0, 4);
		grid.add(b5, 0, 5);
		b1.setOnAction(new EventHandler<ActionEvent>()  {
			@Override
			public void handle(ActionEvent event){
				
				ManagerManageTripsScene back=new ManagerManageTripsScene();
				back.prepareScene(stage,station);
				stage.setScene(back.getScene());
			}
			});
		b2.setOnAction(new EventHandler<ActionEvent>()  {
			@Override
			public void handle(ActionEvent event){
				
				ManagerManageVehiclesScene back=new ManagerManageVehiclesScene();
				back.prepareScene(stage,station);
				stage.setScene(back.getScene());
			}
			});
		b3.setOnAction(new EventHandler<ActionEvent>()  {
			@Override
			public void handle(ActionEvent event){
				
				ManagerManageDriversScene back=new ManagerManageDriversScene();
				back.prepareScene(stage,station);
				stage.setScene(back.getScene());
			}
			});
		b4.setOnAction(new EventHandler<ActionEvent>()  {
			@Override
			public void handle(ActionEvent event){
				
				Employeemenu back=new Employeemenu(stage,station);
				back.submenu();
				stage.setScene(back.getScene());
			}
			});
		
		b5.setOnAction(new EventHandler<ActionEvent>()  {
			@Override
			public void handle(ActionEvent event){
				
				try {
					station.saveAll();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			});
		
		
		
		scene = new Scene(grid,400,400);
	}
	public Scene getscene() {
		
	
	return scene;
	}
}
