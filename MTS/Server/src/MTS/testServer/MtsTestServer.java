package MTS.testServer;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import javax.jws.WebService;

@WebService
public class MtsTestServer implements IContract {

    private IDataStorage dbStorage = new DbStorage();
    private IDataStorage fileStorage = new FileStorage();
    private ServerPrefs prefs;
    private ServerState serverState;
    private Logger logger;

    /**
     * Конструктор.
     */
    public MtsTestServer() {
        logger = initLogger();
        logger.info("Server started");
        serverState = new ServerState();
        serverState.setPaused(false).setClientRestartRequired(false).setActive(true);
    }

    @Override
    public String testMessage(String message) {
        logger.debug("request... "+message);
        return "Test passed:"+message;
    }

    @Override
    public void sendRecord(ApprovedRecord record) {

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