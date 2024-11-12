package com.hemebiotech.analytics;

import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class MainProgram {

  public static void main(String[] args) throws Exception {

    final String file = Paths.get("Project02Eclipse", "symptoms.txt").toAbsolutePath().toString();

    AnalyticsCounter analyticsCounter = new AnalyticsCounter(file);

    List<String> symptoms = analyticsCounter.reading(file);
    Map<String, Integer> mapSymptomsWithAssociatedNumbers = analyticsCounter.analysing(symptoms);
    analyticsCounter.writing(mapSymptomsWithAssociatedNumbers);

  }
}
