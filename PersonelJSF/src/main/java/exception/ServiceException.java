package exception;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 8670135969660230761L;

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

}
