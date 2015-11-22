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
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * A class to store SRT information.
 * 
 * @author fredy
 */
public class SRT implements Comparable<SRT> {
    public final int number;
    public final Date startTime;
    public final Date endTime;
    public final List<String> text;
    
    /**
     * Creates a new instance of SRT.
     * 
     * @param number the subtitle number
     * @param startTime the start time
     * @param endTime the end time
     * @param text the subtitle text
     */
    public SRT(int number, Date startTime, Date endTime, String... text) {
        this.number = number;
        this.startTime = startTime;
        this.endTime = endTime;
        this.text = new ArrayList<>(Arrays.asList(text));
    }
    
    /**
     * Creates a new instance of SRT.
     * 
     * @param number the subtitle number
     * @param startTime the start time
     * @param endTime the end time
     * @param text the subtitle text
     */
    public SRT(int number, Date startTime, Date endTime, List<String> text) {
        this.number = number;
        this.startTime = startTime;
        this.endTime = endTime;
        this.text = new ArrayList<>(text);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (number ^ (number >>> 32));
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SRT other = (SRT) obj;
        if (number != other.number)
            return false;
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(SRT o) {
        return new Integer(number).compareTo(o.number);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("SRT [number=").append(number).append(", startTime=")
            .append(startTime).append(", endTime=").append(endTime).append(", text=")
            .append(text).append("]");
        return builder.toString();
    }
}
