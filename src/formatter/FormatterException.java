package formatter;

public class FormatterException extends RuntimeException {
    
    public FormatterException(String message) {
        super(message + "\nUsage: formatter [input file] [output file] [name] [instructor] [class]");
    }
}
