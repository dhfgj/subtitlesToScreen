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

import java.util.ArrayList;
import java.util.List;

public class DrawOverScreen {
	
	private modifiedWindow[] wArray;
	
	public DrawOverScreen(int size){
		wArray = new modifiedWindow[size];
		initialize();
	}
	
	//REALLY IMPORTANT: In order to run the program smoothly it is important that the windows used are created only one time 
	//since it is an expensive operation. 
	//After creating the needed windows re-utilize them by setting the visibility off, changing value of the string displayed,
	//and position if needed, and then setting the visibility of the window on again.
	
	public void waitFor(long time){
		try {
		    Thread.sleep(time);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
	public void applyChanges(int numberOfIterations){
		for(int i = 0; i<numberOfIterations;i++){
			wArray[i].applyChanges();
		}
	}
	
	public void setInvisible(){
		int numberOfIterations=wArray.length;
		for(int i = 0; i<numberOfIterations;i++){
			wArray[i].setVisible(false);
		}
	}
	
	public void closeAllWindows(){
		int numberOfIterations=wArray.length;
		for(int i = 0; i<numberOfIterations;i++){
			wArray[i].dispose();
		}
	}
	
	public void assignTextToWindows(List<String> text, long time){
		int numberOfIterations=text.size();
		for(int i = 0; i<numberOfIterations;i++){
			wArray[i].set(text.get(i), numberOfIterations-i);//numberOfIterations -i goes decresing by one from  numberOfIterations to 1
		}
		applyChanges(text.size());
		waitFor(time);
		setInvisible();
	}
	
	public void initialize(){
		int numberOfIterations = wArray.length;
		for(int i = 0; i<numberOfIterations;i++)
			wArray[i]=new modifiedWindow();
	}

}
