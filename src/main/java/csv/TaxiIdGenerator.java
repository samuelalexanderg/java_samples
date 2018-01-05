package csv;

import org.apache.commons.io.IOUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by sam on 3/2/17.
 */
public class TaxiIdGenerator {
    private static int NO_OF_ADVERTISER = 100;
    private static int NO_OF_AD = 4;
    private static int NO_OF_TAXI_ID = 5;

    public static void main(String args[]) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < NO_OF_ADVERTISER; i++) {
            String advertiserId = UUID.randomUUID().toString();
            for (int j = 0; j < NO_OF_AD; j++) {
                String adId = UUID.randomUUID().toString();
                for (int k = 0; k < NO_OF_TAXI_ID; k++) {
                    String taxiId = UUID.randomUUID().toString();
                    sb.append(taxiId).append(",").append(adId).append(",").append(advertiserId).append("\n");
                }
            }
        }

        FileOutputStream fos = new FileOutputStream("/home/sam/Downloads/ad_tables_1.csv");
        IOUtils.write(sb.toString().getBytes(), fos);
        fos.close();
    }
}
