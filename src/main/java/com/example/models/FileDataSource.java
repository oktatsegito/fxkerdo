package com.example.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileDataSource implements DataSource {
    private final String filePath;

    public FileDataSource(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<RecordDto> readData() {
        try {
            return tryReadData();
        } catch (FileNotFoundException e) {
            return List.of();
        }
    }
    private List<RecordDto> tryReadData() throws FileNotFoundException {
        List<RecordDto> records = new ArrayList<>();
        File file = new File(filePath);
        try(Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                if(parts.length >= 7) {
                    String id = parts[0];
                    String question = parts[1];
                    String answer1 = parts[2];
                    String answer2 = parts[3];
                    String answer3 = parts[4];
                    String answer4 = parts[5];
                    String correctAnswer = parts[6];
                    
                    RecordDto record = new RecordDto();
                    record.setId(id);
                    record.setQuestion(question);
                    record.setAnswer1(answer1);
                    record.setAnswer2(answer2);
                    record.setAnswer3(answer3);
                    record.setAnswer4(answer4);
                    record.setCorrectAnswer(correctAnswer);
                    
                    records.add(record);
                }
            }            
        }
        return records;
    }
    
}
