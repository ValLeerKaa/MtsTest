package MTS.testServer;

import java.io.*;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class ServerPrefs {
    private static Preferences preferences;

    static final String DEFAULT_LOG_PROPERTIES = "d://java//mtsserver//logs//log4j.properties";

    public ServerPrefs() {
        preferences = Preferences.userNodeForPackage(ServerPrefs.class);
        try {
            if (new File("server_preferences.xml").exists()) {
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
        InputStream is = new BufferedInputStream(new FileInputStream("server_preferences.xml"));
        preferences.importPreferences(is);
        is.close();
        preferences.flush();
    }

    private void initPreferences() throws Exception{
        if (preferences==null) throw new Exception("no prefs");
        exportPrefs();
    }

    private void exportPrefs() throws IOException, BackingStoreException {
        preferences.exportSubtree(new BufferedOutputStream(
                new FileOutputStream("server_preferences.xml")));
    }

    public String getLogPath()
    {
        return (preferences.get("logPath", DEFAULT_LOG_PROPERTIES));
    }
}
