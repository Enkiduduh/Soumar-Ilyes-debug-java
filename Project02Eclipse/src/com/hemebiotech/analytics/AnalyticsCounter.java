package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AnalyticsCounter {
  private final ReadSymptomDataFromFile readSymptomDataFromFile;
  
  public AnalyticsCounter(String filepath) {
    this.readSymptomDataFromFile = new ReadSymptomDataFromFile(filepath);
  }
  public List<String> reading(String filepath) {
    return readSymptomDataFromFile.getSymptoms(filepath);
  }

  public Map<String, Integer> analysing(List<String> symptoms) {
    return readSymptomDataFromFile.getSymptomsWithAssociatedNumbers(symptoms);
  }

  public void writing(Map<String, Integer> mapSymptomsWithAssociatedNumbers) throws IOException {
    readSymptomDataFromFile.writeSymptomsWithAssociatedNumbers(mapSymptomsWithAssociatedNumbers);
  }

}
