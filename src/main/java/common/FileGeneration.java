package common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FileGeneration {

    public ArrayList<HashMap<String, String>> readCscFile(String path) {

        String[] headers;
        String line;
        ArrayList<HashMap<String, String>> listData = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            headers = br.readLine().split(",");
            while ((line = br.readLine()) !=null){
                HashMap<String, String> data = new HashMap<>();
                String[] row = line.split(",");
                for (int i = 0; i < headers.length; i++) {
                    data.put(headers[i], row[i]);
                }
                listData.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return listData;
    }

}
