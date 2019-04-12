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


public class Usermenu {
	User user;
	Stage stage;
	BusStation station;
	Scene scene;
	 public Usermenu(Stage stage,BusStation station,User user){
    	 this.stage=stage;
    	 this.station=station;
    	 this.user=user;
     }
	 public void prepareScene() {
		 stage.setHeight(800);
			stage.setWidth(1600);
		 
		 Button add=new Button("Book Trips");
		 Button back=new Button("back");
		 Button view1=new Button("view tickets");
		 Button view2=new Button("view trips");
		 Button view3=new Button("view info");
		 Button view4=new Button("Save");
		 
		 GridPane mm=new GridPane();
		 mm.add(add, 0, 2);
		 mm.add(back, 0, 4);
		 mm.add(view1, 0, 3);
		 mm.add(view2, 0, 5);
		 mm.add(view3, 0, 6);
		 mm.add(view4, 0,7 );
		 
		 scene  =new Scene(mm,200,100);

		 
			
			back.setOnAction(new EventHandler<ActionEvent>()  {
				@Override
				public void handle(ActionEvent event){
					
					Loginwindow back=new Loginwindow(stage,station);
					back.preparescene();
					stage.setScene(back.getScene());
				}
				});
			
			view2.setOnAction(new EventHandler<ActionEvent>()  {
				@Override
				public void handle(ActionEvent event){
					
					Usertrips tt=new Usertrips();
					tt.prepareScene(stage,station,user);
					stage.setScene(tt.getScene());
				}
				});
			
			
			add.setOnAction(new EventHandler<ActionEvent>()  {
				@Override
				public void handle(ActionEvent event){
					
					UserChooseTripScene tt=new UserChooseTripScene();
					tt.prepareScene(stage,station,user);
					stage.setScene(tt.getScene());
				}
				});
			view1.setOnAction(new EventHandler<ActionEvent>()  {
				@Override
				public void handle(ActionEvent event){
					
					Usertickets tt=new Usertickets();
					tt.prepareScene(stage,station,user);
					stage.setScene(tt.getScene());
				}
				});
			view3.setOnAction(new EventHandler<ActionEvent>()  {
				@Override
				public void handle(ActionEvent event){
					
					Userinfo tt=new Userinfo(stage,station,user);
					tt.prepareScene();
					stage.setScene(tt.getscene());
				}
				});
			
			view4.setOnAction(new EventHandler<ActionEvent>()  {
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
			
	 }
	 
	 public Scene getscene() {
		return scene; 
	 }

}
