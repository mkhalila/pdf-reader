package controller;

import model.TextParser;
import view.PDFReaderView;

import java.io.IOException;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

/**
 * Created by mkhal on 24/09/2016.
 */
public class Controller {
    private TextParser textParser;
    private PDFReaderView pdfReaderView;

    public Controller(PDFReaderView pdfReaderView) {
        this.pdfReaderView = pdfReaderView;
    }

    public void readFile(String fileName) throws IOException, TikaException, SAXException {
        textParser = new TextParser(fileName);
        String text = textParser.getContent();
        //System.out.println(text);
        pdfReaderView.setText(text);
    }
}
