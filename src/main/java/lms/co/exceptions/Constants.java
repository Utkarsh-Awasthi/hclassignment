package lms.co.exceptions;


import org.springframework.http.HttpStatus;


/**
 * @author Utkarsh Awasthi
 * <p>
 * Enumeration  to store all Custom exception codes.
 */
enum ExceptionCodeEnum {
    BOOK_NOT_FOUND("Resource Not Found.", HttpStatus.NOT_FOUND);

    private String message;
    private HttpStatus httpStatus;

    ExceptionCodeEnum(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}
