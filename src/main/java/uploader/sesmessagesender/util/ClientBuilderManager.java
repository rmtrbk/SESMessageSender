package uploader.sesmessagesender.util;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

/**
 * Builds the AWS clients.
 * 
 * @author theja.kotuwella
 *
 */
public class ClientBuilderManager {
	static AmazonSimpleEmailService sesClient = null;
	
	public static AmazonSimpleEmailService getSESClient(){
		if(sesClient == null) {
			sesClient = AmazonSimpleEmailServiceClientBuilder.standard()
							.withRegion(Regions.AP_SOUTHEAST_2)
							.withCredentials(getcredentials()).build();
		}
		return sesClient;
	}
	
	private static AWSStaticCredentialsProvider getcredentials() {
		AWSCredentials credentials 	= new BasicAWSCredentials(PropertyManager.ACCESS_KEY_ATTRIBUTE,
																PropertyManager.SECRET_ATTRIBUTE);
		
		AWSStaticCredentialsProvider credProv = new AWSStaticCredentialsProvider(credentials);
		
		return credProv;
	}
}
