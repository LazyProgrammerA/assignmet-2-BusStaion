import javafx.scene.control.TextField;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

//import atm.gui;
import javafx.application.Application;
import javafx.collections.ObservableList;
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

public class Loginwindow {
	Scene scene;
	 Stage stage;
	 Employeemenu tt;
	 BusStation station ;
	 public Loginwindow(Stage stage,BusStation station){
   	 this.stage=stage;
   	 this.station=station;
    }
	public void preparescene(){
		 stage.setHeight(800);
			stage.setWidth(1600);
		
		TextField password= new TextField();
		password.setPromptText("Password");
		TextField name= new TextField();
		name.setPromptText("Name");
		Button login = new Button("login");
		Button back = new Button("back");
		GridPane grid =new GridPane();
		grid.add(name, 0, 0);
		grid.add(password, 0, 1);
		grid.add(login, 0, 2);
		grid.add(back, 0, 3);
		
		
		scene  =new Scene(grid,400,200);
	back.setOnAction(new EventHandler<ActionEvent>()  {
			@Override
			public void handle(ActionEvent event)
			{
				
				Passengerscene employee= new Passengerscene(stage,station);
				employee.preparescene();
				stage.setScene(employee.getScene());
			}
			});
	
	login.setOnAction(new EventHandler<ActionEvent>()  {
		@Override
		public void handle(ActionEvent event)
		{
			
			String name1=name.getText();
			String password1=password.getText();
			
			ObservableList<User> list = station.getTableUser();
			User user = null;
			
			int i = 0;
			int size = list.size();
			
			while(i<size)
			{
				User user2 = list.get(i);
				String name2 = user2.getname();
				String password2 = user2.getpassword();
				
				if(name1.compareToIgnoreCase(name2)==0 && password1.compareToIgnoreCase(password2)==0 )
				{
					user = user2;
					break;
				}
				i++;
			}
			
			
			if(user == null)
			{
				//label invalid;
				return;
			}
			
			else
			{
				
				
				Usermenu tt=new Usermenu(stage,station,user);
				
				tt.prepareScene();
				
				stage.setScene(tt.getscene());
				
				// go to scene
				
			}
		}
		});
		
	}
	public Scene getScene(){
		return this.scene;
	}
	

}
