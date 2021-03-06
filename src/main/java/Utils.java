import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Utils {

    private static HashMap<String, String> codes = new HashMap<>();

    public static String getCountry(String code) throws IOException {
        if (code != null && !code.equals("")) {
            if (codes.isEmpty()) {
                try (CSVReader csvReader = new CSVReader(new InputStreamReader(Utils.class.getClassLoader().getResourceAsStream("country-codes.csv")))) {
                    String[] values = csvReader.readNext();
                    while (values != null) {
                        codes.put(values[1], values[0]);
                        values = csvReader.readNext();
                    }
                }
            }

            return codes.get(code.toUpperCase());
        } else {
            return null;
        }
    }
}
