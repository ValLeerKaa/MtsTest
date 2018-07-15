package MTS.testClient;

import MTS.Common.CsvProcessor;
import MTS.testServer.MtsTestServer;
import MTS.testServer.MtsTestServerService;
import org.apache.commons.csv.CSVRecord;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.io.FilenameFilter;
import java.util.*;

public class MtsTestClient
{

    static private ClientPrefs prefs;
    static MtsTestServer service;
    static Set<File> currentFilesSet ;
    static Logger logger;
    static Set <File> newFiles = new HashSet<>();
    static CsvProcessor processor = new CsvProcessor();
    static int[] fields;

    public static void main(String[] argv) {
        initPrefs();
        try {
            logger = initLogger();
        }
        catch (Exception exc)
        {
            exc.printStackTrace();
            return;
        }

        logger.info("Client starting");
        initFields();

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
                        if (service.state().isClientRestartRequired())
                            restart();
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

    static private void restart() {
        logger.info("Client restart imminent");
        initPrefs();
        initFields();
        service.restartComplete();
    }

    private static void initFields() {
        String[] fieldsStr = prefs.getFields().split(";");
        fields = new int[fieldsStr.length];
        for (int i=0; i<fields.length;i++)
            fields[i] = Integer.valueOf(fieldsStr[i]);
    }

    /**
     * Основная работа.
     */
    private static void doClientJob() {
        // Первый запуск, "новые" файлы не определены. Альтернативой является хранение состояния в файле и первоначальная
        // сверка с имевшимся слепком, но это ведет к добавлению флага в настройках "начинать с чистого листа
        // или пользоваться конфигом", я такое писал недавно для практических нужд у клиента, но в данном тестовом
        // задании предпочту не усложнять.
        if (currentFilesSet ==null)
        {
            logger.debug("Preparing file list");
            currentFilesSet = new HashSet<>();
            newFilesSearch(new File(prefs.getWorkDirectory()));
            procesNewFiles();
            newFiles.clear();
        }
    }

    private static void procesNewFiles() {
        logger.debug("New files processing...");
        for (File newFile : newFiles)
        {
            try {
                List<List<String>> records = CsvProcessor.readCsv(newFile, fields);
                for (List<String> record : records)
                    service.sendRecord(record);
                moveToArchive(newFile);
            }
            catch (Exception exc)
            {
                moveToBad(newFile);
            }
        }
    }

    private static void moveToBad(File newFile) {
        logger.error("Ошибка обработки, перенос в необработанные "+newFile.getName());
    }

    private static void moveToArchive(File newFile) {
        logger.debug("Обработка успешна, перенос в архив:"+newFile.getName());
    }

    private static void newFilesSearch(File dir) {
        Set<File> tempSet = new HashSet<>();
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
        for (File file : allFiles) {
            if (file.isDirectory()) {
                newFilesSearch(dir);
                continue;
            }
            tempSet.add(file);
            // Файл "новый", т.е. ранее не засветился (или был стерт) и требует обработки.
            if (!currentFilesSet.contains(file)) {
                // Запоминаем его...
                newFiles.add(file);
            }
        }
        currentFilesSet = tempSet;
    }

    private static Logger initLogger()
    {
        Logger logger = Logger.getLogger(MtsTestClient.class);
        PropertyConfigurator.configure(prefs.getLogPath());
        return logger;
    }

    private static void initPrefs()
    {
        prefs = new ClientPrefs();
    }


}
