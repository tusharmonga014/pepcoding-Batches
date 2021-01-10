import java.util.ArrayList;
import java.util.List;

public class l003CoinPermutation {
    List<Integer> smallAns = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public void combinationSum(int[] arr, int idx, int target) {
        if (idx == arr.length || target == 0) {
            if (target == 0) {
                List<Integer> base = new ArrayList<>(smallAns);
                res.add(base);
            }
            return;
        }

        if (target - arr[idx] >= 0) {
            smallAns.add(arr[idx]);
            combinationSum(arr, idx, target - arr[idx]);
            smallAns.remove(smallAns.size() - 1);
        }
        combinationSum(arr, idx + 1, target);
    }

    public List<List<Integer>> combinationSum(int[] arr, int target) {
        combinationSum(arr, 0, target);
        return res;

    }

    // 46
    public void permute(int[] nums, int count, boolean[] vis) {
        if (count == nums.length) {

            res.add(new ArrayList<>(smallAns));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                smallAns.add(nums[i]);
                permute(nums, count + 1, vis);
                smallAns.remove(smallAns.size() - 1);
                vis[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] vis = new boolean[nums.length];
        permute(nums, 0, vis);
        return res;
    }

    // Queen

    // tnq = total no of queens, qpsf = queen placed so far
    // tnb = total no of boxes, bno : box no
    public static int queenCombination1D(int tnb, int bno, int tnq, int qpsf, String ans) {
        if (qpsf == tnq) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int b = bno; b < tnb; b++) {
            count += queenCombination1D(tnb, b + 1, tnq, qpsf + 1, ans + "b" + b + "q" + qpsf + " ");
        }

        return count;

    }

    public static int queenPermutation1D(boolean[] tnb, int tnq, int qpsf, String ans) {
        if (qpsf == tnq) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        for (int b = 0; b < tnb.length; b++) {
            if (!tnb[b]) {
                tnb[b] = true;
                count += queenPermutation1D(tnb, tnq, qpsf + 1, ans + "b" + b + "q" + qpsf + " ");
                tnb[b] = false;
            }
        }

        return count;
    }

    public static int queenCombination2D(boolean[][] tnb, int idx, int tnq, String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        int n = tnb.length;
        int m = tnb[0].length;
        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            count += queenCombination2D(tnb, i + 1, tnq - 1, ans + "(" + r + "," + c + ") ");
        }

        return count;
    }

    public static int queenPermutation2D(boolean[][] tnb, int tnq, String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        int n = tnb.length;
        int m = tnb[0].length;
        for (int i = 0; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (!tnb[r][c]) {
                tnb[r][c] = true;
                count += queenPermutation2D(tnb, tnq - 1, ans + "(" + r + "," + c + ") ");
                tnb[r][c] = false;
            }
        }

        return count;
    }

    // nQueen_Problem==================================================================

    public static boolean isSafeToPlaceQueen(boolean[][] boxes, int r, int c) {

    }

    public static int nQueen01(boolean[][] boxes, int idx, int tnq, String ans) {
        if (tnq == 0) {
            System.out.println(ans);
            return 1;
        }

        int count = 0;
        int n = boxes.length;
        int m = boxes[0].length;
        for (int i = idx; i < n * m; i++) {
            int r = i / m;
            int c = i % m;
            if (isSafeToPlaceQueen(boxes, r, c)) {
                boxes[r][c] = true;
                count += nQueen01(boxes, i + 1, tnq - 1, ans + "(" + r + "," + c + ") ");
                boxes[r][c] = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // System.out.println(queenCombination1D(5, 0, 3, 0, ""));
        // boolean[] tnb = new boolean[5];
        // System.out.println(queenPermutation1D(tnb, 3, 0, ""));

        int n = 4;
        boolean[][] tnb = new boolean[n][n];
        System.out.println(queenCombination2D(tnb, 0, n, ""));
        // System.out.println(queenPermutation2D(tnb, n, ""));
    }

}