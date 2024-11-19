import java.util.*;

public class Problem10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of courses: ");
        int numCourses = sc.nextInt();
        System.out.print("Enter the number of prerequisites: ");
        int n = sc.nextInt();
        List<int[]> prerequisites = new ArrayList<>();
        System.out.println("Enter the prerequisites pairs (course, prerequisite): ");
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            prerequisites.add(new int[]{a, b});
        }
        boolean result = canFinish(numCourses, prerequisites);
        System.out.println("Can finish all courses: " + result);
    }

    public static boolean canFinish(int numCourses, List<int[]> prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];

        // Build the graph and indegree array
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1];
            graph.putIfAbsent(pre, new ArrayList<>());
            graph.get(pre).add(course);
            indegree[course]++;
        }

        // Topological Sort using BFS (Kahn's Algorithm)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int coursesTaken = 0;
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            coursesTaken++;

            if (graph.containsKey(currentCourse)) {
                for (int nextCourse : graph.get(currentCourse)) {
                    indegree[nextCourse]--;
                    if (indegree[nextCourse] == 0) {
                        queue.add(nextCourse);
                    }
                }
            }
        }

        return coursesTaken == numCourses;
    }
}
