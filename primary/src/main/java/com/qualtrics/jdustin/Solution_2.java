package com.qualtrics.jdustin;

import java.util.ArrayList;

// --- Part Two ---
//     Realizing the error of his ways, Santa has switched to a better model of determining whether a string is naughty or nice. None of the old rules apply, as they are all clearly ridiculous.

//     Now, a nice string is one with all of the following properties:

//         It contains a pair of any two letters that appears at least twice in the string without overlapping, like xyxy (xy) or aabcdefgaa (aa), but not like aaa (aa, but it overlaps).
//         It contains at least one letter which repeats with exactly one letter between them, like xyx, abcdefeghi (efe), or even aaa.

//     For example:

//         qjhvhtzxzqqjkmpb is nice because is has a pair that appears twice (qj) and a letter that repeats with exactly one letter between them (zxz).
//         xxyxx is nice because it has a pair that appears twice and a letter that repeats with one between, even though the letters used by each rule overlap.
//         uurcxstgmygtbstg is naughty because it has a pair (tg) but no repeat with a single letter between them.
//         ieodomkazucvgmuy is naughty because it has a repeating letter with one between (odo), but no pair that appears twice.

//     How many strings are nice under these new rules?

public class Solution_2 {
    ArrayList<String> input;

    public Solution_2(ArrayList<String> input) {
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
        return hasPairSeparatedByChar(line)
                && hasTwoPairs(line);
    }

    private boolean hasPairSeparatedByChar(String line) {
        for (int i = 2; i < line.length(); ++i) {
            if (line.charAt(i) == line.charAt(i - 2)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasTwoPairs(String line) {
        String sub;
        String lineWithoutSub;
        for (int i = 1; i < line.length(); ++i) {
            sub = line.substring(i - 1, i + 1);
            lineWithoutSub = line.replaceFirst(sub, "  ");
            if (lineWithoutSub.contains(sub)) {
                return true;
            }
        }

        return false;
    }
}
