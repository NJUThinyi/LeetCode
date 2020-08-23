public class Main {
    public static void main(String[] args) {
        int courseNum = 8;
        int[][] relation = new int[][]{{3,1}, {6,3}, {0,6},{4,1},{7,4},{0,7},{4,2},{5,2},{7,5}, {4,5}};

        Solution solution = new Solution();
        boolean res = solution.canFinish(courseNum, relation);
        System.out.println(res);
    }
}
