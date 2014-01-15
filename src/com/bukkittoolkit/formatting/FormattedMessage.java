package com.bukkittoolkit.formatting;

/**
 * A UtilMessage is a simple interface for anything that can output a string.
 * Although all objects can do this, this is meant specifically for messages.
 * 
 * @author Matthew
 *
 */
public interface FormattedMessage {

	/**
	 * Get the String representation of the Message
	 * @return
	 */
	public String getMessage();
	
}
