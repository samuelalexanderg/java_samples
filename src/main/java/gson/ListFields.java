package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sam on 1/6/17.
 */
public class ListFields {
    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtils.readLines(new File("/home/sam/work/projects/s/reddit/output.json"));

        Gson gson = new GsonBuilder().create();
        int count = 0;
        for (int i = 1; i <= lines.size(); i++ ) {
            String json = lines.get(i - 1);
            Map<String, String> event = new HashMap<>();
            event.putAll(gson.fromJson(json, Map.class));
            if (event.size() > count) {
                count = event.size();
                System.out.println(i + " - " + count);
            }
        }

//        System.out.println(event.keySet());
    }
}
