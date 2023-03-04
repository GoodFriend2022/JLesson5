import java.util.ArrayList;
import java.util.HashSet;

public class Array {
    public static void main(String[] args) {
        
        int[] nums1 = new int[] { 9, 8, 8, 1, 5, 8, 7, 7 };
        //                        0  1  2  3  4  5  6  7
        int[] nums2 = new int[] { 9, 0, 0, 0, 0, 0, 0 };

        ArrayList<Integer> maxArray = FindMaxSizeArray(nums1, nums2);     
        System.out.println(maxArray);
        System.out.printf("Максимальная длина подмассива равна = %d", maxArray.size());
        
    }
    static ArrayList<Integer> FindMaxSizeArray(int[] nums1, int[] nums2) {
        HashSet<ArrayList<Integer>> dic = new HashSet<>();
        ArrayList<Integer> maxSizeArray = new ArrayList<>();
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
                            maxSizeArray = col.size() > maxSizeArray.size() ? col : maxSizeArray;
                        }
                    }
                    maxSizeArray = item && maxSizeArray.size() < 1 ? array : maxSizeArray;
                }
            }
        }
        ConvertIndexToArray(maxSizeArray, nums2);
        return maxSizeArray;
    }

    static void ConvertIndexToArray(ArrayList<Integer> list, int[] array) {
        ArrayList<Integer> newList = new ArrayList<>();
        if (!list.isEmpty()) {
            for (int i : list) {
                newList.add(array[i]);
            }
            list.clear();
            list.addAll(newList);
        }
    }
}
