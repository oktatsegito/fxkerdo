package com.example;

import java.util.List;

import com.example.models.FileDataSource;
import com.example.models.RecordDto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class MainController {

    @FXML
    private TextField actualField;

    @FXML
    private RadioButton answer1;

    @FXML
    private RadioButton answer2;

    @FXML
    private RadioButton answer3;

    @FXML
    private RadioButton answer4;

    @FXML
    private ToggleGroup answers;

    @FXML
    private TextField questionField;

    private List<RecordDto> records;
    private int index = 0;

    @FXML
    void initialize() {
        System.out.println("initialize...");

        records = new FileDataSource("data.csv").readData();

        loadTask(0);
    }

    void loadTask(int index) {
        RecordDto record = records.get(index);
        actualField.setText(record.getId());
        questionField.setText(record.getQuestion());        
        answer1.setText(record.getAnswer1());
        answer2.setText(record.getAnswer2());
        answer3.setText(record.getAnswer3());
        answer4.setText(record.getAnswer4());
    }

    @FXML
    void onClickNextButton(ActionEvent event) {
        System.out.println("Következő...");
        if (index < records.size() - 1) {
            index++;
            loadTask(index);
        }
    }

}
