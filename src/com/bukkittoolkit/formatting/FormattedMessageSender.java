package com.bukkittoolkit.formatting;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class FormattedMessageSender {
	
	private ChatColor defaultLabel = ChatColor.WHITE;
	
	private Map<String, ChatColor> labelColors = new HashMap<String, ChatColor>();
	
	public void addLabel(String label, ChatColor color){
		labelColors.put(label, color);
	}
	
	public void removeLabel(String label){
		labelColors.remove(label);
	}
	
	public boolean hasLabel(String label){
		return labelColors.containsKey(label);
	}
	
	public void sendMessage(String playerName, Plugin header, FormattedMessage message, Object... values){
		sendMessage(Bukkit.getPlayer(playerName), header, message, values);
	}
	public void sendMessage(String playerName, Plugin header, String message, Object... values){
		sendMessage(Bukkit.getPlayer(playerName), header, message, values);
	}
	public void sendMessage(String playerName, String header, FormattedMessage message, Object... values){
		sendMessage(Bukkit.getPlayer(playerName), header, message, values);
	}
	public void sendMessage(String playerName, String header, String message, Object... values){
		sendMessage(Bukkit.getPlayer(playerName), header, message, values);
	}

	public void sendMessage(String playerName, MessageFormat format, Plugin header, FormattedMessage message, Object... values){
		sendMessage(Bukkit.getPlayer(playerName), format, header, message, values);
	}
	
	public void sendMessage(String playerName, MessageFormat format, Plugin header, String message, Object... values){
		sendMessage(Bukkit.getPlayer(playerName), format, header, message, values);
	}
	
	public void sendMessage(String playerName, MessageFormat format, String header, FormattedMessage message, Object... values){
		sendMessage(Bukkit.getPlayer(playerName), format, header, message, values);
	}
	
	public void sendMessage(String playerName, MessageFormat format, String header, String message, Object... values){
		sendMessage(Bukkit.getPlayer(playerName), format, header, message, values);
	}
	
	public void sendMessage(CommandSender sender, Plugin header, FormattedMessage message, Object... values){
		sendMessage(sender, MessageFormat.DEFAULT, header, message, values);
	}
	
	public void sendMessage(CommandSender sender, Plugin header, String message, Object... values){
		sendMessage(sender, MessageFormat.DEFAULT, header, message, values);
	}
	
	public void sendMessage(CommandSender sender, String header, FormattedMessage message, Object... values){
		sendMessage(sender, MessageFormat.DEFAULT, header, message, values);
	}
	
	public void sendMessage(CommandSender sender, String header, String message, Object... values){
		sendMessage(sender, MessageFormat.DEFAULT, header, message, values);
	}
	
	public void sendMessage(CommandSender sender, MessageFormat format, Plugin header, FormattedMessage message, Object... values){
		sendMessage(sender, format, header.getName(), message, values);
	}
	
	public void sendMessage(CommandSender sender, MessageFormat format, Plugin header, String message, Object... values){
		sendMessage(sender, format, header.getName(), message, values);
	}
	
	public void sendMessage(CommandSender sender, MessageFormat format, String header, FormattedMessage message, Object... values){
		sendMessage(sender, format, header, message.getMessage(), values);
	}
	
	public void sendMessage(CommandSender sender, MessageFormat format, String header, String message, Object... values){
		if (sender instanceof Player){
			sendMessage((Player) sender, format, header, message, values);
		}
		
		//TODO: insert cases for other CommandSenders
		
		else{
			sendMessageWithoutColor(sender, format, header, message, values);
		}
		
	}
	
	public void sendMessage(Player player, Plugin header, FormattedMessage message, Object... values){
		sendMessage(player, MessageFormat.DEFAULT, header, message, values);
	}
	
	public void sendMessage(Player player, Plugin header, String message, Object... values){
		sendMessage(player, MessageFormat.DEFAULT, header, message, values);
	}
	
	public void sendMessage(Player player, String header, FormattedMessage message, Object... values){
		sendMessage(player, MessageFormat.DEFAULT, header, message, values);
	}
	
	public void sendMessage(Player player, String header, String message, Object... values){
		sendMessage(player, MessageFormat.DEFAULT, header, message, values);
	}

	public void sendMessage(Player player, MessageFormat format, Plugin header, FormattedMessage message, Object... values){
		sendMessage(player, format, header.getName(), message, values);
	}
	
	public void sendMessage(Player player, MessageFormat format, Plugin header, String message, Object... values){
		sendMessage(player, format, header.getName(), message, values);
	}
	
	public void sendMessage(Player player, MessageFormat format, String header, FormattedMessage message, Object... values){
		sendMessage(player, format, header, message.getMessage(), values);
	}
	
	public void sendMessage(Player player, MessageFormat format, String header, String message, Object... values){
		sendMessageWithColor(player, format, header, message, values);
	}
	
	private void sendMessageWithColor(CommandSender sender, MessageFormat format, String header, String message, Object... values){
		if (sender != null){
			for (Object o: values){
				message = message.replaceFirst("%%", o.toString());
			}
			String string;
			if (header != null && header != ""){
				ChatColor color = defaultLabel;
				if (labelColors.containsKey(header)){
					color = labelColors.get(header);
				}
				string = color + "[" + header + "] " + format.getMessageColor() + message;
			}
			else{
				string = format.getMessageColor() + message;
			}
			sender.sendMessage(string);
		}
	}
	
	private void sendMessageWithoutColor(CommandSender sender, MessageFormat format, String header, String message, Object... values){
		if (sender != null){
			for (Object o: values){
				message = message.replaceFirst("%%", o.toString());
			}
			String string;
			if (header != null && header != ""){
				string = "[" + header + "] " + message;
			}
			else{
				string = message;
			}
			sender.sendMessage(string);
		}
	}
	
}
