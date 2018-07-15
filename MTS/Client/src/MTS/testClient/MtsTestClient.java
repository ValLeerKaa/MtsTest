package MTS.testClient;

import MTS.testServer.MtsTestServer;
import MTS.testServer.MtsTestServerService;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class MtsTestClient
{

    static private ClientPrefs prefs;
    static MtsTestServer service;
    static Set<File> dirSet;
    static Logger logger;

    public static void main(String[] argv) {
        try {
            logger = initLogger();
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
            return;
        }

        logger.info("Client starting");

        try {
            service = new MtsTestServerService().getMtsTestServerPort();
        }
        catch (Exception exc)
        {
            logger.fatal("Seems no server available, exiting");
            return;
        }
        try
        {
            TimerTask tt = new TimerTask()
            {
                @Override
                public void run()
                {
                    try
                    {
                        logger.debug("-=STARTING CYCLE=-");
                        // Основной цикл.
                        if (service.state().isActive()&&!service.state().isPaused())
                            doClientJob();
                        logger.debug("-=CYCLE ENDS=-");
                    }
                    catch (Exception exc)
                    {
                        logger.error(exc.getMessage());
                    }
                }
            };

            Timer timer = new Timer();
            timer.scheduleAtFixedRate(tt,0, prefs.getInterval());
            // Зациклить.
            while (true);
        }
        catch (Exception exc)
        {
            logger.fatal(exc.getStackTrace());
        }
    }

    /**
     * Основная работа.
     */
    private static void doClientJob() {
        // Первый запуск, "новые" файлы не определены. Альтернативой является хранение состояния в файле и первоначальная
        // сверка с имевшимся слепком, но это ведет к добавлению флага в настройках "начинать с чистого листа
        // или пользоваться конфигом", я такое писал недавно для практических нужд у клиента, но в данном тестовом
        // задании предпочту не усложнять.
        if (dirSet==null)
        {
            logger.debug("Preparing file list");
            dirSet = new HashSet<>();
            searchFiles(new File(prefs.getWorkDirectory()));
        }
    }

    private static void searchFiles(File dir)
    {
        File[] allFiles = dir.listFiles(new FilenameFilter() {
            @Override
            // Здесь наверняка можно поиграться с RegEx, но для даной задачи сведем все к принципу "содержит".
            // На дефолтной настройке (".csv") позволит в частности выбирать в том числе файлы с расширением .CSV,
            // ъотя очевидно, что не только - скажем, файл somename.csv.txt тоже подпадет. Но у нас вроде есть фильтр
            // для "непонятных" файлов...
            public boolean accept(File dir, String name) {
                return name.contains(prefs.getFilePattern());
            }
        });
        for (File file: allFiles)
        {
            if (file.isDirectory())
            {
                searchFiles(dir);
                continue;
            }
            if (dirSet.add(file))
            {

            }
        }

    }

    private static Logger initLogger()
    {
        Logger logger = Logger.getLogger(MtsTestClient.class);
        prefs = new ClientPrefs();
        PropertyConfigurator.configure(prefs.getLogPath());
        return logger;
    }
}
