//Time complexcity is O(n)

//Importan
// 🔍 Problem with using String directly
// In Java, String is immutable. Every time you perform an operation like str = str + something, Java:

// Creates a new string object.

// Copies the old string content into it.

// Appends the new part.

// Assigns it back to the str reference.

// This means if you're doing repeated concatenations (like in a loop), the time complexity becomes O(n²) in the worst case due to repeated copying.

// ✅ Why StringBuilder is better
// StringBuilder is mutable, so:

// It doesn't create a new object every time.

// It appends characters or strings to an existing buffer.

// It’s much more efficient for building strings dynamically — especially in loops or recursive code.

class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        int count = 1;
        StringBuilder res = new StringBuilder();
        res.append(s.charAt(0));
        for(int i = 1; i< n; i++){
            if(s.charAt(i) == s.charAt(i - 1)){
                count++;
            }
            else{
                count = 1;
            }
            if(count <= 2){
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}