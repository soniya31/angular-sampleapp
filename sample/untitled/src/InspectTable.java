import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
public class InspectTable {

    public static void main(String arg[]) {
        String filepath = baseDir + "/output" + i + "/report/all.metric.json";

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = new JSONArray();
        Object object;
        Timestamp timestamp = new Timestamp(new Date().getTime());
        object = jsonParser.parse(new FileReader(filepath));
        JSONArray obj = (JSONArray) object;
        Iterator<JSONObject> itr = obj.iterator();
        while (itr.hasNext()) {
            JSONObject jsonObject = itr.next();
            String filename = (String) jsonObject.get("fileName");
            JSONObject metric = (JSONObject) jsonObject.get("metric");
            JSONObject metrics = (JSONObject) metric.get("metrics");
            for (String block : blockList) {
                JSONObject blockObj = (JSONObject) metrics.get(block);

            }
}
