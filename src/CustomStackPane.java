


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 *
 * @author AndrewHeath
 */
class CustomStackPane extends VBox
{
    private Set set;

    public CustomStackPane() {
        super();

        this.setStyle("-fx-spacing: 30px;-fx-alignment: center;-fx-font-size: 2em");
        set = new Set();
        Text t = new Text("Sorting");

        NumbersTf tf = new NumbersTf();
        this.setWidth(300);


        Button btn = new Button();
        btn.setText("Input");
        btn.setOnAction(event -> {
         if(!(tf.getText().length()==0)) {
             t.setText(t.getText() + tf.getText() + ",");
             set.addToSet(Integer.parseInt(tf.getText()));
             tf.clear();
         }
        });
        Button sortBtn = new Button();
        sortBtn.setText("Bubble Sort");
        sortBtn.setOnAction(event -> {

            tf.setEditable(true);
            if(!set.isEmpty()) {

                    set.bubbleSort();
                    t.setText("Sorted:");

                t.setText("Sorted: ");
                for (int i = 0; i < set.size(); i++) {

                    t.setText(t.getText()+set.get(i)+",");
                }
            }else{
                if(!(tf.getText().trim()=="")){

                }
            }
        });
        Button clearBtn = new Button();
        clearBtn.setText("Clear");
        clearBtn.setOnAction(event -> {
            tf.setEditable(true);


            set.clear();
             t.setText("Sorting:");

        });
        Button genRandomBtn = new Button();
        genRandomBtn.setText("Gen Random");
        genRandomBtn.setOnAction(event -> {
            set.clear();
            t.setText("Sorting:");

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
                tf.clear();

                for (int i = 0 ;i<=result.get();i++){

                    set.add(generateNumber());
                    t.setText(t.getText()+set.get(i)+",");
                }

            }


        });
        this.getChildren().addAll(t,tf,btn,sortBtn,genRandomBtn ,clearBtn);
    }
    private static int generateNumber(){
        Random rand = new Random();
        return  rand.nextInt(50) + 1;
    }
}
