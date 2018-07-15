package MTS.testServer;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.jws.WebService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebService
public class MtsTestServer implements IContract {

    private ServerPrefs prefs;
    private ServerState serverState;
    private Logger logger;

    private Set<IDataStorage> storages = new HashSet<>();

    /**
     * Конструктор.
     */
    public MtsTestServer() {
        logger = initLogger();
        logger.info("Server started");
        serverState = new ServerState();
        serverState.setPaused(false).setClientRestartRequired(false).setActive(true);

        storages.add(new DbStorage(logger));
        storages.add(new FileStorage(logger));
    }

    @Override
    public String testMessage(String message) {
        logger.debug("request... "+message);
        return "Test passed:"+message;
    }

    @Override
    public void sendRecord(List<String> record) {
        logger.debug("Принята строка от клиента, сохранение...");
        for (IDataStorage storage : storages)
            storage.saveFields(record);
    }

    @Override
    public ServerState state() {
        return serverState;
    }

    @Override
    public void restartComplete() {
        serverState.setClientRestartRequired(false);
    }

    private Logger initLogger()
    {
        Logger logger = Logger.getLogger(MtsTestServer.class);
        prefs = new ServerPrefs();
        PropertyConfigurator.configure(prefs.getLogPath());
        return logger;
    }
}