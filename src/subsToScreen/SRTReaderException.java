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

/**
 * An exception while reading an SRT file.
 * 
 * @author fredy
 */
public class SRTReaderException extends SRTException {
    private static final long serialVersionUID = 1L;

    /**
     * @param message the exception message
     * @param cause the cause
     */
    public SRTReaderException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message the exception message
     */
    public SRTReaderException(String message) {
        super(message);
    }

    /**
     * @param cause the cause
     */
    public SRTReaderException(Throwable cause) {
        super(cause);
    }
}