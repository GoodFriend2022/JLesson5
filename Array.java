import java.util.ArrayList;
import java.util.HashSet;

public class Array {
    public static void main(String[] args) {
        
        int[] nums1 = new int[] { 9, 8, 8, 0, 5, 8, 7, 7 };
        //                        0  1  2  3  4  5  6  7
        int[] nums2 = new int[] { 0, 8, 8, 0, 0, 0, 0 };

        int maxSize = FindMaxSize(nums1, nums2);     
        System.out.println(maxSize);
    }
    static int FindMaxSize(int[] nums1, int[] nums2) {
        HashSet<ArrayList<Integer>> dic = new HashSet<>();
        int maxSize = 0;
        boolean item = true;
        for (int i = 0; i < nums1.length; i++) {
            if (!item) dic.clear();
            item = false;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    item = true;
                    ArrayList<Integer> array = new ArrayList<>();
                    array.add(j);
                    dic.add(array);
                    for (ArrayList<Integer> col : dic) {
                        if (j > 0 && nums2[j - 1] == nums2[j] && i > 0 && nums1[i - 1] != nums1[i]);
                        else if (col.contains(j - 1)) {
                            col.add(j);
                            maxSize = col.size() > maxSize ? col.size() : maxSize;
                        }
                    }
                }
                maxSize = item && maxSize < 1 ? 1 : maxSize;
            }
        }
        return maxSize;
    }
}
