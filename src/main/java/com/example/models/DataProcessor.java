package com.example.models;

import java.util.List;

public class DataProcessor {
    private final DataSource dataSource;
    
    public DataProcessor(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void process() {
        List<RecordDto> records = dataSource.readData();
        records.forEach(System.out::println);
    }
}
