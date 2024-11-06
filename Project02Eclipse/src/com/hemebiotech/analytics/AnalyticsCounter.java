package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {

  ReadSymptomDataFromFile readSymptomDataFromFile = new ReadSymptomDataFromFile();

  public List<String> reading(String file) {
    return readSymptomDataFromFile.getSymptoms(file);
  }

  public Map<String, Integer> analysing(List<String> symptoms) {
    return readSymptomDataFromFile.getSymptomsWithAssociatedNumbers(symptoms);
  }

  public void writing(Map<String, Integer> mapSymptomsWithAssociatedNumbers) throws IOException {
    readSymptomDataFromFile.writeSymptomsWithAssociatedNumbers(mapSymptomsWithAssociatedNumbers);
  }

}
