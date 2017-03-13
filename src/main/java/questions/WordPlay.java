package questions;

import java.util.HashMap;

public class WordPlay {
    boolean wordplay(String letters, String word) {
        if (letters == null || word == null) {
            return false;
        }
        if (letters.length() < word.length()) {
            return false;
        }

        char[] lettersA = letters.toCharArray();
        char[] wordA = word.toCharArray();
        HashMap<Character, Integer> lettersMap = new HashMap();//

        //HashMap<char, int> lettersMap = new HashMap();
        //int i = lettersMap.get('c');
        //...?

        //<char, Integer> lettersMap = new HashMap();
        //Integer i = lettersMap.get('c');
        //assert(i == null);

        for (int i = 0; i < lettersA.length; i++) {
            if (!lettersMap.containsKey(lettersA[i])) {
                lettersMap.put(lettersA[i], 1);
            } else {
                int currentValue = lettersMap.get(lettersA[i]);
                lettersMap.put(lettersA[i], currentValue++);
            }
        }

        for (int i = 0; i < wordA.length; i++) {
            if (lettersMap.containsKey(wordA[i])) {
                int currentValue = lettersMap.get(wordA[i]);
                if (currentValue == 0) {
                    return false;
                } else {
                    lettersMap.put(wordA[i], currentValue--);
                }
            } else {
                return false;
            }
        }

        return true;


    }

}/*
 * wordplay('act', 'cat') -> TRUE
 * wordplay('bacus', 'abacus') -> FALSE
 * wordplay('block', 'book') -> FALSE
 * wordplay('aaaaabcus', 'abacus') -> TRUE
 * wordplay('aaaaabcusxyz', 'abacus') -> TRUE
 * wordplay('aaaaabbbbbccccc', 'abc') -> TRUE
 */

