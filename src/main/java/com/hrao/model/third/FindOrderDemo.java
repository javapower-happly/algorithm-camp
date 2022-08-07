package com.hrao.model.third;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * 课程表 II
 */

public class FindOrderDemo {


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //定义一个list记录顺序
        List<Integer> sequence = new ArrayList<>();
        //如果prerequisites为空那么就返回对应所有的课程
        if (prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                sequence.add(i);
            }
            int[] res = sequence.stream().mapToInt(Integer::intValue).toArray();
            return res;
        }
        //定义一个数组表示每个节点的入度
        int[] inDeg = new int[numCourses];
        //定义一个队列储存当前节点
        Queue<Integer> queue = new LinkedList();
        //定义一个list存储依赖于当前这门课的课程
        List<Integer>[] pre = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            pre[i] = new ArrayList<>();
        }
        //计算每个节点的入度
        for (int[] course : prerequisites) {
            inDeg[course[0]]++;
        }
        //计算依赖这门课的其他课
        for (int[] course : prerequisites) {
            pre[course[1]].add(course[0]);
        }
        //将入度为0的所有点都添加到队列
        for (int i = 0; i < numCourses; i++) {
            if (inDeg[i] == 0) {
                queue.offer(i);
            }
        }
        //BFS
        while (!queue.isEmpty()) {
            //取出一门课进行分析
            for (int i = 0; i < queue.size(); i++) {
                int curCourse = queue.poll();   //拿到这门课
                sequence.add(curCourse);    //添加这门课
                if (!pre[curCourse].isEmpty()) {     //如果依赖这门课的课不为空
                    for (int course : pre[curCourse]) {
                        inDeg[course]--;    //依赖的这门课减少入度
                        if (inDeg[course] == 0) {
                            queue.offer(course);  //如果因此入度降低到了0,那么就添加
                        }
                    }
                }
            }
        }
        //搜索完毕之后返回
        int[] res = sequence.stream().mapToInt(Integer::intValue).toArray();
        return res.length == numCourses ? res : new int[]{};
    }


}
