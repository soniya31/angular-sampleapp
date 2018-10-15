package computetable;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;

public class SAmple {

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
        while (itr.hasNext()) {
            JSONObject jsonObject = itr.next();
            String filename = (String) jsonObject.get("fileName");
            fileArrList.add(filename);

            fileNameCount++;
            JSONObject metric = (JSONObject) jsonObject.get("metric");
            JSONObject metrics = (JSONObject) metric.get("metrics");
            JSONObject blockObj = (JSONObject) metrics.get("Table");
            if (blockObj != null) {
                JSONObject jsonObjPr = (JSONObject) blockObj.get("pr");
                long e = (Long)jsonObjPr.get("e");
                if(e!=0)
                {
                    count++;
                    arrayList.add(filename);
                }

            }
        }
        System.out.println("Total file Count:" + fileArrList.size());
        System.out.println("File With Table Count:" + arrayList.size());
        Collections.sort(arrayList);
        Collections.sort(fileArrList);
        System.out.println("#####################################################");

        Iterator<String> itrFil = fileArrList.iterator();
        while (itrFil.hasNext()) {
            System.out.println(itrFil.next());
        }

        System.out.println("#####################################################");

        Iterator<String> itre = arrayList.iterator();
        while (itre.hasNext()) {
            System.out.println(itre.next());
        }
        ArrayList<String> nontable = new ArrayList<String>(fileArrList);
        for (int i = 0; i < arrayList.size(); i++) {
            if (nontable.contains(arrayList.get(i))) {
                nontable.remove(arrayList.get(i));
            }
        }
        System.out.println("#####################################################");

        Iterator<String> nonTableItr = nontable.iterator();
        System.out.println("Non Table Count :" + nontable.size());
        while (nonTableItr.hasNext()) {
            System.out.println(nonTableItr.next());
        }


    }


}
