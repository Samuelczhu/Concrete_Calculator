import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            window = primaryStage;
            window.setTitle("混凝土抗压强度计算器");
            //icon source: <div>Icons made by <a href="https://www.flaticon.com/authors/dimitry-miroliubov" title="Dimitry Miroliubov">Dimitry Miroliubov</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
            Image image = new Image("calculator.png");
            window.getIcons().add(image);

            Parent root = FXMLLoader.load(getClass().getResource("mainLayout.fxml"));
            Scene scene = new Scene(root, 700, 500);
            window.setScene(scene);
            window.show();
        } catch (Exception e) {
            alertBox.display("错误","运行错误");
        }
    }
}
