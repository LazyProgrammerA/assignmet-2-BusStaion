import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Signupwindow {
	Scene scene;
	 Stage stage;
	 Employeemenu tt;
	 BusStation station ;
	 public Signupwindow(Stage stage,BusStation station){
  	 this.stage=stage;
  	 this.station=station;
   }

	public void preparescene(){
		 stage.setHeight(800);
			stage.setWidth(1600);
		TextField password= new TextField("");
		TextField name= new TextField("");
		password.setPromptText("Password");
		
		name.setPromptText("Name");
		Button signup = new Button("signup");
		Button back = new Button("back");
		GridPane grid =new GridPane();
		grid.add(name, 0, 0);
		grid.add(password, 0, 1);
		grid.add(signup, 0, 2);
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
	signup.setOnAction(new EventHandler<ActionEvent>()  {
		@Override
		public void handle(ActionEvent event)
		{
			
			User user=new User();
			user.setname(name.getText());
			user.setpassword(password.getText());
			user.setid(station.updateAndGetUserID());
			station.getTableUser().add(user);
		}
		});
		
	}
	public Scene getScene(){
		return this.scene;
	}
	
}
