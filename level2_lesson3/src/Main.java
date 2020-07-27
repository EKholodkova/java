import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] arr = createArray();
        Set<String> wordSet = putArrayIntoHashSet(arr);

        System.out.println(Arrays.deepToString(arr));
        System.out.println(wordSet);

        printAmountOfWords(wordSet, arr);

    }

    public static String[] createArray() {
        String[] arr = {"Sun", "Sky", "Earth", "Bush", "Tree", "Road", "Sky", "Bush", "Sky", "Sun"};
        return arr;
    }

    public static Set<String> putArrayIntoHashSet(String[] arr) {
        Set<String> wordsSet = new HashSet<>();
        for (int i = 0; i<arr.length; i++) {
            wordsSet.add(arr[i]);
        }
        return  wordsSet;
    }

    public static void printAmountOfWords(Set<String> set, String[] arr) {
        for(String word : set) {
            System.out.print(word + ":" );
            int amount = 0;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i].equals(word)) {
                    amount++;
                }
            }
            System.out.println(amount);
        }
    }

   /* public static List<String> putArrayIntoArrayList(String[] arr) {
        List<String> wordsList = new ArrayList<>();
        for (int i = 0; i<arr.length; i++) {
            wordsList.add(arr[i]);
        }
        return  wordsList;
    }*/


}
