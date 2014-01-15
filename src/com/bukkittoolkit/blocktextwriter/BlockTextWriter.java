package com.bukkittoolkit.blocktextwriter;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.bukkittoolkit.BukkitTool;

public class BlockTextWriter implements BukkitTool{
	
	Map<String, Font> fonts;
	
	public BlockTextWriter(){
		fonts = new HashMap<String, Font>();
	}
	
	public void writeString(Location loc, Font font, Material material, String string){
		Validate.notNull(loc);
		Validate.notNull(material);
		Validate.notNull(string);
		Validate.notNull(font);
				
		for (Character c: string.toCharArray()){
			loc = drawLetter(loc, CardinalDirection.getCardinalDirection(loc), font.getLetter(c), material);
		}
	}
	
	public void writeString(Location loc, CardinalDirection direction, Font font, Material material, String string){
		Validate.notNull(loc);
		Validate.notNull(direction);
		Validate.notNull(material);
		Validate.notNull(string);
		Validate.notNull(font);
				
		for (Character c: string.toCharArray()){
			loc = drawLetter(loc, direction, font.getLetter(c), material);
		}
	}
	
	
	
	private Location drawLetter(Location loc, CardinalDirection direction, Letter letter, Material material){
		
		Location temp = loc.clone();
		switch (direction){
		case N:
			for (Point p: letter.points){
				temp.setX(loc.getX() + p.getX());
				temp.setY(loc.getY() + p.getY());
				temp.getBlock().setType(material);
			}
			loc.setX(loc.getX() + 6);
			break;
		case E:
			for (Point p: letter.points){
				temp.setZ(loc.getZ() + p.getX());
				temp.setY(loc.getY() + p.getY());
				temp.getBlock().setType(material);
			}
			loc.setZ(loc.getZ() + 6);
			break;
		case S:
			for (Point p: letter.points){
				temp.setX(loc.getX() - p.getX());
				temp.setY(loc.getY() + p.getY());
				temp.getBlock().setType(material);
			}
			loc.setX(loc.getX() - 6);
			break;
		case W:
			for (Point p: letter.points){
				temp.setZ(loc.getZ() - p.getX());
				temp.setY(loc.getY() + p.getY());
				temp.getBlock().setType(material);
			}
			loc.setZ(loc.getZ() - 6);
			break;
		default:
			//error
		}
		
		return loc;
	}

	@Override
	public boolean onCommand(CommandSender sender, String[] args) {
		
		String text = "";
		
		
		if (args[0].equalsIgnoreCase("drawtext")){
			
			if (args.length < 3){
				return false;
			}
			
			Player player = (Player) sender;
			
			for (int i = 2; i < args.length; i++){
				text = text + args[i] + " ";
			}
			
			Font font = fonts.get(args[1]);
			
			this.writeString(player.getLocation(), font, Material.STONE, text);
			return true;
		}
		
		else if (args[0].equalsIgnoreCase("drawtextat")){
			
			if (args.length < 7){
				return false;
			}
			
			Player player = (Player) sender;
			
			Integer x = Integer.parseInt(args[1]);
			Integer y = Integer.parseInt(args[2]);
			Integer z = Integer.parseInt(args[3]);
			
			CardinalDirection direction;
			
			if (args[4].equalsIgnoreCase("N")) direction = CardinalDirection.N;
			else if (args[4].equalsIgnoreCase("S")) direction = CardinalDirection.S;
			else if (args[4].equalsIgnoreCase("E")) direction = CardinalDirection.E;
			else if (args[4].equalsIgnoreCase("W")) direction = CardinalDirection.W;
			else if (args[4].equalsIgnoreCase("NORTH")) direction = CardinalDirection.N;
			else if (args[4].equalsIgnoreCase("SOUTH")) direction = CardinalDirection.S;
			else if (args[4].equalsIgnoreCase("EAST")) direction = CardinalDirection.E;
			else if (args[4].equalsIgnoreCase("WEST")) direction = CardinalDirection.W;
			else direction = CardinalDirection.N;
			
			
			for (int i = 5; i < args.length; i++){
				text = text + args[i] + " ";
			}
			
			Font font = fonts.get(args[1]);
			
			this.writeString(new Location(player.getWorld(), x, y, z), direction, font, Material.STONE, text);
			return true;
		}
		
		return false;
	}
	
}
