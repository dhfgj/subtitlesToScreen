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


 * This software includes the Fredy Wijaya jsrt Library <https://github.com/fredyw/jsrt/tree/master/jsrt-api/src/main/java/org/fredy/jsrt>:

 	* Copyright 2012 Fredy Wijaya
 	*
 	* Permission is hereby granted, free of charge, to any person obtaining
 	* a copy of this software and associated documentation files (the
 	* "Software"), to deal in the Software without restriction, including
	* without limitation the rights to use, copy, modify, merge, publish,
 	* distribute, sublicense, and/or sell copies of the Software, and to
 	* permit persons to whom the Software is furnished to do so, subject to
 	* the following conditions:
 	* 
 	* The above copyright notice and this permission notice shall be
 	* included in all copies or substantial portions of the Software.
 	* 
 	* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 	* EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 	* MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 	* NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 	* LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 	* OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 	* WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package subsToScreen;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;


/**
 * This class stores collections of SRT objects.
 * 
 * All the methods here perform low-level operations on SRTInfo object.
 * If you need to perform high-level operations for editing the SRTInfo,
 * use {@link SRTEditor} instead.
 * 
 * @author fredy
 */
public class SRTInfo implements Iterable<SRT>, Cloneable {
    private final ArrayList<SRT> SRTArray;
    private final int maxNumberOfTextLines;  //it represents the max number of lines in the text of a SRT object.
    
    /**
     * Creates a new instance of SRTInfo.
     */
    public SRTInfo() {
        SRTArray = new ArrayList<>();
        maxNumberOfTextLines=0;
    }
    
    /**
     * Creates a new instance of SRTInfo.
     * This constructor acts as a copy constructor.
     * 
     * @param SRTArray is the array-list containing SRT objects
     */
    public SRTInfo(ArrayList<SRT> SRTArray, int maxNumberOfTextLines) {
    	this.SRTArray = SRTArray;
    	this.maxNumberOfTextLines=maxNumberOfTextLines;
    }
    
    
    public ArrayList<SRT> getSRTArray(){
    	return SRTArray;
    }
    
    public int getMaxLinesinText(){
    	return maxNumberOfTextLines;
    }
    
    /**
     * Adds SRT object into SRTInfo object. If SRT object already exists, the old
     * SRT object will be replaced with the new SRT object.
     * 
     * @param srt the SRT object to be added
     */
    public void add(SRT srt) {
        remove(srt);
        SRTArray.add(srt);
    }
    
    /**
     * {@inheritDoc}
     */
    public Iterator<SRT> iterator() {
        return SRTArray.iterator();
    }
    
    /**
     * Gets the number of SRT objects stored in SRTInfo object.
     * 
     * @return the number of SRT objects stored in SRTInfo object
     */
    public int size() {
        return SRTArray.size();
    }
    
    /**
     * Removes the SRT object from SRTInfo.
     * 
     * @param srt the SRT object to be removed from SRTInfo
     */
    public void remove(SRT srt) {
        // Set.remove() will check if the object is present in the Set, so
        // there is no need to do another check if the object is present in
        // the set
    	SRTArray.remove(srt);
    }
    
    /**
     * Removes the SRT object with subtitle number from SRTInfo.
     * 
     * @param number the subtitle number to be removed from SRTInfo
     */
    public void remove(int number) {
    	SRTArray.remove(get(number));
        
    }
    
    /**
     * Gets the SRT object from a given number.
     * 
     * @param number the subtitle number
     * @return the SRT object
     */
    public SRT get(int number) {
        // Create a dummy SRT object since the comparison is by number only.
        return SRTArray.get(number);
    }
    
    /**
     * Gets the SRT object.
     * 
     * @param srt the SRT object
     * @return the SRT object
     */
    public SRT get(SRT srt) {    	
        return get(srt.number);
    }
    
    /**
     * Check if the subtitle number is in the SRTInfo object.
     * 
     * @param number the subtitle number
     * @return true if the subtitle number is in the SRTInfo; false otherwise
     */
    public boolean contains(int number) {
        return SRTArray.contains(new SRT(number, null, null, new String[]{}));
    }
    
    /**
     * Check if the SRT is in the SRTInfo object.
     * 
     * @param srt the SRT object
     * @return true if the subtitle number is in the SRTInfo; false otherwise
     */
    public boolean contains(SRT srt) {
        return SRTArray.contains(srt);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Object clone() {
        return new SRTInfo();
    }
}