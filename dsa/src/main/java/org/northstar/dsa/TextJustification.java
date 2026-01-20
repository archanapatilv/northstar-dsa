package org.northstar.dsa;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int prevLength = 0;
        List<String> currentLine = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            int length = words[i].length();
            if(prevLength + length + currentLine.size() > maxWidth) {
                //<TODO> process currentLine
                processCurrentLine(currentLine, result, maxWidth, prevLength + currentLine.size()-1);
                currentLine = new ArrayList<>();
                if(length + 1 > maxWidth) {
                    currentLine.add(words[i]);
                    prevLength = 0;
                    //<TODO> process currentLine
                    processCurrentLine(currentLine, result, maxWidth, length + currentLine.size()-1);
                    currentLine = new ArrayList<>();
                } else {
                    currentLine.add(words[i]);
                    prevLength = length;
                    if(i == words.length - 1) {
                        processCurrentLine(currentLine, result, maxWidth, prevLength + currentLine.size()-1);
                    }
                }
            } else if(prevLength + length + currentLine.size() < maxWidth) {
                prevLength += length;
                currentLine.add(words[i]);
                if(i == words.length - 1) {
                    processCurrentLine(currentLine, result, maxWidth, prevLength + currentLine.size()-1);
                }
            } else {
                currentLine.add(words[i]);
                prevLength = 0;
                //<TODO> process currentLine
                processCurrentLine(currentLine, result, maxWidth,length + currentLine.size()-1);

                currentLine = new ArrayList<>();
            }
        }
        return result;
    }

    private void processCurrentLine(List<String> currentLine, List<String> result, int maxWidth, int length) {
       int nbrOfWords = currentLine.size();
       StringBuffer stringBuffer = new StringBuffer();
       if(nbrOfWords == 1) {
           stringBuffer.append(currentLine.get(0));
           if(length < maxWidth) {
               while(length != maxWidth) {
                   stringBuffer.append(" ");
                   length++;
               }
           }
           result.add(stringBuffer.toString());
       } else {
           int nbrExtraSpaces = maxWidth - length;
           int commonExtraSpaces = nbrExtraSpaces/currentLine.size();
           int leftGreedySpaces = nbrExtraSpaces%currentLine.size();
           stringBuffer.append(currentLine.get(0));
           int temp = commonExtraSpaces + leftGreedySpaces;
           while(temp != 0) {
               stringBuffer.append(" ");
               temp--;
           }
           for(int i = 1; i < currentLine.size(); i++) {
               stringBuffer.append(" ");
               stringBuffer.append(currentLine.get(i));
               temp = commonExtraSpaces;
               while(temp != 0 && i < currentLine.size() - 1) {
                   stringBuffer.append(" ");
                   temp--;
               }
           }
           result.add(stringBuffer.toString());
       }
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        TextJustification textJustification = new TextJustification();
        for (String s : textJustification.fullJustify(words, maxWidth)) {
            System.out.println(s);
        }

    }
}
