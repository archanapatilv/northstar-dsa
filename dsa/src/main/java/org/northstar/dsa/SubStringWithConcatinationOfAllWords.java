package org.northstar.dsa;

import java.util.*;

public class SubStringWithConcatinationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int nbrOfWords = words.length;
        int sizeOfWord = words[0].length();
        int subStringSize = sizeOfWord * nbrOfWords;

        List<Integer> result = new ArrayList<>();
        if(subStringSize > n) {
            return result;
        }

        Map<String, Integer> wordMap = new HashMap<>();
        for(String word: words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for(int i = 0 ; i < n-subStringSize+1; i++) {
            Map<String, Integer> found = new HashMap<>();
            int count = 0;
            for(int j = i; j < n && j < i + subStringSize; j = j+sizeOfWord) {
                String temp = s.substring(j, j+sizeOfWord);
                if(wordMap.containsKey(temp)) {
                    found.put(temp, found.getOrDefault(temp, 0) + 1);
                    if(wordMap.get(temp).equals(found.get(temp))) {
                        count += wordMap.get(temp);
                    } else if(wordMap.get(temp) < (found.get(temp))) {
                        break;
                    }
                } else {
                    break;
                }
            }
            if(count == nbrOfWords) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SubStringWithConcatinationOfAllWords ss = new SubStringWithConcatinationOfAllWords();
       /* List<Integer> list = ss.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});*/
        System.out.println(ss.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        //System.out.println(ss.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
        //System.out.println(ss.findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",
                //new String[]{"fooo","barr","wing","ding","wing"}));
        //System.out.println(ss.findSubstring("barfoofoobarthefoobarman", new String[] {"bar","foo","the"}));
        //System.out.println(ss.findSubstring("aaaaaaaaaaaaaa", new String[] {"aa","aa"}));
    }

    //better one is above
     /*for(int i = 0 ; i < n-subStringSize+1; i++) {
            StringBuffer sBuf = new StringBuffer();
            Map<String, Integer> found = new LinkedHashMap<>();
            int count = 0;
            for(int j = i; j < n && j < i + subStringSize; j++) {
                sBuf.append(s.charAt(j));
                if(sBuf.length() == sizeOfWord) {
                    if(wordMap.containsKey(sBuf.toString())) {
                        found.put(sBuf.toString(), found.getOrDefault(sBuf.toString(), 0) + 1);
                        if(wordMap.get(sBuf.toString()).equals(found.get(sBuf.toString()))) {
                            count += wordMap.get(sBuf.toString());
                        }
                    }
                    sBuf.setLength(0);
                }
            }
            if(count == nbrOfWords) {
                result.add(i);
            }
        }*/
}
