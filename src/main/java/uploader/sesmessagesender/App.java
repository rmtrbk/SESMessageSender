package uploader.sesmessagesender;

import java.io.IOException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

import uploader.sesmessagesender.service.SESMessengerServiceImpl;
import uploader.sesmessagesender.util.PropertyManager;

/**
 * Entry point to the application.
 * Main method allows to send an email via a Simple Email Service.
 * 
 * @author theja.kotuwella
 *
 */
public class App {
	private static final String TO 				= "";
	private static final String FROM 			= "";
	private static final String SUBJECT 		= "Book Inventory Update";
	private static final String HTML_MESSAGE 	= "<h1>Book Inventory Application</h1>";
	private static final String TEXT_MESSAGE 	= "This email is sent by Book Inventory Application";
	
	private SESMessengerServiceImpl sesMessengerService = null;
	
	App(){
		initLog();
		
		PropertyManager.loadProperties();
		
		sesMessengerService = new SESMessengerServiceImpl();
	}
	
	public static void main(String[] arg) {
		App app = new App();
		
		app.sendEmail(TO, FROM, SUBJECT, HTML_MESSAGE, TEXT_MESSAGE);
	}
	
	private void sendEmail(String toAddress,
							String fromAddress,
							String subject,
							String htmlMessage, 
							String textMessage) {
		
		sesMessengerService.sendEmail(toAddress, fromAddress, subject, htmlMessage, 
																	textMessage);
	}
	
	private static void initLog() {
		Logger rootLogger = Logger.getRootLogger();
		rootLogger.setLevel(Level.INFO);

		PatternLayout layout = new PatternLayout("%d{ISO8601} [%t] %-5p %c %x - %m%n");
		rootLogger.addAppender(new ConsoleAppender(layout));
		
		try {
			RollingFileAppender fileAppender = new RollingFileAppender(layout, "SESMessageSender.log");

			rootLogger.addAppender(fileAppender);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
