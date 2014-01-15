package com.bukkittoolkit.formatting;

import org.bukkit.ChatColor;

/**
 * a MessageFormat is a format for different types of messages.
 * MessageFormats are used by Message.sendMessage
 * The output string is structured "[label]: message", where label and message are colored appropriately
 * @author Matthew
 *
 */
public enum MessageFormat {
	
	DEFAULT(ChatColor.WHITE),
	NOTIFICATION(ChatColor.GOLD),
	INCORRECTUSE(ChatColor.RED),
	HELPMESSAGE( ChatColor.LIGHT_PURPLE),
	NOPERMISSION(ChatColor.RED), 
	WRONGNUMBEROFARGUMENTS(ChatColor.RED),
	BADARGUMENTS(ChatColor.RED), 
	ERROR(ChatColor.RED), 
	OUTPUT(ChatColor.GRAY);
	
	//the color of the message
	private final ChatColor messageColor;
	
	private MessageFormat(ChatColor messageColor){
		this.messageColor = messageColor;
	}
	
	/**
	 * Returns the color of the message
	 * @return the color of the message
	 */
	public ChatColor getMessageColor(){
		return messageColor;
	}
	
	public static MessageFormat getMessageFormat(){
		return null;
	}
}
