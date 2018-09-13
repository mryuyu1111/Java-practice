package Exception;

public class RoutePlannerException extends Exception {
	private static final long serialVersionUID = 1L;

	public RoutePlannerException() {
		super();
	}
	
	public RoutePlannerException(String s) {
		super(s);
	}
	
	public RoutePlannerException (Exception e, String message) {
		super(message,e);
	}
}
