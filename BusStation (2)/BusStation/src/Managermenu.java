

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Managermenu {
	 Scene scene;
	 Stage stage;
	 Employeemenu ll;
	 BusStation station;
	 public Managermenu(Stage stage,BusStation station){
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
		 Label invalid =new Label();
		 GridPane mm =new GridPane();
			mm.add(submit, 1, 1);
			mm.add(password, 1, 0);
			mm.add(back, 0, 1);
			mm.add(invalid, 0, 2);
			
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
					
					Manager copy = station.getmanager();
					//back.submenu();
					String password1=copy.getPassword();
					String password2 = password.getText();
					
					if (password1.compareTo(password2) == 0) {
						ManagerScene tt =new ManagerScene(stage,station);
						tt.preparescene();
						stage.setScene(tt.getscene());
						
					}else{
					
						invalid.setText("invalid input");	
					}
				}
				});
			
			scene  =new Scene(mm,200,100);
	}
	public Scene getScene(){
		return this.scene;
	}
	public void setemployeemenu( Employeemenu ll){
		this. ll=ll;
	}

}
