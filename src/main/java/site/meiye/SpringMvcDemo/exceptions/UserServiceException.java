package site.meiye.SpringMvcDemo.exceptions;

public class UserServiceException extends RuntimeException {


    private static final long serialVersionUID = -7090587998820379280L;

    public UserServiceException(String message) {
        super(message);
    }
}
