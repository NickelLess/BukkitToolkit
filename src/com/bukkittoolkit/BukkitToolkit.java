package com.bukkittoolkit;

import java.util.HashSet;
import java.util.Set;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.bukkittoolkit.blocktextwriter.BlockTextWriter;


public class BukkitToolkit extends JavaPlugin{

	private Set<BukkitTool> tools;
	
	public BukkitToolkit(){
		tools = new HashSet<BukkitTool>();
	}
	
	public static BlockTextWriter blockTextWriter = new BlockTextWriter();
	
	public void onEnable(){
		tools.add(blockTextWriter);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		
		if (cmd.getName().equalsIgnoreCase("toolkit")){
			
			if (args.length == 0) return false;
			
			for (BukkitTool tool: tools){
				
				if (tool.onCommand(sender, args) == true){
					return true;
				}
			}
		}
		
		
		return false;
	}
	
}
