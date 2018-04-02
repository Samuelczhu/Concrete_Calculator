import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AnswerWindow {

    public void display() throws Exception {
        if (Algorithm.getN()>=10) {
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("混凝土抗压强度计算结果");
            //icon source: <div>Icons made by <a href="https://www.flaticon.com/authors/smashicons" title="Smashicons">Smashicons</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
            Image image = new Image("answer.png");
            window.getIcons().add(image);

            Parent root = FXMLLoader.load(getClass().getResource("answerWindowLayout.fxml"));
            Scene scene = new Scene(root, 500, 350);
            window.setScene(scene);
            window.show();
        } else {
            alertBox.display("数据不足","请输入10组以上的数据");
        }
    }
}
