//1915. Number of Wonderful Substrings

// A wonderful string is a string where at most one letter appears an odd number of times.

// For example, "ccjjc" and "abab" are wonderful, but "ab" is not.
// Given a string word that consists of the first ten lowercase English letters ('a' through 'j'), return the number of wonderful non-empty substrings in word. If the same substring appears multiple times in word, then count each occurrence separately.

// A substring is a contiguous sequence of characters in a string.

 

// Example 1:

// Input: word = "aba"
// Output: 4
// Explanation: The four wonderful substrings are underlined below:
// - "aba" -> "a"
// - "aba" -> "b"
// - "aba" -> "a"
// - "aba" -> "aba"
// Example 2:

// Input: word = "aabb"
// Output: 9
// Explanation: The nine wonderful substrings are underlined below:
// - "aabb" -> "a"
// - "aabb" -> "aa"
// - "aabb" -> "aab"
// - "aabb" -> "aabb"
// - "aabb" -> "a"
// - "aabb" -> "abb"
// - "aabb" -> "b"
// - "aabb" -> "bb"
// - "aabb" -> "b"
// Example 3:

// Input: word = "he"
// Output: 2
// Explanation: The two wonderful substrings are underlined below:
// - "he" -> "h"
// - "he" -> "e"
 

// Constraints:

// 1 <= word.length <= 105
// word consists of lowercase English letters from 'a' to 'j'.

//ANSWER & INTITUON
//This problem is solved using the bit-manipulation(XOR)
//so the technique is if the same characte are occurs even number of times they are cancell each other and if they occurs odd number of times that can't be canceld out
//so first we take the map and store the every occurence of xor

//this will take the 1024 length of the array beacause j having the bit value 512 and in that much of bit we have to generate at most 1023 largest number and taht canbe easily store in 1024 range of the array.


class Solution {
    public long wonderfulSubstrings(String word) {
        int track[] = new int[1024];
        track[0] = 1;
        int xor = 0;
        long result = 0;

        for(char ch : word.toCharArray()){
            xor ^= (1 << (ch - 'a'));
            result += track[xor];
            for(int i = 0; i < 10; i++){
                result += track[xor ^ (1 << i)];
            }
            track[xor]++;
        }
        return result;
    }
}