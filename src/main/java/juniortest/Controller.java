package juniortest;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import java.util.Random;

/**
 * Test. Ways to fill a tank. Yopsel Mopsel.
 * Controller class.
 *
 * @author Slava Poliakov
 * @version 1.00 2017-12-12
 */


public class Controller {
    private Pane root;
    private Calculator calculator;
    private TextArea resultText;
    private Label titleLabel;
    private Label volumeLabel;
    private Label resultLabel;
    private TextField volumeField;
    private Button startButton;


    public Controller() {
        root = new Pane();
        calculator = new Calculator();
        setDataOnPane();
    }

    /**
     * Method to set data on Pane
     */
    private void setDataOnPane() {
        titleLabel = new Label("How many ways to fill a tank by 10, 5, 2 and 1 litres buckets?");
        titleLabel.setPrefSize(600, 30);
        titleLabel.relocate(0, 10);
        titleLabel.setAlignment(Pos.CENTER);


        volumeLabel = new Label("Input volume of tank from 10 to 200 litres or click CALCULATE to get randomly.");
        volumeLabel.setPrefSize(580, 30);
        volumeLabel.relocate(10, 40);
        volumeLabel.setAlignment(Pos.CENTER);

        volumeField = new TextField();
        volumeField.setPrefSize(100, 30);
        volumeField.relocate(195, 80);
        volumeField.setAlignment(Pos.CENTER);

        startButton = new Button("CALCULATE");
        startButton.setPrefSize(100, 30);
        startButton.relocate(305, 80);
        startButton.setAlignment(Pos.CENTER);
        startButton.setOnMouseClicked(event -> startCalculate());

        resultLabel = new Label();
        resultLabel.setPrefSize(580, 30);
        resultLabel.relocate(10, 120);
        resultLabel.setAlignment(Pos.CENTER);

        resultText = new TextArea();
        resultText.setPrefSize(590, 440);
        resultText.relocate(10, 160);
        resultText.selectPositionCaret(resultText.getLength());
        resultText.deselect();

        root.getChildren().addAll(titleLabel, volumeLabel, volumeField, startButton, resultLabel, resultText);
    }

    /**
     * Method to check input data from user, to calculate and show result
     */
    private void startCalculate() {
        // validating input data
        int volume = 0;
        try {
            String inputData = volumeField.getText();
            volume = inputData.equals("") ? (new Random().nextInt(191) + 10) : Integer.parseInt(inputData);
            if (volume < 10 || volume > 200) {
                throw new NumberFormatException();
            }
            calculator.calculateWays(volume);

            // show results
            if (volume != 0) {
                resultLabel.setText(String.format("Tank volume: %d litres; Possible ways: %d", volume, calculator.getWaysNumber()));
                String waysText = "";
                int size = calculator.getWaysSet().size();
                for (int i = size; i > 0; i--) {
                    waysText += String.format("%5d. ", (size - i + 1)) + calculator.getWaysSet().get(i - 1) + "\n";
                }

                waysText += "\nYOPSEL MOPSEL! IT'S WORKING!!!";

                resultText.setText(waysText);

            }



        } catch (NumberFormatException e) {
            resultLabel.setText("WRONG INPUT DATA!!! It should be integer from 10 to 200. Try again...");
        }

    }

    public Pane getRoot() {
        return root;
    }

}
