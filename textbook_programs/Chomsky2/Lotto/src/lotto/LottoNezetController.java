
package lotto;

import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;


public class LottoNezetController implements Initializable {

    private int MAX = 90;
    private int MIN = 1;

    private int genNum1;
    private int genNum2;
    private int genNum3;
    private int genNum4;
    private int genNum5;
    private int selNum1;
    private int selNum2;
    private int selNum3;
    private int selNum4;
    private int selNum5;

    //<editor-fold defaultstate="collapsed" desc="FXML items">
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label alertText;
    @FXML
    private Label resultLabel;
    @FXML
    private TextField input1;
    @FXML
    private TextField input2;
    @FXML
    private TextField input3;
    @FXML
    private TextField input4;
    @FXML
    private TextField input5;
    @FXML
    private Pane basePane;
    @FXML
    private Pane alertPane;
    @FXML
    private Button alertBtn;


//</editor-fold>

    @FXML
    private void handleAlertButton(ActionEvent event) {

        basePane.setOpacity(1);
        basePane.setDisable(false);
        alertPane.setVisible(false);
        alertText.setText("");

    }


    @FXML
    private void handleButtonAction(ActionEvent event) {

        genNum1 = 0;
        genNum2 = 0;
        genNum3 = 0;
        genNum4 = 0;
        genNum5 = 0;
        genNum1 = getRandomNumber();
        genNum2 = getRandomNumber();;
        genNum3 = getRandomNumber();;
        genNum4 = getRandomNumber();;
        genNum5 = getRandomNumber();;

        label1.setText(String.valueOf(genNum1));
        label2.setText(String.valueOf(genNum2));
        label3.setText(String.valueOf(genNum3));
        label4.setText(String.valueOf(genNum4));
        label5.setText(String.valueOf(genNum5));
        calculate();

    }

    private void alert(String text)
    {
        basePane.setOpacity(0.3);
        basePane.setDisable(true);
        alertPane.setVisible(true);
        alertText.setText(text);
    }

    private String calculate()
    {
        try
        {
            selNum1 = Integer.parseInt(input1.getText());
            selNum2 = Integer.parseInt(input2.getText());
            selNum3 = Integer.parseInt(input3.getText());
            selNum4 = Integer.parseInt(input4.getText());
            selNum5 = Integer.parseInt(input5.getText());
        }
        catch(Exception e)
        {
            alert("Nem jó számot adtál meg");
            System.out.println(e);
            return "";
        }

        ArrayList<Integer> selNums = new ArrayList<>();
        selNums.add(selNum1);
        selNums.add(selNum2);
        selNums.add(selNum3);
        selNums.add(selNum4);
        selNums.add(selNum5);
        int db =0;
        for(int i : selNums)
        {
            if(i>MAX || i <MIN)
            {
                db++;
            }
        }
        if(db!=0)
        {
            alert("A szamoknak 1 és 90 kozott kell lenniuk");
            return "";
        }

        Set<Integer> selNums2 = new HashSet<>(selNums);
        if(selNums2.size()<5)
        {
            alert("A szamoknak kulonbozonek kell lenni.");
            return "";
        }

        int result = 0;

        ArrayList<Integer> genNums = new ArrayList<>();
        genNums.add(genNum1);
        genNums.add(genNum2);
        genNums.add(genNum3);
        genNums.add(genNum4);
        genNums.add(genNum5);

        for(int i = 0;i<selNums.size();i++)
        {
            for(int j = 0;j<genNums.size();j++)
            {
                if(selNums.get(i)==genNums.get(j))
                {
                    result++;
                }
            }
        }

        switch(result)
        {
            case 0:
                resultLabel.setText("Sajnos nem nyert semmit.");
                break;
            case 1:
                resultLabel.setText("Egyesed van a lottón.");
                break;
            case 2:
                resultLabel.setText("Kettesed van a lottón.");
                break;
            case 3:
                resultLabel.setText("Hármasod van a lottón.");
                break;
            case 4:
                resultLabel.setText("Négyesed van a lottón.");
                break;
            case 5:
                resultLabel.setText("ÖTÖSÖD van a lottón.");
                break;
        }



        return "";
    }

    private int getRandomNumber()
    {
        int random = (int) (Math.random()*MAX)+MIN;

        if(random == genNum1 || random == genNum2 || random == genNum3 || random == genNum4 || random == genNum5 )
        {
            return getRandomNumber();
        }
        return random;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {


    }

}
