import controller.Controller;
import view.PDFReaderView;

import java.io.IOException;
import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

/**
 * Created by mkhal on 24/09/2016.
 */
public class Main {
    public static void main(String[] args) throws IOException, TikaException, SAXException {
        PDFReaderView pdfReaderView = new PDFReaderView();
        Controller controller = new Controller(pdfReaderView);
        //controller.readFile("C:\\Users\\mkhal\\IdeaProjects\\PDFReader\\example.pdf");
        //controller.readFile("C:\\\\Users\\\\mkhal\\\\Desktop\\\\Islamic Books\\\\HayatUsSahabah-Part-1.pdf");
        //controller.readFile("C:\\Users\\mkhal\\IdeaProjects\\PDFReader\\islamic-guide-to-sexual-relations.pdf");
        controller.readFile("IslamicMannersByShaykhAbdulFattahAbuGhuddah.pdf");
        pdfReaderView.setVisible(true);
    }
}