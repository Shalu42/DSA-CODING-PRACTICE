import java.util.*;

public class Problem8 {
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
        int result = ladderLength(beginWord, endWord, wordList);
        System.out.println("Shortest transformation sequence length: " + result);
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int steps = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) {
                    return steps;
                }
                for (String neighbor : getNeighbors(currentWord, wordSet)) {
                    queue.add(neighbor);
                }
            }
            steps++;
        }
        return 0;
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
                    wordSet.remove(newWord);
                }
            }
            charArray[i] = originalChar;
        }
        return neighbors;
    }
}
