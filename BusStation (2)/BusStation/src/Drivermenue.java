

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Drivermenue {
	
	 Scene scene;
	 Stage stage;
	 Employeemenu ll;
	 BusStation station;
	 public Drivermenue(Stage stage,BusStation station){
    	 this.stage=stage;
    	 this.station=station;
     }
	public void password(){
		 stage.setHeight(800);
			stage.setWidth(1600);
		Button submit = new Button("submit");
	Button back = new Button("back");
		 TextField password=new TextField();
		 password.setPromptText("password");
		 TextField name=new TextField();
		 name.setPromptText("name");
		 
		 Label invalid =new Label();
		 GridPane mm =new GridPane();
			mm.add(submit, 0, 3);
			mm.add(password, 0, 2);
			mm.add(back, 0, 4);
			mm.add(invalid, 1, 3);
			mm.add(name, 0, 1);
			
			scene  =new Scene(mm,200,100);
			
			back.setOnAction(new EventHandler<ActionEvent>()  {
				@Override
				public void handle(ActionEvent event){
					
					Employeemenu back=new Employeemenu(stage,station);
					back.submenu();
					stage.setScene(back.getScene());
				}
				});
			submit.setOnAction(new EventHandler<ActionEvent>()  {
				@Override
				public void handle(ActionEvent event){
					String name1=name.getText();
					String password1=password.getText();
					
					ObservableList<Driver> list = station.getTableDriver();
					Driver driver = null;
					
					int i = 0;
					int size = list.size();
						
					while(i<size)
					{
						Driver driver2 = list.get(i);
						String name2 = driver2.getName();
						String password2 = driver2.getPassword();
						
						if(name1.compareToIgnoreCase(name2)==0 && password1.compareToIgnoreCase(password2)==0 )
						{
							driver = driver2;
							break;
						}
						i++;
					}
					
					if(driver == null)
					{
						//label invalid;
						return;
					}
					
					else
					{
						Driverinfo xx=new Driverinfo(stage,station,driver);
						xx.prepareScene();
						
						stage.setScene(xx.getscene());
					}
				
				}
				});
			
			
	}
	public Scene getScene(){
		return this.scene;
	}
	public void setemployeemenu( Employeemenu ll){
		this. ll=ll;
	}

}
