package view;

import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.*;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER;

/**
 * Created by mkhal on 24/09/2016.
 */
public class PDFReaderView extends JFrame {
    private JTextPane textPane;

    public PDFReaderView() {
        super("PDF Reader");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(1280, 720));


        textPane = new JTextPane();
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        setJTextPaneFont(textPane, new Font(Font.MONOSPACED, Font.PLAIN, 20), new Color(0, 0, 0));

        /*Font f = new Font(Font.SANS_SERIF, Font.PLAIN, 25);
        textPane.setFont(f);*/

        textPane.setBackground(new Color(255, 255, 255));
        //textPane.setFontCO

        JScrollPane jScrollPane = new JScrollPane(textPane);
        jScrollPane.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        add(jScrollPane);

        pack();
    }

    public static void setJTextPaneFont(JTextPane jtp, Font font, Color c) {
        // Start with the current input attributes for the JTextPane. This
        // should ensure that we do not wipe out any existing attributes
        // (such as alignment or other paragraph attributes) currently
        // set on the text area.
        MutableAttributeSet attrs = jtp.getInputAttributes();

        // Set the font family, size, and style, based on properties of
        // the Font object. Note that JTextPane supports a number of
        // character attributes beyond those supported by the Font class.
        // For example, underline, strike-through, super- and sub-script.
        StyleConstants.setFontFamily(attrs, font.getFamily());
        StyleConstants.setFontSize(attrs, font.getSize());
        StyleConstants.setItalic(attrs, (font.getStyle() & Font.ITALIC) != 0);
        StyleConstants.setBold(attrs, (font.getStyle() & Font.BOLD) != 0);

        // Set the font color
        StyleConstants.setForeground(attrs, c);

        // Retrieve the pane's document object
        StyledDocument doc = jtp.getStyledDocument();

        // Replace the style for the entire document. We exceed the length
        // of the document by 1 so that text entered at the end of the
        // document uses the attributes.
        doc.setCharacterAttributes(0, doc.getLength() + 1, attrs, false);
    }

    public void setText(String text) {
        textPane.setText(text);
    }
}
