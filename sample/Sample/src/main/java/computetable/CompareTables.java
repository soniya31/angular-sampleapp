package computetable;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CompareTables {
    public static void main(String arg[]) throws IOException, ParseException {

        String DBTableFile = "C:\\Users\\hug76386\\Desktop\\TableTesting\\DBWithTable";// count 289
        String jsonTableFile = "C:\\Users\\hug76386\\Desktop\\TableTesting\\TableFiles"; //count 111

        String dbFiles="C:\\Users\\hug76386\\Desktop\\TableTesting\\TotalFilesinDB";
        String jsonFile="C:\\Users\\hug76386\\Desktop\\TableTesting\\TotalFiles";


        ArrayList<String> DB = CompareTables.readTableFromFile(DBTableFile);
        ArrayList<String> json = CompareTables.readTableFromFile(jsonTableFile);
        ArrayList<String> totalDBFiles = CompareTables.readTableFromFile(dbFiles);
        ArrayList<String> totalJson = CompareTables.readTableFromFile(jsonFile);
        ArrayList<String> modify = new ArrayList<String>();
        for (int i = 0; i < totalDBFiles.size(); i++) {
            if (totalJson.contains(totalDBFiles.get(i))) {

            } else {

                modify.add(totalDBFiles.get(i));
            }
        }

        System.out.println(modify.size());
        CompareTables.writeTableToFile(modify,null);
        // CompareTables.printArray(DB);
        //CompareTables.printArray(json);
/*

        Set<String> fileNeedToRemove = new HashSet<String>(DB);
        Set<String> fileNeedToAdd = new HashSet<String>();


        for (int i = 0; i < json.size(); i++) {
            if (fileNeedToRemove.contains(json.get(i))) {
                fileNeedToRemove.remove(json.get(i));
            } else {

                fileNeedToAdd.add(json.get(i));
            }
        }
int count=0;
        for (int i = 0; i < json.size(); i++) {
            if (totalDBFiles.contains(json.get(i))) {
                totalDBFiles.remove(json.get(i));
                count++;
            }
            else{
                System.out.println(json.get(i));
            }
        }
        System.out.println("count"+count);
        CompareTables.writeTableToFile(json,totalDBFiles);
        //System.out.println("here i am"+fileNeedToAdd.removeAll(fileNeedToRemove));
        System.out.println("count 0f file remove:" + fileNeedToRemove.size());
        System.out.println("count 0f add count :" + fileNeedToAdd.size());
*/
        //CompareTables.printArray(diff);
    }

    public static ArrayList<String> readTableFromFile(String fileLoc) throws FileNotFoundException {
        BufferedReader br;
        String thisLine = null;
        ArrayList<String> al = new ArrayList<String>();
        try {
            br = new BufferedReader(new FileReader(fileLoc));
            while ((thisLine = br.readLine()) != null) {
                al.add(thisLine);
            }

        } catch (IOException e) {

        } catch (Exception e) {

        }
        return al;
    }

    public static void printArray(ArrayList<String> arr) {
        System.out.println("**********************************");
        Iterator<String> itr = arr.iterator();
        System.out.println("Files need to updated for Table details :" + arr.size());
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    public static void writeTableToFile(ArrayList<String> hs,ArrayList<String> withoutTable) throws FileNotFoundException {
        String csvFile = "C:\\Users\\hug76386\\Desktop\\TableTesting\\MinusOneCsvFile.txt";
        BufferedWriter br = null;


        File file = new File(csvFile);
        if (file.exists())

        {
            file.delete();
        }
        try {
            file.createNewFile();
            br = new BufferedWriter(new FileWriter(file));

            Iterator<String> withTable = hs.iterator();
            while (withTable.hasNext()) {
                String content = withTable.next() + ",-1";
                br.write(content);
                br.newLine();
            }
            //System.out.println("size of no"+withoutTable.size());
          /*  Iterator<String> noTable=withoutTable.iterator();
            while (noTable.hasNext()) {
                String content = noTable.next() + ",0";
                br.write(content);
                br.newLine();
            }*/

        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");

        } catch (IOException ex) {
            System.out.println("IOException");

        } catch (Exception ex) {
            System.out.println("Exception"+ ex);

        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                System.out.println("Exception" + ex);
            }
        }
    }

}