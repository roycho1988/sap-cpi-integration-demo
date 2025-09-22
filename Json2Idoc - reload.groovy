import com.sap.gateway.ip.core.customdev.util.Message
import groovy.json.JsonSlurper

def processData(Message message) {

    // Read JSON payload as String and parse it
    def body = message.getBody(java.lang.String)
    def json = new JsonSlurper().parseText(body)

    // Build the IDoc-like XML
    def idocXml = """<IDOC>
<EDI_DC40>
  <TABNAM>${json.IDOC.EDI_DC40.TABNAM}</TABNAM>
  <DOCNUM>${json.IDOC.EDI_DC40.DOCNUM}</DOCNUM>
  <IDOCTYP>${json.IDOC.EDI_DC40.IDOCTYP}</IDOCTYP>
  <MESTYP>${json.IDOC.EDI_DC40.MESTYP}</MESTYP>
</EDI_DC40>
</IDOC>"""

    // Make sure the body is a Java String (NOT a GString)
    message.setHeader("Content-Type", "application/xml")
    message.setBody(idocXml.toString())          // <-- the important bit

    // If you prefer InputStream instead, use:
    // message.setBody(new ByteArrayInputStream(idocXml.getBytes("UTF-8")))
    // message.setHeader("Content-Type", "application/xml; charset=utf-8")

    return message
}
