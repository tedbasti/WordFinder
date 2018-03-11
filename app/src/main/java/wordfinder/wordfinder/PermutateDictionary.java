package wordfinder.wordfinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PermutateDictionary {
    private static final String FILENAME = "wordlist.txt";

    public static int stringToInt(String signs, String count) {
        if (count == null) {
            return signs.length();
        }
        try {
            int result = Integer.valueOf(count);
            if (result > signs.length() || result == 0) {
                result = signs.length();
            }
            return result;
        } catch (Exception e) {
            return signs.length();
        }
    }

    public static List<String> go(String signs, String count) throws WordFinderException {
        List<String> result = new ArrayList<>();
        DictionaryReader reader = new DictionaryReader(FILENAME);
        if (reader.openFile() == false) {
            throw new WordFinderException("WÖrterbuch konnte nicht geöffnet werden");
        }
        int size = stringToInt(signs, count);
        Map<String, Boolean> permutation = PermutationHelper.permutate(signs, size);
        String word;
        while ((word = reader.getEntry()) != null) {
            if (permutation.get(word) != null) {
                result.add(word);
            }
        }
        return result;
    }

    public static List<String> go(String signs) throws WordFinderException {
        return go(signs, null);
    }
}