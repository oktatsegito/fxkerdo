package com.example.models;

import java.util.List;

public interface DataSource {
    List<RecordDto> readData();
}
