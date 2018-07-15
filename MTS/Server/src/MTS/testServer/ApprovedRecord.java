package MTS.testServer;

import java.util.ArrayList;
import java.util.List;

public class ApprovedRecord {
    private List<String> record;
    public List<String> getRecord()
    {
        return record;
    };

    public void addField(String field)
    {
        record.add(field);
    }

}
