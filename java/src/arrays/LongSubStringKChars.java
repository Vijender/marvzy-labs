package arrays;

import java.util.HashSet;

public class LongSubStringKChars {

    public int finalLongestSubstring(String S, int k) {

        int longest = 0;
        char[] arr = S.toCharArray();

        for (int i = 0; i < arr.length - 1; i++) {
            int wCount;
            HashSet<Character> set = new HashSet<>();
            set.add(arr[i]);

            for (int j = i + 1; j < arr.length; j++) {
                set.add(arr[j]);
                if (set.size() <=k ) {
                    wCount = (j - i) + 1;
                    longest = Math.max(longest, wCount);
                } else break;
            }
        }
        if (arr.length <= 1) {
            longest = 1;
        }
        return longest;

    }



    static void main() {

        System.out.println("arrays.LongSubStringKChars");
        System.out.println(new LongSubStringKChars().finalLongestSubstring("abcabcbb", 2));        //Expected  = 4

        System.out.println(new LongSubStringKChars().finalLongestSubstring("a", 12));
    }
}
