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


public class Userinfo {
	User user;
	Stage stage;
	BusStation station;
	Scene scene;
	 public Userinfo(Stage stage,BusStation station,User user){
    	 this.stage=stage;
    	 this.station=station;
    	 this.user=user;
     }
	 public void prepareScene() {
		 stage.setHeight(800);
			stage.setWidth(1600);
		Label name =new Label();
		Label password =new Label();
		Label tripid =new Label();
		 Button back=new Button("back");
		 GridPane mm=new GridPane();
		 mm.add(name, 0, 2);
		 mm.add(back, 0, 3);
		 mm.add(password, 1, 2);
		 mm.add(tripid, 0, 1);
		 
		 scene  =new Scene(mm,200,100);
			name.setText("Name " + user.getname());
			password.setText("Password " + user.getpassword());
			
			
			
			back.setOnAction(new EventHandler<ActionEvent>()  {
				@Override
				public void handle(ActionEvent event){
					
				Usermenu back=new Usermenu(stage,station,user);
					back.prepareScene();
					stage.setScene(back.getscene());
				}
				});
			
	 }
	 public Scene getscene() {
		return scene; 
	 }

}
