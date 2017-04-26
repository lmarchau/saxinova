package fr.lmarchau.saxinova.sax.handler;

import java.util.logging.Logger;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * SAX error handler dedicated to {@link ContactHandler}
 */
public class ContactErrorHandler implements ErrorHandler {

	private static final Logger LOG = Logger.getLogger(ContactErrorHandler.class.getName());

	@Override
	public void warning(SAXParseException exception) throws SAXException {
		LOG.warning(buildMessage(exception));
	}

	@Override
	public void error(SAXParseException exception) throws SAXException {
		LOG.severe(buildMessage(exception));
	}

	@Override
	public void fatalError(SAXParseException exception) throws SAXException {
		error(exception);
	}

	/**
	 * build message with exception information
	 *
	 * @param exception
	 * @return
	 */
	private String buildMessage(SAXParseException exception) {
		StringBuilder sb = new StringBuilder();
		sb.append("ID: ").append(exception.getSystemId()).append('\n');
		sb.append("Position: [").append(exception.getLineNumber());
		sb.append(',').append(exception.getColumnNumber()).append("]\n");
		sb.append("Message: ").append(exception.getMessage());
		return sb.toString();
	}
}
