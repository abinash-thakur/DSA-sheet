import java.util.*;
class Sample{
    public static void findState(StringBuilder sb, int i, int n, char prev, List<String> list){
        if(i == n){
            list.add(sb.toString());
            return;
        }
        char avilable[] = {'y', 'r', 'g'};
        for(char ch : avilable){
            if(ch == prev){
                continue;
            }
            sb.append(ch);
            findState(sb, i + 1, n, ch, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static int ways(int i, int p, int n, int state, List<String> list){
        if(i == n){
            return 1;
        }

        String prev = list.get(p);
        int strLen = list.get(p).length();
        int count = 0;

        for(int j = 0; j < state; j++){
            if(j == p){
                continue;
            }

            String curr = list.get(j);
            boolean isValid = true;
            
            for(int k = 0; k < strLen; k++){
                if(prev.charAt(k) == curr.charAt(k)){
                    isValid = false;
                    break;
                }
            }

            if(isValid){
                count += ways(i + 1, j, n, state, list);
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        findState(new StringBuilder(), 0, m, '0', list);

        int stateSize = list.size();
        int res = 0;

        for(int i = 0; i < stateSize; i++){
            res += ways(1, i, n, stateSize, list);
        }
        System.out.println(res);
    }
}