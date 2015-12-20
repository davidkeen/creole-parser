package eu.mrico.creole.xhtml;

import eu.mrico.creole.Creole;
import eu.mrico.creole.ast.Document;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertTrue;

public class HorizontalRuleTest {

    @Test
    public void trailingHr() throws Exception {
        String in = "A single horizontal rule on the last line\n----\n";
        Document doc = Creole.parse(in);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        new XHtmlWriter().write(doc, baos);
        String output = baos.toString("UTF-8");
        System.out.println(output);
        assertTrue(output.contains("<hr/>"));
    }

    @Test
    public void hrWithTextAfter() throws Exception {
        String in = "A horizontal rule\n----\nthen some more text";
        Document doc = Creole.parse(in);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        new XHtmlWriter().write(doc, baos);
        String output = baos.toString("UTF-8");
        System.out.println(output);
        assertTrue(output.contains("<hr/>"));
    }
}
