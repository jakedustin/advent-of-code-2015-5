package com.qualtrics.jdustin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// --- Day 5: Doesn't He Have Intern-Elves For This? ---
//     Santa needs help figuring out which strings in his text file are naughty or nice.

//     A nice string is one with all of the following properties:

//         It contains at least three vowels (aeiou only), like aei, xazegov, or aeiouaeiouaeiou.
//         It contains at least one letter that appears twice in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).
//         It does not contain the strings ab, cd, pq, or xy, even if they are part of one of the other requirements.

//     For example:

//         ugknbfddgicrmopn is nice because it has at least three vowels (u...i...o...), a double letter (...dd...), and none of the disallowed substrings.
//         aaa is nice because it has at least three vowels and a double letter, even though the letters used by different rules overlap.
//         jchzalrnumimnmhp is naughty because it has no double letter.
//         haegwjzuvuyypxyu is naughty because it contains the string xy.
//         dvszwmarrgswjxmb is naughty because it contains only one vowel.

//     How many strings are nice?

public class Solution {
    ArrayList<String> input;
    Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    String[] badSubstrings = { "ab", "cd", "pq", "xy" };

    public Solution(ArrayList input) {
        this.input = input;
    }

    public int getNumNice() {
        int numNice = 0;
        for (String s : input) {
            numNice = numNice + (isLineNice(s) ? 1 : 0);
        }
        return numNice;
    }

    private boolean isLineNice(String line) {
        return hasPair(line)
                && hasVowels(line, 0) >= 3
                && doesNotHaveBadSubstrings(line);
    }

    private boolean hasPair(String line) {
        for (int i = 1; i < line.length(); ++i) {
            if (line.charAt(i) == line.charAt(i - 1)) {
                return true;
            }
        }

        return false;
    }

    private int hasVowels(String line, int index) {
        if (index >= line.length()) {
            return 0;
        }

        int count = vowels.contains(line.charAt(index)) ? 1 : 0;
        return count + hasVowels(line, index + 1);
    }

    private boolean doesNotHaveBadSubstrings(String line) {
        for (String sub : badSubstrings) {
            if (line.contains(sub)) {
                return false;
            }
        }

        return true;
    }
}
