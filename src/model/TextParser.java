package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;

import org.xml.sax.SAXException;

/**
 * Created by mkhal on 26/09/2016.
 */
public class TextParser {
    private String fileName;
    private BodyContentHandler handler;
    private Metadata metadata;
    private FileInputStream inputstream;
    private ParseContext pcontext;
    private PDFParser pdfparser;
    private String[] metadataNames;
    private String content;

    public TextParser(String fileName) throws IOException, TikaException, SAXException {
        Logger.getRootLogger().setLevel(Level.OFF);

        handler = new BodyContentHandler(-1);
        metadata = new Metadata();
        inputstream = new FileInputStream(new File(fileName));
        pcontext = new ParseContext();

        //parsing the document using PDF parser
        pdfparser = new PDFParser();
        pdfparser.parse(inputstream, handler, metadata,pcontext);

        //getting the content of the document
        content = handler.toString();

        //getting metadata of the document
        metadataNames = metadata.names();

    }

    public String getContent() {
        return content;
    }

    public void printMeta() {
        for(String name : metadataNames) {
            System.out.println(name+ " : " + metadata.get(name));
        }
    }

}
