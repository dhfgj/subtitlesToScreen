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
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.io.File;
import java.text.ParseException;


public class Main {

	static final String EMPTY_DATE="00:00:00,000";
	static final String EMPTY_DELAY="+00,000";
	static long difference=0;
	static String welcomeDelay = "no";
	static String welcomeStart = "beginning";

	public void start(String filePath){
//		System.out.println("this is the difference "+difference);		//debug print to see if the difference is computed correctly
		File file = new File(filePath);
		ArrayList arrayList;
		SRTInfo srtinfo = SRTReader.read(file);
		arrayList=srtinfo.getSRTArray();		
		DrawOverScreen d = new DrawOverScreen(srtinfo.getMaxLinesinText());		
		Iterator<SRT> it=arrayList.iterator();
		SRT e;
		long endTime = ((SRT) arrayList.get(0)).startTime.getTime(); //this prevents the wait before the first subtitle
		welcomeSubtitles(5);
		if(difference < 0)
			d.waitFor(Math.abs(difference));
		boolean skipSubs = true;
		while(it.hasNext()){
			e=it.next();
			long y = e.startTime.getTime();
			if(difference>0&&skipSubs){
				while(Math.abs(e.startTime.getTime())>difference&&Math.abs(e.endTime.getTime())>difference)
					e=it.next();
				skipSubs=false;
				endTime=e.startTime.getTime();
			}
			long startTime = e.startTime.getTime();
			d.waitFor(startTime-endTime);
			endTime = e.endTime.getTime();
			d.assignTextToWindows(e.text, Math.abs(startTime-endTime));
		}
		d.closeAllWindows();	//releasing all resources before halting the program
		System.exit(0);
	}

	public void printText(List<String> text){//debug method that prints the text to the standard output
		Iterator<String> it=text.iterator();
		String s;
		while(it.hasNext()){
			s=it.next();
			System.out.println(s);
		}
	}

	public void welcomeSubtitles(int numberOfIterations){
		DrawOverScreen welcomeSubs= new DrawOverScreen(1);
		for (int i = numberOfIterations; i > 0;i--){		//countdown for the initial subtitles
			List <String> s = new ArrayList<String>();
			s.add("Subs start in "+Integer.toString(i)+" from "+welcomeStart+" with "+welcomeDelay+" delay");
			welcomeSubs.assignTextToWindows(s, 1000);
		}
	}

	private static void argumentsInstructions(){
		System.out.println("Correct argument syntax as follows:");
		System.out.println("<input file> <delay> <start point>");
		System.out.println("where <delay> is given by + or - followed by milliseconds. E.g. +02,500 gives delay of 1,5 seconds");
		System.out.println("where <start point> is given in the format: hh:mm:ss,mmm. E.g. 01:32:30,000");
		System.out.println("<delay> & <start point> can be omitted");
		System.exit(1);
	}


	private static void parseArguments(String[] args){
		if(args.length==0 || args.length>3)
			argumentsInstructions();
		try {
			boolean threeArgument = (args.length==3)?true:false;
			if(threeArgument){
				if (args[1].charAt(0)=='-'||args[1].charAt(0)=='+')
					assignDelayAndStartTime(args[1], args[2]);				
				else
					assignDelayAndStartTime(args[2], args[1]);				
			}
			else{
				if (args[1].charAt(0)=='-'||args[1].charAt(0)=='+')
					assignDelayAndStartTime(args[1], EMPTY_DATE);
				else
					assignDelayAndStartTime(EMPTY_DELAY, args[1]);					
			}			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void assignDelayAndStartTime(String args1,String args2) throws ParseException{
		welcomeDelay=(args1==EMPTY_DELAY)?welcomeDelay:args1;
		welcomeStart=(args2==EMPTY_DATE)?welcomeStart:args2;
		boolean positiveDelay = (args1.charAt(0)=='-')?false:true;
		Date padding = SRTTimeFormat.parse(EMPTY_DATE);
		Date startTime=SRTTimeFormat.parse(args2);
		Date delay=SRTTimeFormat.parse("00:00:"+args1.substring(1));
		difference = (positiveDelay)?Math.abs(startTime.getTime()+delay.getTime()-padding.getTime()):(startTime.getTime()>delay.getTime())?Math.abs(startTime.getTime()-delay.getTime()+padding.getTime()):startTime.getTime()-delay.getTime();
	}

	public static void main(String[] args){
		if(args.length!=1)
			parseArguments(args);
		new Main().start(args[0]);
	}
}
