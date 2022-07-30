package com.hrao.model.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 子域名访问计数
 */
public class SubdomainVisitsDemo {


    public static void main(String[] args) {
        String[] strs = {"9001 discuss.leetcode.com"};
        subdomainVisits(strs).forEach(e -> System.out.println(e));
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> countMap = new HashMap<>();
        for (String str : cpdomains) {
            String[] cpdomain = str.split(" ");
            int count = Integer.parseInt(cpdomain[0]);
            /**
             * 将count当做基础次数,每次从countMap找到对应key的次数(首次为0),加上基数,如果莫个key出现多次,则累加多次。
             */
            countMap.put(cpdomain[1], countMap.getOrDefault(cpdomain[1], 0) + count);
            while (cpdomain[1].indexOf(".") != -1) {
                /**
                 * 每次通过"."截取一段域名进行累加处理,每一段域名都是符合:将count当做基础次数,每次从countMap找到对应key的次数(首次为0),加上基数,如果莫个key出现多次,则累加多次.
                 */
                String newKey = cpdomain[1].substring(cpdomain[1].indexOf(".") + 1);
                countMap.put(newKey, countMap.getOrDefault(newKey, 0) + count);
                cpdomain[1] = newKey;
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> item : countMap.entrySet()) {
            result.add(item.getKey() + " " + item.getValue());
        }
        return result;

    }


}
