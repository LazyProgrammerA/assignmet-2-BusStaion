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


public class Driverinfo {
	Driver driver;
	Stage stage;
	BusStation station;
	Scene scene;
	 public Driverinfo(Stage stage,BusStation station,Driver driver){
    	 this.stage=stage;
    	 this.station=station;
    	 this.driver=driver;
     }
	 public void prepareScene() {
		 stage.setHeight(800);
			stage.setWidth(1600);
		 Button info=new Button("view info");
		 Button back=new Button("back");
		 Button info2=new Button("view trip info");
		 GridPane mm=new GridPane();
		 mm.add(info, 0, 2);
		 mm.add(back, 0, 4);
		 mm.add(info2, 0, 3);
		 scene  =new Scene(mm,200,100);
			info.setOnAction(new EventHandler<ActionEvent>()  {
				@Override
				public void handle(ActionEvent event){
					
				Driverinfo2 dd=new Driverinfo2(stage,station,driver);
				dd.prepareScene();
				stage.setScene(dd.getscene());
				}
				});
			
			
			back.setOnAction(new EventHandler<ActionEvent>()  {
				@Override
				public void handle(ActionEvent event){
					
					Employeemenu back=new Employeemenu(stage,station);
					back.submenu();
					stage.setScene(back.getScene());
				}
				});
			info2.setOnAction(new EventHandler<ActionEvent>()  {
				@Override
				public void handle(ActionEvent event){
					
					Drivertrip info=new Drivertrip(stage,station,driver);
					info.prepareScene();
					stage.setScene(info.getscene());
					
				}
				});
			
	 }
	 public Scene getscene() {
		return scene; 
	 }

}
