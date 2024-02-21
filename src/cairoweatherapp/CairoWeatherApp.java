
package cairoweatherapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class CairoWeatherApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
      // this is the first app , so this this to load splash xml
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("splash.fxml"));
        loader.setController(new SplashController());
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.setTitle(" Weather App");
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}



