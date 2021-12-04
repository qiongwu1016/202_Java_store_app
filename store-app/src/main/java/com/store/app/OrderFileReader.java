package com.store.app;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class OrderFileReader {

    public static Order read(String filePath, String splitBy) throws IOException {

        String line = "";
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        Order thisOrder = new Order();
        try {
            //parsing a CSV file into BufferedReader class constructor  
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] row = line.split(splitBy);
                Request request = new Request(row[0], Integer.valueOf(row[1]), row[2]);
                thisOrder.addRequest(request);
            }
            br.close();
            return thisOrder;
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            br.close();
        }
        return thisOrder;
    }
        
}

