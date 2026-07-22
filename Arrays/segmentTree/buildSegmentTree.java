// Segment Tree: build a sum-segment-tree from an array and query range maximum.
// Tree is stored implicitly in an array: node i has children 2*i+1 (left) and 2*i+2 (right).

class Main {
    /**
     * Returns the maximum value in query range [l, r].
     * @param seg   segment tree array
     * @param i     index of the current node in seg
     * @param l     query range start
     * @param r     query range end
     * @param start start of the range covered by node i
     * @param end   end of the range covered by node i
     */
    public static int rangeMaxQuery(int seg[], int i, int l, int r, int start, int end){
        // no overlap between [start, end] and [l, r]
        if(start > r || end < l){
            return Integer.MIN_VALUE;
        }

        // [start, end] fully inside [l, r]
        if(start >= l && end <= r){
            return seg[i];
        }

        // partial overlap: recurse into both children and combine
        int mid = start + (end - start) / 2;
        int left = rangeMaxQuery(seg, 2 * i + 1, l, r, start, mid);
        int right = rangeMaxQuery(seg, 2 * i + 2, left, r, mid + 1, end);

        return Math.max(left, right);
    }

    /**
     * Builds a sum segment tree over nums[l..r] into seg, rooted at node i.
     * @param seg   segment tree array to populate
     * @param nums  source array
     * @param i     index of the current node in seg
     * @param l     start of the range this node covers
     * @param r     end of the range this node covers
     */
    public static void buildTree(int seg[],int nums[], int i, int l, int r){
        // leaf node: single element range
        if(l == r){
            seg[i] = nums[l];
            return;
        }
        int mid = (l + r) / 2;
        buildTree(seg, nums, 2 * i + 1, l, mid);
        buildTree(seg, nums, 2 * i + 2, mid + 1, r);
        seg[i] = seg[2 * i + 1] + seg[2 * i + 2];
    }

    public static void main(String[] args) {
        int nums[] = {1,3,6,7,4,8,9};
        int n = nums.length;
        int tree[] = new int[4 * n]; // segment tree array (size should be 4*n for safety)
        buildTree(tree, nums, 0, 0, n - 1);

        for(int i = 0; i < 2 * n; i++){
            System.out.println(tree[i]);
        }
    }
}