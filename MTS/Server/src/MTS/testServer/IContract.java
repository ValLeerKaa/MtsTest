package MTS.testServer;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;


@WebService public interface IContract {
    @WebMethod String testMessage(@WebParam(name = "message") String message);
    @WebMethod void sendRecord(List<String> record);
    @WebMethod ServerState state();
    @WebMethod void restartComplete();
}
