import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonSlurper

Message processData(Message message) {
    def body = message.getBody(String)
    def json = new JsonSlurper().parseText(body)

    // Example: wrap JSON into IDoc-like XML
    def idocXml = """
    <IDOC>
        <EDI_DC40>
            <TABNAM>${json.IDOC.EDI_DC40.TABNAM}</TABNAM>
            <DOCNUM>${json.IDOC.EDI_DC40.DOCNUM}</DOCNUM>
            <IDOCTYP>${json.IDOC.EDI_DC40.IDOCTYP}</IDOCTYP>
            <MESTYP>${json.IDOC.EDI_DC40.MESTYP}</MESTYP>
        </EDI_DC40>
    </IDOC>
    """

    message.setBody(idocXml)
    return message
}
