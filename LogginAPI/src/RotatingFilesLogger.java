import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RotatingFilesLogger {
	
	private static final Logger logger =
			Logger.getLogger(RotatingFilesLogger.class.getName());

	public static void main(String[] args) {
		FileHandler handler;

		try	{
			handler = new FileHandler("logs/rotating.log", 1000, 3, true);
			logger.addHandler(handler);
			handler.setLevel(Level.WARNING);
		} catch (IOException e) {
			e.printStackTrace();
		}

		logger.fine("Hello from fine world");
		logger.info("Hello from info world");

		logger.warning("Division by zero");
		try	{
			int i = 25/0;
		} catch (Exception exception) {
			logger.severe("Division by zero!!!");
		}
	}
}
