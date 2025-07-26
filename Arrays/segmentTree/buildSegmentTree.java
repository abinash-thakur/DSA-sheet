// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void buildTree(int tree[],int nums[], int i, int l, int r){
        if(l == r){
            tree[i] = nums[l];
            return;
        }
        int mid = (l + r) / 2;
        buildTree(tree, nums, 2 * i + 1, l, mid);
        buildTree(tree, nums, 2 * i + 2, mid + 1, r);
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }
    public static void main(String[] args) {
        int nums[] = {1,3,6,7,4,8,9};
        int n = nums.length;
        int tree[] = new int[2 * n];
        buildTree(tree, nums, 0, 0, n - 1);
        
        for(int i = 0; i < 2 * n; i++){
            System.out.println(tree[i]);
        }
    }
}