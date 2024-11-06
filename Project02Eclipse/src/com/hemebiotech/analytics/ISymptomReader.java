package com.hemebiotech.analytics;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Anything that will read symptom data from a source
 * The important part is, the return value from the operation, which is a list
 * of strings,
 * that may contain many duplications
 *
 * The implementation does not need to order the list
 *
 */
public interface ISymptomReader {
  /**
   * transform a file into a list of symptoms
   *
   * @param a file with a list of symptoms as data source
   *
   * @return a raw listing of all Symptoms obtained from a data source, duplicates
   *         are possible/probable
   */
  List<String> GetSymptoms(String filename);

  /**
   * get symptoms with associated number of times from a list of symptoms
   *
   * @param list of symptoms
   *
   * @return a collection of symptoms with their associated number of times
   */
  public Map<String, Integer> GetSymptomsWithAssociatedNumbers(List<String> symptoms);

  /**
   * write a file from map list of symptoms with associated number of times
   *
   * @param a collection of symptoms with their associated number of times
   *
   * @return a file with a sorted listed of symptoms with their associated number
   *         of times
   */
  void writeSymptomsWithAssociatedNumbers(Map<String, Integer> mapSymptomsWithAssociatedNumbers) throws IOException;
}

// Lire les données provenant d'un fichier
// @param => file
// @result => list of symptom

// analyser les données faire une liste des symptomes avec leur nombre associé
// @param => list of symptom
// @result =>

// Trier les données et les écrire dans un fichier result.out
// @param =>
// @result =>
