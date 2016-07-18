package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML TextArea out;
    @FXML TextField in;

    @FXML public void show(ActionEvent actionEvent) {
        String intake = in.getText();
        out.setText("" +getDecimal(intake));
        //calls method to set Text
    }

    private long getDecimal(String intake) {
            char conversion[] = intake.toCharArray();
            //converts string to a char array for convenience
            int convert[] = new int[conversion.length];
            long sum = 0L;
            int con = conversion.length;
        //sets stock lengths for arrays and value of sum
        try{
            for (int k = 0; k < conversion.length; k++) {
                con -= 1;
                convert[con] = (int) (Integer.parseInt(String.valueOf(conversion[k])) * (Math.pow(2.0, con)));
                //conversion formula, 2.0 to the power of con * the binary at location k.
                sum += (long) convert[con];
                if(Integer.parseInt(String.valueOf(conversion[con])) > 1 | Integer.parseInt(String.valueOf(conversion[con])) < 0) {
                    //checks if its binary
                    throw new NumberFormatException("Must be binary, 1s or 0s!");
                }
            }
            return sum;
        }catch(NumberFormatException e) {
            sum = 0L;
            out.setText(e.getMessage());
            //sets out to the error message if the user inputs a non binary number
        }
        return sum;
    }
}
