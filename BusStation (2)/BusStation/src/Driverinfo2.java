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


public class Driverinfo2 {
	Driver driver;
	Stage stage;
	BusStation station;
	Scene scene;
	 public Driverinfo2(Stage stage,BusStation station,Driver driver){
    	 this.stage=stage;
    	 this.station=station;
    	 this.driver=driver;
     }
	 public void prepareScene() {
		 stage.setHeight(800);
			stage.setWidth(1600);
		Label name =new Label();
		Label password =new Label();
		Label tripid =new Label();
		 Button back=new Button("back");
		 GridPane mm=new GridPane();
		 mm.add(name, 0, 1);
		 mm.add(back, 0, 4);
		 mm.add(password, 0, 2);
		 mm.add(tripid, 0, 3);
		 
		 scene  =new Scene(mm,200,100);
			name.setText("Name: "+driver.getName());
			password.setText("Password: "+driver.getPassword());
			tripid.setText("Trip ID: "+driver.getTripID());
			
			
			back.setOnAction(new EventHandler<ActionEvent>()  {
				@Override
				public void handle(ActionEvent event){
					
				Driverinfo back=new Driverinfo(stage,station,driver);
					back.prepareScene();
					stage.setScene(back.getscene());
				}
				});
			
	 }
	 public Scene getscene() {
		return scene; 
	 }

}
