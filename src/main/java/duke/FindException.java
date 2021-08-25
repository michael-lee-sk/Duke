package duke;

public class FindException extends Exception{
    public FindException() {
        super("Sorry, your find command is incomplete. Please type in a description\n");
    }

    public FindException(String message) {
        super(message + "\n");
    }
}
