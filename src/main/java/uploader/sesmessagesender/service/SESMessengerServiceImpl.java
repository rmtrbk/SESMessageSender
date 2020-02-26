package uploader.sesmessagesender.service;

import org.apache.log4j.Logger;

import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

import uploader.sesmessagesender.util.ClientBuilderManager;

/**
 * Sends a message to a given SES email address.
 *  
 * @author theja.kotuwella
 *
 */
public class SESMessengerServiceImpl implements ISESMessengerService {
	private static Logger log = Logger.getLogger(SESMessengerServiceImpl.class.getName());
	
	private static final String FORMAT = "UTF-8";
	
	public void sendEmail(String toAddress,
									String fromAddress,
									String subject,
									String htmlMessage, 
									String textMessage) {
		
		SendEmailRequest request = new SendEmailRequest().withDestination(
		              				new Destination().withToAddresses(toAddress))
		          					.withMessage(new Message()
		          							.withBody(new Body()
		          							.withHtml(new Content()
		          							.withCharset(FORMAT).withData(htmlMessage))
		          							.withText(new Content()
		          							.withCharset(FORMAT).withData(textMessage)))
		          							.withSubject(new Content()
		          							.withCharset(FORMAT).withData(subject)))
		          							.withSource(fromAddress);
		
		ClientBuilderManager.getSESClient().sendEmail(request);

		log.info("SESMessengerServiceImpl: Email sent via SES. " 
					+ toAddress + " will receive an email.");
	}
}
