package exceptions;


public class DaoException extends RuntimeException {

    public DaoException() {
    }

    public DaoException(String msg) {
        super(msg);
    }

    public DaoException(Exception e) {
        super(e);
    }
}
