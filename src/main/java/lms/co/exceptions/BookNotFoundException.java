package lms.co.exceptions;

/**
 * @author Utkarsh Awasthi
 **/

public class BookNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final ExceptionCodeEnum exceptionCodeEnum;

    private transient String message;

    private final String errorDetails;

    public BookNotFoundException(ExceptionCodeEnum exceptionCodeEnum, String message, String errorDetails) {
        this.exceptionCodeEnum = exceptionCodeEnum;
        this.message = message;
        this.errorDetails = errorDetails;
    }

    public ExceptionCodeEnum getExceptionCodeEnum() {
        return exceptionCodeEnum;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorDetails() {
        return errorDetails;
    }
}
