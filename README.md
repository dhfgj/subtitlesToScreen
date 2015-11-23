# subsReader
A small java program that reads .srt formatted files and draws the subtitles directly to the screen without making any window appear. It provides for online video players with a lack of subtitles. 

Arguments
---------
The program accepts three arguments: -input file- -delay- -start point-.
Where -input file- is necessary and is the path of the .srt file wanted to be read.
Where -delay- is given by + or - followed by milliseconds. E.g. +02,500 gives delay of 1,5 seconds.
Where -start point- is given in the format: hh:mm:ss,mmm. E.g. 01:32:30,000.
-delay- or -start point- or both can be omitted. 

Examples
--------
__With one argument__

    java subsToScreen.Main /home/user/Documents/subtitleFiles/mySrtFile.srt
it plays the .srt file mySrtFile.srt from the beginning with no delay

__with two arguments__

    java subsToScreen.Main /home/user/Documents/subtitleFiles/mySrtFile.srt 00:35:25,000
it plays the .srt file from 35th minute, 25th second and 0 milliseconds.
 
    java subsToScreen.Main /home/user/Documents/subtitleFiles/mySrtFile.srt +05,250
it plays the .srt file from the beginning with delay of 5 seconds and 250 milliseconds. With the + sign the subtitles are shifted to the right.

__with three arguments__

    java subsToScreen.Main /home/user/Documents/subtitleFiles/mySrtFile.srt 00:35:25,000 +05,250
it plays the .srt file from 35th minute, 25th second and 0 milliseconds with 5 seconds and 250 milliseconds delay.

    java subsToScreen.Main /home/user/Documents/subtitleFiles/mySrtFile.srt +05,250 00:35:25,000
It is also legal to invert the -delay- and -start time- arguments positions.

\< dafg \>
