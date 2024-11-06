package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class AnalyticsCounter {
  private static int headacheCount = 0;
  private static int rashCount = 0;
  private static int pupilCount = 0;

  public static void main(String[] args) throws Exception {

    try (BufferedReader reader = new BufferedReader(new FileReader("symptoms.txt"))) {
      String line = reader.readLine();

      // int headCount = 0;
      while (line != null) {
        // System.out.println("symptom from file: " + line);
        if (line.equals("headache")) {
          headacheCount++;
          System.out.println("number of headaches: " + headacheCount);
        } else if (line.equals("rash")) {
          rashCount++;
          System.out.println("number of rashs: " + rashCount);
        } else if (line.contains("pupils")) {
          pupilCount++;
          System.out.println("number of pupils: " + pupilCount);
        }

        line = reader.readLine();

        try (FileWriter writer = new FileWriter("result.out")) {
          writer.write("headache: " + headacheCount + "\n");
          writer.write("rash: " + rashCount + "\n");
          writer.write("dialated pupils: " + pupilCount + "\n");
        }
      }
      reader.close();
    }
  }
}
// Lire les données provenant d'un fichier
// @param => file
//@result => list of symptom

// analyser les données faire une liste des symptomes avec leur nombre associé
// @param => list of symptom
//@result => 

// Trier les données et les écrire dans un fichier result.out
// @param =>
//@result =>
