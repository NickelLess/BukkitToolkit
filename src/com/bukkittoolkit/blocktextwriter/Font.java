package com.bukkittoolkit.blocktextwriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.Validate;

public final class Font {

	private Map<String, Letter> letters;
	private int maxStringSize = 0;
	private int maxLetterWidth = 0;		//these measurements include letter offsets
	private int maxLetterHeight = 0;
	
	public Font(File fontDirectory){
		Validate.notNull(fontDirectory);
		Validate.isTrue(fontDirectory.isDirectory());
		
		letters = new HashMap<String, Letter>();
		
		for (File file: fontDirectory.listFiles()){
			if (file.getName().endsWith(".font")){
				addLetter(file);
			}
		}	
	}
	
	private void addLetter(File file){
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String name = reader.readLine();
			Validate.notNull(name);
			String sourceString = "";

			//read name
			if (name.startsWith("&&")){
				//special character
				name = name.substring(2);
				if (name.equalsIgnoreCase("SPACE")){
					sourceString = " ";
				}
				
			}
			else{
				sourceString = name;
			}
			
			//read width
			String widthString = reader.readLine();
			
			//read height
			String heightString = reader.readLine();
			
			//read xOffset
			String xOffsetString = reader.readLine();
			
			//read yOffset
			String yOffsetString = reader.readLine();
			
			//read points
			String pointString;
			while ((pointString = reader.readLine()) != null){
				
			}
			
			
			reader.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public final Letter getLetter(Character c){
		return letters.get(c);
	}
	
	
}
