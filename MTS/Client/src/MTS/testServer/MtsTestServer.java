
package MTS.testServer;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.7-b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MtsTestServer", targetNamespace = "http://testServer.MTS/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MtsTestServer {


    /**
     * 
     * @return
     *     returns MTS.testServer.ServerState
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "state", targetNamespace = "http://testServer.MTS/", className = "MTS.testServer.State")
    @ResponseWrapper(localName = "stateResponse", targetNamespace = "http://testServer.MTS/", className = "MTS.testServer.StateResponse")
    @Action(input = "http://testServer.MTS/MtsTestServer/stateRequest", output = "http://testServer.MTS/MtsTestServer/stateResponse")
    public ServerState state();

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "testMessage", targetNamespace = "http://testServer.MTS/", className = "MTS.testServer.TestMessage")
    @ResponseWrapper(localName = "testMessageResponse", targetNamespace = "http://testServer.MTS/", className = "MTS.testServer.TestMessageResponse")
    @Action(input = "http://testServer.MTS/MtsTestServer/testMessageRequest", output = "http://testServer.MTS/MtsTestServer/testMessageResponse")
    public String testMessage(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     */
    @WebMethod
    @RequestWrapper(localName = "sendRecord", targetNamespace = "http://testServer.MTS/", className = "MTS.testServer.SendRecord")
    @ResponseWrapper(localName = "sendRecordResponse", targetNamespace = "http://testServer.MTS/", className = "MTS.testServer.SendRecordResponse")
    @Action(input = "http://testServer.MTS/MtsTestServer/sendRecordRequest", output = "http://testServer.MTS/MtsTestServer/sendRecordResponse")
    public void sendRecord(
        @WebParam(name = "arg0", targetNamespace = "")
        List<String> arg0);

    /**
     * 
     */
    @WebMethod
    @RequestWrapper(localName = "restartComplete", targetNamespace = "http://testServer.MTS/", className = "MTS.testServer.RestartComplete")
    @ResponseWrapper(localName = "restartCompleteResponse", targetNamespace = "http://testServer.MTS/", className = "MTS.testServer.RestartCompleteResponse")
    @Action(input = "http://testServer.MTS/MtsTestServer/restartCompleteRequest", output = "http://testServer.MTS/MtsTestServer/restartCompleteResponse")
    public void restartComplete();

}
