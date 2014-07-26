package formatter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Usage:
 * > formatter [file] [name] [instructor] [class]
 * 
 * @author Shreyas
 */
public class Formatter {
    
    public static void main(String[] args) {
        File f = new File(args[0]);
        
        if (!f.exists())
            throw new FormatterException("\"" + args[0] + "\" does not exist.");
        if (!f.canRead())
            throw new FormatterException("\"" + args[0] + "\" cannot be read.");
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        
        
    }
}
