

//import bus.Mainmenu;
//import bus.Managermenu;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import atm.Validation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Employeemenu {
	 Scene scene;
	 Stage stage;
	 Mainmenu vv;
	 Managermenu kk;
	 Mainmenu hh;
	 BusStation station;

	 public Employeemenu(Stage stage,BusStation station){
    	 this.stage=stage;
    	 this.station=station;
     }
	public void submenu(){
		 stage.setHeight(800);
			stage.setWidth(1600);
		Button manager = new Button("manager");
		Button driver = new Button("driver");
		Button back = new Button("back");
		Button save = new Button("Save");
		GridPane xy =new GridPane();
		xy.add(manager, 0, 0);
		xy.add(driver, 1, 0);
		xy.add(back, 1, 2);
		manager.setOnAction(new EventHandler<ActionEvent>()  {
			@Override
			public void handle(ActionEvent event){
				//stage.setScene(kk.getScene());
				Managermenu manager=new Managermenu(stage,station);
				manager.password();
				stage.setScene(manager.getScene());
				
			}
			});
		driver.setOnAction(new EventHandler<ActionEvent>()  {
			@Override
			public void handle(ActionEvent event){
				
				Drivermenue manager=new Drivermenue(stage,station);
				manager.password();
				stage.setScene(manager.getScene());
			}
			});
		back.setOnAction(new EventHandler<ActionEvent>()  {
			@Override
			public void handle(ActionEvent event){
				//stage.setScene(hh.getScene());
				Mainmenu back1 =new Mainmenu(stage,station);
				try {
					back1.mainmenu();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			stage.setScene(back1.getScene());
			}
			});
		
		save.setOnAction(new EventHandler<ActionEvent>()  {
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
		
		scene  =new Scene(xy,200,100);
	}
	public Scene getScene(){
		return this.scene;
	}
	public void setmainmenu( Mainmenu vv){
		this.vv=vv;
	}
	public void setManagermenu( Managermenu kk){
		this.kk=kk;
	}
//	public void setemployeemenu(Mainmenu hh){
	    // this. hh=hh;
	//}
}
