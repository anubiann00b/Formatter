package formatter;

public class FormatterException extends RuntimeException {
    
    public FormatterException(String message) {
        super(message + "\nUsage: formatter [file] [name] [instructor] [class]");
    }
}
