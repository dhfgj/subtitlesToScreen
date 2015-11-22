/* Copyright 2015 Dimitri Diomaiuta 

 * This file is part of subsToScreen.

 * subsToScreen is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 2 of the License, or
 * (at your option) any later version.

 * subsToScreen is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with subsToScreen. If not, see <http://www.gnu.org/licenses/>.
*/
package subsToScreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Window;

public class modifiedWindow extends Window{

	private String s;
	private Shape shape;
	private int padding = 1;

	public modifiedWindow() {
		super(null);
	}
	
	public modifiedWindow(String s, int padding){
		super(null);
		this.s=s;
		this.padding = padding;
	}
	
	public modifiedWindow(String s){
		super(null);
		this.s=s;
	}

	public void set(String s){
		this.s=s;
	}
	
	public void set(int x){
		padding = x;
	}
	
	public void set(String s, int x){
		this.s=s;
		padding = x;
	}

	public String get(){
		return this.s;
	}

	@Override
	public void paint(Graphics g)
	{
		Graphics2D g2d = ((Graphics2D)g);
		Font f=getFont().deriveFont(Font.BOLD,48f);
		FontMetrics metrics = g.getFontMetrics(f);
		final String message = s;
		shape=f.createGlyphVector(g2d.getFontRenderContext(), message)
				.getOutline(
						(getWidth()-metrics.stringWidth(message))/2,
						(getHeight()-metrics.getHeight()*padding));
		// Java6: com.sun.awt.AWTUtilities.setWindowShape(this, shape);
		setShape(shape);
		g.setColor(Color.WHITE);
		g2d.fill(shape.getBounds());	
	}
	@Override
	public void update(Graphics g)
	{
		paint(g);
	}

	public void applyChanges(){
		setAlwaysOnTop(true);
		setBounds(getGraphicsConfiguration().getBounds());
		setVisible(true);
	}

}
