package wordfinder.wordfinder;

import java.util.HashMap;
import java.util.Map;

public class PermutationHelper {
    /**
     * Calculates the factulty to a given N.
     * not recursively to avoid stack overflow.
     * @param N
     * @return
     */
    public static int faculty(int N) {
        int fac=1;
        for(int i=1; i<=N; i++) {
            fac = fac * i;
        }
        return fac;
    }

    /**
     * Takes an array, delete one entry
     * and returns a new array without the given entry
     * (given with the index charToKill)
     * @param oldArray
     * @param charToKill
     * @return
     */
    public static char[] killElement(final char[] oldArray, int charToKill) {
        char[] newArray = new char[oldArray.length-1];
        for(int i=0,ni=0; i<oldArray.length; i++) {
            if (i!=charToKill) {
                newArray[ni++] = oldArray[i];
            }
        }
        return newArray;
    }

    public static Map<String, Boolean> permutate(String signs) {
        return permutate(signs, signs.length());
    }

    public static Map<String, Boolean> permutate(String signs, int len) {
        //Use faculty of the signsMax, because more is not needed
        //Calculate it 2 times to avoid hash problems
        Map<String, Boolean> result = new HashMap<>(2*faculty(len));
        char[] signsChar = signs.toCharArray();
        //Only start the stuff, when sign is bigger/equals 1
        if (len >= 1) {
            permutate(len, signsChar, new StringBuilder(), result);
        }
        return result;
    }

    private static void permutate(int lenLeft, char[] signs, final StringBuilder builder, Map<String, Boolean> permutates) {
        if (lenLeft == 0) {
            //WHen only 1 sign more there, just add the sign and return
            //builder.append(signs[0]);
            permutates.put(builder.toString(), true);
            return;
        } else {
            for (int i = 0; i < signs.length; i++) {
                char[] currentSigns = killElement(signs, i);
                StringBuilder newBuilder = new StringBuilder(builder);
                newBuilder.append(signs[i]);
                permutate((lenLeft-1), currentSigns, newBuilder, permutates);
            }
        }
    }
}