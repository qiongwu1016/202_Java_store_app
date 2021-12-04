package com.store.app;

import java.io.IOException;

public class App {
      static String CARDS_FILE = "./src/main/resources/Cards - Sheet1.csv";
      static String  INPUT_FILE = "./src/main/resources/Input1 - Sheet1.csv";
      static String DATASET_FILE = "./src/main/resources/Dataset - Sheet1.csv";
      static String OUTPUT_FILE_PATH = "./output/";

      //set cap on the quantity of each category that can be ordered in one single order. 
      static Integer ESSENTIAL_CAP = 5;
      static Integer LUXURY_CAP = 3;
      static Integer MISC_CAP = 6;
  public static void main(String[] args) throws IOException {
  
    //

    //Read cards input file and store the card numbers in Database: [String] cards
    CardFileReader.read(CARDS_FILE, ",");

    //Read Dataset input file and store the inventory data in Database: [Item] items
    DatasetFileReader.read(DATASET_FILE, ",");

    //Read input file and create an Order object.
    Order order = OrderFileReader.read(INPUT_FILE, ",");

    //process the order
    order.process();
 
    
    

    

    

  }
}

