package com.store.app;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class DatasetFileReader {

    public static void read(String filePath, String splitBy) throws IOException {

        String line = "";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        Database db = Database.getInstance();
        try {
            //parsing a CSV file into BufferedReader class constructor  
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] row = line.split(splitBy);
                
                Item thisItem = new Item(row[1], Integer.valueOf(row[2]), Float.valueOf(row[3]));
                thisItem.setCategory(row[0]);
                db.addItem(thisItem);
            }
            br.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            br.close();
        }
    }
        
}

