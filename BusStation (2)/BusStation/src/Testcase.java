
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

public class Testcase extends Application {
	public static void main(String[] args){
		launch(args);
	}
	@Override
	public void start(Stage primaryStage )throws Exception {
		
		primaryStage.setTitle("mainmenu");
		BusStation station =new BusStation();
		station.loadAll();
		station.setmanager();
		Mainmenu main=new Mainmenu(primaryStage,station);
		//BusStation station =new BusStation();
		main.mainmenu();
	
		primaryStage.setScene(main.getScene());
		
		primaryStage.show();
	}
}
