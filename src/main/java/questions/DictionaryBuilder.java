package questions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DictionaryBuilder {
    private static HashMap<String, List<String>> generateDictionaryMap() {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(new File("words.txt")));
            String line;
            List<String> temp;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                char[] charA = line.toCharArray();
                Arrays.sort(charA);
                String a = new String(charA);
                if (map.containsKey(a)) {
                    temp = map.get(a);
                    if (!temp.contains(line)) {
                        temp.add(line);
                        map.put(a, temp);
                    }
                } else {
                    temp = new ArrayList<String>();
                    temp.add(line);
                    map.put(a, temp);
                }
            }
            System.out.println(map.size());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }

    private static List<String> getValidWords(String letters, HashMap<String, List<String>> dictionary) {
        List<String> validWords = new ArrayList<String>();
        char[] lettersArray = letters.toCharArray();
        Arrays.sort(lettersArray);
        String inputLetters = new String(lettersArray);
        if (dictionary.containsKey(inputLetters)) {
            validWords = dictionary.get(inputLetters);
        }
        return validWords;
    }
}
