
package MTS.testServer;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the MTS.testServer package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RestartComplete_QNAME = new QName("http://testServer.MTS/", "restartComplete");
    private final static QName _SendRecordResponse_QNAME = new QName("http://testServer.MTS/", "sendRecordResponse");
    private final static QName _TestMessage_QNAME = new QName("http://testServer.MTS/", "testMessage");
    private final static QName _TestMessageResponse_QNAME = new QName("http://testServer.MTS/", "testMessageResponse");
    private final static QName _RestartCompleteResponse_QNAME = new QName("http://testServer.MTS/", "restartCompleteResponse");
    private final static QName _SendRecord_QNAME = new QName("http://testServer.MTS/", "sendRecord");
    private final static QName _State_QNAME = new QName("http://testServer.MTS/", "state");
    private final static QName _StateResponse_QNAME = new QName("http://testServer.MTS/", "stateResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: MTS.testServer
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RestartCompleteResponse }
     * 
     */
    public RestartCompleteResponse createRestartCompleteResponse() {
        return new RestartCompleteResponse();
    }

    /**
     * Create an instance of {@link SendRecord }
     * 
     */
    public SendRecord createSendRecord() {
        return new SendRecord();
    }

    /**
     * Create an instance of {@link TestMessage }
     * 
     */
    public TestMessage createTestMessage() {
        return new TestMessage();
    }

    /**
     * Create an instance of {@link TestMessageResponse }
     * 
     */
    public TestMessageResponse createTestMessageResponse() {
        return new TestMessageResponse();
    }

    /**
     * Create an instance of {@link SendRecordResponse }
     * 
     */
    public SendRecordResponse createSendRecordResponse() {
        return new SendRecordResponse();
    }

    /**
     * Create an instance of {@link RestartComplete }
     * 
     */
    public RestartComplete createRestartComplete() {
        return new RestartComplete();
    }

    /**
     * Create an instance of {@link StateResponse }
     * 
     */
    public StateResponse createStateResponse() {
        return new StateResponse();
    }

    /**
     * Create an instance of {@link State }
     * 
     */
    public State createState() {
        return new State();
    }

    /**
     * Create an instance of {@link ServerState }
     * 
     */
    public ServerState createServerState() {
        return new ServerState();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestartComplete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testServer.MTS/", name = "restartComplete")
    public JAXBElement<RestartComplete> createRestartComplete(RestartComplete value) {
        return new JAXBElement<RestartComplete>(_RestartComplete_QNAME, RestartComplete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendRecordResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testServer.MTS/", name = "sendRecordResponse")
    public JAXBElement<SendRecordResponse> createSendRecordResponse(SendRecordResponse value) {
        return new JAXBElement<SendRecordResponse>(_SendRecordResponse_QNAME, SendRecordResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestMessage }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testServer.MTS/", name = "testMessage")
    public JAXBElement<TestMessage> createTestMessage(TestMessage value) {
        return new JAXBElement<TestMessage>(_TestMessage_QNAME, TestMessage.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TestMessageResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testServer.MTS/", name = "testMessageResponse")
    public JAXBElement<TestMessageResponse> createTestMessageResponse(TestMessageResponse value) {
        return new JAXBElement<TestMessageResponse>(_TestMessageResponse_QNAME, TestMessageResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RestartCompleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testServer.MTS/", name = "restartCompleteResponse")
    public JAXBElement<RestartCompleteResponse> createRestartCompleteResponse(RestartCompleteResponse value) {
        return new JAXBElement<RestartCompleteResponse>(_RestartCompleteResponse_QNAME, RestartCompleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendRecord }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testServer.MTS/", name = "sendRecord")
    public JAXBElement<SendRecord> createSendRecord(SendRecord value) {
        return new JAXBElement<SendRecord>(_SendRecord_QNAME, SendRecord.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link State }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testServer.MTS/", name = "state")
    public JAXBElement<State> createState(State value) {
        return new JAXBElement<State>(_State_QNAME, State.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://testServer.MTS/", name = "stateResponse")
    public JAXBElement<StateResponse> createStateResponse(StateResponse value) {
        return new JAXBElement<StateResponse>(_StateResponse_QNAME, StateResponse.class, null, value);
    }

}
