import java.util.*;

class Main {

    public static int digitDp(String num, int n, int idx, int prev, boolean tight, boolean lzero, int even, int odd, int len) {
        if (idx == n) {
            if(even == odd && len >= 2)
                return 1;
            return 0;
        }

        int lb = (idx == n - 2) ? 1 : 0;
        int ub = tight ? num.charAt(idx) - '0' : 9;
        int total = 0;

        for (int i = lb; i <= ub; i++) {
            int currEven = even;
            int currOdd = odd;

            boolean isNewLZero = lzero && (i == 0);
            int newLen = len;

            if(!isNewLZero){
                newLen++;
                if((idx + 1) % 2 == 0){
                    currEven += i;
                }
                else{
                    currOdd += i;
                }
            }

            total += digitDp(
                num,
                n,
                idx + 1,
                i,
                tight && (i == ub),
                isNewLZero,
                currEven,
                currOdd,
                newLen
            );
        }

        return total;
    }
    public static int solve(int num){
        if(num == 0){
            return 0;
        }
        String s = Integer.toString(num);
        int n = s.length();
        return digitDp(s, n, 0, -1, true, true, 0, 0, 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        System.out.println(solve(n2) - solve(n1 - 1));
    }
}
