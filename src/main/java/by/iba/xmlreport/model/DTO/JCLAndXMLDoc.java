package by.iba.xmlreport.model.DTO;

import org.w3c.dom.Document;

public class JCLAndXMLDoc {
    private int idStat;
    private String jclText;
    private Document xmlDocument;

    public JCLAndXMLDoc() {
    }

    public JCLAndXMLDoc(String jclText, Document xmlDocument) {
        this.jclText = jclText;
        this.xmlDocument = xmlDocument;
    }

    public int getIdStat() {
        return idStat;
    }

    public void setIdStat(int idStat) {
        this.idStat = idStat;
    }

    public String getJclText() {
        return jclText;
    }

    public void setJclText(String jclText) {
        this.jclText = jclText;
    }

    public Document getXmlDocument() {
        return xmlDocument;
    }

    public void setXmlDocument(Document xmlDocument) {
        this.xmlDocument = xmlDocument;
    }
}
