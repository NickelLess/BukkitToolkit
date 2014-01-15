package com.bukkittoolkit.blocktextwriter;

import java.awt.Point;
import java.util.Set;

final class Letter {
	
	public Set<Point> points;
	public short width;
	public short height;
	public short xOffset;
	public short yOffset;
	
	protected Letter(Set<Point> points, short width, short height, short xOffset, short yOffset){
		this.points = points;
		this.width = width;
		this.height = height;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
	
}
