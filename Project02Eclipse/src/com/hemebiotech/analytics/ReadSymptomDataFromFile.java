package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

  private final String filepath;

  /**
   *
   * @param filepath a full or partial path to file with symptom strings in it,
   *                 one per line
   */
  public ReadSymptomDataFromFile(String filepath) {
    this.filepath = filepath;
  }

  @Override
  public List<String> getSymptoms(String filename) {
    List<String> result = new ArrayList<String>();

    if (filepath != null) {
      try {
        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line = reader.readLine();

        while (line != null) {
          result.add(line);
          line = reader.readLine();
        }
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return result;
  }

  @Override
  public Map<String, Integer> getSymptomsWithAssociatedNumbers(List<String> symptoms) {
    Map<String, Integer> map = new TreeMap<String, Integer>();

    if (symptoms != null && !symptoms.isEmpty()) {
      Collections.sort(symptoms);

      for (String symptom : symptoms) {
        map.put(symptom, map.containsKey(symptom) ? map.get(symptom) + 1 : 1);
      }

    }
    return map;
  }

  @Override
  public void writeSymptomsWithAssociatedNumbers(Map<String, Integer> mapSymptomsWithAssociatedNumbers) throws IOException {

    String currentUsersHomeDir = System.getProperty("user.home");
    String path = currentUsersHomeDir + System.getProperty("file.separator") + "result.out";
    FileWriter writer = new FileWriter(path);
    if (mapSymptomsWithAssociatedNumbers != null && !mapSymptomsWithAssociatedNumbers.isEmpty()) {
      mapSymptomsWithAssociatedNumbers.forEach((symptom, key) -> {
        try {
          writer.write(symptom + "=" + key);
          writer.write(System.getProperty("line.separator"));
        } catch (IOException e) {
          e.printStackTrace();
        }
      });

      writer.close();

    } else {
      writer.write("aucun symptome n'a été trouvé");
      writer.close();
    }
    System.out.println("le fichier de sortie se trouve: " + path);
  }
}
