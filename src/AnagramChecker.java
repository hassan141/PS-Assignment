import java.util.Arrays;

public class AnagramChecker {


    public static boolean areAnagrams(String str1, String str2) {

        if (str1 == null || str2 == null) {
            // Anagrams require valid strings; nulls cannot be anagrams
            return false;
        }

        // Step 2: Normalize strings - remove whitespace and convert to lowercase.
        // This ensures case-insensitivity and ignores spaces (e.g., "Racecar" and "race car" are anagrams).
        String cleanedStr1 = str1.replaceAll("\\s", "").toLowerCase();
        String cleanedStr2 = str2.replaceAll("\\s", "").toLowerCase();

        // Step 3: Check if lengths are equal. Anagrams must have the same number of characters.
        if (cleanedStr1.length() != cleanedStr2.length()) {
            return false;
        }

        // Step 4: Convert strings to char arrays
        char[] charArray1 = cleanedStr1.toCharArray();
        char[] charArray2 = cleanedStr2.toCharArray();

        // Step 5: Sort both char arrays alphabetically
        // If two strings are anagrams, their sorted character arrays will be identical.
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        // Step 6: Compare the sorted arrays. If they are identical, the strings are anagrams.
        return Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        System.out.println("'listen' and 'silent' are anagrams: " + AnagramChecker.areAnagrams("listen", "silent"));
        System.out.println("'hello' and 'world' are anagrams: " + AnagramChecker.areAnagrams("hello", "world"));
        System.out.println("'Racecar' and 'race car' are anagrams: " + AnagramChecker.areAnagrams("Racecar", "race car"));
        System.out.println("'anagram' and 'nag a ram' are anagrams: " + AnagramChecker.areAnagrams("anagram", "nag a ram"));
        System.out.println("'' and '' are anagrams: " + AnagramChecker.areAnagrams("", ""));
        System.out.println("'a' and 'a' are anagrams: " + AnagramChecker.areAnagrams("a", "a"));
        System.out.println("'a' and 'b' are anagrams: " + AnagramChecker.areAnagrams("a", "b"));
        System.out.println("null and 'abc' are anagrams: " + AnagramChecker.areAnagrams(null, "abc"));
        System.out.println("'abc' and null are anagrams: " + AnagramChecker.areAnagrams("abc", null));
        System.out.println("'dormitory' and 'dirty room' are anagrams: " + AnagramChecker.areAnagrams("dormitory", "dirty room"));
    }
}
