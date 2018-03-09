package converter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Controller for Length converter.
 * @author Piyaphol Wiengperm.
 */
public class ConverterController {

    @FXML
    TextField textfield1;
    @FXML
    TextField textfield2;
    @FXML
    Button convert;
    @FXML
    Button clear;
    @FXML
    ComboBox<Length> comboBox1;
    @FXML
    ComboBox<Length> comboBox2;

    /**
     * handle the event from convert button.
     * @param event is action event.
     */
    public void handleConvert(ActionEvent event){
        try{
            if(textfield1.getLength() != 0){
                String text = textfield1.getText().trim();
                if(checkInvalid(text)){
                Length unit1 = comboBox1.getValue();
                Length unit2 = comboBox2.getValue();
                String result = convert(text,unit1,unit2);
                System.out.println("handleConvert converting "+text);
                textfield2.setText(result);}
            }
            else if(textfield2.getLength() != 0){
                String text = textfield2.getText().trim();
                if(checkInvalid(text)){
                Length unit1 = comboBox1.getValue();
                Length unit2 = comboBox2.getValue();
                String result = convert(text,unit2,unit1);
                System.out.println("handleConvert converting "+text);
                textfield1.setText(result);}
            }
        }catch (Exception e){
            e.getMessage();
        }
    }

    /**
     * handle the event from clear button.
     * @param event is action event.
     */
    public void handleClear(ActionEvent event){
        textfield1.setText(null);
        textfield2.setText(null);
        textfield1.setStyle(null);
        textfield2.setStyle(null);
    }

    /**
     * check if user input invalid number and show red color if it invalid.
     * @param text
     * @return boolean.
     */
    public boolean checkInvalid(String text){
        if(Double.parseDouble(text)<0){
            textfield1.setStyle("-fx-text-inner-color: red;");
            textfield2.setStyle("-fx-text-inner-color: red;");
            return false;
        }
        return true;
    }

    /** initialize the controller.*/
    public void initialize(){
        System.out.println("Running initialize");
        if(comboBox1 != null){
            comboBox1.getItems().addAll(Length.values());
            comboBox1.getSelectionModel().select(0);
        }
        if(comboBox2 != null){
            comboBox2.getItems().addAll(Length.values());
            comboBox2.getSelectionModel().select(1);
        }
    }

    /**
     * convert the length from input value from unit to another unit.
     * @param text is value input from user.
     * @param unit1 initial unit.
     * @param unit2 unit that want to convert.
     * @return format of String.
     */
    public String convert(String text,Length unit1,Length unit2){
        double result;
        double value = Double.parseDouble(text);
        result = (value * unit1.getValue())/unit2.getValue();
        return String.format("%.4g",result);
    }
}
