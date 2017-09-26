/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.TextField;

/**
 *
 * @author AndrewHeath
 */
public class NumbersTf extends TextField {

    public NumbersTf() {

            textProperty().addListener((observable, oldValue, newValue) -> {
                Pattern p = Pattern.compile("-?\\d+");
                Matcher m = p.matcher(this.getText());
                while (m.find()) {
                    this.setText(m.group());
                }

            });

    }


}
