package application;
	
import java.net.URL;
import java.nio.file.Paths;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//	BorderPane root = new BorderPane();
//Parent root = FXMLLoader.load(getClass().getResource("/src/main/java/com/github/tschierv/memorygame/presentation/MainView.fxml"));
		//	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("/src/main/java/com/github/tschierv/memorygame/presentation/MainView.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("./MainView.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

