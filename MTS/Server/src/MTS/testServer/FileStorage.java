package MTS.testServer;

import org.apache.log4j.Logger;

import java.util.List;


public class FileStorage extends AbstractDataStorage implements IDataStorage {
    public FileStorage(Logger logger) {
        super(logger);
    }

    @Override
    public void saveFields(List<String> record) {
        logger.debug("Запись в .csv - файл");
    }
}
