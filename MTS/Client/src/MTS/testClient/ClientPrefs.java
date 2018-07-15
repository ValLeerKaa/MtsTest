package MTS.testClient;

import MTS.Common.CsvProcessor;

import java.io.*;
import java.util.prefs.BackingStoreException;
import java.util.prefs.InvalidPreferencesFormatException;
import java.util.prefs.Preferences;

public class ClientPrefs {
    static final String DEFAULT_LOG_PROPERTIES = "d://java//mtsclient//logs//log4j.properties";
    static final String DEFAULT_MS_INTERVAL = "5000";
    static final String DEFAULT_WORK_DIRECTORY = "d://temp";
    static final String DEFAULT_FILE_PATTERN = ".csv";
    static final String DEFAULT_FIELDS_SEPARATED_BY_COMMA = "ALL;";

    private static Preferences preferences;

    public ClientPrefs()
    {
        preferences = Preferences.userNodeForPackage(ClientPrefs.class);
        try {
            if (new File("preferences.xml").exists()) {
                importPrefs();
            } else
                initPreferences();
        }
        catch (Exception exc) {
            System.out.println("Cannot load or initialize prefs, exiting");
            System.exit(-1);
        }
    }

    private void importPrefs() throws Exception{
        InputStream is = new BufferedInputStream(new FileInputStream("preferences.xml"));
        preferences.importPreferences(is);
        is.close();
        preferences.flush();
    }

    /**
     * Установка начальных значений.
     * @throws Exception
     */
    private void initPreferences() throws Exception{
        if (preferences==null) throw new Exception("no prefs");
        preferences.put("logPath", DEFAULT_LOG_PROPERTIES);
        preferences.put("interval", DEFAULT_MS_INTERVAL);
        preferences.put("workDir", DEFAULT_WORK_DIRECTORY);
        preferences.put("fileMask", DEFAULT_FILE_PATTERN);
        preferences.put("fields", DEFAULT_FIELDS_SEPARATED_BY_COMMA);

        exportPrefs();
    }

    private void exportPrefs() throws IOException, BackingStoreException {
        preferences.exportSubtree(new BufferedOutputStream(
                 new FileOutputStream("preferences.xml")));
    }

    public String getLogPath()
    {
        return (preferences.get("logPath", DEFAULT_LOG_PROPERTIES));
    }

    public int getInterval()
    {
        return Integer.valueOf(preferences.get("interval", "5000"));
    }

    public String getWorkDirectory() {
        return preferences.get("workDir", DEFAULT_WORK_DIRECTORY);
    }

    public String getFilePattern()
    {
        return preferences.get("fileMask", DEFAULT_FILE_PATTERN);
    }
    public String getFields()
    {
        return preferences.get("fields", DEFAULT_FIELDS_SEPARATED_BY_COMMA);
    }

}
