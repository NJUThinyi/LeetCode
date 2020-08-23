//你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
//
// 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
//
// 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
//
//
//
// 示例 1:
//
// 输入: 2, [[1,0]]
//输出: true
//解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
//
// 示例 2:
//
// 输入: 2, [[1,0],[0,1]]
//输出: false
//解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
//
//
//
// 提示：
//
//
// 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
// 你可以假定输入的先决条件中没有重复的边。
// 1 <= numCourses <= 10^5
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序
// 👍 505 👎 0


import java.lang.reflect.Array;
import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        return BFS(numCourses, prerequisites);
    }

    // 广度优先搜索
    public boolean BFS(int numCourses, int[][] prerequisites){
        // 将课程节点和相关信息转化为图，并且能够保存顶点的入度
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // 生成图的顶点
        for(int i=0;i<numCourses;i++){
            graph.put(i, new ArrayList<>());
        }

        // 生成图的边，并且存储每个顶点的入度
        for(int[] edge: prerequisites){
            graph.get(edge[0]).add(edge[1]);
        }

        // 采用队列存储入度为0的顶点，表示可以学习的课程
        Queue<Integer> availableCourses = new ArrayDeque<>(numCourses);

        boolean res = true;

        while(graph.size()>0){
//            for(int i: graph.keySet()){
//                if(graph.get(i).size()==0){
//                    availableCourses.add(i);
//                    graph.remove(i);
//                }
//            }

            for(Iterator<Map.Entry<Integer, List<Integer>>> entrys = graph.entrySet().iterator();entrys.hasNext();){
                Map.Entry<Integer, List<Integer>> entry = entrys.next();
                if(entry.getValue().size()==0){
                    availableCourses.add(entry.getKey());
                    entrys.remove();
                }
            }

            if(availableCourses.isEmpty() && graph.size()>0){
                res = false;
                break;
            }else{
                Integer availableCourse = availableCourses.poll();
                if(availableCourse!=null){
                    for(Iterator<Map.Entry<Integer, List<Integer>>> entrys = graph.entrySet().iterator();entrys.hasNext();){
                        Map.Entry<Integer, List<Integer>> entry = entrys.next();
                        if(entry.getValue().contains(availableCourse)){
                            entry.getValue().remove(availableCourse);
                        }
                    }
                }
            }
        }
        return res;
    }

    // 深度优先搜索
    public boolean DFS(int numCourses, int[][] prerequisites){
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
