


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static jdk.nashorn.internal.objects.NativeMath.round;

/**
 *@brief A class to define the CustomStackPane which hold the main components for the Sorting program@
 * @version 0.2
 * @author AndrewHeath
 */
class CustomStackPane extends VBox
{
    private Set set;

    /**
     * @brief Constructor
     */
    public CustomStackPane()
    {
        super();
        //Creating elements and assigning styles
        this.requestFocus();
        Text heading =new Text("Sorting");
        heading.setStyle("-fx-fill:#9a5ab6;-fx-font-size: 4em;-fx-font-weight:bold;");
        this.setStyle("-fx-spacing: 30px;-fx-alignment: center;-fx-font-size: 2em");
        set = new Set();
        Text sortedT = new Text("Sorted: ");

        NumbersTf tf = new NumbersTf();
        Tooltip numberInputTp = new Tooltip("Insert a number then press input to add to the set");
        tf.setTooltip(numberInputTp);
        tf.setMaxWidth(300);
        this.setWidth(300);
        Text rangeT = new Text("Range: ");
        Text originalSetT = new Text("Set: ");
        originalSetT.setStyle("-fx-font-weight:bold");
		Text meanT = new Text("Mean: ");
        Text stdDevT = new Text("Standard Deviation: ");
		
        CustomButton inputBtn = new CustomButton();
        inputBtn.setText("Input");
        //Action event for the input Button
        inputBtn.setOnAction(event ->
        {
         if(!(tf.getText().length()==0)) {
             originalSetT.setText( originalSetT.getText() + tf.getText() + ",");
             set.addToSet(Integer.parseInt(tf.getText()));
             tf.clear();
         }
        });
        CustomButton AnalyseBtn = new CustomButton();
        AnalyseBtn.setText("Analyse Set");
        //Action Event for the Analyse button
        AnalyseBtn.setOnAction(event ->
        {

            tf.setEditable(true);
            if(!set.isEmpty()) {
                    rangeT.setText("Range: "+set.getRange());
                    meanT.setText("Mean: "+Double.toString(set.getMean()));
                    stdDevT.setText("Standard Deviation: "+Double.toString(set.getSd()));
                    set.bubbleSort();
                    sortedT.setText("Sorted:");

                sortedT.setText("Sorted: ");
                for (int i = 0; i < set.size(); i++) {

                    sortedT.setText(sortedT.getText()+set.get(i)+",");
                }
            }else{
                if(!(tf.getText().trim()=="")){

                }
            }
        });
		
        CustomButton clearBtn = new CustomButton();
        clearBtn.setText("Clear");
        //Action Event for Clear Button
        clearBtn.setOnAction(event -> {
            tf.setEditable(true);


            set.clear();
             sortedT.setText("Sorting:");
             meanT.setText("");

        });
        CustomButton genRandomBtn = new CustomButton();
        genRandomBtn.setText("Gen Random");
        //Action Event for generate Random number Button
        genRandomBtn.setOnAction(event ->
        {
            set.clear();
            sortedT.setText("Sorting:");

            List<Integer> choices = new ArrayList<>();
            choices.add(1);  choices.add(2); choices.add(3);choices.add(4);choices.add(5);  choices.add(6);  choices.add(7); choices.add(8);choices.add(9);choices.add(10);



            ChoiceDialog<Integer> dialog = new ChoiceDialog<Integer>(5, choices);
            dialog.setTitle("Random Number");
            dialog.setHeaderText("Random Number Generator");
            dialog.setContentText("How many numbers to generate:");

            Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
            stage.getIcons().add(
                    new Image(this.getClass().getResource("icon.png").toString()));
            Optional<Integer> result = dialog.showAndWait();
            if (result.isPresent()){
                tf.setEditable(false);
                set.clear();
                originalSetT.setText("");
                tf.clear();
				rangeT.setText("Range: ");
                for (int i = 0 ;i<=result.get();i++){

                    set.add(generateNumber());
                    originalSetT.setText(originalSetT.getText()+set.get(i)+",");
                }
            }
        });
        //Adding GUI elements to window
        HBox numberInputHBox = new HBox();
        numberInputHBox.getChildren().addAll(inputBtn,genRandomBtn);
        numberInputHBox.setAlignment(Pos.CENTER);
        numberInputHBox.setSpacing(10);
        this.getChildren().addAll(heading,originalSetT,sortedT,meanT,stdDevT,rangeT,tf,numberInputHBox,AnalyseBtn ,clearBtn);
    }

    /**
     * @brief A static method for generating a method between 1 and 50
     * @return random integer
     */
    private static int generateNumber()
    {
        Random rand = new Random();
        return  rand.nextInt(50) + 1;
    }
}
