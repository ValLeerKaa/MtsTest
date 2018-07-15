package MTS.testServer;
import javax.jws.WebService;

@WebService
public class MtsTestServer implements IContract {

    private IDataStorage dbStorage = new DbStorage();
    private IDataStorage fileStorage = new FileStorage();

    public MtsTestServer() {
        System.out.println("Server started.");
    }

    @Override
    public String testMessage(String message) {
        System.out.println("request... "+message);
        return "Test:"+message;
    }

    @Override
    public void sendRecord(ApprovedRecord record) {

    }

    @Override
    public ServerState state() {
        return null;
    }
}