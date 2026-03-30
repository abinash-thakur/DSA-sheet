// This is a great combinatorics problem.
/*
Intuition:
1. We have (n - 1) people to consider because `pos` is fixed and not part of the selection.
2. We need to choose exactly `k` people from these (n - 1) people.
3. For a fixed visible set, directions are forced by side:
   left of `pos` must choose `L`, and right of `pos` must choose `R`.
4. Only the person at `pos` has 2 free choices: `L` or `R`.

So, the total number of valid assignments is:
((n - 1) C k) * 2

The key part is computing nCr efficiently under modulo.
For that, we use:
- Binary exponentiation (fast power)
- Modular inverse (typically with Fermat's Little Theorem)
*/

class Solution {
    private long MOD = (long)(1e9 + 7);
    private long bes(long b, long m){
        long res = 1;
        while(m > 0){
            if((m & 1) == 1){
                res = (res * b) % MOD;
            }

            b = (b * b) % MOD;
            m = m >> 1;
        }

        return res;
    }
    private long fact(long n){
        long res = 1;
        for(long i = 1; i <= n; i++){
            res = (res * i) % MOD;
        }
        return res;
    }
    public int countVisiblePeople(int n, int pos, int k) {
        long MOD = (long)(1e9 + 7);
        
        long a = n - 1;
        long numerator = fact(a);
        long denomenator = (fact(k) * fact(a - k)) % MOD;

        long res = (numerator * (bes(denomenator, MOD - 2) % MOD)) % MOD;
        res = (2 * res) % MOD;

        return (int)res;
    }
}