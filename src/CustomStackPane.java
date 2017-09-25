/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 *
 * @author AndrewHeath
 */
class CustomStackPane extends VBox
{
    private Set set;
    private ToggleGroup sortTg;
    private RadioButton bubbleRb;
    public CustomStackPane() {
        super();
        set = new Set();
        Text t = new Text("Hi");
        NumbersTf tf = new NumbersTf();
        sortTg = new ToggleGroup();
        bubbleRb = new RadioButton();
        bubbleRb.setToggleGroup(sortTg);
        Button btn = new Button();
        btn.setText("Input");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                t.setText(t.getText()+","+tf.getText());
                set.addToSet(Integer.parseInt(tf.getText()));
                tf.clear();
            }
        });
        Button btn2 = new Button();
        btn2.setText("Print'");
        btn2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                for (int i =0;i< set.getNumberSet().size();i++){
                   
                    System.out.println( set.getNumberSet().get(i));
                }
            }
        });
        this.getChildren().addAll(t,tf,btn, btn2,bubbleRb);
    }
    
}
