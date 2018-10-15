package collectionList;

import org.apache.commons.collections.bag.SynchronizedSortedBag;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class parser {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();

        File file = new File("C:\\Users\\hug76386\\Desktop\\PM_Data\\jsondata");
        BufferedReader br = null;
        String jsonName;
        StringBuffer stringBuffer =new StringBuffer();
        try {
            br = new BufferedReader(new FileReader(file));


            while ((jsonName = br.readLine()) != null) {
                String fileName = jsonName.substring(0, jsonName.indexOf(".")) + ".pdf";
                System.out.println(fileName);
               // String jsonFormat = "{\"jsonFile\": \"" + jsonName + "\", \"form\": \"" + fileName + "\"},";
                //stringBuffer.append(jsonFormat);


            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        System.out.println(stringBuffer.toString());

    }
}