package juniortest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Test. Ways to fill a tank. Yopsel Mopsel.
 * Main class.
 *
 * @author Slava Poliakov
 * @version 1.00 2017-12-12
 */


public class Main extends Application {

    private Pane root;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Controller controller = new Controller();
        root=controller.getRoot();

        primaryStage.setTitle("Slava Poliakov test program. Yopsel Mopsel");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
