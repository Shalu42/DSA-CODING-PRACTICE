import java.util.*;

public class Problem8 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalWords = words.length;
        int substringLength = wordLength * totalWords;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - substringLength; i++) {
            Map<String, Integer> seenWords = new HashMap<>();
            int j = 0;
            while (j < totalWords) {
                int wordIndex = i + j * wordLength;
                String currentWord = s.substring(wordIndex, wordIndex + wordLength);
                if (!wordCount.containsKey(currentWord)) {
                    break;
                }
                seenWords.put(currentWord, seenWords.getOrDefault(currentWord, 0) + 1);
                if (seenWords.get(currentWord) > wordCount.get(currentWord)) {
                    break;
                }
                j++;
            }
            if (j == totalWords) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string s:");
        String s = sc.nextLine();
        System.out.println("Enter the number of words:");
        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline
        String[] words = new String[n];
        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            words[i] = sc.nextLine();
        }
        List<Integer> result = findSubstring(s, words);
        System.out.println("Starting indices of concatenated substrings are: " + result);
    }
}
