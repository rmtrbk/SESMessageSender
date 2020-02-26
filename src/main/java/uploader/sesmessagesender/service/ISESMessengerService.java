package uploader.sesmessagesender.service;

/**
 * Messenger services interface.
 * 
 * @author theja.kotuwella
 *
 */
public interface ISESMessengerService {
	void sendEmail(String toAddress,
					String fromAddress,
					String subject,
					String htmlMessage, 
					String textMessage);
}
