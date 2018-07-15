package MTS.Common;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class CsvProcessor {
    private static Preferences preferences;

    static final String DEFAULT_FORMAT = "excel";
    static final String DEFAULT_DELIMITER = ";";

    public CsvProcessor() {
        preferences = Preferences.userNodeForPackage(CsvProcessor.class);
        try {
            if (new File("csv_preferences.xml").exists()) {
                importPrefs();
            } else
                initPreferences();
        }
        catch (Exception exc) {
            System.out.println("Cannot load or initialize scv_prefs, exiting");
            System.exit(-1);
        }
    }

    private void importPrefs() throws Exception{
        InputStream is = new BufferedInputStream(new FileInputStream("csv_preferences.xml"));
        preferences.importPreferences(is);
        is.close();
        preferences.flush();
    }

    private void initPreferences() throws Exception{
        if (preferences==null) throw new Exception("no prefs");
        preferences.put("format",       DEFAULT_FORMAT);
        preferences.put("delimiter",    DEFAULT_DELIMITER);

        exportPrefs();
    }

    private void exportPrefs() throws IOException, BackingStoreException {
        preferences.exportSubtree(new BufferedOutputStream(
                new FileOutputStream("csv_preferences.xml")));
    }

    static public List<List<String>> readCsv (File file, int[] fields) throws Exception
    {
        List<List<String>> result = new ArrayList<>();

        Iterable<CSVRecord> records;
        try (Reader in = new FileReader(file.getAbsolutePath())) {
            String key = preferences.get("format","excel").toUpperCase();
            char delimiter = preferences.get("delimiter", ";").charAt(0);
            switch (key) {
                case "EXCEL" : records = CSVFormat.EXCEL.withDelimiter(delimiter).parse(in); break;
                case "MYSQL" : records = CSVFormat.MYSQL.withDelimiter(delimiter).parse(in); break;
                case "RFC-4180": records = CSVFormat.RFC4180.withDelimiter(delimiter).parse(in); break;
                default: records = CSVFormat.EXCEL.withDelimiter(';').parse(in);
            }
            for (CSVRecord record : records)
            {
                List<String> str = new ArrayList<>();
                for (int i = 0; i<fields.length; i++)
                    str.add(record.get(fields[i]));
                result.add(str);
            }

        }
        return result;
    }
}
