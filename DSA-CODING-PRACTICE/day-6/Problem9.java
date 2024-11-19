import java.util.*;

public class Problem9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the beginWord: ");
        String beginWord = sc.next();
        System.out.print("Enter the endWord: ");
        String endWord = sc.next();
        System.out.print("Enter the number of words in the wordList: ");
        int n = sc.nextInt();
        List<String> wordList = new ArrayList<>();
        System.out.println("Enter the words in the wordList:");
        for (int i = 0; i < n; i++) {
            wordList.add(sc.next());
        }
        List<List<String>> result = findLadders(beginWord, endWord, wordList);
        System.out.println("All shortest transformation sequences:");
        for (List<String> sequence : result) {
            System.out.println(sequence);
        }
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> results = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return results;
        }
        Map<String, List<String>> neighborsMap = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        bfs(beginWord, endWord, wordSet, neighborsMap, distance);
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        dfs(beginWord, endWord, neighborsMap, distance, path, results);
        return results;
    }

    private static void bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, List<String>> neighborsMap, Map<String, Integer> distance) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        distance.put(beginWord, 0);
        for (String word : wordSet) {
            neighborsMap.put(word, new ArrayList<>());
        }
        while (!queue.isEmpty()) {
            String currentWord = queue.poll();
            int currentDistance = distance.get(currentWord);
            for (String neighbor : getNeighbors(currentWord, wordSet)) {
                neighborsMap.get(currentWord).add(neighbor);
                if (!distance.containsKey(neighbor)) {
                    distance.put(neighbor, currentDistance + 1);
                    if (neighbor.equals(endWord)) continue;
                    queue.add(neighbor);
                }
            }
        }
    }

    private static List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char originalChar = charArray[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) continue;
                charArray[i] = c;
                String newWord = new String(charArray);
                if (wordSet.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }
            charArray[i] = originalChar;
        }
        return neighbors;
    }

    private static void dfs(String currentWord, String endWord, Map<String, List<String>> neighborsMap, Map<String, Integer> distance, List<String> path, List<List<String>> results) {
        if (currentWord.equals(endWord)) {
            results.add(new ArrayList<>(path));
            return;
        }
        for (String neighbor : neighborsMap.getOrDefault(currentWord, new ArrayList<>())) {
            if (distance.get(neighbor) == distance.get(currentWord) + 1) {
                path.add(neighbor);
                dfs(neighbor, endWord, neighborsMap, distance, path, results);
                path.remove(path.size() - 1);
            }
        }
    }
}
