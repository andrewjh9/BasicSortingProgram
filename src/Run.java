

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @version 0.2
 * @author AndrewHeath
 */
public class Run extends Application
{
    
    
    @Override
    public void start(Stage primaryStage)
    {
    
        
        CustomStackPane root = new CustomStackPane();
  
        
        Scene scene = new Scene(root, 600, 700);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("icon.png"));
        primaryStage.setTitle("Sorting Program");
        primaryStage.setScene(scene);
        primaryStage.show();
       
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
