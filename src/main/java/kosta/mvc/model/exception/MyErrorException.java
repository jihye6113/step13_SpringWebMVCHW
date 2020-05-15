package kosta.mvc.model.exception;

public class MyErrorException extends RuntimeException {
    public MyErrorException() {}
    public MyErrorException(String message) {
    	super(message);
    }
}
