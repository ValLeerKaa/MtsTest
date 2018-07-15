package MTS.testServer;

import org.apache.log4j.Logger;

import java.util.List;


public class DbStorage extends AbstractDataStorage implements IDataStorage {
    public DbStorage(Logger logger) {
        super(logger);
    }

    @Override
    public void saveFields(List<String> record) {
        logger.debug("Запись в БД");
    }
}
