package com.bukkittoolkit.formatting;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;

/**
 * The Logger outputs messages to the terminal.
 * 
 * The logger gets it's Logger from Bukkit.
 * 
 * The Logger has a verbosity level. The more verbose the more messages are outputed.
 * Messages can be sent to the logger. Each Message can specify a verbosity level.
 * @author Matthew
 *
 */
public class FormattedLogger {

	/**
	 * The verbosity level. The default value is 2.
	 */
	private int verbose = 2;
	
	private Logger logger = null;
	
	private boolean hasLogger(){
		if (logger == null){
			logger = Bukkit.getLogger();
			if (logger == null){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Logs messages if the verbose level is high enough.
	 * This method should be used plugin wide as the only way to log messages.
	 * @param verboseLevel The verbose level of the message being logged
	 * @param level the Bukkit level of the message
	 * @param msg the LogMessage
	 */
	public void log(int verboseLevel, Level level, FormattedMessage msg, Object object){
		String m = msg.getMessage();
		if (object != null){
			m = m + ": " + object.toString();
		}
		
		log(verboseLevel, level, m);
	}
	
	public void log(int verboseLevel, Level level, FormattedMessage msg){		
		log(verboseLevel, level, msg.getMessage());
	}
	
	/**
	 * Logs messages if the verbose level is high enough.
	 * This method should be used plugin wide as the only way to log messages.
	 * @param verboseLevel The verbose level of the message being logged
	 * @param level the Bukkit level of the message
	 * @param msg The message
	 */
	public void log(int verboseLevel, Level level, String msg){
		
		//If the verbose level is high enough
		if (verboseLevel <= verbose){
			
			//make sure we can log
			if (!hasLogger()){
				return;
			}
			
			//log the message
			logger.log(level, msg);
		}
		
	}
}
