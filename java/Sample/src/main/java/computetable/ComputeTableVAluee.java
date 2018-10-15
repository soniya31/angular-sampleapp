package computetable;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ComputeTableVAluee {

    public static void main(String arg[]) throws IOException, ParseException {
        String filepath = "C:\\Users\\hug76386\\Desktop\\Flamingo-AllMetric";
//String filepath="C:\\Users\\hug76386\\Downloads\\all.metric (6).json";
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = new JSONArray();
        Object object;
        int fileNameCount = 0;
        int count = 0;
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> fileArrList = new ArrayList<String>();
        Timestamp timestamp = new Timestamp(new Date().getTime());
        object = jsonParser.parse(new FileReader(filepath));
        JSONArray obj = (JSONArray) object;
        Iterator<JSONObject> itr = obj.iterator();
        HashMap<String, Long> hashmap = new HashMap<String, Long>();
        while (itr.hasNext()) {
            JSONObject jsonLong = itr.next();
            String filename = (String) jsonLong.get("fileName");


            fileNameCount++;
            JSONObject metric = (JSONObject) jsonLong.get("metric");
            JSONObject metrics = (JSONObject) metric.get("metrics");
            JSONObject blockObj = (JSONObject) metrics.get("Table");
            if (blockObj != null) {
                JSONObject jsonObjPr = (JSONObject) blockObj.get("pr");
                Long e = (Long) jsonObjPr.get("e");
                if (e > 0) {
                    hashmap.put(filename, e);
                    fileArrList.add(filename);

                }
                else
                {
                    //zero e list
                    arrayList.add(filename);
                }

            }
        }
        System.out.println("hhvgh" + fileArrList.size());
        ComputeTableVAluee.writeTableToFile(fileArrList);
      /*  HashMap<String, Long> sortedHashmap = ComputeTableVAluee.sortByComparator(hashmap);
        Set<Map.Entry<String, Long>> set = sortedHashmap.entrySet();
        Iterator<Map.Entry<String, Long>> itr1 = set.iterator();
        while (itr1.hasNext()) {
            Map.Entry<String, Long> m = itr1.next();
            System.out.println(m.getKey() + "  -  " + m.getValue());
        }
        System.out.println("Total file Count:" + fileArrList.size());
        System.out.println("File With Table Count:" + hashmap.size());*/

    }

    private static LinkedHashMap<String, Long> sortByComparator(Map<String, Long> unsortMap) {
        List<Map.Entry<String, Long>> list = new ArrayList<Map.Entry<String, Long>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        LinkedHashMap<String, Long> sortedMap = new LinkedHashMap<String, Long>();
        for (Map.Entry<String, Long> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static void writeTableToFile(ArrayList<String> hs) throws FileNotFoundException {
        String csvFile = "C:\\Users\\hug76386\\Desktop\\TableTesting\\ValidationcsvFile.txt";
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
                String content = withTable.next() + ",1";
                br.write(content);
                br.newLine();
            }

        } catch (FileNotFoundException ex) {
            System.out.println("File Not Found");

        } catch (IOException ex) {
            System.out.println("IOException");

        } catch (Exception ex) {
            System.out.println("Exception");

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
