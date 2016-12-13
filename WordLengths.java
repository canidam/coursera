import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by chen.anidam on 13-Dec-16.
 */
public class WordLengths {

    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("words.txt").getFile());
    ArrayList<String> words = new ArrayList<>();
    int[] counts = new int[31];

    void countWordsLength(File f, int[] counts)
    {

        try (Scanner scan = new Scanner(f)) {
            while (scan.hasNext()) {
                // add words to arraylist and trip punctuations
                words.add(scan.next().replaceAll("[^a-zA-Z0-9-]", ""));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // loop over the arraylist and count chars per word
        for (String w : words) {
            int index = w.length();
            if (index >= 30) {
                counts[30] += 1;
                continue;
            }
            counts[index] += 1;
        }
    }

    int indexOfMax(int[] array) {
        int max = 0, index = 0;
        for (int i=0; i < array.length; i++) {
            if (array[i] >= max) {
                max = array[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        WordLengths wl = new WordLengths();
        wl.countWordsLength(wl.file, wl.counts);

        for (int i=0; i < wl.counts.length; i++) {
            System.out.println("length: " + i + "\t" + wl.counts[i]);
        }
        System.out.println("largest element length: " + wl.indexOfMax(wl.counts));
    }

}
