
/**
 * CounterInitializationException - a runtime exception that signals that the counter could
 * not be created.
 * 
 * @author Charles Hoot
 * @version 5.0
 */
public class CounterInitializationException extends RuntimeException
{

	public CounterInitializationException(String reason)
	{
		super(reason);
	}
}