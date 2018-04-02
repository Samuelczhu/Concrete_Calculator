import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private TableView<TestData> inputTable;
    @FXML private TableColumn<TestData, String> PlaceUsed;
    @FXML private TableColumn<TestData, Integer> StiffLevel;
    @FXML private TableColumn<TestData, Integer> SampleAge;
    @FXML private TableColumn<TestData, Double> RepresentData;
    @FXML private TableColumn<TestData, Double> ReachPercent;

    @FXML private TextField placeInput;
    @FXML private TextField stiffInput;
    @FXML private TextField ageInput;
    @FXML private TextField representInput;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //initialize the table column
        PlaceUsed.setCellValueFactory(new PropertyValueFactory<>("placeUsed"));
        StiffLevel.setCellValueFactory(new PropertyValueFactory<>("stiffLevel"));
        SampleAge.setCellValueFactory(new PropertyValueFactory<>("sampleAge"));
        RepresentData.setCellValueFactory(new PropertyValueFactory<>("representData"));
        ReachPercent.setCellValueFactory(new PropertyValueFactory<>("reachPercent"));
    }

    public void addItem() {
        try {
            // getting value
            String place = placeInput.getText();
            int stiff = Integer.valueOf(stiffInput.getText());
            int age = Integer.valueOf(ageInput.getText());
            double represent = Double.valueOf(representInput.getText());

            //clear data
            ageInput.clear();
            representInput.clear();

            //add to the input table
            inputTable.getItems().add(new TestData(place,stiff,age,represent));
        } catch (Exception e) {
            alertBox.display("错误","请输入正确的值");
        }
    }

    public void deleteItem() {
        try {
            ObservableList<TestData> dataSelected, allData;
            allData = inputTable.getItems();
            dataSelected = inputTable.getSelectionModel().getSelectedItems();
            dataSelected.forEach(allData::remove);
        } catch (Exception e) {
            alertBox.display("错误","删除错误");
        }
    }

    public void calculate() throws Exception {
        try {
            ObservableList<TestData> allData = inputTable.getItems();
            //calculate
            Algorithm.setFcuk(allData.get(0).getStiffLevel());
            Algorithm.setN(allData.size());
            Algorithm.findLambdas();
            Algorithm.findMfcu(allData);
            Algorithm.findFcumin(allData);
            Algorithm.findSfcu(allData);

            // create a answer window
            AnswerWindow answerWindow = new AnswerWindow();
            answerWindow.display();
        } catch (Exception e) {
            alertBox.display("无法计算","请输入正确的值");
        }
    }

    public void showInfo() throws Exception {
        InfoWindow infoWindow = new InfoWindow();
        infoWindow.display();
    }

    public void showEquation() throws Exception {
        EquationWindow equationWindow = new EquationWindow();
        equationWindow.display();
    }
}
