package formatter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFStyles;

/**
 * Usage:
 * > formatter [input file] [output file] [name] [instructor] [class]
 * 
 * @author Shreyas
 */
public class Formatter {
    
    public static void main(String[] args) throws IOException {
        File f = new File(args[0]);
        
        if (!f.exists())
            throw new FormatterException("\"" + args[0] + "\" does not exist.");
        if (!f.canRead())
            throw new FormatterException("\"" + args[0] + "\" cannot be read.");
        
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        
        FileOutputStream out;
        try {
            out = new FileOutputStream(args[1]);
        } catch (FileNotFoundException e) {
            throw new FormatterException("\"" + args[0] + "\" cannot be found.");
        }
        
        XWPFDocument document = new XWPFDocument();
        
        XWPFStyles styles = document.createStyles();
        //CTStyle s = new CTStyle();
        //XWPFStyle style = new XWPFStyle();
        //styles.addStyle(null);
        
        String line;
        while ((line = reader.readLine()) != null) {
            XWPFParagraph p = document.createParagraph();
            XWPFRun run = p.createRun();
            run.setText(line);
        }
        reader.close();
        
        document.write(out);
        out.close();
    }
}
