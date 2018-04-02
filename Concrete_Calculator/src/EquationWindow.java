import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class EquationWindow {

    // Formula information provided by my father

    @FXML private Button closeButton;

    public void display() throws Exception {
        Stage window = new Stage();
        window.setTitle("计算公式");
        //icon source: <div>Icons made by <a href="https://www.flaticon.com/authors/dimitry-miroliubov" title="Dimitry Miroliubov">Dimitry Miroliubov</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
        Image image = new Image("formula.png");
        window.getIcons().add(image);

        Parent root = FXMLLoader.load(getClass().getResource("equationWindowLayout.fxml"));
        Scene scene = new Scene(root, 500, 350);
        window.setScene(scene);
        window.show();
    }

    public void back() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
