package com.hrao.model.second;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组的度
 */
public class FindShortestSubArrayDemo {


    public static void main(String[] args) {

        int[] nums = {1,1,2,2,4,4,4,1};
        System.out.println(findShortestSubArray(nums));
    }


    private static int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> countMap = new HashMap<>();
        int max = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            /**
             * 通过hashmap记录出,每个元素出现的次数和位置
             */
            if (!countMap.containsKey(nums[i])) {
                countMap.put(nums[i], new int[]{1, i});
            } else {
                countMap.get(nums[i])[0]++;
            }
            int[] arr = countMap.get(nums[i]);
            /**
             * 计算出当前元素的位置与出现元素次数的之差，则是数组的度
             */
            int len = i - arr[1] + 1;
            /**
             * 取值最大的那个度
             */
            if (max < arr[0] || (max == arr[0] && res > len)) {
                max = arr[0];
                res = len;
            }
        }

        return res;
    }

}
