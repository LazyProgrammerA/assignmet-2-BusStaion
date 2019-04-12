import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class Main extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
		
	}
	
	public void start(Stage primaryStage) throws Exception
	{
		BusStation station = new BusStation();
		station.loadAll();
	LogInScene logIn = new LogInScene();
	logIn.prepareScene(primaryStage , station);
	primaryStage.setWidth(1900);
	primaryStage.setHeight(1000);
	primaryStage.show();
	primaryStage.setScene(logIn.getScene());
	
	}

}
