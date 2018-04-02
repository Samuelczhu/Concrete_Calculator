import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AnswerWindowController implements Initializable {

    // ids
    @FXML private TextField fcuk;
    @FXML private TextField n;
    @FXML private TextField lambda1;
    @FXML private TextField lambda2;
    @FXML private TextField mfcu;
    @FXML private TextField fcumin;
    @FXML private TextField Sfcu;
    @FXML private TextField mfcu_Add_lambda1Sfcu;
    @FXML private TextField fcuk085;
    @FXML private TextField fcuk09;
    @FXML private TextField fcuk095;
    @FXML private TextField fcuk11;
    @FXML private TextField fcuk115;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //set the answer on the TextField
        fcuk.setText(String.valueOf(Algorithm.getFcuk()));
        n.setText(String.valueOf(Algorithm.getN()));
        lambda1.setText(String.valueOf(Algorithm.getLamba1()));
        lambda2.setText(String.valueOf(Algorithm.getLambda2()));
        mfcu.setText(String.valueOf(Algorithm.getMfcu()));
        fcumin.setText(String.valueOf(Algorithm.getFcumin()));
        Sfcu.setText(String.valueOf(Algorithm.getSfcu()));
        mfcu_Add_lambda1Sfcu.setText(String.valueOf(Algorithm.getMfcu() + Algorithm.getLamba1()*Algorithm.getSfcu()));
        fcuk085.setText(String.valueOf((double)Math.round((0.85 * Algorithm.getFcuk()) * 10d) / 10d));
        fcuk09.setText(String.valueOf((double)Math.round((0.9 * Algorithm.getFcuk()) * 10d) / 10d));
        fcuk095.setText(String.valueOf((double)Math.round((0.95 * Algorithm.getFcuk()) * 10d) / 10d));
        fcuk11.setText(String.valueOf((double)Math.round((1.1 * Algorithm.getFcuk()) * 10d) / 10d));
        fcuk115.setText(String.valueOf((double)Math.round((1.15 * Algorithm.getFcuk()) * 10d) / 10d));
    }
}
