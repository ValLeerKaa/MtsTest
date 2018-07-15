package MTS.testServer;


import org.apache.log4j.Logger;

public class AbstractDataStorage {
    protected Logger logger;

    public AbstractDataStorage(Logger logger) {
        this.logger = logger;
    }
}
