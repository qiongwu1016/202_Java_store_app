package com.store.app;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class CardFileReader {

    public static void read(String filePath, String splitBy) throws IOException {

        String line = "";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        Database db = Database.getInstance();
        try {
            //parsing a CSV file into BufferedReader class constructor  
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] row = line.split(splitBy);
                String cardNumber = row[0];
                db.addCard(cardNumber);
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

