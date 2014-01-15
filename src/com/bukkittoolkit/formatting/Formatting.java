package com.bukkittoolkit.formatting;

import org.bukkit.command.CommandSender;

import com.bukkittoolkit.BukkitTool;

public class Formatting implements BukkitTool{

	public static FormattedMessageSender msgSender = new FormattedMessageSender();
	public static FormattedLogger logger = new FormattedLogger();
	
	@Override
	public boolean onCommand(CommandSender sender, String[] args) {
		// TODO Auto-generated method stub
		return false;
	}

}
