package com.hrao.model.first;

import java.util.Arrays;

/**
 * 加1
 */
public class PlusOneDemo {


    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            /**
             * 场景1:元素不为9时: 取最后一个元素+1余上10等于元素+1的值,直接返回数组
             * 场景2:元素为9时:取最后一个元素+1余上10等于0,则取下一位继续(类似于满10加1的操作)
             * 场景3:所有元素为9时,将所有元素值都设置为0,将数组长度,增加一位,并且首位设置为1(类似于满10加1的操作)
             */
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        Arrays.stream(plusOne(new int[]{9, 9, 9, 9})).forEach(e->System.out.println(e));
    }

}
